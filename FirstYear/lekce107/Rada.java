/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce107;

/**
 *
 * @author jakub.wimmer.s
 */
public class Rada {
    private double[] rada;
    int prvek;
    static int soucet2; 
    
    public static void main(String[] args) {
        Rada rada = new Rada(5);
        //rada.nastav(0, 1253.5);
        //rada.nastav(1, -555.555);
        //rada.nastav(2, 999);
        rada.zobraz();
        System.out.println("Soucet:" + rada.soucet());
        System.out.println("Soucin:" + rada.soucin());
    }
    
    public Rada(int velikost) {
        rada = new double[velikost];
        for (int c = 0; c < rada.length; c++) {
        rada[c] = Math.random();
        }
    }
    
    public void nastav(int prvek, double hodnota) {
        rada[prvek] = hodnota;
    }
    
    public double hodnota(int prvek) {
        return rada[prvek];
    }
    
    public void zobraz() {
        for (int c = 0; c < rada.length; c++) {
        System.out.println(rada[c]);
        }
    }
        
    public double soucet() {
        double soucet = 0;
        for (int c = 0; c < rada.length; c++) {
        soucet += rada[prvek];
        }
        return soucet;
    }
   
    public double soucin() {
        double soucin = 1;
        for (int c = 0; c < rada.length; c++) {
        soucin *= rada[prvek];
        }
        return soucin;
    }
    


}
/*
        int c = 0;
        while (prvek < rada.length) {
        System.out.println(rada[c]);
        prvek++;
        }
*/