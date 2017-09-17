package org.garen.oss.swagger.api.Valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.oss.swagger.model.FileType;
import org.springframework.stereotype.Component;

/**
 * 文件类型接口入参验证类
 *
 * @author Garen Gosling
 * @create 2017-09-16 10:11
 * @since v1.0
 */
@Component
public class FileTypeValid extends BaseValid{
    /**
     * 新增文件类型，验证参数
     *
     * @param fileType
     * @return
     */
    public String saveFileTypeValid(FileType fileType){
        if(fileType == null){
            return paramNullMsg();
        }
        if(StringUtils.isBlank(fileType.getName())){
            return emptyMsg("名称");
        }
        if(StringUtils.isBlank(fileType.getCode())){
            return emptyMsg("编码");
        }
        if(StringUtils.isBlank(fileType.getType())){
            return emptyMsg("分类");
        }
        if(fileType.getMaxSize() == null){
            return emptyMsg("最大允许的文件大小");
        }
        if(fileType.getAvailable() == null){
            return emptyMsg("是否使用");
        }
        return null;
    }

    /**
     * 修改文件类型，验证参数
     *
     * @param fileType
     * @return
     */
    public String updateFileTypeValid(FileType fileType){
        if(fileType == null){
            return paramNullMsg();
        }
        if(fileType.getId() == null || fileType.getId() == 0){
            return emptyMsg("id");
        }
        if(StringUtils.isBlank(fileType.getName())
                && StringUtils.isBlank(fileType.getCode())
                && StringUtils.isBlank(fileType.getType())
                && fileType.getMaxSize() == null
                && fileType.getAvailable() == null){
            return paramNullMsg();
        }
        return null;
    }

    /**
     * ID查询、删除文件类型，验证参数
     *
     * @param id
     * @return
     */
    public String idValid(Long id){
        if(id == null){
            return emptyMsg("id");
        }
        return null;
    }

    /**
     * 编码查询文件类型，验证参数
     *
     * @param code
     * @return
     */
    public String codeValid(String code){
        if(StringUtils.isBlank(code)){
            return emptyMsg("code");
        }
        return null;
    }

    /**
     * 名称查询文件类型，验证参数
     *
     * @param name
     * @return
     */
    public String nameValid(String name){
        if(StringUtils.isBlank(name)){
            return emptyMsg("name");
        }
        return null;
    }
    
}
