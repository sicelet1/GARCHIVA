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
public class Tvar {
    
    private double x, y;

    public Tvar(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double obsah() {
        return 0;
    }
    
    public double obvod() {
        return 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void posunO(double oX, double oY) {
        this.x += oX;
        this.y += oY;
    }
}
