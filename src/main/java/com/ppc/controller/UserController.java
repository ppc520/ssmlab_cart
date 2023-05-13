package com.ppc.controller;

import com.ppc.common.result.Result;
import com.ppc.entity.User;
import com.ppc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User userFromDatabase = userService.getByUserName(user.getUsername());
        if (userFromDatabase != null) {
            if (userFromDatabase.getPassword().equals(user.getPassword())) {
                return Result.ok(userFromDatabase);
            }
        }
        return Result.fail();
    }
    @GetMapping("/{username}")
    public Result getByUsername(@PathVariable("username") String username){
        System.out.println("===================>执行了/username");
        User user = userService.getByUserName(username);
        User userVo=new User();
        userVo.setUserId(user.getUserId());
        userVo.setBalance(user.getBalance());
        userVo.setUsername(user.getUsername());
        List list=new ArrayList();
        list.add(userVo);
        return Result.ok(list);
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        User byUserName = userService.getByUserName(user.getUsername());
        user.setBalance(user.getBalance()+ byUserName.getBalance());
        if(userService.update(user)>0){
            return Result.ok(user);
        }
        return Result.fail();
    }
}
