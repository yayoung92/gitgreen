package com.git.ex03.myanno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) //실행중에 사용되는 어노테이션
@Target(ElementType.TYPE)  // 클래스 위에데가 붙일 수 있다.
public @interface ManualBean {

}
