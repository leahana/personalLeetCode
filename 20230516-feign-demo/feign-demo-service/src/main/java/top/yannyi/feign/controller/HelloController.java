package top.yannyi.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 10:32
 * @Desc:
 */

@RestController
public class HelloController {


    @Autowired
    private Environment env;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        if (Objects.equals(token, "this is token")) {
            String serverPort = env.getProperty("server.port");
            return "Hello, World! from port: " + serverPort;
        } else {
            response.setStatus(401);
            return "fail";
        }

    }

    @GetMapping("/token")
    public String test() {
        return "this is token";
    }


}
