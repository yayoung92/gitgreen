package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        AA.doB();

        AA a1 = new AA();
        a1.doA();
        System.out.println(a1.getA());
    }
}