package com.mh.restapi01.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller   // 스프링 IOC 컨테이너에 Controller(주소맵핑) 하는 클래스라고 알려주기
@RequiredArgsConstructor  // Autowired 보다 이 어노테이션을 사용해서 객체 주입하는 것을 더 선호함.
public class MainController {
//    @Autowired
    private final MainService mainService;

    @GetMapping("main")  // main.html 보내기
    public String main(){
        System.out.println(mainService);
        return "main";
    }

    @GetMapping("mainapi")   // 문자열 그대로 보내기
    public @ResponseBody String mainapi(){
        return mainService.toString();
    }
}
