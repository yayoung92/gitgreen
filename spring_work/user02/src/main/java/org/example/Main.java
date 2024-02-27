package org.example;

import org.example.conf.MyConf;
import org.example.member.Member;
import org.example.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConf.class);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm:ss");
        // 객체 선언
//        Member member1 = new Member(null,"aaa@naver.com","1234","홍길동",formatter.format(now));
        Member member1 = Member.builder()
                .emil("aaa@naver.com")
                .password("1234")
                .name("홍길동")
                .wdate(formatter.format(now))
                .build();

        Member member2 = Member.builder()
                .emil("bbb@naver.com")
                .password("5678")
                .name("김길동")
                .wdate(formatter.format(now))
                .build();

        MemberService memberService = context.getBean(MemberService.class);
        memberService.Regist(member1);
        memberService.Regist(member2);

        memberService.List();

        String[] str = context.getBeanDefinitionNames();
        for(String s : str){
            System.out.println(s);
        }

        context.close();
    }
}