package UDP;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    private DatagramSocket socket;
    private byte[] buffer;
    private String sourceFile = "D:\\network\\network\\src\\main\\java\\file_dir\\fileSender.txt";
    private DatagramPacket requestPacket;
    private InetAddress clientAddress;
    private int clientPort;
    private FileInputStream fin;

    public UDPServer() throws Exception{
        /* init file */
        File file = new File(sourceFile);
        fin = new FileInputStream(file);
        /* host server UDP */
        socket = new DatagramSocket(5000);
        buffer = new byte[1024];
        System.out.println("Waiting for client");

        while(true) {
            /* waiting for client */
            requestPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(requestPacket);
            clientAddress = requestPacket.getAddress(); // get req
            clientPort = requestPacket.getPort(); // get req
            System.out.println("Get request" + requestPacket + "Client info: " + clientAddress + " Port: " + clientPort);
            /* init file and send */
            int bytesRead;
            while((bytesRead = fin.read(buffer)) != -1) {
                DatagramPacket res = new DatagramPacket(buffer, bytesRead, clientAddress, clientPort);
                socket.send(res);
            }
            System.out.println("Sent file");
            fin.close();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        try {
            new UDPServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
