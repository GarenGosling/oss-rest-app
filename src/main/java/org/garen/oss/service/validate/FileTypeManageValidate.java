package org.garen.oss.service.validate;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.protocol.HTTP;

import org.garen.oss.swagger.model.FileType;
import org.garen.oss.swagger.model.SuccessModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * FileTypeManage的验证类
 *
 * @author Garen Gosling
 * @create 2017-09-14 20:47
 * @since v1.0
 */
@Component
public class FileTypeManageValidate extends BaseValidate{

    /**
     * 新增文件类型，验证参数
     *
     * @param fileType
     * @return
     */
    public SuccessModel saveFileTypeValidate(FileType fileType){
        if(fileType == null){
            return validateFailResponse();
        }
        if(StringUtils.isBlank(fileType.getName())){
            return validateFailResponse("名称");
        }
        if(StringUtils.isBlank(fileType.getCode())){
            return validateFailResponse("编码");
        }
        if(StringUtils.isBlank(fileType.getType())){
            return validateFailResponse("分类");
        }
        if(fileType.getMaxSize() == null){
            return validateFailResponse("最大允许的文件大小");
        }
        if(fileType.getAvailable() == null){
            return validateFailResponse("是否使用");
        }
        return null;
    }

    /**
     * 修改文件类型，验证参数
     *
     * @param fileType
     * @return
     */
    public SuccessModel updateFileTypeValidate(FileType fileType){
        if(fileType == null){
            return validateFailResponse("修改的对象");
        }
        if(fileType.getId() == null || fileType.getId() == 0){
            return validateFailResponse("id");
        }
        if(StringUtils.isBlank(fileType.getName())
                && StringUtils.isBlank(fileType.getCode())
                && StringUtils.isBlank(fileType.getType())
                && fileType.getMaxSize() == null
                && fileType.getAvailable() == null){
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
     * @param code
     * @return
     */
    public SuccessModel codeValidate(String code){
        if(StringUtils.isBlank(code)){
            return validateFailResponse("code");
        }
        return null;
    }

    /**
     * 名称查询文件类型，验证参数
     *
     * @param name
     * @return
     */
    public SuccessModel nameValidate(String name){
        if(StringUtils.isBlank(name)){
            return validateFailResponse("name");
        }
        return null;
    }

}
