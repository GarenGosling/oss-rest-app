package org.garen.oss.service;

import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.mybatis.domain.FileTypeExample;
import org.garen.oss.mybatis.service.FileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/23.
 */
@Service
public class FileTypeManage extends BaseManage<Long>{
    @Autowired
    private FileTypeService<FileType, FileTypeExample, Long> service;

    @Override
    public FileTypeService<FileType, FileTypeExample, Long> getService() {
        return service;
    }




}
