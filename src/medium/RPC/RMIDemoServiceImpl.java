package medium.RPC;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by xjlin on 2019/1/19.
 */
public class RMIDemoServiceImpl extends UnicastRemoteObject implements RMIDemoService{

    public RMIDemoServiceImpl() throws RemoteException{
    }

    @Override
    public String sayHello(String name) throws RemoteException{
        return "hello " + name;
    }
}
