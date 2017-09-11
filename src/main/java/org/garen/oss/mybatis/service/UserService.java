package org.garen.oss.mybatis.service;


import org.garen.oss.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <B>文件名称：</B>FileUploadService<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>2017/03/08<BR>
 *
 * @author 刘学良  liuxueliang@yingu.com
 * @version 1.0
 **/
@Service
public class UserService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK> {

    @Autowired
    UserMapper<T, Q, PK> mapper;
    @Override
    public UserMapper<T, Q, PK> getMapper() {
        return mapper;
    }
}
