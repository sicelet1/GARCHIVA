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
public class PokusnaTrida {
    public static void main(String[] args) {
        Trojuhelnik t = new Trojuhelnik(3, 4, 0, 0);
        System.out.println(t.getA());
        System.out.println(t.getB());
        System.out.println(t.getC());
    }
}