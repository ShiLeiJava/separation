package com.leo.separation.RestAPI;

import com.leo.separation.entity.User;
import com.leo.separation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Copyright 上海后丽信息科技有限公司
 * Created by Leo_lei on 2018/11/8
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService  userService;


    @PostMapping("/insert")
    public String insert(@RequestBody User user){
       userService.insert(user);
       return "success";
    }

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> res = userService.queryAll();
        return res;
    }

}
