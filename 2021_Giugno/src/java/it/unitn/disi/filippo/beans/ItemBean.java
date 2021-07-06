/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Filippo
 */
public class ItemBean implements Serializable {
    private static int count = 0;
    
    private String title;
    private String description;
    private int currentPrice;
    private String bestOfferer;
    private Date deadline;
    private String id;
    
    public ItemBean() {}
    public ItemBean(String t, String d, int p, String u, Date dt) {
        this.id = ""+(++ItemBean.count);
        this.title = t;
        this.description = d;
        this.currentPrice = p;
        this.bestOfferer = u;
        this.deadline = dt;
    }
    
    public String getID() {
        return this.id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setCurrentPrice(int price) {
        this.currentPrice = price;
    }
    public int getCurrentPrice() {
        return this.currentPrice;
    }
    
    public void setBestOfferer(String user) {
        this.bestOfferer = user;
    }
    public String getBestOfferer() {
        return this.bestOfferer;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public Date getDeadline() {
        return this.deadline;
    }
    
    @Override
    public boolean equals(Object o) {
        return ((ItemBean)o).getID() == this.id;
    }
}
