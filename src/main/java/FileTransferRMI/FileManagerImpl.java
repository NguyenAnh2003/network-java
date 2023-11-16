package FileTransferRMI;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class FileManagerImpl extends UnicastRemoteObject implements FileManager, Serializable {
    private String DIR = "D:\\network\\network\\src\\main\\java\\FileTransferRMI\\fout";
    private Path path;
    private String filename = "out.json";

    protected FileManagerImpl() throws RemoteException {
    }

    protected FileManagerImpl(int port) throws RemoteException {
        super(port);
    }

    protected FileManagerImpl(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public void uploadFile(byte[] bytes, int length) throws RemoteException {
        /**
         * absolute file path
         * upload using FileOutputStream
         * byte read
         */
        try {
            /* javac -cp C:/"Program Files"/Java/json-simple-1.1.1.jar
            * FileTransferRMI/*.java
             */
            byte[] data = bytes;
            System.out.println("Data: " + data + " length: " + data.length);
            path = Path.of(DIR, filename);
            FileOutputStream fout = new FileOutputStream(path.toFile());

            /* JSON */
            String jsonStr = new String(data, StandardCharsets.UTF_8);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonStr);
            String text = jsonObject.get("text").toString();
            String description = jsonObject.get("description").toString();
            System.out.println("JSON data: " + text + " des: " + description);
            /* FileoutputStream for writing byte in file */
            fout.write(data);
            fout.flush();
            System.out.println("Done in writing file" + filename + " in " + DIR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
