package java_rmi;
import java.rmi.*;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            String registration = "rmi://localhost/HelloRMI";
            Remote remote = Naming.lookup(registration);
            HelloRMI helloRMI = (HelloRMI) remote;
            System.out.println("SUM: " + helloRMI.add(3, 5));
            System.out.println("SUB: " + helloRMI.sub(3, 5));
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
    }
}
