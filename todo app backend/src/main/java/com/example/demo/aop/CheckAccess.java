package com.example.demo.aop;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;;

@Retention(RUNTIME)
public @interface CheckAccess{
    String[] permissions() default {};
    
}  