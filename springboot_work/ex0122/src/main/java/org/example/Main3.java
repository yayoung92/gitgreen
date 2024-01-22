package org.example;

class SuperCls{
    static int count = 0;
}

class SubCls extends SuperCls{
    public static void setCount(){
        SuperCls.count = 100;
    }
}
public class Main3 {

    public static void main(String[] args) {
        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);

        SuperCls.count = 200;
        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);

        // static 이용하게 되면 메모리 사용이 많아져서 램 과부화 걸릴 수도 있다.
        // new 이용하게 되면 heap 영역에 올리는 것이다.
        //SubCls sc = new SubCls();
        // setter 를 이용해서 상속된 변수의 값 바꾸기
        //sc.setCount();
        SubCls.setCount();
        System.out.println(SuperCls.count);
        System.out.println(SubCls.count);
    }
}
