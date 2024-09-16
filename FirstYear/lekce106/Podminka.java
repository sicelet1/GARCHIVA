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
public class Podminka {
    public static void pozorNaBoolenpromennou() {
        boolean b = false;
        if (b) {
            System.out.println("plati");
        }
        if (!b) {
            System.out.println("neplati");
        }
//        if (true == b) {
//          System.out.println("take plati");
//        }
    }
    public static void main(String[] args) {
        int i = 20;
        if (i == 10) {
            System.out.println("i je deset");
        }
        int j = 50;
        if (j > 10) {
            System.out.println("j je vetsi nez 10");
            if (i > 20) {
                System.out.println("j je vetsi nez 20");    
            }
        } else {
            System.out.println("j neni vetsi nez 10");
        }
        pozorNaBoolenpromennou();
    }
}