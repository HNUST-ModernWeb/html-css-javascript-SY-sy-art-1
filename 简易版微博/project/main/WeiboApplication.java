package com.weibo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeiboApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeiboApplication.class, args);
        System.out.println("简易微博系统启动成功！访问：http://localhost:8080/login.html");
    }
}
