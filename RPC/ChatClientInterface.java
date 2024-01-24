import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientInterface extends Remote {
    String getName() throws RemoteException;
    void receiveMessage(String message) throws RemoteException;
}