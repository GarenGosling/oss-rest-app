package org.garen.oss.cache;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.service.FileTypeManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 文件类型缓存
 *
 * @author Garen Gosling
 * @create 2017-09-16 02:06
 * @since v1.0
 */

@Component
public class FileTypesCache {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    FileTypeManage fileTypeManage;

    /**
     * 文件类型缓存
     */
    public static Map<String, FileType> FILE_TYPES_CACHE = null;

    /**
     * 初始化文件类型缓存
     */
    public void init(){
        logger.info("============== init FILE_TYPES_CACHE start ==============");
        List<FileType> fileTypes = fileTypeManage.getService().findAll();
        if(CollectionUtils.isNotEmpty(fileTypes)){
            FILE_TYPES_CACHE = new HashedMap();
            fileTypes.forEach(fileType -> {
                FILE_TYPES_CACHE.put(fileType.getCode(), fileType);
            });
        }
        if(FILE_TYPES_CACHE == null){
            logger.error("init fail!");
        }else{
            logger.info("init success!");
        }
        logger.info("============== init FILE_TYPES_CACHE end ==============");
    }

    /**
     * 新增、修改
     *
     * @param fileType
     */
    public void saveOrUpdate(FileType fileType){
        logger.info("============== saveOrUpdate FILE_TYPES_CACHE start ==============");
        if(FILE_TYPES_CACHE == null){
            throw new RuntimeException("FILE_TYPES_CACHE is null");
        }
        FILE_TYPES_CACHE.put(fileType.getCode(), fileType);
        logger.info("============== saveOrUpdate FILE_TYPES_CACHE end ==============");
    }

    /**
     * 删除
     *
     * @param fileType
     */
    public void delete(FileType fileType){
        logger.info("============== update FILE_TYPES_CACHE start ==============");
        if(FILE_TYPES_CACHE == null){
            throw new RuntimeException("FILE_TYPES_CACHE is null");
        }
        FILE_TYPES_CACHE.remove(fileType.getCode());
        logger.info("============== update FILE_TYPES_CACHE end ==============");
    }
    /**
     * 将文件头转换成16进制字符串
     *
     * @param bytes
     * @return 16进制字符串
     */
    private String bytesToHexString(byte[] bytes){
        // 验证
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        // 业务
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String s = Integer.toHexString(v);
            if (s.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    /**
     * 判断文件类型
     *
     * @param is
     * @return
     * @throws IOException
     */
    public FileType getType(InputStream is) throws IOException {
        if(FILE_TYPES_CACHE == null){
            throw new RuntimeException("FILE_TYPES_CACHE is null");
        }
        byte[] b = new byte[28];
        is.read(b, 0, 28);
        String fileHead = bytesToHexString(b);
        // 验证
        if(StringUtils.isBlank(fileHead)){
            return null;
        }
        // 业务
        fileHead = fileHead.toUpperCase();
        for (String key : FILE_TYPES_CACHE.keySet()) {
            if (fileHead.startsWith(key)) {
                FileType fileType = FILE_TYPES_CACHE.get(key);
                if(fileType.getAvailable()){
                    return fileType;
                }
            }
        }
        return null;
    }

}
