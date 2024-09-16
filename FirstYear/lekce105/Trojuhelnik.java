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
public class Trojuhelnik extends Tvar {
    private double a, b, c;
    
    public Trojuhelnik(double a, double b, double x, double y) {
        super(x, y);
        this.a = a;
        this.b = b;
        spocitejC();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double obsah() {
        return a * b / 2;
    }
    
    public void setA(double a) {
        this.a = a;
        spocitejC();
    }

    public void setB(double b) {
        this.b = b;
        spocitejC();
    }
    
    
    private void spocitejC() {
        this.c = Math.sqrt(a * a + b * b);
    }
}