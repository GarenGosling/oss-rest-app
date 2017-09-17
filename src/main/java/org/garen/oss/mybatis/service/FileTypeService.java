package org.garen.oss.mybatis.service;

import org.apache.commons.lang3.StringUtils;
import org.garen.oss.cache.FileTypesCache;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.mybatis.mapper.FileTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

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
