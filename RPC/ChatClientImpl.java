import java.rmi.*;
import java.rmi.server.*;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClientInterface {
    private String name;

    public ChatClientImpl(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println(message);
    }
}