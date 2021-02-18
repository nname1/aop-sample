package com.test.service;

import org.springframework.stereotype.Service;

/**
 * @Author: Longgui Wang
 * @Date: 2021/2/18 1:02 PM
 */

@Service
public class AspectService {

    public String sayHi(String name)
    {
        System.out.println("方法：sayHi 执行中 ....");
        return"Hello, " + name;
    }

    @MyAnno("kelvin")
    public String sayHello(String name)
    {
        System.out.println("方法：sayHello 执行中 ....");
        return"Hello, " + name;
    }

    public void excuteException()
    {
        System.out.println("方法：excuteException 执行中 ....");
        int n = 1;
        if(n > 0) {
            throw new RuntimeException("数据异常");
        }
    }


}
