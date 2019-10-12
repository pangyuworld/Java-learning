package com.pang.proxy.dynamic;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Controller
 * @Package com.pang.proxy.dynamic
 * @description:
 * @date 2019/10/12 15:26
 */
public interface Controller {
    default void login() {
        System.out.println("用户登录");
        StaticValue.loginStatus = true;
    }

    default boolean getLoginStatus() {
        return StaticValue.loginStatus;
    }

    @Token
    Controller setUserName(String userName);
}
