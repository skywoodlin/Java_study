package medium.RPC;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by xjlin on 2019/1/19.
 *
 * 这个client本来要在另一个工程上
 * 而且要导入Server端提供的RMIDemoService这个接口
 */
public class RMIClient{
    public static void main(String[] args) throws RemoteException, NotBoundException{
        String name = "medium.RPC.RMIDemoService";

        Registry registry = LocateRegistry.getRegistry("localhost", 1111);

        //查找对应服务
        RMIDemoService service = (RMIDemoService) registry.lookup(name);

        //调用服务

        System.out.println(service.sayHello("skywoodlin"));
    }
}
