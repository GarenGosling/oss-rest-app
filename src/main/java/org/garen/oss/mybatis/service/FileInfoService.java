package org.garen.oss.mybatis.service;

import org.garen.oss.mybatis.mapper.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/14.
 */
@Service
public class FileInfoService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {
    @Autowired
    FileInfoMapper<T, Q, PK> mapper;
    @Override
    public FileInfoMapper<T, Q, PK> getMapper() {
        return mapper;
    }

}
