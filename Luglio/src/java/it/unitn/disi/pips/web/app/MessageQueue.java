/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web.app;

import java.util.ArrayList;

/**
 *
 * @author Filippo
 */
public class MessageQueue<String> extends ArrayList {
    
    public MessageQueue(){
        super();
    }
    
    public void addMsg(String msg) {
        if (msg != null) {
            this.add(msg);
        }
    }
    
    public ArrayList<String> getLastNMsg(int n) {
        ArrayList<String> msgs = new ArrayList();
        int start = this.size() - n;
        for (Object msg : this) {
            if (this.indexOf(msg) >= start) {
                msgs.add((String)msg);
            }
        }
        return msgs;
    }
    
}
