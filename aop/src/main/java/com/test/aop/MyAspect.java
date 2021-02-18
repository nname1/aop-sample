package com.test.aop;

import com.test.service.MyAnno;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: Longgui Wang
 * @Date: 2021/2/9 1:15 PM
 */

@Aspect
@Component
public class MyAspect {

    @Pointcut("@within(myAnno)")
    public void annotatedClass(MyAnno myAnno) {
    }

    @Pointcut("@annotation(myAnno)")
    public void annotatedMethod(MyAnno myAnno) {

    }

    @Around("annotatedClass(myAnno)")
    public Object aroundAnnotatedClass(ProceedingJoinPoint pjp, MyAnno myAnno) throws Exception {
        return aroundAdvice(pjp, myAnno);
    }

    @Around("annotatedMethod(myAnno)")
    public Object aroundAnnotatedMethod(ProceedingJoinPoint pjp, MyAnno myAnno) throws Exception {
        return aroundAdvice(pjp, myAnno);
    }

    public Object aroundAdvice(ProceedingJoinPoint pjp, MyAnno myAnno) throws Exception {
        try{
            System.out.println("myAnno.value is "+myAnno.value());
            return pjp.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            return null;
        }
    }

    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Exception {
        try{
            System.out.println("myAnno.value is null");
            return pjp.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            return null;
        }
    }
}
