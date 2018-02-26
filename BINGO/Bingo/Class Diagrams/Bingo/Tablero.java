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
import java.util.Random;
import java.util.Stack;
//import java.util.Stack;
import java.util.stream.IntStream;

/**
 *
 * @author Addiel
 */
public  class Tablero {
        private ArrayList<Integer> tab = new ArrayList<>(25);
        private int[] nA;
        private int[] nA2;
        private int[] nA3;
        private int[] nA4;
        private int[] nA5;
        public  int count;
    public Tablero(){
        for(int i=0;i<25;i++){
            this.tab.add(i, null);
        }
        nA = IntStream.rangeClosed(1, 15).toArray();
        nA2 = IntStream.rangeClosed(16, 30).toArray();
        nA3 = IntStream.rangeClosed(31, 45).toArray();
        nA4 = IntStream.rangeClosed(46, 60).toArray();
        nA5 = IntStream.rangeClosed(61, 75).toArray();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
   
    public ArrayList getTab() {
        return this.tab;
    }

    public void setTab(ArrayList tab) {
        this.tab = tab;
    }
    /** desoredenar vector aleatorio*/
    public int[] mixed(int[]aux, Random r){
        for (int i = aux.length; i > 0; i--) {
        int pos = r.nextInt(i);
        int tmp = aux[i-1];
        aux[i - 1] = aux[pos];
        aux[pos] = tmp;
        }  
        return aux;
    }
    public Stack myR(){
        Stack nAx = new Stack();
        int n=0;
        for(int i=0;i<75;i++){
            nAx.push(i);
        }
        Collections.shuffle(nAx);
        return nAx;
    }
   public void fillTab(){
       int aux = 5;
       int aux2 = 10;
       int aux3 = 15;
       int aux4 = 20;
       Random r = new Random();
        nA=mixed(nA,r);
        nA2=mixed(nA2,r);
        nA3=mixed(nA3,r);
        nA4=mixed(nA4,r);
        nA5=mixed(nA5,r);
       for(int i=0;i<5;i++){
           this.getTab().add(i,nA[i]);
        }
       for(int j=0;j<5;j++){
           this.getTab().add(aux,nA2[j]);
           aux++;
       }
       for(int h=0;h<5;h++){ 
            this.getTab().add(aux2,nA3[h]);
            aux2++;
       }
        for(int l=0;l<5;l++){
           this.getTab().add(aux3,nA4[l]);
           aux3++;
       }
        for(int m=0;m<5;m++){
           this.getTab().add(aux4,nA5[m]);
           aux4++;
       }
      
   } 
  public StringBuilder printTab(){
      StringBuilder s = new StringBuilder();
       s.append((char)27 + "[34;42m" + "N° Carton : " + count + "\n");
       s.append("==========================" + "\n");
       s.append( "|"+ " B  " + "|" + " I  " + "|" + " N  " + "|" + " G  " + "|" + " O  " + "| \n"); 
       s.append("========================== \n");
       int c = 5;
       int c2 = 10;
       int c3 = 15;
       int c4 = 20;
       for(int i = 0; i <5;i++){
         int aux = (int)getTab().get(i);
         if(aux > 9){
         s.append("[ ").append(getTab().get(i)).append(" ");
         }
         else{
         s.append("[ ").append(getTab().get(i)).append("  ");
         }
         //---------------------------------------------------//
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c)).append(" ");
         c++;
         //---------------------------------------------------//
         s.append("\t"); 
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c2)).append(" ");
         c2++;
         //---------------------------------------------------// 
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c3)).append(" ");
         c3++;
         //---------------------------------------------------//
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c4)).append(" ");
         s.append("]");
         s.append("\n");
         c4++;
       }
       s.append("-------------------------- \n");
      return s;
  } 
  public StringBuilder reporteTabs(){
     StringBuilder s = new StringBuilder();
     s.append("<table>");
     s.append("<tr>");
     s.append("<td>B</td>");
     s.append("<td>I</td>");
     s.append("<td>N</td>");
     s.append("<td>G</td>");
     s.append("<td>O</td>");
     s.append("</tr>");
     s.append("<tr>");
     int c = 5;
     int c2 = 10;
     int c3 = 15;
     int c4 = 20;
     for(int i = 0; i <5;i++){
        int aux = (int)getTab().get(i);
        s.append("<td>" + getTab().get(i) + "</td>");
        s.append("</tr>");

        s.append("<tr>");
        s.append("<td>" + getTab().get(c) + "</td>");
        s.append("</tr>");

        s.append("<tr>");
        s.append("<td>" + getTab().get(c2) + "</td>");
        s.append("</tr>");

        s.append("<tr>");
        s.append("<td>" + getTab().get(c3) + "</td>");
        s.append("</tr>");

        s.append("<tr>");
        s.append("<td>" + getTab().get(c4) + "</td>");
        s.append("</tr>");

        s.append("</table>");
     
    
    }
        return s;
  }
  /*public static void main(String[] args) {
       Tablero t = new Tablero();
       t.fillTab();
       System.out.println(t.printTab().toString() + t.getTab().size());
      
        
    
        
   }*/
}
