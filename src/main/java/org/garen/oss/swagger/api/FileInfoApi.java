package org.garen.oss.swagger.api;


import io.swagger.annotations.*;
import org.garen.oss.swagger.model.FileInfo;
import org.garen.oss.swagger.model.ResponseModel;
import org.garen.oss.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-15T04:56:23.159Z")

@Api(value = "fileInfo", description = "the fileInfo API")
public interface FileInfoApi {

    @ApiOperation(value = "删除文件信息", notes = "删除文件信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteFileInfo(@ApiParam(value = "文件信息ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();


    @ApiOperation(value = "通过md5查询", notes = "通过md5查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo/md5",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByMd5(@ApiParam(value = "md5") @RequestParam(value = "md5", required = false) String md5);


    @ApiOperation(value = "通过minMd5查询", notes = "通过名称查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo/minMd5",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByMinMd5(@ApiParam(value = "minMd5") @RequestParam(value = "minMd5", required = false) String minMd5);


    @ApiOperation(value = "分页查询文件信息", notes = "分页查询文件类型 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                           @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                           @ApiParam(value = "文件名称") @RequestParam(value = "name", required = false) String name,
                                           @ApiParam(value = "文件类型") @RequestParam(value = "type", required = false) String type,
                                           @ApiParam(value = "文件种类") @RequestParam(value = "category", required = false) String category,
                                           @ApiParam(value = "文件大小从") @RequestParam(value = "sizeBegin", required = false) Long sizeBegin,
                                           @ApiParam(value = "文件大小至") @RequestParam(value = "sizeEnd", required = false) Long sizeEnd,
                                           @ApiParam(value = "文件MD5值") @RequestParam(value = "md5", required = false) String md5,
                                           @ApiParam(value = "文件缩略图MD5值") @RequestParam(value = "minMd5", required = false) String minMd5,
                                           @ApiParam(value = "创建时间从") @RequestParam(value = "createTimeBegin", required = false) String createTimeBegin,
                                           @ApiParam(value = "创建时间至") @RequestParam(value = "createTimeEnd", required = false) String createTimeEnd);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getFileInfo(@ApiParam(value = "文件信息ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "新增文件信息", notes = "新增文件信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveFileInfo(@ApiParam(value = "文件信息") @RequestBody FileInfo fileInfo);


    @ApiOperation(value = "修改文件信息", notes = "修改文件信息 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileInfo",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateFileInfo(@ApiParam(value = "文件信息") @RequestBody FileInfo fileInfo);

}
