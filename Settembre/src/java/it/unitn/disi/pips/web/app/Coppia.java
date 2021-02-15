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
public class Coppia {
    
    private String utente1;
    private String utente2;
    private ArrayList<String> lista1;
    private ArrayList<String> lista2;
    private String image;
    
    public Coppia (String u1) {
        utente1 = u1;
        lista1 = new ArrayList<>();
    }
    
//    public Coppia (String u1, String u2) {
//        utente1 = u1;
//        utente2 = u2;
//        lista1 = new ArrayList<>();
//        lista2 = new ArrayList<>();
//    }
    
    public void addOpponent (String u2) {
        utente2 = u2;
        lista2 = new ArrayList<>();
    }
    
    public String getFirst() {
        return utente1;
    }

    public String getSecond() {
        return utente2;
    }    
    
    public boolean avaliable() {
        return utente1 == null || utente2 == null;
    }
    
    public void removeUser(String u) {
        if (u.equals(utente1))
            utente1 = null;
        if (u.equals(utente2))
            utente2 = null;
    }
    
    public void addWord(String w, String u) {
        if (u.equals(utente1))
            lista1.add(w);
        if (u.equals(utente2))
            lista2.add(w);
    }
    
    public boolean checkWin() {
        boolean win = false;
        for (String f : lista1) {
            for (String s : lista2) {
                if (f.equals(s)) {
                    win = true;
                    break;
                }
            }
            if (win) break;
        }
        return win;
    }
    
    @Override
    public String toString() {
        if (utente2 == null) {
            return "user1 is " + utente1 + " and they are waiting";
        }
        return "user1 is " + utente1 + " and user2 is " + utente2;
    }
    
}
