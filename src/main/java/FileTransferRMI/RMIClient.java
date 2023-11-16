package FileTransferRMI;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.Remote;


public class RMIClient implements Serializable{
    public static void main(String[] args) {
        try {
            /* init connection RMI */
            String registration = "rmi://localhost/fileRMI";
            Remote remote = Naming.lookup(registration);
            FileManager fm = (FileManager) remote;

            /* Init file to send */
            String DIR = "D:\\network\\network\\src\\main\\java\\FileTransferRMI\\hello.json";
            File file = new File(DIR);
            FileInputStream fin = new FileInputStream(file);
            System.out.println("Uploading file...");
            /* file bytes, length */
            byte[] buffer = new byte[(int) file.length()];
            fin.read(buffer, 0, buffer.length);
            /* upload file function call */
            fm.uploadFile(buffer, (int) file.length());
            System.out.println("Upload file: " + buffer.length + " sucess "); // annoucement
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
