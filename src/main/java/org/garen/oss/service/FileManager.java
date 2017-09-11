package org.garen.oss.service;

import org.garen.oss.mybatis.domain.File;
import org.garen.oss.mybatis.domain.FileQuery;
import org.garen.oss.mybatis.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class FileManager extends BaseManage<Long>{
    @Autowired
    private FileService<File, FileQuery, Long> service;

    @Override
    public FileService<File, FileQuery, Long> getService() {
        return service;
    }

}
