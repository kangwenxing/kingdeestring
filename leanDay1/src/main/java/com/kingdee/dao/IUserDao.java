package com.kingdee.dao;

import com.kingdee.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
