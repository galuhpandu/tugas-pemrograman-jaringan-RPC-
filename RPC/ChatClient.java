import java.rmi.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            String serverURL = "rmi://localhost/ChatServer";
            ChatService chatServer = (ChatService) Naming.lookup(serverURL);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            ChatClientInterface client = new ChatClientImpl(name);
            chatServer.addClient(client);

            System.out.println("Connected to ChatServer. Type 'exit' to quit.");
            while (true) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) {
                    chatServer.removeClient(client);
                    System.exit(0);
                }
                chatServer.sendMessage(client, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}