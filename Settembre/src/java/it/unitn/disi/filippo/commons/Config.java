/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.commons;

import java.util.Random;
import javax.servlet.ServletContext;

/**
 *
 * @author Filippo
 */
public class Config {
    
    public static void initialize(ServletContext ctx) {
        
        WaitingRoom room = new WaitingRoom();
        MappaDiCoppie map = new MappaDiCoppie();
        ctx.setAttribute("room", room);
        ctx.setAttribute("map", map);
    }
    
    public static final Random rand = new Random();
    
}
