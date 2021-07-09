/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.filippo.commons;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Filippo
 */
public class MappaDiCoppie extends HashMap<String, Coppia>{
    private static int serial = 0;
    
    public MappaDiCoppie(){
        
    }
     
    @Override
    public String toString() {
        String print = "Coppie attive: "+this.size()+"\n";
        for (Map.Entry<String, Coppia> set : this.entrySet()) {
            print += ">  "+set.getValue()+"\n";
        }
        return print;
    }
}
