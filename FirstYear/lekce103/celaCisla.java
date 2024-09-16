/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce103;

/**
 *
 * @author setupacc
 */
public class celaCisla {
    public static void main(String[] args) {
        byte bajt = -128;
        short kratky = 32767;
        int normalni = 2_000_000_000;
        long dlouhy = 3_000_000_000L;
        int soucet = 5 + 3;
        int dvojkove = 0b110110110101;
        int osmickove = 06665;
        int hexadecimalni = 0xDB5;
        System.out.println(dvojkove);
        System.out.println(osmickove);
        System.out.println(hexadecimalni);
    }
}