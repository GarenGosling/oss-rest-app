package org.garen.oss.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;


/**
 * <B>文件名称：</B>UploadHandler.java<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <BR> 上传通用工具类
 * <B>版权声明：</B><BR>
 * <B>公司部门：</B><BR>
 * <B>创建时间：</B><BR>
 *
 * @author 刘学良 liuxueliang@yingu.com
 * @version 1.0
 */
@Component
public class UploadHandler {


   /* @Autowired
    FileService fileService;

    @Autowired
    FileUploadManage fileUploadManage;

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadHandler.class);

    public String getUploadSuffix(){
        return UPLOAD_SUFFIXES_IMAGE + "," + UPLOAD_SUFFIXES_OTHERS;
    }


    *//**
     * 验证
     * @param multipartFile
     * @return
     *//*
    private FileUpload validate(MultipartFile multipartFile){
        FileUpload uploadEntity = null;
        // 验证文件类型
        if(!validSuffix(getSuffix(multipartFile))){
            throw new BadRequestException("只能上传"+getUploadSuffix()+"类型的文件");
        }
        return uploadEntity;
    }

    *//**
     * 单个上传
     * @param multipartFile
     * @return
     *//*
    public FileUpload fileUploadSingle(MultipartFile multipartFile) {
        //验证
        FileUpload uploadEntity = validate(multipartFile);
        if(uploadEntity != null){
            return uploadEntity;
        }

        uploadEntity = new FileUpload();
        try {
            uploadEntity.setName(       this.getOldName(multipartFile));
            uploadEntity.setMd5(        this.getMd5(multipartFile));
            uploadEntity.setFileSize(   this.getFileSize(multipartFile));
            uploadEntity.setSuffix(     this.getSuffix(multipartFile));
            uploadEntity.setCreateTime( new Date());
            uploadEntity.setPath(       "/preview/" + uploadEntity.getMd5() + "/" + uploadEntity.getSuffix());

            //判断文件是否存在
            FileUploadQuery query       = new FileUploadQuery();
            query.or().andMd5EqualTo(   uploadEntity.getMd5());
            FileUpload fileUpload       = fileUploadManage.getService().selectOneByExample(query);
            if(!ObjectUtils.isEmpty(fileUpload)){
//                throw new BadRequestException("该文件已存在，不可以重复上传");
                return fileUpload;
            }
            fileService.upload(         multipartFile   , uploadEntity.getMd5());
            uploadEntity                = fileUploadManage.save(uploadEntity);
            return uploadEntity;
        }catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("fileUploadSingle 上传文件异常:{}",e.getMessage());
            throw new BadRequestException("上传文件异常");
        }
    }



    public String getSuffix(MultipartFile multipartFile){
        String fullName = multipartFile.getOriginalFilename();
        return fullName.substring(fullName.lastIndexOf('.')+1);
    }



    private String getFullPath(String path){
        String fullPath = "";
        if(StringUtils.isBlank(path)){
            fullPath = YG_ONLINE_API_UPLOAD;
        }else {
            fullPath = YG_ONLINE_API_UPLOAD+path;
        }
        return fullPath;
    }

    public String getFullPath(FileUpload fileUpload) {
        String pre          = getFullPath(fileUpload.getPath());
        String newFileName  = fileUpload.getMd5() + "." + fileUpload.getSuffix();
        return pre +"/"+ newFileName;
    }

    private boolean validSuffix(String suffix){
        boolean available = false;
        String[] suffixes = getUploadSuffix().split(",");
        for (String s : suffixes) {
            if(s.equals(suffix)){
                available = true;
                break;
            }
        }
        return available;
    }

    private boolean validSuffix(String suffix, String uploadSuffixes){
        boolean available = false;
        if(StringUtils.isBlank(uploadSuffixes)){
            return validSuffix(suffix);
        }
        String[] suffixes = uploadSuffixes.split(",");
        for (String s : suffixes) {
            if(s.toLowerCase().equals(suffix.toLowerCase())){
                available = true;
                break;
            }
        }
        return available;
    }

    *//**
     * 删除文件
     * @return
     * @throws Exception
     *//*
    public boolean deleteFile(String fullName){
        File file = new File(fullName);
        boolean flag = false;
        if(file.isFile()){
            flag = file.delete();
        }
        return flag;
    }

    *//**
     * 图片制作缩略图
     * @param file
     * @return
     *//*
    public File createThumbnail(MultipartFile file){
        String suffix = getSuffix(file);
        if(StringUtils.isBlank(suffix)){
            throw new BadRequestException("上传文件异常");
        }
        if("pdf".equals(suffix.toLowerCase())){
           return createThumbnailPDF(file);
        }
        if(validSuffix(suffix, UPLOAD_SUFFIXES_IMAGE)){
            return createThumbnailImage(file);
        }
        throw new BadRequestException("制作缩略图异常");
    }

    public File createThumbnailImage(MultipartFile file){
        String fileMd5 = getMd5(file);
        String fileSuffix = getSuffix(file);
        String dirPath = YG_ONLINE_CACHE_FILE + YG_ONLINE_CACHE_THUMBNAIL;
        hasDirectory(dirPath);
        File thumbnailFile = new File(dirPath + fileMd5 + "." + fileSuffix);
        try {
            Thumbnails.of(file.getInputStream()).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnailFile);
            return thumbnailFile;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("制作缩略图异常:{}",e.getMessage());
            throw new BusinessException("制作缩略图异常");
        }
    }

    public File createThumbnailPDF(MultipartFile file) {
        String fileMd5 = getMd5(file);
        String dirPath = YG_ONLINE_CACHE_FILE + YG_ONLINE_CACHE_THUMBNAIL;
        hasDirectory(dirPath);
        File thumbnailFile = new File(dirPath + fileMd5 + ".jpg");
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            Document document = new Document();
            document.setInputStream(inputStream, null);

            BufferedImage image = (BufferedImage) document.getPageImage(0,
                    GraphicsRenderingHints.SCREEN,
                    Page.BOUNDARY_CROPBOX,
                    0f, 1f);
            Thumbnails.of(image).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnailFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (PDFException e) {
            e.printStackTrace();
        } catch (PDFSecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return thumbnailFile;
    }

    *//**
     * 图片制作缩略图
     * @param file
     * @return
     *//*
    public File createThumbnail(byte[] file,String suffix){
        if(StringUtils.isBlank(suffix)){
            throw new BadRequestException("上传文件异常");
        }
        if("pdf".equals(suffix.toLowerCase())){
            return createThumbnailPDF(file);
        }
        if(validSuffix(suffix, UPLOAD_SUFFIXES_IMAGE)){
            return createThumbnailImage(file,suffix);
        }
        throw new BadRequestException("制作缩略图异常");
    }

    public File createThumbnailImage(byte[] file,String fileSuffix){
        String fileMd5 = MD5Util.getMD5String(file);
        String dirPath = YG_ONLINE_CACHE_FILE + YG_ONLINE_CACHE_THUMBNAIL;
        hasDirectory(dirPath);
        File thumbnailFile = new File(dirPath + fileMd5 + "." + fileSuffix);
        try {
            Thumbnails.of(new ByteArrayInputStream(file)).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnailFile);
            return thumbnailFile;
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("制作缩略图异常:{}",e.getMessage());
            throw new BusinessException("制作缩略图异常");
        }
    }

    public File createThumbnailPDF(byte[] file) {
        String fileMd5 = MD5Util.getMD5String(file);
        String dirPath = YG_ONLINE_CACHE_FILE + YG_ONLINE_CACHE_THUMBNAIL;
        hasDirectory(dirPath);
        File thumbnailFile = new File(dirPath + fileMd5 + ".jpg");
        InputStream inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(file);
            Document document = new Document();
            document.setInputStream(inputStream, null);

            BufferedImage image = (BufferedImage) document.getPageImage(0,
                    GraphicsRenderingHints.SCREEN,
                    Page.BOUNDARY_CROPBOX,
                    0f, 1f);
            Thumbnails.of(image).size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT).toFile(thumbnailFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (PDFException e) {
            e.printStackTrace();
        } catch (PDFSecurityException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return thumbnailFile;
    }
    *//**
     * 缩略图MD5
     * @param thumbnailFile
     * @return
     *//*
    public String getThumbnailMd5(File thumbnailFile){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(thumbnailFile);
            return DigestUtils.md5Hex(IOUtils.toByteArray(fileInputStream));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new BusinessException("缩略图文件名异常");
        } catch (IOException e) {
            e.printStackTrace();
            throw new BusinessException("缩略图文件名异常");
        }
    }

    *//**
     * 缩略图后缀
     * @param thumbnailFile
     * @return
     *//*
    public String getThumbnailSuffix(File thumbnailFile){
        if(StringUtils.isBlank(thumbnailFile.getName()) || thumbnailFile.getName().split("[.]").length != 2){
            throw new BusinessException("缩略图文件名异常");
        }
        return thumbnailFile.getName().split("[.]")[1].toLowerCase();
    }

    *//**
     * 目录不存在则创建
     * @param path
     *//*
    public static boolean hasDirectory(String path) {
        File dir = new File(path);
        return dir.mkdirs();
    }*/
}
