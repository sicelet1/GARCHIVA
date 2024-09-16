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
class PrivatniTrida {
    
    int y;
    
    private static class VnitrniTrida {
        
        int x;
    }
    
    public static void main(String[] args) {
        PrivatniTrida pt = new PrivatniTrida();
        System.out.println(pt.y);
        VnitrniTrida vt = new VnitrniTrida();
        System.out.println(vt.x);
    }
}
