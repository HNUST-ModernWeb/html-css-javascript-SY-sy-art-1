package com.weibo;

import com.weibo.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> userList = new ArrayList<>();

    public String register(String username, String password) {
        if (username == null || username.trim().isEmpty()) return "用户名不能为空";
        if (password == null || password.trim().isEmpty()) return "密码不能为空";
        for (User u : userList) {
            if (u.getUsername().equals(username)) return "用户名已存在";
        }
        userList.add(new User(username, password));
        return "注册成功";
    }

    public boolean login(String username, String password) {
        for (User u : userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
