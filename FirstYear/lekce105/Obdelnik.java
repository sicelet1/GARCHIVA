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
public class Obdelnik extends Tvar {
    private double a;
    private double b;

//    public Obdelnik(double a, double b) {
//        this.a = a;
//        this.b = b;
//    }

    public Obdelnik(double a, double b, double x, double y) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    @Override
    public double obvod() {
        return 2 * (a + b);
    }

    @Override
    public double obsah() {
        return a * b;
    }
}