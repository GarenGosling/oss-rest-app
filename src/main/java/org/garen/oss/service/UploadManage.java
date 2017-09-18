package org.garen.oss.service;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.IOUtils;
import org.garen.oss.cache.FileTypesCache;
import org.garen.oss.mybatis.domain.FileInfo;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.swagger.api.Valid.FileUploadValid;
import org.garen.oss.util.FileUtil;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 文件上传业务类
 *
 * @author Garen Gosling
 * @create 2017-09-15 23:34
 * @since v1.0
 */
@Service
public class UploadManage {
    private static Logger logger = LoggerFactory.getLogger(FileUploadValid.class);

    @Value("${upload.cache.file}")
    private String UPLOAD_CACHE_FILE;
    @Value("${upload.cache.delimiter}")
    private String UPLOAD_CACHE_DELIMITER;
    @Value("${upload.cache.thumbnailWidth}")
    protected int THUMBNAIL_WIDTH;
    @Value("${upload.cache.thumbnailHeight}")
    protected int THUMBNAIL_HEIGHT;
    @Autowired
    FileInfoManage fileInfoManage;
    @Autowired
    FileTypesCache fileTypesCache;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @return
     */
    @Transactional
    public Map<String, Object> upload(MultipartFile multipartFile, FileType fileType) {
        // 1、初始化对象
        org.garen.oss.swagger.model.FileInfo fileInfoParam = null;
        try {
            fileInfoParam = getFileInfoByMultipartFile(multipartFile, fileType);
        } catch (IOException e) {
            return resultMap(null, 0, "初始化对象异常", null);
        }
        // 2、是否已存在
        FileInfo fileInfo = fileInfoManage.getByMd5(fileInfoParam.getMd5());
        if(fileInfo != null){
            return resultMap(fileInfo, 0, "文件已存在", null);
        }

        // 4、文件缓存到本地目录
        String cacheDirPath = getCacheDirPath(fileInfoParam.getCategory());
        FileUtil.mkdir(cacheDirPath);
        String cacheFullFullName = getCacheFileFullName(fileInfoParam.getCategory(), fileInfoParam.getMd5(), fileInfoParam.getType());
        File cacheFile = new File(cacheFullFullName);
        try {
            multipartFile.transferTo(cacheFile);
        } catch (IOException e) {
            return resultMap(null, 0, "文件缓存到本地目录异常", e.getMessage());
        }
        // 缩略图缓存到本地
        File cacheThumbnailImage = null;
        if("picture".equals(fileInfoParam.getCategory())
                || "pdf".equals(fileInfoParam.getType())){
            try {
                cacheThumbnailImage = createThumbnailImage(fileInfoParam.getCategory(), fileInfoParam.getType(), fileInfoParam.getMd5());
            } catch (IOException e) {
                e.printStackTrace();
                return resultMap(null, 0, "缩略图异常1", e.getMessage());
            } catch (PDFException e) {
                e.printStackTrace();
                return resultMap(null, 0, "缩略图异常2", e.getMessage());
            } catch (PDFSecurityException e) {
                e.printStackTrace();
                return resultMap(null, 0, "缩略图异常3", e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return resultMap(null, 0, "缩略图异常4", e.getMessage());
            }
        }
        // 2、持久化文件信息
        fileInfoParam.setMinMd5(minMd5(fileInfoParam.getMd5()));
        fileInfoParam.setMinPreview(cacheThumbnailImage.length() + "");
        fileInfo = fileInfoManage.saveFileInfo2(fileInfoParam);
        // 3、验证保存
        if(fileInfo == null) {
            return resultMap(null, 0, "保存文件信息异常", null);
        }
        // 5、上传至OSS服务器
        uploadOSS(cacheFile, cacheThumbnailImage);
        // 6、删除缓存文件   TODO
//            FileUtil.deleteFile(cacheFile);
//            FileUtil.deleteFile(cacheThumbnailImage);
        // 7、返回文件信息对象
        return resultMap(fileInfo, 1, null, null);
    }

    /**
     * 制作缩略图
     *      类型：图片
     *
     * @param category
     * @param type
     * @param md5
     * @return
     */
    public File createThumbnailImage(String category, String type, String md5) throws IOException, PDFException, PDFSecurityException, InterruptedException {
        FileUtil.mkdir(getCacheThumbnailDirPath(category));
        File thumbnailImage = null;
        if("picture".equals(category)){
            //thumbnailImage = new File(getCacheFileThumbnailFullName(category, md5, type));
            //Thumbnails.of(file.getInputStream()).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnailImage);
            return thumbnailImage(category, type, md5);
        }else if ("pdf".equals(type)){
            thumbnailImage = new File(getCacheFileThumbnailFullName(category, md5, "jpg"));
            Document document = new Document();
            document.setFile(getCacheFileFullName(category, md5, type));
            BufferedImage image = (BufferedImage) document.getPageImage(0, GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX, 0f, 1f);
            Thumbnails.of(image).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnailImage);
            return thumbnailImage;
        }
        return null;
    }

