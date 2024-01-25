package org.example;

import util.Login;
import util.MyCLI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MemberDB md = new MemberDB();
      //  boolean result = true;

        while(true){
            int select = 0;
            if(Login.member != null && Login.getRole().equalsIgnoreCase("admin"))
                select = printMenuAdmin();
            else
                select = printMenu();

            if(select==1) {
                md.insert();
            }
            else if(select==2){
                if(!Login.login) {
                    Member dbMember = md.login();
                    System.out.println("dbMember =" + dbMember);
                    if(dbMember!=null){
                        Login.login = true;
                        Login.member = dbMember;
                    }
                }else{
                    System.out.println("이미 로그인하셨습니다.");
                }
            }
            else if(select ==6) {
                System.out.println("종료됩니다.");
                // break 하고 같은 것임.
                System.exit(0);
            }
        }

    }

    // user 로 로그인 하면 상품 등록 x
    // admin 으로 로그인하면 상품 등록 o, 회원목록
    public static int printMenu(){
        System.out.println("1.회원가입");
        System.out.println("2.로그인");
        System.out.println("3.로그아웃");
        System.out.println("4.물품보기");
        System.out.println("5.장바구니");
        System.out.println("6.주문목록");
        System.out.println("7.종료");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();

        return menu;
    }

    public static int printMenuAdmin(){
        System.out.println("1.회원가입");
        System.out.println("2.로그인");
        System.out.println("3.로그아웃");
        System.out.println("4.물품보기");
        System.out.println("5.장바구니");
        System.out.println("6.주문목록");
        System.out.println("7.종료");
        System.out.println("8.상품등록");
        System.out.println("9.회원목록");
        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        return menu;
    }
}