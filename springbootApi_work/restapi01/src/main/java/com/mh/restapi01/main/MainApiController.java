package com.mh.restapi01.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainApiController {
    @GetMapping("main/api/aa")
    public String mainApiaa(String str, String id, int age){
        System.out.printf("id = " + id);
        System.out.printf("age = " + age);
        return "문자열이 보내진다." + str + id +age;
    }
}
