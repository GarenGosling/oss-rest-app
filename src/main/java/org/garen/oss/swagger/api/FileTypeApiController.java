package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.oss.service.FileTypeManage;
import org.garen.oss.swagger.api.Valid.FileTypeValid;
import org.garen.oss.swagger.model.BaseModel;
import org.garen.oss.swagger.model.FileType;
import org.garen.oss.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-14T10:30:32.894Z")

@Controller
public class FileTypeApiController extends BaseModel implements FileTypeApi {

    @Autowired
    FileTypeValid valid;
    
    @Autowired
    FileTypeManage fileTypeManage;

    public ResponseEntity<ResponseModel> deleteFileType(@ApiParam(value = "文件类型ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = fileTypeManage.deleteFileType(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getAll() {
        List<org.garen.oss.mybatis.domain.FileType> all = fileTypeManage.findAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "文件类型编码") @RequestParam(value = "code", required = false) String code) {
        String msg = valid.codeValid(code);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        
        org.garen.oss.mybatis.domain.FileType fileType = fileTypeManage.getByCode(code);
        return new ResponseEntity<ResponseModel>(successModel("查询", fileType), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByName(@ApiParam(value = "文件类型名称") @RequestParam(value = "name", required = false) String name) {
        String msg = valid.nameValid(name);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        org.garen.oss.mybatis.domain.FileType fileType = fileTypeManage.getByName(name);
        return new ResponseEntity<ResponseModel>(successModel("查询", fileType), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "文件名称") @RequestParam(value = "name", required = false) String name) {
        Map page = fileTypeManage.getByPage(start, length, name);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getFileType(@ApiParam(value = "文件类型ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = fileTypeManage.findById(id);
        return new ResponseEntity<ResponseModel>(successModel("查询成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveFileType(@ApiParam(value = "文件类型"  ) @RequestBody FileType fileType) {
        String msg = valid.saveFileTypeValid(fileType);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = fileTypeManage.saveFileType(fileType);
        return new ResponseEntity<ResponseModel>(successModelMsg("新增成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateFileType(@ApiParam(value = "文件类型"  ) @RequestBody FileType fileType) {
        String msg = valid.updateFileTypeValid(fileType);
        int i = fileTypeManage.updateFileType(fileType);
        return new ResponseEntity<ResponseModel>(successModelMsg("修改成功，数量：" + i), HttpStatus.OK);
    }

}
