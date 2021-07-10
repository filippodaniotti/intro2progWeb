/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.beans;

import java.util.ArrayList;

/**
 *
 * @author Filippo
 */
public class MessageQueue extends ArrayList<String>{
    
    public MessageQueue(){};
    
    public MessageQueue getMessagesFrom(int start) {
        MessageQueue msg = new MessageQueue();
        int counter = 0;
        for (String message : this) {
            if (++counter > start) {
                msg.add(message);
            }
        }
        return msg;        
    }
    
}
