package coreJavaVolumn.Volumn1.CP6.proxy.UserServiceProxy;

import java.lang.reflect.Proxy;

/**
 * Created by xjlin on 2018/8/31.
 */
public class UserServiceTest{
    public static void main(String[] args) throws Throwable {
        System.out.println("---------------JDK动态代理----------------");
        UserService userService = (UserService) Proxy.newProxyInstance(UserServiceTest.class.getClassLoader(),
                new Class<?>[]{UserService.class},
                new MyInvocationHandler(new UserServiceImpl()));

        userService.execute();
    }
}
