/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.beans;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Filippo
 */
public class ItemBeanList extends LinkedList<ItemBean> {
    public ItemBeanList(){}
    
    public void addItem(List<ItemBean> items, String[] item) {
        int priceInt = Integer.parseInt(item[2]);
        int dtInt = Integer.parseInt(item[4]);
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + dtInt * 1000);
        ItemBean it = new ItemBean(item[0], item[1], priceInt, item[3], expireTime);
        this.add(it);
    }
    
    public ItemBeanList getActiveAuctions() {
        ItemBeanList active = new ItemBeanList();
        long currentTime = new Date().getTime();
        for (ItemBean item : this) {
            if (item.getDeadline().getTime() > currentTime) {
                active.add(item);
            }
        }
        return active;
    }
    
    public ItemBeanList getExpiredAuctions() {
        ItemBeanList expired = new ItemBeanList();
        long currentTime = new Date().getTime();
        for (ItemBean item : this) {
            if (item.getDeadline().getTime() < currentTime) {
                expired.add(item);
            }
        }
        return expired;
    }
}
