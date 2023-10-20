package java_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloRMI extends Remote {
    /*
    Providing the description of the methods that can be invoked by remote clients
    Extending interface and method prototype within the interface should throw the RemoteException
     */
    public int add(int a, int b) throws RemoteException;
    public int sub(int a, int b) throws RemoteException;
}
