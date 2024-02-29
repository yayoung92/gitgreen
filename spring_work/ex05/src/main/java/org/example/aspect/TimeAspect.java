package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalTime;

@Aspect
public class TimeAspect {
    @Pointcut("execution( public * org..*(..))")  // public 인 어떤것도 상관없이 실행, org. 안의 어떤것도 상관없이 실행
    private void publicTarget(){

    }
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        LocalTime beforeTime = LocalTime.now();
        try{
            Object result = proceedingJoinPoint.proceed();
            return result;
        }
        finally {
            LocalTime afterTime = LocalTime.now();

            System.out.println(LocalTime.now());
        }
    }
}
