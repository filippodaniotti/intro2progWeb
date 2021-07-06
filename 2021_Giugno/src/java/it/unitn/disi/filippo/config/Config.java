/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.config;

import it.unitn.disi.filippo.beans.ItemBean;
import it.unitn.disi.filippo.beans.ItemBeanList;
import it.unitn.disi.filippo.beans.UserBean;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;

/**
 *
 * @author Filippo
 */
public class Config {

    public static final String userBeanListKey = "userList";
    public static final String itemBeanListKey = "itemList";
    
    public static void loadData(ServletContext ctx) {
        loadUsers(ctx);
        loadItems(ctx);
    }

    public static void loadUsers(ServletContext ctx) {
        String userdata1[] = {"user1", "pw1"};
        String userdata2[] = {"user2", "pw2"};
        String userdata3[] = {"user3", "pw3"};
        List<UserBean> users = new LinkedList<>();

        users.add(new UserBean(userdata1[0], userdata1[1]));
        users.add(new UserBean(userdata2[0], userdata2[1]));
        users.add(new UserBean(userdata3[0], userdata3[1]));

        ctx.setAttribute(userBeanListKey, users);
    }

    public static void loadItems(ServletContext ctx) {
        String itemdata1[] = {
            "DVD Film I sogni segreti di Walter Mitty",
            "Film del 2013 diretto da Ben Stiller e con protagonisti lo stesso Ben Stiller, Kristen Wiig e Sean Penn",
            "1",
            "user1",
            "600"
        };
        //
        String itemdata2[] = {
            "Trenino Lima E.424",
            "Modello in scala N, funzionante",
            "1",
            "user1",
            "300"
        };
        //
        String itemdata3[] = {
            "Microprocessore ESP32",
            "Scheda di sviluppo ESP32 NodeMCU WiFi con CP2102 (modello successivo a ESP8266) incluso E-Book!",
            "2",
            "user2",
            "30"
        };
        
        ItemBeanList items = new ItemBeanList();
        items.addItem(items, itemdata1);
        items.addItem(items, itemdata2);
        items.addItem(items, itemdata3);
        
        ctx.setAttribute(itemBeanListKey, items);
    }
}
