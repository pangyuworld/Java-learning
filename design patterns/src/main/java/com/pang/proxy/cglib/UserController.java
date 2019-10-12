package com.pang.proxy.cglib;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserController
 * @Package com.pang.proxy.cglib
 * @description: 用户控制器
 * @date 2019/10/12 15:49
 */
public class UserController {
    private String userName;
    private static boolean loginStatus;

    public UserController() {
        userName = "default user name";
        loginStatus = false;
    }

    public  void login() {
        System.out.println("用户进行登录");
        loginStatus = true;
    }

    public static boolean getLoginStatus() {
        System.out.println("用户当前登录状态：" + loginStatus);
        return loginStatus;
    }

    @Token
    public String getUserName() {
        System.out.println("获取用户名：" + this.userName);
        return userName;
    }

    @Token
    public UserController setUserName(String userName) {
        System.out.println("设置用户名为：" + userName);
        this.userName = userName;
        return this;
    }
}
