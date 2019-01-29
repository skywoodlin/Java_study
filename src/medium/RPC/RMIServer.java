package medium.RPC;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by xjlin on 2019/1/19.
 *
 * 云析学院视频：6.14-牺学院【擎天老师】架构师进阶知识：想弄清楚微服务先搞懂RPC.wmv
 */
public class RMIServer{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        String name = "medium.RPC.RMIDemoService";

        //创建服务
        RMIDemoService service = new RMIDemoServiceImpl();

        //创建本机1111端口上的RMI注册表， 基于tcp的协议框架， 自己定义端口
        Registry registry = LocateRegistry.createRegistry(1111);

        //将服务绑定到注册表中
        registry.bind(name, service);
    }
}
