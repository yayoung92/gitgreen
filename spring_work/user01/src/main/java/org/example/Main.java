package org.example;

import org.example.conf.MyConf;
import org.example.member.MemberDTO;
import org.example.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static AnnotationConfigApplicationContext acac = null;
    public static void main(String[] args) {

        // insert User 등록
        // list User 조회

        acac =new AnnotationConfigApplicationContext(MyConf.class);
        processNewCommand();
        processListCommand();
    }

    // User 등록하기
    private static void processNewCommand(){
        MemberService ms = acac.getBean(MemberService.class);

        MemberDTO md = MemberDTO.builder()
                .emil("aaa@naver.com")
                .name("홍길동")
                .password("1234")
                .confirmPassword("1234")
                .build();

        if(!md.isEqualsPassword()){     // 두개의 비밀번호 입력받아서 같지 않다면
            System.out.println("비밀번호 틀렸다.");
            return;
        }

        ms.regist(md); // 같다면 regist() 실행.

    }
    // User list 목록 보기
    private static void processListCommand(){
        MemberService ms = acac.getBean(MemberService.class);
        ms.list();
    }
}