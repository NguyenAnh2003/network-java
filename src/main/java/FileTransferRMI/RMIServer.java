package FileTransferRMI;

import java.io.Serializable;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;

public class RMIServer implements Serializable {
    private static Connection connection;
    public static void main(String[] args) {
        try {
            FileManagerImpl fileManager = new FileManagerImpl();
            String registration = "rmi://localhost/fileRMI";
            Naming.rebind(registration, fileManager);
            connection = initConnection();
            System.out.println("Connection: " + connection);
            System.out.println("Waiting for client...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection initConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "12345";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
