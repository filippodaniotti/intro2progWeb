/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web.app;

/**
 *
 * @author Filippo
 */
public class WaitingRoom {
    
    private Coppia coppia;
    
    public WaitingRoom () {
        
    }
    
    public WaitingRoom (Coppia c) {
        coppia = c;
    }
    
    public void addCoppia(Coppia c) {
        coppia = c;
    }
    
    public Coppia getCoppia() {
        return coppia;
    }
    
    public boolean isEmpty () {
        return coppia == null;
    }
    
    @Override
    public String toString() {
        return coppia.toString();
    }
}
