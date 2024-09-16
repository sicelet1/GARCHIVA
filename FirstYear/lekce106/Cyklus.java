/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce106;

/**
 *
 * @author setupacc
 */
public class Cyklus {
    public static void whileCyklus() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
    
    public static void doWhileCyklus() {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }
    
    public static void forCyklus() {
        for (int i =1; i <= 10; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        System.out.println("while");
        whileCyklus();
        System.out.println("do-while");
        doWhileCyklus();
        System.out.println("for");
        forCyklus();
    }
}