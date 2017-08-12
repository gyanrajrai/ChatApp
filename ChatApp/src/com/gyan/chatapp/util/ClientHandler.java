/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin_GYAN
 */
public class ClientHandler {
    
    //this class works as a Attendence of clients (Registering);
    List<Client>clients=new ArrayList<>();
    
    public void addCleint(Client client){
        clients.add(client);
        
    }
     public void removeClient(Client client){
        clients.remove(client);
        
    }
    public List<Client>getClietnts(){
        return clients;
    }    
    public Client getByUserName(String userName){
        for(Client c:clients){
            if(c.getUser().getUserName().equalsIgnoreCase(userName)){
                return c;
            }
        }
        return null;
    }
}
