package org.garen.oss.service.validate;

import org.apache.commons.lang3.StringUtils;
import org.garen.oss.swagger.model.FileInfo;
import org.garen.oss.swagger.model.SuccessModel;
import org.springframework.stereotype.Component;

/**
 * FileTypeManage的验证类
 *
 * @author Garen Gosling
 * @create 2017-09-14 20:47
 * @since v1.0
 */
@Component
public class FileInfoManageValidate extends BaseValidate{

    /**
     * 新增文件信息，验证参数
     *
     * @param fileInfo
     * @return
     */
    public SuccessModel saveFileInfoValidate(FileInfo fileInfo){
        if(fileInfo == null){
            return validateFailResponse();
        }
        if(StringUtils.isBlank(fileInfo.getName())){
            return validateFailResponse("名称");
        }
        if(StringUtils.isBlank(fileInfo.getType())){
            return validateFailResponse("文件类型");
        }
        if(StringUtils.isBlank(fileInfo.getCategory())){
            return validateFailResponse("文件种类");
        }
        if(fileInfo.getSize() == null){
            return validateFailResponse("文件大小");
        }
        if(StringUtils.isBlank(fileInfo.getMd5())){
            return validateFailResponse("文件MD5值");
        }
        if(StringUtils.isBlank(fileInfo.getPreview())){
            return validateFailResponse("文件下载路径");
        }
        return null;
    }

    /**
     * 修改文件类型，验证参数
     *
     * @param fileInfo
     * @return
     */
    public SuccessModel updateFileInfoValidate(FileInfo fileInfo){
        if(fileInfo == null){
            return validateFailResponse("修改的对象");
        }
        if(fileInfo.getId() == null || fileInfo.getId() == 0){
            return validateFailResponse("id");
        }
        if(StringUtils.isBlank(fileInfo.getName())
                && StringUtils.isBlank(fileInfo.getType())
                && StringUtils.isBlank(fileInfo.getCategory())
                && fileInfo.getSize() == null
                && StringUtils.isBlank(fileInfo.getMd5())
                && StringUtils.isBlank(fileInfo.getMinMd5())
                && StringUtils.isBlank(fileInfo.getPreview())
                && StringUtils.isBlank(fileInfo.getMinPreview())
                ){
            return validateFailResponse("修改的参数");
        }
        return null;
    }

    /**
     * ID查询、删除文件类型，验证参数
     *
     * @param id
     * @return
     */
    public SuccessModel idValidate(Long id){
        if(id == null){
            return validateFailResponse("id");
        }
        return null;
    }

    /**
     * 编码查询文件类型，验证参数
     *
     * @param md5
     * @return
     */
    public SuccessModel md5Validate(String md5){
        if(StringUtils.isBlank(md5)){
            return validateFailResponse("md5");
        }
        return null;
    }

    /**
     * 名称查询文件类型，验证参数
     *
     * @param minMd5
     * @return
     */
    public SuccessModel minMd5Validate(String minMd5){
        if(StringUtils.isBlank(minMd5)){
            return validateFailResponse("minMd5");
        }
        return null;
    }

}
