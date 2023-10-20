package ChatRMI;

import java.io.*;

public class Message implements Serializable {
  private String sender = null;
  private String message = null;


  public Message(String sender, String message)  {
    this.sender = sender;
    this.message = message;
  }

  public String getSender()  { return sender; }

  public String getMessage()  { return message;}

  public String toString()  { return sender + ":" + message; }
}
