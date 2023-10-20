package java_rmi;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements HelloRMI {
    public HelloImpl() throws RemoteException {

    }

    public HelloImpl(int port) throws RemoteException {
        super(port);
    }

    public HelloImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        System.out.println("Addition");
        return (a+b);
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        System.out.println("Subtraction");
        return (a-b);
    }
}
