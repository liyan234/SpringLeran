package org.example.demoprojectSpring.controller;

import org.example.demoprojectSpring.domain.User;
import org.example.demoprojectSpring.serivce.UserService;
import org.example.demoprojectSpring.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
// pub 公有的  v1设置为版本号
@RequestMapping("/api/v1/pub/user")
public class UserController {

    /*@PostMapping("login")
    public JsonData login(String password, String username) {
        System.out.println("username" + username + "password" + password);
        return JsonData.buildSuccess("");
    }*/

    @Autowired
    public UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        System.out.println("user" + user);
        String token = userService.login(user.getUsername(), user.getPassword());
        if (token != null) {
            return JsonData.buildSuccess(token);
        } else {
            return JsonData.buildError("账号或者密码错误");
        }
    }

    @GetMapping("list")
    public JsonData listUser() {
        return JsonData.buildSuccess(userService.listUser());
    }
}
