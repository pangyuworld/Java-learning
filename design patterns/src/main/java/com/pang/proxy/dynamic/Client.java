package com.pang.proxy.dynamic;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.proxy.dynamic
 * @description:
 * @date 2019/10/12 15:44
 */
public class Client {
    public static void main(String...args){
        Controller targer=new UserController();

        targer= (Controller) new ProxyFactory(targer).getProxyInstance();

        targer.setUserName("张三");

        targer.login();

        targer.setUserName("李四");
    }
}
