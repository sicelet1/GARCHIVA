/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce104;

/**
 *
 * @author jakub.wimmer.s
 */
public class PrimitivniTypy {
    int x;
    public static void main(String[] args) {
        int i1 = 5;
//        Integer i2 = new Integer(10);
        Integer i2 = 10;
//        System.out.println(i1 + i2.intValue());
        System.out.println(i1 + i2);
//        Boolean b = new Boolean(true);
//        Boolean b = true;
        Boolean b = Boolean.TRUE;
        PrimitivniTypy pt = new PrimitivniTypy();
        pt.x = 5;
    }
}
