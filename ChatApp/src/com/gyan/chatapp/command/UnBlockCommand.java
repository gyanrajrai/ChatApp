/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.command;

import com.gyan.chatapp.util.Client;
import java.io.IOException;
import java.io.PrintStream;

/**
 *
 * @author Admin_GYAN
 */
public class UnBlockCommand extends ChatCommand{

    @Override
    public void execute(String[] tokens) throws IOException {
        if(tokens.length>=2){
            Client friend=handler.getByUserName(tokens[1]);
            if(friend==null){
                out.println("User not Found");
            }
            else{
                 client.unblock(client);
                 out.println(tokens[1]+" has been unblocked" );
                 
            }
        }
        else{
            out.println("not enough parameter");
        }
    }
    
}
