package top.yannyi.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 10:32
 * @Desc:
 */

@RestController
public class HelloController {

// ...

    @Autowired
    private Environment env;

    @GetMapping("/hello")
    public String hello() {
        String serverPort = env.getProperty("server.port");
        return "Hello, World! from port: " + serverPort;
    }

}
