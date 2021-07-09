/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.commons;

/**
 *
 * @author Filippo
 */
public class WaitingRoom {
    private Coppia coppia = null;
    public WaitingRoom() {}
    
    public void addCoppia(Coppia c) {
        coppia = c;
    }
    
    
    public void addOpponent(String name) {
        coppia.addOpponent(name);
    }
    
    public boolean isEmpty() {
        return coppia == null;
    }
    
    public Coppia getCoppiaAndClean() {
        Coppia c = this.coppia;
        coppia = null;
        return c;
    }
    
    public String getFirstUser() {
        return coppia.getFirstUser();
    }
    
    public void finalizeCoppia() {
        coppia.setLists();
        coppia.setImage();
    }
    
    @Override
    public String toString() {
        return coppia.toString();
    }
}
