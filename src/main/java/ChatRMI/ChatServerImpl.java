package ChatRMI;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

public  class ChatServerImpl extends UnicastRemoteObject implements ChatServer {
  private Vector chatters = new Vector();

  public ChatServerImpl()throws RemoteException {
    super();
    System.out.println("Starting Server...");
  }

  public static void main(String args[])  {
       // System.setSecurityManager(new RMISecurityManager());
	    System.out.println ("Creating Registry ...");
		try {
		     LocateRegistry.createRegistry(5050); //Registry.REGISTRY_PORT
             ChatServerImpl cs = new ChatServerImpl();
		     Naming.rebind("XYZ", cs);
		     System.out.println("Server Ready");
		}  catch(Exception e) {
		      System.out.println("Create registry failed " + e.getMessage());
			  System.exit(0);
		}
   }

  synchronized public void register(ChatClient c)  {
	    chatters.addElement(c);
  }

  synchronized public void postMessage(Message m) {
	   	ChatClient t;
		for (int i=0;i < chatters.size();i++) {
	      t = (ChatClient)chatters.elementAt(i);
		  try{
				t.chatNotify(m);
		  } catch(Exception e) {
				chatters.removeElementAt(i--);
			}
		}
  }
}
