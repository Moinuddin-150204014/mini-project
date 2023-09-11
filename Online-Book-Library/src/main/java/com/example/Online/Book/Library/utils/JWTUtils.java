package com.example.Online.Book.Library.utils;

import com.example.Online.Book.Library.constants.AppConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {
    public static String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis()+ AppConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,AppConstants.TOKEN_SECRET)
                .compact();
    }
}
