package org.garen.oss.swagger.api;

//import com.sun.istack.internal.NotNull;


import io.swagger.annotations.*;
import org.garen.oss.swagger.model.SuccessModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-23T10:42:37.061Z")

@Api(value = "fileupload", description = "the fileupload API")
public interface FileuploadApi {

    @ApiOperation(value = "文件上传", notes = "流程图", response = SuccessModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = SuccessModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = SuccessModel.class) })
    @RequestMapping(value = "/fileupload",
        produces = { "application/json" },
        consumes = { "multipart/form-data" },
        method = RequestMethod.POST)
    ResponseEntity<SuccessModel> fileupload(@ApiParam(value = "file detail") @RequestPart("file") MultipartFile file);


}
