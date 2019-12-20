package com.wangzai.dao;

import com.wangzai.admin.User;
import com.wangzai.mybatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    @Select("select * from user")
    List<User> findAll();
}
