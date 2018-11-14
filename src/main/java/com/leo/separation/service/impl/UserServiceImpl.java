package com.leo.separation.service.impl;

import com.leo.separation.config.ReadDataSource;
import com.leo.separation.config.WriteDataSource;
import com.leo.separation.dao.UserDao;
import com.leo.separation.entity.User;
import com.leo.separation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Copyright 上海后丽信息科技有限公司
 * Created by Leo_lei on 2018/11/8
 */
@Service
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @WriteDataSource
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    @ReadDataSource
    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
