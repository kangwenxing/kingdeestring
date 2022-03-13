package com.xupt.dao;

import com.xupt.domain.UserInfo;

import java.util.List;

public interface IUserInfoDao {
    List<UserInfo> selectUser();
}
