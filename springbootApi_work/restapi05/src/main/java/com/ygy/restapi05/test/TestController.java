package com.ygy.restapi05.test;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jwt.secret}")
    private String mykey;

    @GetMapping("/test")
    public String test(){
        String password = passwordEncoder.encode("1234");
        return password;
    }

    @PostMapping("/test")
    public String test2(){
        String password = passwordEncoder.encode("1234");
        return password + ": mykey = " + mykey;
    }

}
