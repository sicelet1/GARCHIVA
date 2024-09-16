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
 * @author jakub.wimmer.s
 */
public class Panel {
    public static void main(String[] args) {
        Matrix panel = Matrix.createMatrix(5, 5);
        panel.showWindow();
//        panel.setOn(panel.getWidth() - 1, panel.getHeight() - 1);
        for (int sloupec = 0; sloupec < panel.getWidth(); sloupec++) {
            for (int radek = 0; radek < panel.getWidth(); radek++) {
                if (sloupec%2 == radek%2) {
                    panel.setOn(sloupec, radek);
                }
                Utils.sleep(100);
            }
        }
    }
}