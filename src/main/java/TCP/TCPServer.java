package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;

public class TCPServer {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private FileOutputStream fout;
    private String destinationDir = "D:\\network\\network\\src\\main\\java\\TCP\\fout";
    private Path path;
    private String filename = "receive.txt";

    public TCPServer() throws Exception {
        serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client");
        while(true) {
            /* accepting connection */
            socket = serverSocket.accept();
            if(socket.isConnected()) {
                System.out.println("Connected");
            }
            /* get input through socket*/
            inputStream = socket.getInputStream();
            /*  */
            path = Path.of(destinationDir, filename);
            fout = new FileOutputStream(path.toFile());

            byte[] buffer = new byte[1024];
            int bytesRead;

            while((bytesRead = inputStream.read(buffer)) != -1) {
                fout.write(buffer, 0, bytesRead);
            }

            System.out.println("File saved in: " + destinationDir);
        }
    }
    public static void main(String[] args) {
        try {
            new TCPServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
