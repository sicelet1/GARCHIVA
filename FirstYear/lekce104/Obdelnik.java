/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce104;

/**
 *
 * @author setupacc
 */
public class Obdelnik {
    double a;
    double b;
    
    public Obdelnik(double a, double b) {
    this.a = a;
    this.b = b;
    }
    
    double obvod() {
        return 2 * (a + b);
    }
    
    double obsah() {
        return a * b;
    }
    
    public static void main(String[] args) {
        Obdelnik obdelnik = new Obdelnik(2, 4);
        System.out.println(obdelnik.obvod());
        System.out.println(obdelnik.obsah());
    }
}