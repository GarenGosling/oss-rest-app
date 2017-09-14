package org.garen.oss.service;

import org.garen.oss.mybatis.domain.FileInfo;
import org.garen.oss.mybatis.domain.FileInfoExample;
import org.garen.oss.mybatis.service.FileInfoService;
import org.garen.oss.util.upload.UploadHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class FileInfoManage extends BaseManage<Long>{
    @Autowired
    private FileInfoService<FileInfo, FileInfoExample, Long> service;

    @Override
    public FileInfoService<FileInfo, FileInfoExample, Long> getService() {
        return service;
    }


    public FileInfo upload(MultipartFile multipartFile) throws IOException {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(multipartFile.getName());
        fileInfo.setMd5(UploadHandler.getMd5(multipartFile));



        return null;
    }


}
