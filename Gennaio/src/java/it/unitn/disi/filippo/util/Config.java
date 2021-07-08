/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Filippo
 */
public class Config {
    
    public static final String dbURL = "jdbc:derby://localhost:1527/MyDerbyDB";
    public static final String user = "WEBENGINE";
    public static final String password = "WEBENGINE";
    
    public static int getKind(String kind) {
        int tipo = 0;
        switch(kind) {
            case "Pensione": tipo = 2; break;
            case "Albergo": tipo = 1; break;
            case "Appartamento": tipo = 3; break;
        }
        return  tipo;
    }
}
