/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.pips.web.app;

import java.util.HashMap;

/**
 *
 * @author Filippo
 */
public class MappaDiCoppie extends HashMap<String, Coppia> {
    
    
    public MappaDiCoppie () {
        super();
    }
    
    @Override
    public String toString() {
        String out = "";
        if (this.keySet().size() > 0){
            for (String key : this.keySet()) {
                out += this.get(key).toString();
                out += "\n";
            }
        } else {
            out += "empty";
        }        
        return out;
    }
}
