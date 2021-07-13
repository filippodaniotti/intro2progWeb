/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.util;

/**
 *
 * @author Filippo
 */
public class Config {
    public static final String dbURL = "jdbc:derby://localhost:1527/ExamDerbyDB";
    public static final String user = "WEBENGINE";
    public static final String pw = "WEBENGINE";
    
    public static final String activeGames = "active";
    public static final String fixedCells = "fixed";
    public static final String fixedCellsMap = "map";
    
    public static boolean isRed(int x, int y) {
        boolean red = false;
        int rx = x/3;
        int ry = y/3;
        
        if (rx == 0 && ry == 0 ||
            rx == 0 && ry == 2 ||
            rx == 2 && ry == 0 ||
            rx == 2 && ry == 2 ||
            rx == 1 && ry == 1) {
            red = true;
        }
        
        return red;
    }
}
