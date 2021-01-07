package com.atguigu.service;

import com.atguigu.pojo.Calculation;

public class Calculator {//implements Calculation {

    //    @Override
    public int add(int num1, int num2) {
        int result = 0;
        result = num1 + num2;
        return result;
    }

    //    @Override
    public int add(int num1, int num2, int num3) {
        int result = 0;
        result = num1 + num2 + num3;
        return result;
    }

    //    @Override
    public int div(int num1, int num2) {
        int result = 0;
        result = num1 / num2;
        return result;
    }
}