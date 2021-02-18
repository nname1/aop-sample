package com.test.service;

import java.lang.annotation.*;

/**
 * @Author: Longgui Wang
 * @Date: 2021/2/9 1:12 PM
 */

@Target(value = { ElementType.METHOD, ElementType.TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnno {

    public String value();
}
