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
public class Ctverec extends Tvar {
    private double a;

//    public Ctverec(double a) {
//        this.a = a;
//    }

    public Ctverec(double a, double x, double y) {
        super(x, y);
        this.a = a;
    }

    @Override
    public double obvod() {
        return 4 * a;
    }

    @Override
    public double obsah() {
        return a * a;
    }
    
    public static void main(String[] args) {
        Ctverec ctverec = new Ctverec(10.0, 100, 200);
        System.out.println(ctverec.obvod());
        System.out.println(ctverec.obsah());
        Obdelnik obdelnik = new Obdelnik(5, 6, 1000, 1000);
        System.out.println(obdelnik.obvod());
        System.out.println(obdelnik.obsah());
        Tvar tvar = new Ctverec(20, 150, 350);
        Tvar tvar2 = new Obdelnik(99, 88, 2000, 3000);
    }
}