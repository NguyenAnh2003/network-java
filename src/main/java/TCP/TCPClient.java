package TCP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Sending with string
 * Sending with file (bytes)
 */
public class TCPClient {

    private FileInputStream fin;
    private String host = "127.0.0.1";
    private String sourceFile = "D:\\network\\network\\src\\main\\java\\TCP\\send.txt";
    private Socket socket;
    private File fileSender;
    private OutputStream outputStream;
    public TCPClient() throws Exception{
        /* setup static file */
        fileSender = new File(sourceFile);

        fin = new FileInputStream(fileSender);

        /* create connection */
        socket = new Socket(host, 5000);
        if(!socket.isConnected()) {
            System.out.println("Connection error");
            return;
        }
        /* get output from socket */
        outputStream = socket.getOutputStream();
        /* send file */
        byte[] buffer = new byte[1024];
        int bytesRead;

        while((bytesRead = fin.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
            System.out.println("Sent file" + " Bytes: "+ bytesRead);
        }

        outputStream.flush();
        outputStream.close();
        socket.close();
    }
    public static void main(String[] args) throws Exception{
        new TCPClient();
    }
}
