package com.leo.separation.service;

import com.leo.separation.entity.User;

import java.util.List;

/**
 * @Copyright 上海后丽信息科技有限公司
 * Created by Leo_lei on 2018/11/8
 */
public interface UserService {

    public void insert(User user);
    public List<User> queryAll();
}
