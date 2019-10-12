package com.pang.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ProxyFactory
 * @Package com.pang.proxy.cglib
 * @description:
 * @date 2019/10/12 15:53
 */
public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        // 1.创建一个工具类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类
        enhancer.setSuperclass(target.getClass());
        // 3.设置回调函数
        enhancer.setCallback(this);
        // 4.创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Token token=method.getAnnotation(Token.class);
        if (token!=null){
            // 如果包含token注解，那就进行验证
            System.out.println("存在token注解，需要进行验证");
            if (UserController.getLoginStatus()){
                // 验证通过
                System.out.println("验证通过，有权执行当前方法");
                Object returlVal=method.invoke(target,objects);
                System.out.println("执行完成");
                return returlVal;
            }else{
                // 验证不通过
                System.out.println("验证没通过，无权执行当前方法");
                return null;
            }
        }else{
            // 没有包含token注解，不进行验证
            System.out.println("不存在token注解，不需要进行验证");
            System.out.println("执行当前方法");
            Object returlVal=method.invoke(target,objects);
            System.out.println("执行完成");
            return returlVal;
        }
    }
}
