package org.garen.oss.service;

import org.garen.oss.mybatis.domain.File;
import org.garen.oss.mybatis.domain.FileQuery;
import org.garen.oss.mybatis.service.FileService;
import org.garen.oss.util.upload.UploadHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class FileManage extends BaseManage<Long>{
    @Autowired
    private FileService<File, FileQuery, Long> service;

    @Override
    public FileService<File, FileQuery, Long> getService() {
        return service;
    }


    public File upload(MultipartFile multipartFile) throws IOException {
        File fileInfo = new File();
        fileInfo.setName(multipartFile.getName());
        fileInfo.setMd5(UploadHandler.getMd5(multipartFile));



        return null;
    }


}
