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
public class PrivateMessageCommand extends ChatCommand{

    @Override
    public void execute(String[] tokens) throws IOException {
        if(tokens.length>=3){
            Client friend=handler.getByUserName(tokens[1]);
            if(friend==null){
                out.println("User not Found");
            }
            else{
                 PrintStream ps = new PrintStream(friend.getSocket().getOutputStream());
                ps.print("[private message from  " +client.getUser().getUserName()+":]"+tokens[2]);
                String reply=friend.getAutoreply();
                if(reply!=null && reply.length()>0){
                    out.println("[ Auto reply from "+friend.getUser().getUserName()+">"+reply);
                }
            }
        }
    }
    
}
