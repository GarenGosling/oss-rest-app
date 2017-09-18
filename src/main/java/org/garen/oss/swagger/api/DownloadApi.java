package org.garen.oss.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.garen.oss.swagger.model.ResponseModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-24T08:52:43.345Z")

@Api(value = "download", description = "the download API")
public interface DownloadApi {

    @ApiOperation(value = "下载", notes = "下载 ", response = ResponseModel.class, tags = {})
    @RequestMapping(value = "/download/{md5}",
            method = RequestMethod.GET)
    void download(@ApiParam(value = "md5", required = true) @PathVariable("md5") String md5, HttpServletResponse response);

}