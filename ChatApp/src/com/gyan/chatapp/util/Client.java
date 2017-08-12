/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.util;

import com.gyan.chatapp.entity.User;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin_GYAN
 */
public class Client {
    private String autoreply;
    
    private User user;
    private Socket socket;
    private List<Client> blockList = new ArrayList<>();
    
    public Client(User user, Socket socket) {
        this.user = user;
        this.socket = socket;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Socket getSocket() {
        return socket;
    }
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setAutoreply(String autoreply) {
        this.autoreply = autoreply;
    }

    public String getAutoreply() {
        return autoreply;
    }
    
    
    public void block(Client c) {
        if (!hashBlock(c)) {
            blockList.add(c);
        }
        
    }

    public void unblock(Client c) {
        if (hashBlock(c)) {
            blockList.remove(c);
        }
        
    }

    public boolean hashBlock(Client c) {
        for (Client clients : blockList) {
            if (clients.equals(c)) {
                return true;
            }
        }
        return false;
        
    }
    
}
