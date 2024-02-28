package org.example;

import org.example.components.MemberService;
import org.example.conf.MyConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConf.class);

/*        String[] str = context.getBeanDefinitionNames();
        Arrays.stream(str).forEach(System.out::println);*/

        MemberService memberService = context.getBean(MemberService.class);
        memberService.regist();

        context.close();

    }
}