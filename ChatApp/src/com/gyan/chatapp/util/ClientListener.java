/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.util;

import com.gyan.chatapp.command.ChatCommand;
import com.gyan.chatapp.command.ChatCommandFactory;
import com.gyan.chatapp.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Admin_GYAN
 */
public class ClientListener extends Thread {

    private Client client;
    private Socket socket;
    protected PrintStream out;
    private BufferedReader reader;
    private ClientHandler handler;

    public ClientListener(Socket socket, ClientHandler handler) throws IOException {
        this.socket = socket;
        this.handler = handler;
        out = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            login();
            //chat until press exit
            while (!isInterrupted()) {
                out.print("(me)>");
                String line = reader.readLine();
                String[] tokens = line.split(";");
                ChatCommand cmd = ChatCommandFactory.get(tokens[0]);
                if (cmd != null) {
                    cmd.setClient(client);
                    cmd.setClientHandler(handler);
                    cmd.setPrintStream(out);
                    cmd.execute(tokens);

                } else {
                    broadCastMessage(client.getUser().getUserName() + " says " + line + "\r\n");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void login() throws IOException {
        out.println("Welcome to WlinkGyan Server:");
        out.println("Enter UserName");
        String userName = reader.readLine();
        out.println("Enter Password");
        String password = reader.readLine();
        System.out.println(userName + " Has joined" + "\r\n");
        System.out.println("Hello! " + userName);
        //user set at the time of login
        User user = new User(userName, password);
        //Set User and Socket
        client = new Client(user, socket);
        handler.addCleint(client);
        broadCastMessage(userName + "  has Joined Group" + "\r\n");

    }

    public void broadCastMessage(String msg) throws IOException {
        for (Client c : handler.getClietnts()) {
            if (!c.equals(client)) {
                //broadcast to all pc 
                PrintStream ps = new PrintStream(c.getSocket().getOutputStream());
                ps.print(msg);

            }

        }
    }

   
    }
    

