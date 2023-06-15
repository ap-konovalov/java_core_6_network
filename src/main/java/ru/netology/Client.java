package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 8089;

    public static void main(String[] args) throws IOException {

        try (Socket clientSocket = new Socket(SERVER_HOST, SERVER_PORT)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Ping");
            String serverResponse = in.readLine();
            if (serverResponse.equalsIgnoreCase("Pong")) {
                System.out.println("Connection with server established.");
            }
            System.out.println("Incoming request from server: " + in.readLine());
            String myName = "Bratishka";
            System.out.println("Send response to server: " + myName);
            out.println(myName);
        }
    }
}