package org.garen.oss.swagger.api.Valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.oss.swagger.model.FileInfo;
import org.springframework.stereotype.Component;

/**
 * 文件信息接口入参验证类
 *
 * @author Garen Gosling
 * @create 2017-09-16 10:10
 * @since v1.0
 */
@Component
public class FileInfoValid extends BaseValid {

    /**
     * 新增文件信息，验证参数
     *
     * @param fileInfo
     * @return
     */
    public String saveFileInfoValid(FileInfo fileInfo){
        if(fileInfo == null){
            return paramNullMsg();
        }
        if(StringUtils.isBlank(fileInfo.getName())){
            return emptyMsg("名称");
        }
        if(StringUtils.isBlank(fileInfo.getType())){
            return emptyMsg("文件类型");
        }
        if(StringUtils.isBlank(fileInfo.getCategory())){
            return emptyMsg("文件种类");
        }
        if(fileInfo.getSize() == null){
            return emptyMsg("文件大小");
        }
        if(StringUtils.isBlank(fileInfo.getMd5())){
            return emptyMsg("文件MD5值");
        }
        if(StringUtils.isBlank(fileInfo.getPreview())){
            return emptyMsg("文件下载路径");
        }
        return null;
    }

    /**
     * 修改文件类型，验证参数
     *
     * @param fileInfo
     * @return
     */
    public String updateFileInfoValid(FileInfo fileInfo){
        if(fileInfo == null){
            return paramNullMsg();
        }
        if(fileInfo.getId() == null || fileInfo.getId() == 0){
            return emptyMsg("id");
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
     * @param md5
     * @return
     */
    public String md5Valid(String md5){
        if(StringUtils.isBlank(md5)){
            return emptyMsg("md5");
        }
        return null;
    }

    /**
     * 名称查询文件类型，验证参数
     *
     * @param minMd5
     * @return
     */
    public String minMd5Valid(String minMd5){
        if(StringUtils.isBlank(minMd5)){
            return emptyMsg("minMd5");
        }
        return null;
    }
    
    
}
