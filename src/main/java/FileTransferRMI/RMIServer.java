package FileTransferRMI;

import java.io.Serializable;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;

public class RMIServer implements Serializable {
    public static void main(String[] args) {
        try {
            FileManagerImpl fileManager = new FileManagerImpl();
            String registration = "rmi://localhost/fileRMI";
            Naming.rebind(registration, fileManager);
            System.out.println("Waiting for client...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
