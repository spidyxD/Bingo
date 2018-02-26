/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoG;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;



/**
 *
 * @author Addiel
 */
public class Bingo{
    private ArrayList<Jugador> players = new ArrayList<>(); 
    private int cantidad;
    private int ronda;
    private String cartWing;
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
    public String message;
    private int[] mG;
    private int[] numbers;
    private Stack<Integer> nums = new Stack();
    private Stack<Integer> auxN = new Stack();
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

    public String getCartWing() {
        return cartWing;
    }

    public void setCartWing(String cartWing) {
        this.cartWing = cartWing;
    }
    
    public String getModeWing() {
        return modeWing;
    }

    public void setModeWing(String modeWing) {
        this.modeWing = modeWing;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
    
    public String getWhoWing() {
        return whoWing;
    }

    public void setWhoWing(String whoWing) {
        this.whoWing = whoWing;
    }

    public Stack<Integer> getAuxN() {
        return auxN;
    }

    public void setAuxN(Stack<Integer> auxN) {
        this.auxN = auxN;
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
               t.getTab().get(n).setFlag(true);
               t.getTab().get(n).setX("X");
    }
    /** metodos para verificar patrones en los tablero
     * @param t
     * @return */
    public Boolean verifyPatronLH(Tablero t){ 
        boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(5).isFlag() && t.getTab().get(10).isFlag() && t.getTab().get(15).isFlag() && t.getTab().get(20).isFlag()){
        flag = true;}    
        else if(t.getTab().get(1).isFlag() && t.getTab().get(6).isFlag() && t.getTab().get(11).isFlag() && t.getTab().get(16).isFlag() && t.getTab().get(21).isFlag()){
        flag = true;} 
        else if(t.getTab().get(2).isFlag() && t.getTab().get(7).isFlag() && t.getTab().get(12).isFlag() && t.getTab().get(17).isFlag() && t.getTab().get(22).isFlag()){
        flag = true;} 
        else if(t.getTab().get(3).isFlag() && t.getTab().get(8).isFlag() && t.getTab().get(13).isFlag() && t.getTab().get(18).isFlag() && t.getTab().get(23).isFlag()){
        flag = true;}
        else if(t.getTab().get(4).isFlag() && t.getTab().get(9).isFlag() && t.getTab().get(14).isFlag() && t.getTab().get(19).isFlag() && t.getTab().get(24).isFlag()){
        flag = true;} 
        
                
        return flag;
    }
    public Boolean verifyPatronLV(Tablero t){
        boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(1).isFlag() && t.getTab().get(2).isFlag() && t.getTab().get(3).isFlag() && t.getTab().get(4).isFlag()){
        flag = true;}    
        else if(t.getTab().get(5).isFlag() && t.getTab().get(6).isFlag() && t.getTab().get(7).isFlag() && t.getTab().get(8).isFlag() && t.getTab().get(9).isFlag()){
        flag = true;} 
        else if(t.getTab().get(10).isFlag() && t.getTab().get(11).isFlag() && t.getTab().get(12).isFlag() && t.getTab().get(13).isFlag() && t.getTab().get(14).isFlag()){
        flag = true;} 
        else if(t.getTab().get(15).isFlag() && t.getTab().get(16).isFlag() && t.getTab().get(17).isFlag() && t.getTab().get(18).isFlag() && t.getTab().get(19).isFlag()){
        flag = true;}
        else if(t.getTab().get(20).isFlag() && t.getTab().get(21).isFlag() && t.getTab().get(22).isFlag() && t.getTab().get(23).isFlag() && t.getTab().get(24).isFlag()){
        flag = true;} 
        
