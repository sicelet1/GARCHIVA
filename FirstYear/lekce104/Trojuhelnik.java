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
public class Trojuhelnik {
    double a;
    double b;
    double c;
    
    public Trojuhelnik(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = Math.sqrt(a * a + b * b);
    }
    
    double obvod() {
        return a + b + c;
    }
    
    double obsah() {
        return (a * b) / 2;
    }
    
    public static void main(String[] args) {
        Trojuhelnik trojuhelnik = new Trojuhelnik(3, 4);
        System.out.println(trojuhelnik.obvod());
        System.out.println(trojuhelnik.obsah());
    }
}