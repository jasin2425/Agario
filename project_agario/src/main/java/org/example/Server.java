package org.example;
import java.io.*;
import java.net.*;

public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private  int PORT=12345;
    public Server(int PORT) {
        this.PORT = PORT;
    }

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine = in.readLine();
        System.out.println(inputLine);
        out.println(inputLine);

    }
    public void stopServer() throws IOException {
        out.close();
        in.close();
        serverSocket.close();
        clientSocket.close();
    }
    public static  void main(String[] args) throws IOException {
        Server server = new Server(12345);
        server.startServer();
    }
}
