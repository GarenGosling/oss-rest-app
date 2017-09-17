package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.oss.service.FileInfoManage;
import org.garen.oss.swagger.api.Valid.FileInfoValid;
import org.garen.oss.swagger.model.BaseModel;
import org.garen.oss.swagger.model.FileInfo;
import org.garen.oss.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T04:56:23.159Z")

@Controller
public class FileInfoApiController extends BaseModel implements FileInfoApi {
    @Autowired
    FileInfoValid valid;
    @Autowired
    FileInfoManage fileInfoManage;

    public ResponseEntity<ResponseModel> deleteFileInfo(@ApiParam(value = "文件信息ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = fileInfoManage.removeById(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getAll() {
        List<org.garen.oss.mybatis.domain.FileInfo> all =fileInfoManage.findAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部", all), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByMd5(@ApiParam(value = "md5") @RequestParam(value = "md5", required = false) String md5) {
        String msg = valid.md5Valid(md5);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        org.garen.oss.mybatis.domain.FileInfo fileInfo = fileInfoManage.getByMd5(md5);
        return new ResponseEntity<ResponseModel>(successModel("查询", fileInfo), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByMinMd5(@ApiParam(value = "minMd5") @RequestParam(value = "minMd5", required = false) String minMd5) {
        String msg = valid.md5Valid(minMd5);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        org.garen.oss.mybatis.domain.FileInfo fileInfo = fileInfoManage.getByMinMd5(minMd5);
        return new ResponseEntity<ResponseModel>(successModel("查询", fileInfo), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
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
        Map page = fileInfoManage.getByPage(start, length, name, type, category, sizeBegin, sizeEnd, md5, minMd5, createTimeBegin, createTimeEnd);
        return new ResponseEntity<ResponseModel>(successModel("分页查询", page), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> getFileInfo(@ApiParam(value = "文件信息ID") @RequestParam(value = "id", required = false) Long id) {
        String msg = valid.idValid(id);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = fileInfoManage.findById(id);
        return new ResponseEntity<ResponseModel>(successModel("查询成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> saveFileInfo(@ApiParam(value = "文件信息"  ) @RequestBody FileInfo fileInfo) {
        String msg = valid.saveFileInfoValid(fileInfo);
        if(StringUtils.isNotBlank(msg)){
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        }
        int i = fileInfoManage.saveFileInfo(fileInfo);
        return new ResponseEntity<ResponseModel>(successModelMsg("新增成功，数量：" + i ), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateFileInfo(@ApiParam(value = "文件信息"  ) @RequestBody FileInfo fileInfo) {
        String msg = valid.updateFileInfoValid(fileInfo);
        int i = fileInfoManage.updateFileInfo(fileInfo);
        return new ResponseEntity<ResponseModel>(successModelMsg("修改成功，数量：" + i), HttpStatus.OK);
    }

}
