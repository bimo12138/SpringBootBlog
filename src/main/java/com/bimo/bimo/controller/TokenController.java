package com.bimo.bimo.controller;

import com.auth0.jwt.JWT;
import com.bimo.bimo.pojo.MyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

@RequestMapping("/token")
@RestController
public class TokenController {

    @PutMapping
    public MyResponse UpdateToken(String token) {
        Date date = JWT.decode(token).getExpiresAt();
        if (date.getTime() < System.currentTimeMillis()) {
            return new MyResponse("Token 以及过期了, 请重新登录！");
        }
        if (date.getTime() - System.currentTimeMillis() - 1000 * 60 * 60 * 24 > 0) {
            // 有效
            return new MyResponse("Token 仍然在有效期内，不需要更新");
        } else {
            // update

        }
        return null;
    }
}
