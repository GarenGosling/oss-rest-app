package org.garen.oss.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.garen.oss.mybatis.domain.FileType;
import org.garen.oss.mybatis.domain.FileTypeExample;

import java.io.Serializable;
import java.util.List;

public interface FileTypeMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK>{
    long countByExample(FileTypeExample example);

    int deleteByExample(FileTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileType record);

    int insertSelective(FileType record);

    List<FileType> selectByExample(FileTypeExample example);

    FileType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileType record, @Param("example") FileTypeExample example);

    int updateByExample(@Param("record") FileType record, @Param("example") FileTypeExample example);

    int updateByPrimaryKeySelective(FileType record);

    int updateByPrimaryKey(FileType record);
}