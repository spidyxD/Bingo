/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Addiel
 */
package bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Addiel
 */
public class Jugador {
    int cant;
    List<Tablero> tabs = new ArrayList();
    int count;
    public Jugador() {
        cant = 10;
        for(int i=0;i<cant;i++){
            this.tabs.add(i, null);
        }
        count =0;
    }
    public Jugador(int c) {
        this.cant = c;
        
        for(int i=0;i<cant;i++){
            this.tabs.add(i, null);
        }
        count = 0;
    }
    
    public  List<Tablero>  getTabs() {
        return tabs;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public void setTabs( ArrayList<Tablero>  tabs) {
        this.tabs = tabs;
    }
    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    public void initTabs(int c){
         this.setCant(c);
         for(int i=0;i<this.getCant();i++){
            this.getTabs().add(i, new Tablero());
        }
    }
    
}
