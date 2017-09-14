package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.PropertyUtils;
import org.garen.oss.service.FileTypeManage;
import org.garen.oss.service.validate.FileTypeManageValidate;
import org.garen.oss.swagger.model.FileType;
import org.garen.oss.swagger.model.SuccessModel;
import org.garen.oss.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-14T10:30:32.894Z")

@Controller
public class FileTypeApiController implements FileTypeApi {

    @Autowired
    FileTypeManage fileTypeManage;

    public ResponseEntity<SuccessModel> deleteFileType(@ApiParam(value = "文件类型ID") @RequestParam(value = "id", required = false) Long id) {
        SuccessModel successModel = fileTypeManage.deleteFileType(id);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getAll() {
        SuccessModel successModel = fileTypeManage.getAll();
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByCode(@ApiParam(value = "文件类型编码") @RequestParam(value = "code", required = false) String code) {
        SuccessModel successModel = fileTypeManage.getByCode(code);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByName(@ApiParam(value = "文件类型名称") @RequestParam(value = "name", required = false) String name) {
        SuccessModel successModel = fileTypeManage.getByName(name);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "文件名称") @RequestParam(value = "name", required = false) String name) {
        SuccessModel successModel = fileTypeManage.getByPage(start, length, name);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getFileType(@ApiParam(value = "文件类型ID") @RequestParam(value = "id", required = false) Long id) {
        SuccessModel successModel = fileTypeManage.getFileType(id);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> saveFileType(@ApiParam(value = "文件类型"  ) @RequestBody FileType fileType) {
        SuccessModel successModel = fileTypeManage.saveFileType(fileType);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> updateFileType(@ApiParam(value = "文件类型"  ) @RequestBody FileType fileType) {
        SuccessModel successModel = fileTypeManage.updateFileType(fileType);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

}
