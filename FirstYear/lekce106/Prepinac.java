/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce106;

/**
 *
 * @author jakub.wimmer.s
 */
public class Prepinac {
    
    public static void main(String[] args) {
        int m = 2;
//        System.out.println("Mesic cislo " + m + " se jmenuje "+ nazevMesice(m));
//        prepinacBezPreruseni(m);
        prepinacSPrerusenim(m);
    }
    public static String nazevMesice(int cisloMesice) {
        switch (cisloMesice) {
            case 1:
                return "leden";
            case 2:
                return "unor";
            default:
                return "neznamy mesic";
        }
    }


    public static void prepinacBezPreruseni(int n) {
        switch (n) {
            case 1:
                System.out.println("jedna");
            case 2:
                System.out.println("dva");
            default:
                System.out.println("default");
        }
    }

    public static void prepinacSPrerusenim(int n) {
        switch (n) {
            case 1:
                System.out.println("jedna");
                break;
            case 2:
                System.out.println("dva");
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}