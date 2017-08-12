/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.command;

/**
 *
 * @author Admin_GYAN
 */
public class ChatCommandFactory {

    public static ChatCommand get(String key) {
        if (key.equalsIgnoreCase("exit")) {
            return new ExitCommand();
        } else if (key.equalsIgnoreCase("list")) {
            return new ListCommand();
        } else if (key.equalsIgnoreCase("pm")) {
            return new PrivateMessageCommand();
        } else if (key.equalsIgnoreCase("block")) {
            return new BlockCommand();
        } else if (key.equalsIgnoreCase("unblock")) {
            return new UnBlockCommand();
        } else if (key.equalsIgnoreCase("autoreply:")) {
            return new AutoreplyCommand();
        } else if(key.equalsIgnoreCase("file")){
            return new FileCommmand();
        }

        return null;
    }

}
