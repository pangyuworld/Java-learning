package com.pang.proxy.cglib;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.proxy.cglib
 * @description:
 * @date 2019/10/12 16:05
 */
public class Client {
    public static void main(String...args){
        UserController userController=new UserController();
        userController= (UserController) new ProxyFactory(userController).getProxyInstance();
        userController.setUserName("张三");
        userController.getUserName();
        userController.login();
        userController.setUserName("李四");
        userController.getUserName();
    }
}
