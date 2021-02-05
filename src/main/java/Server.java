import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 20000;
        try {
            System.out.println("Starting server");

            ServerSocket serverSocket= new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();//Начинем слушать порт и ожидать подключения
            PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection!");
            final String name = fromClient.readLine();
             toClient.println(String.format("Hi, %s, your port is %d", name, clientSocket.getPort()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
