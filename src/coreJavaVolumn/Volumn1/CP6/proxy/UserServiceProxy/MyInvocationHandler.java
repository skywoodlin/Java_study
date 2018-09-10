package coreJavaVolumn.Volumn1.CP6.proxy.UserServiceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xjlin on 2018/8/31.
 * 自定义“调用处理程序”——MyInvocationHandler
 */
public class MyInvocationHandler implements InvocationHandler{

    private UserService userService;

    public MyInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    /*
     * @proxy 内存中的代理实例 $proxy0
     * @method 内存代理实例中class.forName("被代理类").getMethod("目标方法") 即被代理的类的方法对象
     * @args 方法参数
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();   //事务开启

        method.invoke(userService, args);

        after();    //事务关闭

        return "成功了";
    }

    private void before() {
        System.out.println("事务开启！");
    }

    private void after() {
        System.out.println("事务关闭");
    }
}
