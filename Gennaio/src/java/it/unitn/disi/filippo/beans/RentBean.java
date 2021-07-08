/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.beans;

import java.io.Serializable;

/**
 *
 * @author Filippo
 */
public class RentBean implements Serializable {
    
    private String id;
    private String name;
    private String price;
    private String score;
    private String kind;
    private String image;
    private String extra;
    
    public RentBean() {};

    RentBean(String id, String name, String price, String score, String kind, String image, String extra) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.score = score;
        this.kind = kind;
        this.image = image;
        this.extra = extra;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPrice() {
        return this.price;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public String getScore() {
        return this.score;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getKind() {
        return this.kind;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }
    public void setExtra(String extra) {
        this.extra = extra;
    }
    public String getExtra() {
        return this.extra;
    }
    
}
