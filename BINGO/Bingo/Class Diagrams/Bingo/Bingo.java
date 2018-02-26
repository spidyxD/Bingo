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
import java.util.Random;
import java.util.stream.IntStream;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Addiel
 */
public class Bingo extends Thread {
    private ArrayList<Jugador> players = new ArrayList<>(); 
    private int cantidad;
    private String modeWing;
    private String whoWing;
    public final int LINEA_HORIZONTAL = 0;
    public final int LINEA_VERTICAL = 1;
    public final int LINEA_DIAGONAL = 2;
    public final int FIG_C = 3;
    public final int FIG_X = 4;
    public final int FIG_O = 5;
    public final int FIG_U = 6;
    public final int ALL = 7;
    private int[] mG;
    private int[] numbers;
    private Stack<Integer> nums = new Stack();
    public Bingo() {
        cantidad = 1;
        for(int i=0;i<cantidad;i++){
            players.add(i, null);
        }
        mG = IntStream.rangeClosed(0, 7).toArray();
       numbers = IntStream.rangeClosed(1, 75).toArray();
       for(int i=0;i<75;i++){
            nums.add(i, i+1);
        }
    }
    public String getModeWing() {
        return modeWing;
    }

    public void setModeWing(String modeWing) {
        this.modeWing = modeWing;
    }

    public String getWhoWing() {
        return whoWing;
    }

    public void setWhoWing(String whoWing) {
        this.whoWing = whoWing;
    }
    
    public Bingo(int cantidad) {
        this.cantidad = cantidad;
        for(int i=0;i<cantidad;i++){
            players.add(i, null);
        }
        mG = IntStream.rangeClosed(0, 7).toArray();
        numbers = IntStream.rangeClosed(1, 75).toArray();
        for(int i=0;i<75;i++){
              nums.add(i, i+1);
        }
    }
   
