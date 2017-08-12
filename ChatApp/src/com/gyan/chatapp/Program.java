/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp;

import com.gyan.chatapp.entity.FileDemo;
import com.gyan.chatapp.util.ClientHandler;
import com.gyan.chatapp.util.ClientListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin_GYAN
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int port = 9090;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is Running at:" + port);
            ClientHandler handler = new ClientHandler();
            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection request from the " + socket.getInetAddress().getHostAddress());
                ClientListener listener = new ClientListener(socket, handler);
                listener.start();
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        
    }

}
