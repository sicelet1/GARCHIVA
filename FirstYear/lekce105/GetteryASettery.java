/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce105;

/**
 *
 * @author jakub.wimmer.s
 */
public class GetteryASettery {
    public static void main(String[] args) {
        GetteryASettery gas = new GetteryASettery();
        gas.x = 5;
        gas.setX(5);
        
    }
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    } 
}