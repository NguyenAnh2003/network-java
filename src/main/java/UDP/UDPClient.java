package UDP;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Path;

public class UDPClient {
    private DatagramSocket socket;
    private byte[] buffer;
    private Path path;
    private FileOutputStream fout;
    private DatagramPacket reqPacket;
    private String destDir = "D:\\network\\network\\src\\main\\java\\file_dir\\fout";
    private String filename = "out.txt";
    private InetAddress address;
    public UDPClient() throws Exception {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
        buffer = new byte[1024];
        reqPacket = new DatagramPacket(buffer, buffer.length, address, 5000);
        socket.send(reqPacket);

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        System.out.println("Received packet" + packet);
        path = Path.of(destDir, filename);
        fout = new FileOutputStream(path.toFile());
        fout.write(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println("Receive and saved file in: " + destDir);
    }

    public static void main(String[] args) {
        try {
            new UDPClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
