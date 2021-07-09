/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.commons;

import java.util.ArrayList;

/**
 *
 * @author Filippo
 */
public class Coppia {

    String user1 = null;
    String user2 = null;
    ArrayList<String> lista1 = null;
    ArrayList<String> lista2 = null;
    String image = null;
    boolean won = false;

    public Coppia(String us1) {
        user1 = us1;
    }

    public void addOpponent(String us2) {
        user2 = us2;
    }

    public String getFirstUser() {
        String user = "";
        if (this.user1 != null) {
            user += this.user1;
        }
        return user;
    }

    public void setLists() {
        lista1 = new ArrayList<>();
        lista2 = new ArrayList<>();
    }

    public void setImage() {
        int image = Config.rand.nextInt(10);
        String imgPath = "img/" + image + ".jpg";
        this.image = imgPath;
    }

    public String getImage() {
        return this.image;
    }
    
    public ArrayList<String> getList1() {
        return this.lista1;
    }
    public ArrayList<String> getList2() {
        return this.lista2;
    }
    
    public void win() {
        this.won = true;
    }
    
    public boolean isWon() {
        return this.won;
    }
    
    @Override
    public String toString() {
        if (user2 != null) {
            return "Users are " + user1 + " and " + user2;
        } else {
            return "User " + user1 + " is waiting for an opponent";
        }
    }
}
