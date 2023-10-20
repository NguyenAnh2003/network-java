package ChatRMI;

import java.rmi.*;

public interface ChatClient extends Remote {
  public void chatNotify(Message m) throws RemoteException;
  public String getName() throws RemoteException;
 

}
