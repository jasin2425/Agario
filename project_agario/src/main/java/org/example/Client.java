package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.util.Enumeration;
public class Client {
    private  int port;
    private  String host;
    private Socket clientsocket;
    private BufferedReader in;
    private PrintWriter out;

    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port=port;
    }

    public void connect() throws IOException {
        clientsocket = new Socket(host, port);
        out = new PrintWriter(clientsocket.getOutputStream(), true);
        in=new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
    }
    public String sendMessage(String message) throws IOException {
        out.println(message);
        out.flush();
        return in.readLine();
    }

    public void disconnect() throws IOException {
        in.close();
        out.close();
        clientsocket.close();

    }
    public static  void main(String[] args) throws IOException {
        InetAddress localIP = InetAddress.getLocalHost();
        String host = localIP.getHostAddress();
        Client client = new Client(host, 12345);
        client.connect();
        client.sendMessage("Hello World");
        client.disconnect();
    }
}

