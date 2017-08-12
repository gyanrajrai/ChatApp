/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.command;

import com.gyan.chatapp.entity.FileDemo;
import com.gyan.chatapp.util.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Admin_GYAN
 */
public class FileCommmand extends ChatCommand{

    @Override
    public void execute(String[] tokens) throws IOException {
        if(tokens.length>=3){
            Client client =handler.getByUserName(tokens[1]);
            if(client==null){
                out.println("User not Found");
            }
            else{
                 PrintStream ps = new PrintStream(client.getSocket().getOutputStream());
                ps.print("[File Sent from  " +client.getUser().getUserName()+":]"+tokens[2]);
                FileDemo file=new FileDemo();
                file.sendFile();
               
            }
        }
    }
    
}
