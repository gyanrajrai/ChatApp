/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.command;

import com.gyan.chatapp.util.Client;
import com.gyan.chatapp.util.ClientHandler;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Admin_GYAN
 */
public abstract class ChatCommand {

    protected Client client;
    protected PrintStream out;
    protected ClientHandler handler;

    public abstract void execute(String[] tokens) throws IOException;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PrintStream getPrintStream() {
        return out;
    }

    public void setPrintStream(PrintStream out) {
        this.out = out;
    }

    public ClientHandler getClientHandler() {
        return handler;
    }

    public void setClientHandler(ClientHandler clientHandler) {
        this.handler = clientHandler;
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
