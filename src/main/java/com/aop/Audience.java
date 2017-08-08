package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 单独写这么个类加个@Aspect是没有作用的,该类还是一个普通的java bean 不会被视为一个切面
 * 需要启动代理,有两种方式 1.javaConfig配置 2.xml配置
 * Created by 高保红 on 2017/8/1.
 */
//@Aspect    //标注Audience是一个切面
public class Audience {

//    @Pointcut("execution(**com.aop.Performance.perform(..))")
//    public void performance(){}

//    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }
//    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }
//    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }
//    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }



//    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silencing cell phones");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        }catch (Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
