package com.pang.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ProxyFactory
 * @Package com.pang.proxy.dynamic
 * @description: 用户控制器代理
 * @date 2019/10/12 15:23
 */
public class ProxyFactory {
    private Object targer;

    public ProxyFactory(Object targer) {
        this.targer = targer;
    }

    public Object getProxyInstance() {
        /**
         * public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         * 1. ClassLoader loader类加载器，通过getClass().getClassLoader()获取
         * 2. Class<?>[] interfaces目标对象实现的接口类型,因为这个傻逼设置，所以JDK代理只能代理实现了接口的类
         * 3. InvocationHandler h事件处理，执行目标对象时候，会触发处理器方法，相当于代理了方法
         */
        return Proxy.newProxyInstance(targer.getClass().getClassLoader(), targer.getClass()
                .getInterfaces(), (proxy, method, args) -> {
            // 获取token注解
            Token token = method.getAnnotation(Token.class);
            if (token != null) {
                System.out.println("存在token注解，需要进行验证");
                // 如果存在注解，那就开始进行验证
                if (StaticValue.loginStatus) {
                    // 如果登陆了的话，那就执行
                    System.out.println("验证通过，有权限执行当前方法");
                    Object resultVal = method.invoke(targer, args);
                    System.out.println("执行完成");
                    return resultVal;
                } else {
                    // 如果没有登录，那就不通过
                    System.out.println("验证没有通过");
                    return null;
                }
            } else {
                System.out.println("不存在token注解，不用验证");
                System.out.println("执行方法前");
                Object resultVal = method.invoke(targer, args);
                System.out.println("执行完方法");
                return resultVal;
            }
        });
    }
}
