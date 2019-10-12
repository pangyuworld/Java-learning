package com.pang.proxy.dynamic;

/**
 * @author pang
 * @version V1.0
 * @ClassName: UserController
 * @Package com.pang.proxy.dynamic
 * @description:
 * @date 2019/10/12 15:18
 */
public class UserController implements Controller {

    @Override
    public Controller setUserName(String userName) {
        System.out.println("设置用户名为：" + userName);
        return this;
    }
}
