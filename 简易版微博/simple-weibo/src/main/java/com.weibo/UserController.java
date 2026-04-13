package com.weibo;

import com.weibo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层：提供注册、登录接口，供前端调用
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    // 注入用户服务（业务逻辑）
    @Autowired
    private UserService userService;

    // 注册接口：前端提交用户名和密码，返回注册结果
    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return userService.register(username, password);
    }

    // 登录接口：前端提交用户名和密码，返回登录结果（true/false）
    @PostMapping("/login")
    public boolean login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return userService.login(username, password);
    }
}
