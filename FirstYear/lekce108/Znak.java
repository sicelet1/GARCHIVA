/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce108;

/**
 *
 * @author jakub.wimmer.s
 */
public class Znak {
    public static void main(String[] args) {
        char c = '@';
        System.out.println(c);
        c++;
        System.out.println(c);
        for (char c2 = 'A'; c2 <= 'C'; c2++) {
            System.out.println(c2);
        }
        c = 66;
        System.out.println(c);
        if (c >= 'A' && c <= 'Z') {
            System.out.println("velke pismeno");
            c += 32;
            System.out.println(c);
        }
        
        char[] p = new char[10];
        p[0] = 'H';
        p[1] = 'e';
        System.out.println(p);
        
        p = "Hello".toCharArray();
        System.out.println(p);
    }
}