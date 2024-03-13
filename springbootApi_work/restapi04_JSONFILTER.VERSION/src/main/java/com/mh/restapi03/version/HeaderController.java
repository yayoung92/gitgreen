package com.mh.restapi03.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HeaderController {
    @GetMapping(value = "header", headers = "h1=1")
    public String headerV1(){
        return "headersV1111";
    }
    @GetMapping(value = "header", params = "h1=2")
    public String headerV2(){
        return "headerV2222";
    }
}
