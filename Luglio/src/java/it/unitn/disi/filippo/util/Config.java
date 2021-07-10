


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.util;

import it.unitn.disi.filippo.beans.MessageQueue;
import javax.servlet.ServletContext;

/**
 *
 * @author Filippo
 */
public class Config {
    
    public static final String queue = "queue";
    
    public static void initialize(ServletContext ctx) {
        ctx.setAttribute(queue, new MessageQueue());
    }
}
