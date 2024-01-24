import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatService extends Remote {
    void sendMessage(ChatClientInterface client, String message) throws RemoteException;
    void addClient(ChatClientInterface client) throws RemoteException;
    void removeClient(ChatClientInterface client) throws RemoteException;
}