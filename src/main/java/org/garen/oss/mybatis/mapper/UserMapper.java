package org.garen.oss.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.garen.oss.mybatis.domain.User;
import org.garen.oss.mybatis.domain.UserExample;

import java.io.Serializable;
import java.util.List;

public interface UserMapper <T,Q,PK extends Serializable> extends CommonMapper<T, Q,PK>{
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}