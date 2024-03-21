package com.ygy.restapi05.jwt;

import com.ygy.restapi05.member.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
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
    // 토큰 검증해주는 함수/ 유효성
    public Jws<Claims> validateToken(String token){
        Jws<Claims> jws = Jwts.parser()  // 번역해가
                .setSigningKey(hmacShaKeyFor(mykey.getBytes())) // 비밀번호로
                .build() // 객체 생성하고 // 이전 버전에는 build 없어도 됬는데 스프링 버전 업데이트로 인해 최신버전은 써야 한다.
                .parseClaimsJws(token); // claim 들을 번역해라 컬렉션타입으로 만들어줘
        System.out.println(jws);
        return jws;
    }
}
