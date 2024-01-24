package org.example;

import util.MyCLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MemberDB md = new MemberDB();
      //  boolena result = true;

        while(true){
            int select = printMenu();
            if(select==1) {
                md.insert();
            }
            else if(select==2){
                md.login();

            }
            else if(select ==6) {
                System.out.println("종료됩니다.");
                // break 하고 같은 것임.
                System.exit(0);
            }
        }

    }

    public static int printMenu(){
        System.out.println("1.회원가입");
        System.out.println("2.로그인");
        System.out.println("3.물품보기");
        System.out.println("4.장바구니");
        System.out.println("5.주문목록");
        System.out.println("6.종료");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        return menu;
    }
}