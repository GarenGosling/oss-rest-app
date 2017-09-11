package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.garen.oss.swagger.model.SuccessModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-23T10:42:37.061Z")

@Controller
public class FileuploadApiController implements FileuploadApi {

    public ResponseEntity<SuccessModel> fileupload(@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file) {

        System.out.println("do some magic");

        return new ResponseEntity<SuccessModel>(new SuccessModel().data(null).message("上传成功"), HttpStatus.OK);
    }

}
