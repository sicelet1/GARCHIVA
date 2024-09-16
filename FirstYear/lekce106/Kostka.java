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
public class Kostka {
    
    int hod;
    public Matrix kos = Matrix.createMatrix(3, 3);
    
    public Kostka() {
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
            case 1:
                kos.setOn(1, 1);
                break;
            case 2: 
                kos.setOn(0, 0);
                kos.setOn(2, 2);
                break;
            case 3:
                kos.setOn(0, 0);
                kos.setOn(1, 1);
                kos.setOn(2, 2);
                break;
            case 4:
                kos.setOn(0, 0);
                kos.setOn(0, 2);
                kos.setOn(2, 0);
                kos.setOn(2, 2);
                break;
            case 5:
                kos.setOn(0, 0);
                kos.setOn(0, 2);
                kos.setOn(1, 1);
                kos.setOn(2, 0);
                kos.setOn(2, 2);
                break;
            case 6:
                kos.setOn(0, 0);
                kos.setOn(0, 1);
                kos.setOn(0, 2);
                kos.setOn(2, 0);
                kos.setOn(2, 1);
                kos.setOn(2, 2);
                break;
        }
    }
    
    public static void main(String[] args) {
        Kostka Kostka = new Kostka();
        while (true) {
            for (int h = 1; h <= 6; h++) {
            Kostka.setHod(h);
            Kostka.vypniVsechna();
            Utils.sleep(500);
            Kostka.zobrazenaHodnota(Kostka.getHod());
            Utils.sleep(500);
            }
        }
    }
}