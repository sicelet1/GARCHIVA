/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce106;

import cz.gyarab.util.light.Matrix;

/**
 *
 * @author jakub.wimmer.s
 */
public class Pole {
    int i = 0;
    private Matrix pole = Matrix.createHorizontal(5);

    public Pole() {
        pole.showWindow();
    }
        
    public void zhasniLicha () {
        for(i = 0; i <= pole.getSize();i++) {
            if (i % 2 == 1) {
            pole.setOn(i);
            }
        }
    }
    
    public void zhasniVsechnaKromeKrajnich () {
        for(i = 0; i <= pole.getSize();i++) {
            if (i > 0 && i < pole.getSize()-1) {
            pole.setOn(i);
            }
        }
    }
    
    public static void main(String[] args) {
        Pole pole = new Pole();
        pole.zhasniLicha();
    }
}