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
public class LepsiPravouhlyTrojuhelnik {
    double a;
    double b;
    double c;

    public LepsiPravouhlyTrojuhelnik(double a, double b) {
        this.a = a;
        this.b = b;
        this.c = Math.sqrt(a * a + b * b);
    }
    
    double obvod() {
//        System.out.println("FYI: pocitam obvod");
        return a + b + c;
    }
    
    double obsah() {
        return a * b / 2;
    }
    public static void main(String[] args) {
        LepsiPravouhlyTrojuhelnik lpt1 = new LepsiPravouhlyTrojuhelnik(3, 4);
        System.out.println(lpt1.c);
        System.out.println(lpt1.obvod());
        System.out.println(lpt1.obsah());
        LepsiPravouhlyTrojuhelnik lpt2 = new LepsiPravouhlyTrojuhelnik(30, 40);
        System.out.println(lpt2.c);
    }
}