        return flag;
    }
    public Boolean verifyPatronDiag(Tablero t){
        boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(6).isFlag() && t.getTab().get(12).isFlag() && t.getTab().get(18).isFlag() && t.getTab().get(24).isFlag()){
        flag = true;}    
        else if(t.getTab().get(4).isFlag() && t.getTab().get(8).isFlag() && t.getTab().get(12).isFlag() && t.getTab().get(16).isFlag() && t.getTab().get(20).isFlag()){
        flag = true;} 
        return flag;
    }
    public Boolean verifyPatronC(Tablero t){
        boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(5).isFlag() && t.getTab().get(10).isFlag() && t.getTab().get(15).isFlag() && t.getTab().get(20).isFlag()){ 
        if(t.getTab().get(1).isFlag() && t.getTab().get(2).isFlag() && t.getTab().get(3).isFlag() && t.getTab().get(4).isFlag())
        if(t.getTab().get(9).isFlag() && t.getTab().get(14).isFlag() && t.getTab().get(19).isFlag() && t.getTab().get(24).isFlag())
        flag = true;} 
        return flag;
    }
    public Boolean verifyPatronX(Tablero t){
         boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(6).isFlag() && t.getTab().get(12).isFlag() && t.getTab().get(18).isFlag() && t.getTab().get(24).isFlag() && t.getTab().get(4).isFlag() && t.getTab().get(8).isFlag() && t.getTab().get(16).isFlag() && t.getTab().get(20).isFlag()){
        flag = true;}    
        return flag;
    }
    public Boolean verifyPatronU(Tablero t){
        boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(1).isFlag() && t.getTab().get(2).isFlag() && t.getTab().get(3).isFlag() && t.getTab().get(4).isFlag()){
        if(t.getTab().get(20).isFlag() && t.getTab().get(21).isFlag() && t.getTab().get(22).isFlag() && t.getTab().get(23).isFlag() && t.getTab().get(24).isFlag())
        if(t.getTab().get(9).isFlag() && t.getTab().get(14).isFlag() && t.getTab().get(19).isFlag())
        flag = true;} 
        return flag;
    }
    public Boolean verifyPatronO(Tablero t){
        boolean flag = false;
        if(t.getTab().get(5).isFlag() && t.getTab().get(10).isFlag() && t.getTab().get(15).isFlag()){
        if(t.getTab().get(9).isFlag() && t.getTab().get(14).isFlag() && t.getTab().get(19).isFlag())
        if(t.getTab().get(0).isFlag() && t.getTab().get(1).isFlag() && t.getTab().get(2).isFlag() && t.getTab().get(3).isFlag() && t.getTab().get(4).isFlag())
        if(t.getTab().get(20).isFlag() && t.getTab().get(21).isFlag() && t.getTab().get(22).isFlag() && t.getTab().get(23).isFlag() && t.getTab().get(24).isFlag())
        flag = true;} 
         
        return flag;
    }
    public Boolean verifyPatronALL(Tablero t){
         boolean flag = false;
        if(t.getTab().get(0).isFlag() && t.getTab().get(1).isFlag() && t.getTab().get(2).isFlag() && t.getTab().get(3).isFlag() && t.getTab().get(4).isFlag()){
        if(t.getTab().get(5).isFlag() && t.getTab().get(6).isFlag() && t.getTab().get(7).isFlag() && t.getTab().get(8).isFlag() && t.getTab().get(9).isFlag())
        if(t.getTab().get(10).isFlag() && t.getTab().get(11).isFlag() && t.getTab().get(12).isFlag() && t.getTab().get(13).isFlag() && t.getTab().get(14).isFlag())
        if(t.getTab().get(15).isFlag() && t.getTab().get(16).isFlag() && t.getTab().get(17).isFlag() && t.getTab().get(18).isFlag() && t.getTab().get(19).isFlag())
        if(t.getTab().get(20).isFlag() && t.getTab().get(21).isFlag() && t.getTab().get(22).isFlag() && t.getTab().get(23).isFlag() && t.getTab().get(24).isFlag())
        flag = true;} 
        
        return flag;
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
                   setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                   flag = true;  
            }
            if(flag == true){   
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("LINEA_HORIZONTAL");
               
               
           }
           break;
           
           case LINEA_VERTICAL:
            for(int m=0; m<j.getCant();m++)
                if(verifyPatronLV(j.getTabs().get(m))){
                     setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                     flag = true;
            }
           if(flag == true){ 
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("LINEA_VERTICAL");
               
           }
           break;
           
           case LINEA_DIAGONAL:
            for(int m=0; m<j.getCant();m++)
                 if(verifyPatronDiag(j.getTabs().get(m))){
                     setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                     flag = true;
            }
           if(flag == true){ 
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("LINEA_DIAGONAL");
           }
           break;
           
           case FIG_C:
           for(int m=0; m<j.getCant();m++)
                  if(verifyPatronC(j.getTabs().get(m))){
                      setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                      flag = true;   
           }
           if(flag == true){
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIGURA_C");
           }
           break;
           
           case FIG_X:
           for(int m=0; m<j.getCant();m++)
                  if(verifyPatronX(j.getTabs().get(m))){
                      setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                      flag = true;
           }
           if(flag == true){
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIGURA_X");
           }
           break;
           
           case FIG_O:
           for(int m=0; m<j.getCant();m++)
                 if(verifyPatronO(j.getTabs().get(m))){
                     setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                     flag = true;   
           }
           if(flag == true){ 
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIGURA_O");
           }
           break;
           
           case FIG_U:
           for(int m=0; m<j.getCant();m++)
                if(verifyPatronU(j.getTabs().get(m))){
                    setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                    flag = true;
           }
           if(flag == true){
               setWhoWing(String.valueOf(j.getCount()));
               setModeWing("FIGURA_U");
           }
           break;
           
           case ALL:
           for(int m=0; m<j.getCant();m++)
                  if (verifyPatronALL(j.getTabs().get(m))){
                      setCartWing(String.valueOf(j.getTabs().get(m).getCount()));
                      flag = true; 
           }
           if(flag == true){
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
    public StringBuilder stackPrint(){
        StringBuilder s = new StringBuilder();
        for(int i=0; i<getAuxN().size();i++){
            s.append("---");
            s.append("| ").append(getAuxN().get(i)).append(" |").append("\n");
            s.append("---");
            s.append("\n");
        }
        return s;
    }
    public void buildHTML(StringBuilder aux){    
      FileOutputStream fos = null;
      File file;
      try {
	  file = new File("Salida.html");
	  fos = new FileOutputStream(file);
	  if (!file.exists()) {
	     file.createNewFile();
	  }
	  byte[] bytesArray = String.valueOf(aux).getBytes();

	  fos.write(bytesArray);
	  fos.flush();
	  System.out.println("File Written Successfully");
       } 
       catch (IOException e) {
       } 
       finally {
	  try {
	     if (fos != null) 
	     {
		 fos.close();
	     }
          } 
	  catch (IOException ioe) {
	     System.out.println("Error in closing the Stream");
	  }
       }
   
    }
    public StringBuilder reporteFinal(ArrayList<Jugador> j,int tGame,int cJ,int nCar,int nx, StringBuilder end){
    StringBuilder s = new StringBuilder();
        s.append("<html>");
        s.append("<head>");
        s.append("<title>BINGO</title>");
        s.append("<meta charset=").append("UTF-8").append(">");
        s.append("<meta name=").append("viewport").append("content=").append("width=device-width, initial-scale=1.0").append(">");
        s.append("</head>");
        s.append("<body>");
        s.append("<h1>Parametros iniciales</h1>");
        s.append("<ol>");
        s.append("<li>Cantidad de usuarios: ").append(getCantidad()).append("</li>");
        s.append("<li>Cantidad de cartones por usuario: ").append(nCar).append("</li>");
        s.append("<li>Tipo de juego: ").append(getModeWing()).append(" </li>");
        s.append("</ol>");
        s.append("<h2>Ronda N° ").append(getRonda()).append("</h2>");
        s.append("<table border=1>");
        s.append("<tr>");
        s.append("<td><center></center></td>");
        s.append("</tr>");
        s.append("<tr>");
        s.append("<td>PILA</td>");
        for(int i=0;i<getAuxN().size();i++){
            s.append("<tr>");
            s.append("<td>").append(getAuxN().get(i)).append("</td>");
            s.append("</tr>");
        }
        s.append("</table>");
        for(int h=0; h<cJ;h++){    
        for(int m=0; m<nCar;m++){
        s.append("<h3>Columna ").append(getNCol(nx)).append(" - ").append("El numero: ").append(nx).append("</h3>");
        s.append("<h4>Jugador N° ").append(j.get(h).getCount()).append("</h4>");
        s.append(j.get(h).getTabs().get(m).reporteTabs());
        }
        }
        //s.append(end);
        s.append("<h5>El ganador es el Juegador N°").append(getWhoWing()).append("</h5>");
        s.append("<h6>Carton N° ").append(getCartWing()).append("</h6>");
        s.append("</body>");
        s.append("</html>");
    
    return s;
    }
    public StringBuilder reporteRonda(ArrayList<Jugador> j,int cJ,int nCar,int nx){
    StringBuilder s = new StringBuilder();
    for(int h=0; h<cJ;h++){    
        for(int m=0; m<nCar;m++){
        s.append("<h1>Columna ").append(getNCol(nx)).append(" - ").append("El numero: ").append(nx).append("</h1>");
        s.append("<h2>Jugador N° ").append(j.get(h).getCount()).append("</h3>");
        s.append(j.get(h).getTabs().get(m).reporteTabs());
        }
        }
        return s;
    }
    
    public void iniciarJuego(){ 
        StringBuilder end = new StringBuilder();
        Random r = new Random();
        boolean flag = false;
        int aux =0;
        int nx =0;
        int rnd=0;
        int tGame =0;
        numbers = IntStream.rangeClosed(1, 75).toArray();
        mG= IntStream.rangeClosed(0, 7).toArray();
        mG = mixed(mG,r);
        numbers = mixed(numbers,r); 
        nums = myR(nums);
        Scanner s = new Scanner(System.in);
        System.out.println("Cuantos jugadores habran?");
        int cJ = s.nextInt();
        setCantidad(cJ);
        System.out.println("Cuantos cartones como máximo tendrá cada jugador?");
        int nC = s.nextInt(); 
        System.out.println("Seleccione el modo de juego en un rango de 0 a 7");
        tGame = s.nextInt();  
        int[] nT = IntStream.rangeClosed(1, nC).toArray();
          nT = mixed(nT,r);
        //iniciando valores de jugadores 
        for(int i=0; i<cJ;i++){
           initPlayers(cJ);
        } 
        //iniciando los tableros de cada jugador
        for(int i=0; i<cJ;i++){ 
           getPlayers().get(i).initTabs(nC);
           aux++;
           getPlayers().get(i).setCount(aux);
           
        } 
        //llenando aleatoriamente los tableros de cada jugador
        for(int h=0; h<cJ;h++){
            for(int m=0; m<nC;m++){
                getPlayers().get(h).getTabs().get(m).fillTab();
                getPlayers().get(h).getTabs().get(m).setCount(m+1);
            }
        }
        System.out.println("Empezando la partida....");
        while(!flag){
            nx = nums.get(rnd);
            getAuxN().push(nx); 
            rnd++;
        for(int h=0; h<cJ;h++){    
        for(int m=0; m<nC;m++){
            System.out.println((char)27 + "[31;43m" + "Columna "+ getNCol(nx) + " - "+ "El numero: " + nx);
            System.out.println((char)27 + "[34;42m" + "Jugador N°" +  getPlayers().get(h).getCount());
            //end.append("<h1>Columna ").append(getNCol(nx)).append("El numero: ").append(nx).append(end).append("</h1>");
            //end.append("<h2>Jugador N° ").append(getPlayers().get(h).getCount()).append("</h2>");
            for(int e=0; e<25;e++){
            if(getPlayers().get(h).getTabs().get(m).getTab().get(e).getNumber() == nx){
                addXP(getPlayers().get(h).getTabs().get(m),e);
               
                }
            }
                System.out.println(getPlayers().get(h).getTabs().get(m).printTab());
                System.out.println("\n");
                end.append(getPlayers().get(h).getTabs().get(m).reporteTabs());
        }
            if(GAMEMODE(tGame,getPlayers().get(h))){
               setRonda(rnd);
               System.out.println("Hay ganador");
               System.out.println("Ronda: " + getRonda());
               System.out.println("El jugador gandor es el N° " + getWhoWing());
               System.out.println("Carton N° " + getCartWing());
               System.out.println("Modo de juego ganado: " + getModeWing());
               System.out.println("Pila con numeros utilizados: ");
               System.out.println(getAuxN().toString() + "\n");
               buildHTML((StringBuilder)reporteFinal(getPlayers(),tGame,cJ,nC,nx,end)); 
               
               flag = true;
               break;
            }
        }
        
        }
    }   
}
