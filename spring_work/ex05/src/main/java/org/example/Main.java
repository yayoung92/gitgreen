package org.example;

import org.example.components.Calculator;
import org.example.conf.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Calculator calculator = context.getBean(Calculator.class);
        calculator.doPrint();

        context.close();

    }
}