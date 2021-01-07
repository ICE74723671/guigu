package com.atguigu.proxy;

import com.atguigu.service.Calculator;
import com.atguigu.utils.LogUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * description:
 *
 * @author Ice on 2020/12/7 in 10:42
 */
public class CalculatorProxy {

    public static Object creatCglibProxy(Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                LogUtils.logBefore(method.getName(), args);
                Object result = null;
                try {
                    result = method.invoke(object, args);
                    LogUtils.logAfterReturning(method.getName(), result);
                } catch (Exception e) {
                    LogUtils.logAfterThrowing(method.getName(), e);
                }
                return result;
            }
        });

        return  enhancer.create();
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Calculator proxy = (Calculator) creatCglibProxy(calculator);
        proxy.add(1,2);
    }
}
