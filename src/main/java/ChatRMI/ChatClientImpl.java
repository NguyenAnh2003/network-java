package ChatRMI;

import ChatRMI.ChatClient;
import ChatRMI.ChatServer;
import ChatRMI.Message;

import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class ChatClientImpl extends JFrame implements ChatClient,ActionListener {
  private	JTextField cText;
  private	JTextArea chatText;
  private	JButton sendText;
  private JButton disconnect; // disconnect from server
  private ChatServer cs;     // a reference to the server
  private String name = null;// The user's name


  public static void main(String[] args)  {
    ChatClientImpl c = new ChatClientImpl("localhost");//args[0]);
    c.setVisible(true);
    c.show();
  }

  public ChatClientImpl(String server)  {
    setSize(600,300);
	
	JPanel bp= new JPanel();
	disconnect = new JButton("Disconnect"); //disconnect from server
    disconnect.setBackground(Color.pink); //for dramatic effect
    bp.add(disconnect);
    disconnect.addActionListener(this);
	cText= new JTextField(30);
	bp.add(cText);
    cText.addActionListener(this);
	sendText = new JButton("Send");
	bp.add(sendText);
    sendText.addActionListener(this);
    
    chatText = new JTextArea(15,30); //message window
    chatText.setEditable(false);
      //    seteration(EXIT_ON_CLOSE);
    Container contentPane = getContentPane();
    contentPane.add(new JScrollPane(chatText));
    contentPane.add(chatText,"Center");
    contentPane.add(bp,BorderLayout.SOUTH);

      //create a dialogue box to ask for the user name
    name = JOptionPane.showInputDialog(this,"Nick Name");
   	setTitle("Java Chat Room: "+ name);
    System.out.println("Registering name: " + name);
    registerChatter(server);
  }

  public void actionPerformed(ActionEvent evt) {
	    Object source = evt.getSource();
	    if (source == sendText  || source ==cText) sendText(cText.getText().trim());
	    else if (source == disconnect) {
		    sendText("***"+name+" logged off. Bye");
			cs = null;
			System.exit(0);
		}
  }

  public void sendText(String msg)  {
	    try{
			cs.postMessage(new Message(name,msg));
		} catch (Exception e)    {
			chatText.append("***Server Error***\n");
		}
	    cText.setText("");
  }

  public void registerChatter(String server)  {
		try {		//export our remote methods
			UnicastRemoteObject.exportObject(this, 0);
			cs = (ChatServer)Naming.lookup("rmi://"+server+"/XYZ");
			cs.register(this);
		}  catch (Exception e)    {
			System.out.println("Connection error: " + e);
			System.exit(0);
		}
  }
 public synchronized void chatNotify(Message m)   {
	    if (m.getMessage() != null)
			 chatText.append(m.toString());//getSender() + ": " +m.getMessage()+"\n");
 }

 public String getName() {
	    return name;
 }
}
