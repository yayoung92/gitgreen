package util;

import org.example.Member;

import java.util.Scanner;

public class MyCLI {

    public Member inputMember(){
        Scanner scan = new Scanner(System.in);

        System.out.println("이메일을 입력하세요. : ");
        String email = scan.nextLine();

        System.out.println("주소를 입력하세요. : ");
        String address = scan.nextLine();

        System.out.println("이름을 입력하세요. : ");
        String name = scan.nextLine();

        System.out.println("패스워드를 입력하세요. : ");
        String password = scan.nextLine();

    // return new Member(email, null, null, password); 와 같음
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .address(address)
                .build();
    }

    public Member loginMember(){
        Scanner scan = new Scanner(System.in);

        System.out.println("이메일을 입력하세요. : ");
        String email = scan.nextLine();

        System.out.println("패스워드를 입력하세요. : ");
        String password = scan.nextLine();

        //return new Member(email, null, null, password);
        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }
}
