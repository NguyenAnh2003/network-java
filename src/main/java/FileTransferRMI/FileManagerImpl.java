package FileTransferRMI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class FileManagerImpl extends UnicastRemoteObject implements FileManagerInterface, Serializable {
    private String DIR = "D:\\network\\network\\src\\main\\java\\FileTransferRMI\\fout";
    private Path path;
    private String filename = "filename.txt";

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
            byte[] data = bytes;
            System.out.println("Data: " + data + " length: " + data.length);
            path = Path.of(DIR, filename);
            FileOutputStream fout = new FileOutputStream(path.toFile());
            int bytesRead;
            /* FileoutputStream for writing byte in file */
            fout.write(data);
            fout.flush();
            System.out.println("Done in writing file" + filename + " in " + DIR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
