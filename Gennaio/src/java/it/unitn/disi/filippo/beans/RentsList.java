/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.beans;

import java.util.LinkedList;

/**
 *
 * @author Filippo
 */
public class RentsList extends LinkedList<RentBean> {
    public RentsList() {};
    
    public void addBean(Object[] beanData) {
        String[] data = new String[7];
        for (int i = 0; i < 7; ++i) {
            data[i] = (String) beanData[i];
        }
        RentBean rent = new RentBean(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        this.add(rent);
    }
}
