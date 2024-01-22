package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberDB md = new MemberDB();

        System.out.println("이메일을 입력하세요. : ");
        String email = scan.nextLine();

        System.out.println("주소를 입력하세요. : ");
        String address = scan.nextLine();

        System.out.println("이름을 입력하세요. : ");
        String name = scan.nextLine();

        System.out.println("패스워드를 입력하세요. : ");
        String password = scan.nextLine();

        Member member = new Member(email, name, address, password);
        md.insert(member);
    }
}