    public ArrayList<Jugador> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Jugador> players) {
        this.players = players;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
    public void initPlayers(int c){
        int n =0;
        for(int i=0;i<cantidad;i++){
            n++;
            this.setCantidad(c);
            players.add(i, new Jugador());
            players.get(i).setCount(n);
        }
    }
    /** sustituir el valor que es seleccionado por una X en el table
     * @param t
     * @param n*/
    public void addXP(Tablero t,int n){
         for(int i=0; i < t.getTab().size();i++){
               t.getTab().set(n, 0);
         }
    }
    /** metodos para verificar patrones en los tablero
     * @param t
     * @return */
    public Boolean verifyPatronLH(Tablero t){ 
        boolean flag = false;
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        for(int i=0;i<=20;i+=5){
           if(t.getTab().get(i).equals(0)){
           flag = true;  
            }
        }
        for(int i=0;i<4;i++){
            a+=5;
            b+=5;
            c+=5;
            d+=5;
            if(t.getTab().get(a).equals(0) || t.getTab().get(b).equals(0) || t.getTab().get(c).equals(0) || t.getTab().get(d).equals(0)){
            flag = true;  
            }
        }
        return flag;
    }
    public Boolean verifyPatronLV(Tablero t){
        int a = 4;
        int b = 9;
        int c = 14;
        int d = 19;
        for(int i = 0; i < 5;i++){
             ++a;
             ++b;
             ++c;
             ++d;
            if(t.getTab().get(i).equals(0) || t.getTab().get(b).equals(0) ||t.getTab().get(c).equals(0) || t.getTab().get(d).equals(0)){
             return true;
            } 
        }
        return false;
    }
    public Boolean verifyPatronDiag(Tablero t){
        boolean flag = false;
        for(int i=0;i<25;i+=6){
         if(t.getTab().get(i).equals(0))
            flag = true;
        }
        for(int i=4;i<25;i+=4){
         if(t.getTab().get(i).equals(0))
            flag = true;
        }
        return flag;
    }
    public Boolean verifyPatronC(Tablero t){
        boolean flag = false;
        int a = 5;
        int b = 9;
        for(int i = 0; i < 5;i++){
            if(t.getTab().get(i).equals(0)){
                flag = true;    
            } 
        }
        for(int i = 0; i < 3;i++){   
            a+=5;
            b+=4;
            if(t.getTab().get(a).equals(0)){
            if(t.getTab().get(b).equals(0))
                flag = true; 
             }
         } 
        
        return flag;
    }
    public Boolean verifyPatronX(Tablero t){
        if(t.getTab().get(0).equals(0) && t.getTab().get(4).equals(0)){
        if(t.getTab().get(6).equals(0) && t.getTab().get(8).equals(0))
        if(t.getTab().get(12).equals(0)) 
        if(t.getTab().get(16).equals(0) && t.getTab().get(18).equals(0))
        if(t.getTab().get(20).equals(0) && t.getTab().get(24).equals(0))
            return true;}
        
        return false;
    }
    public Boolean verifyPatronU(Tablero t){
        boolean flag = false;
    
        for(int i = 0; i < 5;i++){
            if(t.getTab().get(i).equals(0))
                flag = true;
        }
        if(t.getTab().get(9).equals(0) && t.getTab().get(14).equals(0) && t.getTab().get(19).equals(0))
            flag = true;
        for(int h = 20; h < 25;h++){
            if(t.getTab().get(h).equals(0))
                  flag = true;
        }
        
        return flag;
    }
    public Boolean verifyPatronO(Tablero t){
        boolean flag = false;
        int aux = 19;
        for(int i = 0; i < 5;i++){
            ++aux; 
            if(t.getTab().get(i).equals(0) && t.getTab().get(aux).equals(0))
            flag = true;
        }
        
         if(t.getTab().get(5).equals(0) && t.getTab().get(10).equals(0) && t.getTab().get(15).equals(0))
         if(t.getTab().get(9).equals(0) && t.getTab().get(14).equals(0) && t.getTab().get(19).equals(0))
            flag = true;
         
        return flag;
    }
    public Boolean verifyPatronALL(Tablero t){
        for(int i = 0; i < 25;i++){
            if(t.getTab().get(i).equals(0))
                return true;
        }
        return false;
    }
    public void waitSeconds(int segundos) {
        try {
                Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
        }
    }
    public boolean GAMEMODE(int g, Jugador j){
        boolean flag = false;
        String nWing = "";
        String mWing = "";
       switch(g){
           case LINEA_HORIZONTAL:
            for(int m=0; m<j.getCant();m++)
                if(verifyPatronLH(j.getTabs().get(m))){
                   flag = true;  
                }
            if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("LINEA_HORIZONTAL");
           }
           break;
           
           case LINEA_VERTICAL:
            for(int m=0; m<j.getCant();m++)
                if(verifyPatronLV(j.getTabs().get(m))){
                     flag = true;
                } 
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("LINEA_VERTICAL");
           }
           break;
           
           case LINEA_DIAGONAL:
            for(int m=0; m<j.getCant();m++)
                 if(verifyPatronDiag(j.getTabs().get(m))){
                     flag = true;
                 } 
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("LINEA_DIAGONAL");
           }
           break;
           
           case FIG_C:
           for(int m=0; m<j.getCant();m++)
                  if(verifyPatronC(j.getTabs().get(m))){
                      flag = true;
           }
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIG_C");
           }
           break;
           
           case FIG_X:
           for(int m=0; m<j.getCant();m++)
                  if(verifyPatronX(j.getTabs().get(m))){
                      flag = true;
           }
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIG_X");
           }
           break;
           
           case FIG_O:
           for(int m=0; m<j.getCant();m++)
                 if(verifyPatronO(j.getTabs().get(m))){
                     flag = true;
           }
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIG_O");
           }
           break;
           
           case FIG_U:
           for(int m=0; m<j.getCant();m++)
                if(verifyPatronU(j.getTabs().get(m))){
                    flag = true;
           }
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIG_U");
           }
           break;
           
           case ALL:
           for(int m=0; m<j.getCant();m++)
                  if (verifyPatronALL(j.getTabs().get(m))){
                      flag = true;
           }
           if(flag == true){
               for(int m=0; m<j.getCant();m++)
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("El BINGO");
           }
           break;
           
           default:
               flag = false;
               break;
       }   
       return flag;
    }
    public int[] mixed(int[]aux, Random r){
        for (int i = aux.length; i > 0; i--) {
        int pos = r.nextInt(i);
        int tmp = aux[i-1];
        aux[i - 1] = aux[pos];
        aux[pos] = tmp;
        }  
        return aux;
    }
    public Stack myR(Stack nAx ){
        Collections.shuffle(nAx);
        return nAx;
    }
    public String getNCol(int n){
        String aux = "";
        int a = 15;
        int b = 30;
        int c = 45;
        int d = 60;
        for(int i =0;i<15;i++){
            a++;
            b++;
            c++;
            d++;
        if(n <= i )
        aux = "B";
        else if(n <= a)
        aux  = "I";
        else if(n <= b)
        aux  = "N";
        else if(n <= c)
        aux  = "G";
        else if(n <= d)
        aux  = "O";
      }
        return aux;
    }
    public void iniciarJuego(){ 
        Random r = new Random();
        boolean flag = false;
        int aux =0;
        int nx =0;
        int mx =r.nextInt(7);
        numbers = IntStream.rangeClosed(1, 75).toArray();
        mG= IntStream.rangeClosed(0, 7).toArray();
        mG = mixed(mG,r);
        numbers = mixed(numbers,r); 
        nums = myR(nums);
        Scanner s = new Scanner(System.in);
        System.out.println("Cuantos jugadores habran?");
        int cJ = s.nextInt();
        Bingo b = new Bingo(cJ);
        System.out.println("Cuantos cartones como máximo tendrá cada jugador?");
        int nC = s.nextInt();  
        int[] nT = IntStream.rangeClosed(1, nC).toArray();
          nT = mixed(nT,r);
        //iniciando valores de jugadores 
        for(int i=0; i<cJ;i++){
           b.initPlayers(cJ);
        } 
        //iniciando los tableros de cada jugador
        for(int i=0; i<cJ;i++){
           b.getPlayers().get(i).initTabs(nC);
        } 
        //llenando aleatoriamente los tableros de cada jugador
        for(int h=0; h<cJ;h++){
            //aux++;
            for(int m=0; m<nC;m++){
                b.getPlayers().get(h).getTabs().get(m).fillTab();
                b.getPlayers().get(h).getTabs().get(m).setCount(m+1);
                /*System.out.println("Jugador N°" + aux);
                System.out.println(b.getPlayers().get(h).getTabs().get(m).printTab()+"\t");*/
            }
        }
        System.out.println("Empezando la partida....");
        for(int h=0; h<cJ;h++){
            aux++;   
        for(int l=0; l<50; l++){
            nx = nums.get(r.nextInt(74));   
        for(int m=0; m<nC;m++){
            System.out.println((char)27 + "[31;43m" + "Columna "+ getNCol(nx) + " - "+ "El numero: " + nx);
            if(b.getPlayers().get(h).getTabs().get(m).getTab().contains(nx)){
                b.addXP(b.getPlayers().get(h).getTabs().get(m),b.getPlayers().get(h).getTabs().get(m).getTab().indexOf(nx));
                }
                b.waitSeconds(1);
                System.out.println((char)27 + "[34;42m" + "Jugador N°" + aux);
                System.out.println(b.getPlayers().get(h).getTabs().get(m).printTab());
                System.out.println("\n");
            if(b.GAMEMODE(mG[mx],b.getPlayers().get(h))){
               System.out.println("Hay ganador");
               System.out.println("El jugador gandor es el N° " + b.getWhoWing());
               System.out.println("Modo de juego ganado: " + b.getModeWing());
               flag = true;
               break;
           }
        }
        if(flag == true)
             break;
        }
        if(flag == true)
             break;
    }
        /*for(int h=0; h<cJ;h++){
        for(int m=0; m<nC;m++)
           if(b.GAMEMODE(mx,b.getPlayers().get(h))){
               System.out.println("Hay ganador");
               System.out.println("El jugador gandor es el N° " + b.getWhoWing());
               System.out.println("Modo de juego ganado: " + b.getModeWing());
               break;
           }

     }*/
}
   
    
    
    
    
    
    
}

