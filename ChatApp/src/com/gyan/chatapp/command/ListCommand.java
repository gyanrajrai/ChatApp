/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gyan.chatapp.command;

import com.gyan.chatapp.util.Client;
import java.io.IOException;

/**
 *
 * @author Admin_GYAN
 */
public class ListCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        StringBuilder content = new StringBuilder();
        content.append("Users\r]n=========\r\n");
        for (Client c : handler.getClietnts()) {
            if (!c.hashBlock(client)) {
                String blocked=(client.hashBlock(c))?"Blocked":"";
                content.append(c.getUser().getUserName()+blocked).append("\r\n");

            }

        }
        out.println(content.toString());
    }

}
