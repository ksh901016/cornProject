package com.corn.toyproject.core.app.auth.utils;

import com.corn.toyproject.core.app.auth.domain.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;

public class TokenUtils {

    public static String generateJwtToken(User user){
        JwtBuilder builder = Jwts.builder()
                .setSubject(user.getEmail())
                .setHeader(new HashMap<>())
                .setClaims(null)
                .setExpiration(null)
                .signWith(SignatureAlgorithm.HS256, "");
        return builder.compact();
    }
}
