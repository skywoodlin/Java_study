package coreJavaVolumn.Volumn1.CP6.proxy.UserServiceProxy;

/**
 * Created by xjlin on 2018/8/31.
 * 定义目标业务对象类UserServiceImpl
 */
public class UserServiceImpl implements UserService{
    @Override
    public String execute() throws Throwable {
        System.out.println("step 2 执行方法啦！！");
        return "step 2 执行方法啦！！";
    }
}

