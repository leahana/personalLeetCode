package top.yannyi.token.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 14:38
 * @Desc:
 */

@Service
public class TokenService {

    // Replace this with your own token generation logic
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}
