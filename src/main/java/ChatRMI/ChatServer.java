package ChatRMI;

import java.rmi.*;

public interface ChatServer extends Remote{
   public void register(ChatClient c) throws RemoteException;
   public void postMessage(Message m) throws RemoteException;


}
