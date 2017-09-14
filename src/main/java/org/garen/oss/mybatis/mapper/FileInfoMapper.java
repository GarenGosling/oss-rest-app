package org.garen.oss.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.garen.oss.mybatis.domain.FileInfo;
import org.garen.oss.mybatis.domain.FileInfoExample;

import java.io.Serializable;
import java.util.List;

public interface FileInfoMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK>{
    long countByExample(FileInfoExample example);

    int deleteByExample(FileInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    List<FileInfo> selectByExample(FileInfoExample example);

    FileInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

    int updateByExample(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKey(FileInfo record);
}