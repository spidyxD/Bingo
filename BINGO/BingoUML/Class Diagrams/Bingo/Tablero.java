/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 *
 * @author Addiel
 */
public  class Tablero {
        private ArrayList<Numero> tab = new ArrayList<>(25);
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
        count =0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
   
    public ArrayList<Numero> getTab() {
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
           this.getTab().add(i,new Numero(nA[i],false,""));
        }
       for(int j=0;j<5;j++){
           this.getTab().add(aux,new Numero(nA2[j],false,""));
           aux++;
       }
       for(int h=0;h<5;h++){ 
            this.getTab().add(aux2,new Numero(nA3[h],false,""));
            aux2++;
       }
        for(int l=0;l<5;l++){
           this.getTab().add(aux3,new Numero(nA4[l],false,""));
           aux3++;
       }
        for(int m=0;m<5;m++){
           this.getTab().add(aux4,new Numero(nA5[m],false,""));
           aux4++;
       }
      
   } 
  public StringBuilder printTab(){
      StringBuilder s = new StringBuilder();
       s.append((char)27 + "[34;42m" + "N° Carton : " + getCount() + "\n");
       s.append("==========================" + "\n");
       s.append( "|"+ " B  " + "|" + " I  " + "|" + " N  " + "|" + " G  " + "|" + " O  " + "| \n"); 
       s.append("========================== \n");
       int c = 5;
       int c2 = 10;
       int c3 = 15;
       int c4 = 20;
       for(int i = 0; i <5;i++){
         int aux = (int)getTab().get(i).getNumber();
         if(getTab().get(i).getX().equals("")){
         if(aux > 9){
         s.append("[ ").append(getTab().get(i).getNumber()).append(" ");
         }
         else{
         s.append("[ ").append(getTab().get(i).getNumber()).append("  ");
         }
         }
         else{
         s.append("[ ").append(getTab().get(i).getX()).append("  ");
         }
         //---------------------------------------------------//
         if(getTab().get(c).getX().equals("")){
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c).getNumber()).append(" ");
         c++;
         }else{
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c).getX()).append("  ");
         c++;
         }
         //---------------------------------------------------//
         if(getTab().get(c2).getX().equals("")){
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c2).getNumber()).append(" ");
         c2++;
         }else{
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c2).getX()).append("  ");
         c2++;
         }
         //---------------------------------------------------// 
         if(getTab().get(c3).getX().equals("")){
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c3).getNumber()).append(" ");
         c3++;
         }else{
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c3).getX()).append("  ");
         c3++;
         }
         //---------------------------------------------------//
        if(getTab().get(c4).getX().equals("")){
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c4).getNumber()).append(" ");
         c4++;
         }else{
         s.append("\t");
         s.deleteCharAt(s.length()-1).append("| ").append(getTab().get(c4).getX()).append("  ");
         c4++;
         }
         s.append("]");
         s.append("\n");
       }
       s.append("-------------------------- \n");
      return s;
  } 
  public StringBuilder reporteTabs(){
     StringBuilder s = new StringBuilder();
     int c = 5;
     int c2 = 10;
     int c3 = 15;
     int c4 = 20;
     s.append("<h1>N° Carton : ").append(getCount()).append( "</h1>");
     s.append("<table border=1>");
     s.append("<tr>");
     s.append("<td>B</td>");
     s.append("<td>I</td>");
     s.append("<td>N</td>");
     s.append("<td>G</td>");
     s.append("<td>O</td>");
     s.append("</tr>");
     
    
    
    s.append("<tr>");
    for(int i = 0; i <5;i++){ 
        if(getTab().get(i).getX().equals("")){
        s.append("<td>").append(getTab().get(i).getNumber()).append("</td>");
        }else{
         s.append("<td>").append(getTab().get(i).getX()).append("</td>");
        }
    }
     s.append("</tr>");
        
     s.append("<tr>");
     for(int i = 0; i <5;i++){ 
         if(getTab().get(c).getX().equals("")){
        s.append("<td>").append(getTab().get(c).getNumber()).append("</td>");
        c++;
        }else{
         s.append("<td>").append(getTab().get(c).getX()).append("</td>");
         c++;
        }
     }
     s.append("</tr>");
         
     s.append("<tr>");
     for(int i = 0; i <5;i++){ 
        if(getTab().get(c2).getX().equals("")){ 
        s.append("<td>").append(getTab().get(c2).getNumber()).append("</td>");
        c2++;
        }else{
         s.append("<td>").append(getTab().get(c2).getX()).append("</td>");
         c2++;
        }
     }
    s.append("</tr>");
        
    s.append("<tr>");
    for(int i = 0; i <5;i++){ 
        if(getTab().get(c3).getX().equals("")){ 
        s.append("<td>").append(getTab().get(c3).getNumber()).append("</td>");
        c3++;
        }else{
         s.append("<td>").append(getTab().get(c3).getX()).append("</td>");
         c3++;
        }
    }
    s.append("</tr>");
        
    s.append("<tr>");
    for(int i = 0; i <5;i++){ 
        if(getTab().get(c4).getX().equals("")){ 
        s.append("<td>").append(getTab().get(c4).getNumber()).append("</td>");
        c4++;
        }else{
         s.append("<td>").append(getTab().get(c4).getX()).append("</td>");
         c4++;
        }
    }
     s.append("</tr>");   
     s.append("</table>");
        return s;
  }      
}
