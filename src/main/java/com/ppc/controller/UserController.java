package com.ppc.controller;

import com.ppc.common.result.Result;
import com.ppc.entity.User;
import com.ppc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println("user = " + user);
        User userFromDatabase=userService.getByUserName(user.getUsername());
        System.out.println("userFromDatabase = " + userFromDatabase);
        if(userFromDatabase.getPassword()!=null){
            return userFromDatabase.getPassword().equals(user.getPassword())?Result.ok():Result.fail();
        }
        return Result.fail();

    }
}
