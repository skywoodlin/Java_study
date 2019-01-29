package medium.RPC;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by xjlin on 2019/1/19.
 */
public interface RMIDemoService extends Remote{
    String sayHello(String name) throws RemoteException;
}
