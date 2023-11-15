package FileTransferRMI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Scanner;


public class RMIClient implements Serializable{
    public static void main(String[] args) {
        try {
            /* init connection RMI */
            String registration = "rmi://localhost/fileRMI";
            Remote remote = Naming.lookup(registration);
            FileManagerInterface fm = (FileManagerInterface) remote;

            /* Init file to send */
            String DIR = "D:\\network\\network\\src\\main\\java\\FileTransferRMI\\fileExp.txt";
            File file = new File(DIR);
            FileInputStream fin = new FileInputStream(file);
            System.out.println("Uploading file...");
            /* file bytes, length */
            byte[] buffer = new byte[(int) file.length()];
            int bytesRead;
            fin.read(buffer, 0, buffer.length);
            fm.uploadFile(buffer, (int) file.length());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
