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
public class Ctverec {
    double a;
    
    public Ctverec(double a) {
        this.a = a;
    }
    
    double obvod() {
        return 4 * a;
    }
    
    double obsah() {
        return a * a;
    }
    
    public static void main(String[] args) {
        Ctverec ctverec = new Ctverec(3);
        System.out.println(ctverec.obvod());
        System.out.println(ctverec.obsah());
    }
}