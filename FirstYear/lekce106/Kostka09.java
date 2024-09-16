/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce106;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;

/**
 *
 * @author setupacc
 */
public class Kostka09 {
    
    int hod;
    public Matrix kos = Matrix.createMatrix(5, 5);
    
    public Kostka09() {
        kos.showWindow();
    }
    
    public int getHod() {
        return hod;
    }
    
    public void setHod(int hod) {
        this.hod = hod;
    }
    
    public void vypniVsechna() {
        for (int sloupec = 0; sloupec < kos.getWidth(); sloupec++) {
            for (int radek = 0; radek < kos.getHeight(); radek++) {
                kos.setOff(sloupec, radek);
            }
        }
    }
    
    public void zobrazenaHodnota(int hod) {
        switch(hod) {
            case 0:
                break;
            case 1:
                kos.setOn(2, 2);
                break;
            case 2: 
                kos.setOn(0, 0);
                kos.setOn(4, 4);
                break;
            case 3:
                kos.setOn(0, 0);
                kos.setOn(2, 2);
                kos.setOn(4, 4);
                break;
            case 4:
                kos.setOn(0, 0);
                kos.setOn(0, 4);
                kos.setOn(4, 0);
                kos.setOn(4, 4);
                break;
            case 5:
                kos.setOn(0, 0);
                kos.setOn(0, 4);
                kos.setOn(2, 2);
                kos.setOn(4, 0);
                kos.setOn(4, 4);
                break;
            case 6:
                kos.setOn(0, 0);
                kos.setOn(0, 2);
                kos.setOn(0, 4);
                kos.setOn(4, 0);
                kos.setOn(4, 2);
                kos.setOn(4, 4);
                break;
            case 7:
                kos.setOn(0, 0);
                kos.setOn(0, 2);
                kos.setOn(0, 4);
                kos.setOn(2, 2);
                kos.setOn(4, 0);
                kos.setOn(4, 2);
                kos.setOn(4, 4);
                break;
            case 8:
                kos.setOn(0, 0);
                kos.setOn(0, 2);
                kos.setOn(0, 4);
                kos.setOn(2, 0);
                kos.setOn(2, 4);
                kos.setOn(4, 0);
                kos.setOn(4, 2);
                kos.setOn(4, 4);
                break;
            case 9:
                kos.setOn(0, 0);
                kos.setOn(0, 2);
                kos.setOn(0, 4);
                kos.setOn(2, 0);
                kos.setOn(2, 2);
                kos.setOn(2, 4);
                kos.setOn(4, 0);
                kos.setOn(4, 2);
                kos.setOn(4, 4);
                break;
        }
    }
    
    public static void main(String[] args) {
        Kostka09 Kostka09 = new Kostka09();
        while (true) {
            for (int h = 0; h <= 9; h++) {
            Kostka09.setHod(h);
            Kostka09.vypniVsechna();
            Utils.sleep(500);
            Kostka09.zobrazenaHodnota(Kostka09.getHod());
            Utils.sleep(500);
            }
        }
    }
}