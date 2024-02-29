package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.time.Duration;
import java.time.LocalTime;

@Aspect
public class TimeAspect {
//    @Pointcut("execution( public * org..*(..))")  // public 인 어떤것도 상관없이 실행, org. 안의 어떤것도 상관없이 실행
//    private void publicTarget(){
//
//    }
    @Pointcut("execution(* org.example.components..*(..))")  // public 인 어떤것도 상관없이 실행, org. 안의 어떤것도 상관없이 실행
    private void publicTarget(){

    }
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("시작하기 전에 보여지는 부분");
        LocalTime beforeTime = LocalTime.now();
        try{
            System.out.println("되나");
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
        finally {
            LocalTime afterTime = LocalTime.now();
            Duration duration = Duration.between(beforeTime,afterTime);
            System.out.println(duration.getNano());
            System.out.println("끝나기전에 실행되는 부분");
        }
    }
}
