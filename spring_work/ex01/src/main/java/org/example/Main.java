package org.example;

import org.example.component.AA;
import org.example.component.BB;
import org.example.conf.AppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 객체 담는 통 이라는 클래스 만들기
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppContext.class);
//
        AA a1 = context.getBean(AA.class);
        System.out.println(a1);

        AA a2 = context.getBean(AA.class);
        System.out.println(a2);

        a1.setName("감사합니다!");

        System.out.println(a1.getName());
        System.out.println(a2.getName());
        System.out.println(a1==a2);

        // 객체 넣는 통은 마지막에 닫아줘야 한다.

        BB bb = context.getBean(BB.class);
        System.out.println(bb.getHi());

        context.close();

    }
}