package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.garen.oss.service.FileInfoManage;
import org.garen.oss.swagger.model.FileInfo;
import org.garen.oss.swagger.model.SuccessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T04:56:23.159Z")

@Controller
public class FileInfoApiController implements FileInfoApi {

    @Autowired
    FileInfoManage fileInfoManage;

    public ResponseEntity<SuccessModel> deleteFileInfo(@ApiParam(value = "文件信息ID") @RequestParam(value = "id", required = false) Long id) {
        SuccessModel successModel = fileInfoManage.deleteFileInfo(id);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getAll() {
        SuccessModel successModel = fileInfoManage.getAll();
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByMd5(@ApiParam(value = "md5") @RequestParam(value = "md5", required = false) String md5) {
        SuccessModel successModel = fileInfoManage.getByMd5(md5);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByMinMd5(@ApiParam(value = "minMd5") @RequestParam(value = "minMd5", required = false) String minMd5) {
        SuccessModel successModel = fileInfoManage.getByMinMd5(minMd5);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
        @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
        @ApiParam(value = "文件名称") @RequestParam(value = "name", required = false) String name,
        @ApiParam(value = "文件类型") @RequestParam(value = "type", required = false) String type,
        @ApiParam(value = "文件种类") @RequestParam(value = "category", required = false) String category,
        @ApiParam(value = "文件大小从") @RequestParam(value = "sizeBegin", required = false) Long sizeBegin,
        @ApiParam(value = "文件大小至") @RequestParam(value = "sizeEnd", required = false) Long sizeEnd,
        @ApiParam(value = "文件MD5值") @RequestParam(value = "md5", required = false) String md5,
        @ApiParam(value = "文件缩略图MD5值") @RequestParam(value = "minMd5", required = false) String minMd5,
        @ApiParam(value = "创建时间从") @RequestParam(value = "createTimeBegin", required = false) String createTimeBegin,
        @ApiParam(value = "创建时间至") @RequestParam(value = "createTimeEnd", required = false) String createTimeEnd) {
        SuccessModel successModel = fileInfoManage.getByPage(start, length, name, type, category, sizeBegin, sizeEnd, md5, minMd5, createTimeBegin, createTimeEnd);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> getFileInfo(@ApiParam(value = "文件信息ID") @RequestParam(value = "id", required = false) Long id) {
        SuccessModel successModel = fileInfoManage.getFileInfo(id);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> saveFileInfo(@ApiParam(value = "文件信息"  ) @RequestBody FileInfo fileInfo) {
        SuccessModel successModel = fileInfoManage.saveFileInfo(fileInfo);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

    public ResponseEntity<SuccessModel> updateFileInfo(@ApiParam(value = "文件信息"  ) @RequestBody FileInfo fileInfo) {
        SuccessModel successModel = fileInfoManage.updateFileInfo(fileInfo);
        return new ResponseEntity<SuccessModel>(successModel, HttpStatus.OK);
    }

}
