package org.garen.oss.swagger.api;


import io.swagger.annotations.ApiParam;
import org.garen.oss.service.DownloadManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-03-24T08:52:43.345Z")

@Controller
public class DownloadApiController implements DownloadApi{

    @Autowired
    DownloadManage downloadManage;

    @Override
    public void download(@ApiParam(value = "图片名称",required=true ) @PathVariable("md5") String md5, HttpServletResponse response) {
        downloadManage.downloadLocal(md5, response);
    }



}
