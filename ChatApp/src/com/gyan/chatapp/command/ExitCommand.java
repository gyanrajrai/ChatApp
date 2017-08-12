/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.command;

import java.io.IOException;

/**
 *
 * @author Admin_GYAN
 */
public class ExitCommand extends ChatCommand{

    @Override
    public void execute(String[] tokens) throws IOException {
        String msg=client.getUser().getUserName()+"Socke chai "+client.getSocket()+"has log out";
        broadCastMessage(msg);
        handler.removeClient(client);
        client.getSocket().close();
                
    }
    
}
