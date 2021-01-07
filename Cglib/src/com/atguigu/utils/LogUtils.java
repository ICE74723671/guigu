package com.atguigu.utils;

import java.util.Arrays;

public class LogUtils {

    public static void logBefore(String method,Object ... args){
        System.out.println(" 当前运算是 " + method + "  , 参数是: " + Arrays.asList(args));
    }

    public static void logAfterReturning(String method,Object result){
        System.out.println(" 当前运算是 " + method + "  , 结果是: " + result);
    }

    public static void logAfterThrowing(String method,Exception e){
        System.out.println(" 当前运算是 " + method + "  , 抛的异常是: " + e);
    }

}