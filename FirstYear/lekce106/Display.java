/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce106;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.LightColor;
import cz.gyarab.util.light.Matrix;

/**
 *
 * @author setupacc
 */
public class Display {
    
    int hod;
    public Matrix dis = Matrix.createMatrix(3, 5);
    
    public Display() {
        dis.showWindow();
    }
    
    public int getHod() {
        return hod;
    }
    
    public void setHod(int hod) {
        this.hod = hod;
    }
    
    public void vypniVsechna() {
        for (int sloupec = 0; sloupec < dis.getWidth(); sloupec++) {
            for (int radek = 0; radek < dis.getHeight(); radek++) {
                dis.setBackground(sloupec, radek, LightColor.BLACK);
            }
        }
    }
    
    public void zapniLevySloupec() {
        for (int l = 0; l <= 4; l++) {
            dis.setBackground(0, l, LightColor.RED);
        }
    }
    
    public void zapniPravySloupec() {
        for (int p = 0; p <= 4; p++) {
            dis.setBackground(2, p, LightColor.RED);
        }
    }
    
     public void zapniProstredniSloupecStridave() {
        for (int str = 0; str <= 4; str++) {
            if (str%2 == 0) {
                dis.setBackground(1, str, LightColor.RED);
            }
        }
    }
    
    public void zobrazenaHodnota(int hod) {
        switch(hod) {
            case 0:
                this.zapniLevySloupec();
                dis.setBackground(1, 0, LightColor.RED);
                dis.setBackground(1, 4, LightColor.RED);
                this.zapniPravySloupec();
                break;
            case 1:
                this.zapniPravySloupec();
                break;
            case 2: 
                this.zapniLevySloupec();
                dis.setBackground(0, 3, LightColor.BLACK);
                this.zapniProstredniSloupecStridave();
                this.zapniPravySloupec();
                dis.setBackground(2, 1, LightColor.BLACK);
                break;
            case 3:
                this.zapniLevySloupec();
                dis.setBackground(0, 1, LightColor.BLACK);
                dis.setBackground(0, 3, LightColor.BLACK);
                this.zapniProstredniSloupecStridave();
                this.zapniPravySloupec();
                break;
            case 4:
                this.zapniLevySloupec();
                dis.setBackground(0, 0, LightColor.BLACK);
                dis.setBackground(0, 1, LightColor.BLACK);
                dis.setBackground(1, 2, LightColor.RED);
                this.zapniPravySloupec();
                break;
            case 5:
                this.zapniLevySloupec();
                dis.setBackground(0, 1, LightColor.BLACK);
                this.zapniProstredniSloupecStridave();
                this.zapniPravySloupec();
                dis.setBackground(2, 3, LightColor.BLACK);
                break;
            case 6:
                this.zapniLevySloupec();
                this.zapniProstredniSloupecStridave();
                this.zapniPravySloupec();
                dis.setBackground(2, 3, LightColor.BLACK);
                break;
            case 7:
                dis.setBackground(0, 4, LightColor.RED);
                dis.setBackground(1, 4, LightColor.RED);
                this.zapniPravySloupec();
                break;
            case 8:
                this.zapniLevySloupec();
                this.zapniProstredniSloupecStridave();
                this.zapniPravySloupec();
                break;
            case 9:
                this.zapniLevySloupec();
                dis.setBackground(0, 1, LightColor.BLACK);
                this.zapniProstredniSloupecStridave();
                this.zapniPravySloupec();
                break;
        }
    }
    
    public static void main(String[] args) {
        Display Display = new Display();
        while (true) {
            for (int h = 0; h <= 9; h++) {
            Display.setHod(h);
            Display.vypniVsechna();
            Utils.sleep(500);
            Display.zobrazenaHodnota(Display.getHod());
            Utils.sleep(500);
            }
        }
    }
}