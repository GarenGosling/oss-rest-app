package org.garen.oss.mybatis.service;

import org.garen.oss.mybatis.mapper.FileTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/14.
 */
@Service
public class FileTypeService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    FileTypeMapper<T, Q, PK> mapper;
    @Override
    public FileTypeMapper<T, Q, PK> getMapper() {
        return mapper;
    }

}
