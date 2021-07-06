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
public class UserBean implements Serializable {
    private String username;
    private String password;
    
    public UserBean() {
        
    }
    
    public UserBean(String user, String pw) {
        username = user;
        password = pw;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object o) {
        return this.username.equals(((UserBean)o).getUsername()) && 
               this.password.equals(((UserBean)o).getPassword());
    }
        
}
