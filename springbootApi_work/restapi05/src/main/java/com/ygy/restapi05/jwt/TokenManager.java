package com.ygy.restapi05.jwt;

import com.ygy.restapi05.member.Member;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${spring.jwt.secret}")
    private String mykey;

    // 토큰 만들어주는 함수
    public String generateToken(Member member){
        return Jwts.builder()
                .subject("ygytoken")
                .claim("id", member.getId())
                .claim("username", member.getUsername())
                .claim("role", member.getRole())
                .claim("email", member.getEmail())
                // 유효시간은 10 시간
                //.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 토큰 유효시간 정하기
                // 유효시간은 15분
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))  // 토큰 유효시간 정하기
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    // 토큰 검증해주는 함수
    public String validateToken(String token){
        return null;
    }
}