    public File thumbnailImage(String category, String type, String md5){
        String fileFullName = getCacheFileFullName(category, md5, type);
        String fileThumbnailFullName = getCacheFileThumbnailFullName(category, md5, type);
        File imgFile = new File(fileFullName);
        Image img = null;
        try {
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            logger.info("缩略图生成异常-1");
            e.printStackTrace();
        }
        BufferedImage bi = new BufferedImage(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        g.drawImage(img, 0, 0, THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, Color.LIGHT_GRAY, null);
        g.dispose();
        File thumbnailFile = null;
        try {
            thumbnailFile = new File(fileThumbnailFullName);
            ImageIO.write(bi, type, thumbnailFile);
        } catch (IOException e) {
            logger.info("缩略图生成异常-2");
            e.printStackTrace();
        }
        logger.info("缩略图生成成功");
        return thumbnailFile;
    }

    /**
     * 上传至OSS服务器
     *
     * @param cacheFile
     */
    public void uploadOSS(File cacheFile, File thumbnailCacheFile){
        // TODO
    }


    /**
     * 上传文件缓存路径
     *
     * @param category
     * @return
     */
    public String getCacheDirPath(String category){
        return UPLOAD_CACHE_FILE + UPLOAD_CACHE_DELIMITER + category;
    }

    /**
     * 上传文件缩略图缓存路径
     *
     * @param category
     * @return
     */
    public String getCacheThumbnailDirPath(String category){
        return UPLOAD_CACHE_FILE + UPLOAD_CACHE_DELIMITER + category + UPLOAD_CACHE_DELIMITER + "Thumbnail";
    }

    /**
     * 上传文件缓存全文件名
     *
     * @param md5
     * @param suffix
     * @return
     */
    public String getCacheFileFullName(String category, String md5, String suffix){
        return getCacheDirPath(category) + UPLOAD_CACHE_DELIMITER + md5 + "." + suffix;
    }

    /**
     * 缩略图名称
     *
     * @param md5
     * @return
     */
    public String minMd5(String md5){
        return  "THUMBNAIL-" + md5;
    }

    /**
     * 上传文件缩略图缓存全文件名
     *
     * @param md5
     * @param suffix
     * @return
     */
    public String getCacheFileThumbnailFullName(String category, String md5, String suffix){
        return getCacheThumbnailDirPath(category) + UPLOAD_CACHE_DELIMITER + minMd5(md5) + "." + suffix;
    }

    /**
     * 初始化对象
     *
     * @param multipartFile
     * @param fileType
     * @return
     * @throws IOException
     */
    public org.garen.oss.swagger.model.FileInfo getFileInfoByMultipartFile(MultipartFile multipartFile, FileType fileType) throws IOException {
        org.garen.oss.swagger.model.FileInfo fileInfo = new org.garen.oss.swagger.model.FileInfo();
        fileInfo.setName(multipartFile.getOriginalFilename());
        fileInfo.setType(fileType.getName());
        fileInfo.setCategory(fileType.getType());
        fileInfo.setSize(multipartFile.getSize());
        fileInfo.setMd5(DigestUtils.md5Hex(IOUtils.toByteArray(multipartFile.getInputStream())));
        fileInfo.setMinMd5(null);
        fileInfo.setPreview("default");
        fileInfo.setMinPreview(null);
        return fileInfo;
    }

    /**
     * 哈希结果
     *
     * @param fileInfo
     * @param count
     * @return
     */
    public Map<String, Object> resultMap(FileInfo fileInfo, Integer count, String msg, String data){
        Map<String, Object> map = new HashedMap();
        map.put("fileInfo", fileInfo);
        map.put("count", count);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

}
