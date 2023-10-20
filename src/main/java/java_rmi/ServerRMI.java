package java_rmi;
import java.rmi.*;
public class ServerRMI {
    public static void main(String[] args) {
        try {
            HelloImpl hello = new HelloImpl();
            String registration = "rmi://localhost/HelloRMI";
            Naming.rebind(registration, hello);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
    }
}
