/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoG;

/**
 *
 * @author Addiel
 */
public class Numero {
    int number;
    boolean flag;
    String x;
    public Numero() {
        number =-1;
        flag = false;
        x = "";
    }
    
    public Numero(int number, boolean flag ,String x) {
        this.number = number;
        this.flag = flag;
        this.x = x;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
    
}
