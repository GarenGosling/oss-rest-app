package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.oss.cache.FileTypesCache;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.service.UploadManage;
import org.garen.oss.swagger.api.Valid.FileUploadValid;
import org.garen.oss.swagger.model.BaseModel;
import org.garen.oss.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-23T10:42:37.061Z")

@Controller
public class UploadApiController extends BaseModel implements UploadApi {

    @Autowired
    FileUploadValid valid;
    @Autowired
    UploadManage uploadManage;
    @Autowired
    FileTypesCache fileTypesCache;

    public ResponseEntity<ResponseModel> fileupload(@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) {

        FileType fileType = null;
        try {
            fileType = fileTypesCache.getType(file.getInputStream());
        } catch (IOException e) {
            return new ResponseEntity<ResponseModel>(exceptionModel("文件上传异常，数量：0", e.getMessage()), HttpStatus.OK);
        }
        String msg = valid.multipartFileValid(file, fileType);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        Map<String, Object> resultMap = uploadManage.upload(file, fileType);
        if(resultMap.get("fileInfo") == null){
            return new ResponseEntity<ResponseModel>(exceptionModel(resultMap.get("msg") + "，数量：" + (Integer)resultMap.get("count"), (String) resultMap.get("data")), HttpStatus.OK);
        }
        return new ResponseEntity<ResponseModel>(successModel("文件上传成功，数量：" + (Integer)resultMap.get("count"), resultMap.get("fileInfo")), HttpStatus.OK);

    }

}
