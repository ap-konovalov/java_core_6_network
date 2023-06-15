package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// https://github.com/netology-code/jd-homeworks/tree/master/network
public class Server {

    private static final int SERVER_PORT = 8089;

    public static void main(String[] args) throws IOException {

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String initialRequest = in.readLine();
                System.out.println("Client request: " + initialRequest);
                if (initialRequest.equalsIgnoreCase("Ping")) {
                    out.println("Pong");
                    System.out.println("New client connected on port: " + clientSocket.getPort());
                }
                System.out.println("Send message to client: What's your name?");
                out.println("What's your name?");
                String name = in.readLine();
                System.out.println("Client response: " + name);
                System.out.println("Privet " + name);
            }
        }
    }
}