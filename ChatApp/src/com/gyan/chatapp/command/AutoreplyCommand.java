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
public class AutoreplyCommand extends ChatCommand {

    @Override
    public void execute(String[] tokens) throws IOException {
        String msg = "not enough Parameter";
        if (tokens.length >= 2) {
            client.setAutoreply(tokens[1]);
            msg = "Auto Reply Activated:";
        } else {
            out.println(msg);
        }
    }

}
