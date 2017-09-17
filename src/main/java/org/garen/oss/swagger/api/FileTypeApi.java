package org.garen.oss.swagger.api;


import io.swagger.annotations.*;
import org.garen.oss.swagger.model.FileType;
import org.garen.oss.swagger.model.ResponseModel;
import org.garen.oss.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-09-14T10:30:32.894Z")

@Api(value = "fileType", description = "the fileType API")
public interface FileTypeApi {

    @ApiOperation(value = "删除文件类型", notes = "删除文件类型 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteFileType(@ApiParam(value = "文件类型ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "查询全部", notes = "查询全部 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType/all",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getAll();


    @ApiOperation(value = "通过编码查询", notes = "通过编码查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType/code",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByCode(@ApiParam(value = "文件类型编码") @RequestParam(value = "code", required = false) String code);


    @ApiOperation(value = "通过名称查询", notes = "通过名称查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType/name",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByName(@ApiParam(value = "文件类型名称") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "分页查询文件类型", notes = "分页查询文件类型 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType/page",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                           @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length,
                                           @ApiParam(value = "文件名称") @RequestParam(value = "name", required = false) String name);


    @ApiOperation(value = "ID查询", notes = "ID查询 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getFileType(@ApiParam(value = "文件类型ID") @RequestParam(value = "id", required = false) Long id);


    @ApiOperation(value = "新增文件类型", notes = "新增文件类型 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveFileType(@ApiParam(value = "文件类型") @RequestBody FileType fileType);


    @ApiOperation(value = "修改文件类型", notes = "修改文件类型 ", response = ResponseModel.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ResponseModel.class) })
    @RequestMapping(value = "/fileType",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateFileType(@ApiParam(value = "文件类型") @RequestBody FileType fileType);

}
