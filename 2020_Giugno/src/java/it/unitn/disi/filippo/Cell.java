/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo;

/**
 *
 * @author Filippo
 */
public class Cell {
    
    private int neighbors;
    private boolean bomb;
    private boolean clicked;
    
    public Cell() {
        this.neighbors = 0;
        this.bomb = false;
        this.clicked = false;
    }
    
    public boolean isBomb() {
        return this.bomb;
    }
    
    public void placeBomb() {
        this.bomb = true;
    }
    
    public void updateNeighbors() {
        ++neighbors;
    }
    
    public int getNeighbors() {
        return this.neighbors;
    }
    
    public void click() {
        if (!this.clicked) {
            this.clicked = true;
        }
    }
    
    public boolean isClicked() {
        return this.clicked;
    }
    
//    @Override
//    public String toString() {
//        return "Cell"
//    }
}
