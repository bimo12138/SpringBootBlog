package com.bimo.bimo.config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bimo.bimo.pojo.User;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
public class JwtToken {
    public static String createJWT(User user) {
        return JWT.create().withAudience(user.getUsername()).withExpiresAt(new Date(new Date().getTime() + 1000 * 60 * 60 * 24))
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
}
