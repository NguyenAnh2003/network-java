package FileTransferRMI;

import java.io.Serializable;
import java.rmi.Naming;

public class RMIServer implements Serializable {
    public static void main(String[] args) {
        try {
            FileManagerImpl fileManager = new FileManagerImpl();
            String registration = "rmi://localhost/fileRMI";
            Naming.rebind(registration, fileManager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
