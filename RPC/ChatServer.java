import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements ChatService {
    private List<ChatClientInterface> clients;

    public ChatServer() throws RemoteException {
        clients = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            Naming.rebind("ChatServer", server);
            System.out.println("ChatServer is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void sendMessage(ChatClientInterface client, String message) throws RemoteException {
        System.out.println("Message from " + client.getName() + ": " + message);
        for (ChatClientInterface c : clients) {
            if (!c.equals(client)) {
                c.receiveMessage(client.getName() + ": " + message);
            }
        }
    }

    public synchronized void addClient(ChatClientInterface client) throws RemoteException {
        clients.add(client);
    }

    public synchronized void removeClient(ChatClientInterface client) throws RemoteException {
        clients.remove(client);
    }
}