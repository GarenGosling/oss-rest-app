package org.garen.oss.swagger.api.Valid;

import org.garen.oss.mybatis.domain.FileType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传接口入参验证类
 *
 * @author Garen Gosling
 * @create 2017-09-16 10:12
 * @since v1.0
 */
@Component
public class FileUploadValid extends BaseValid{
    private static Logger logger = LoggerFactory.getLogger(FileUploadValid.class);

    /**
     * 验证上传文件
     *
     * @param multipartFile
     * @param fileType
     * @return
     */
    public String multipartFileValid(MultipartFile multipartFile, FileType fileType) {
        if (multipartFile == null) {
            return emptyMsg("文件");
        }
        if (fileType == null) {
            return "系统不支持该类型文件上传";
        }
        if (multipartFile.getSize() > fileType.getMaxSize()) {
            return fileType.getName() + "类型的文件单次上传最大为" + fileType.getMaxSize() / 1024 + "KB";
        }
        return null;
    }

}
