/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce109;

/**
 *
 * @author jakub.wimmer.s
 */
public class DenVTydnu {
    public static final int PO = 1;
    public static final int UT = 2;
    //...
    public static final int NE = 7;
    public static final int[] TYDEN = {PO, UT, NE};
    public static void main(String[] args) {
        String dnes = ""; //...
        if(dnes.equals("streda")) {
            //...
        }
        int den = PO;
        if(den == UT) {
            //...
        }
        
        for (int d : TYDEN)
            switch (d) {
                case PO:
                    System.out.println("je pondeli");
                    break;
                case UT:
                    System.out.println("je utery");
                    break;
                default:
                    System.out.println("je nedele");
                
            }
    }
}
