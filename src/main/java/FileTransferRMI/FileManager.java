package FileTransferRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * interface for file transfer
 * file type: json - working with DB (mongoDB)
 * user enter information then save in json type
 * the server unpack and save to DB
 * protocol - java RMI
 */

public interface FileManager extends Remote {
    /* upload file to server */
    public void uploadFile(byte[] bytes, int length) throws RemoteException;
}
