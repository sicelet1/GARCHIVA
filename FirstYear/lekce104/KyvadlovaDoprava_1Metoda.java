/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce104;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Semaphore;

/**
 *
 * @author jakub.wimmer.s
 */
public class KyvadlovaDoprava_1Metoda {
    private Semaphore levy = Semaphore.createSemaphoreUpsideRight();
    private Semaphore pravy = Semaphore.createSemaphoreUpsideLeft();

    public KyvadlovaDoprava_1Metoda() {
        levy.setTitle("levý semafor");
        pravy.setTitle("pravý semafor");
        levy.setRedOn();
        pravy.setGreenOn();
        levy.showWindow();
        pravy.showWindow();
    }
    
    public void nastavPrujezd() {
        Utils.sleep(5000);
        pravy.setGreenOff();
        pravy.setYellowOn();
        Utils.sleep(1000);
        pravy.setYellowOff();
        pravy.setRedOn();
        Utils.sleep(2000);
        levy.setYellowOn();
        Utils.sleep(1000);
        levy.setRedOff();
        levy.setYellowOff();
        levy.setGreenOn();
        Utils.sleep(5000);
        levy.setGreenOff();
        levy.setYellowOn();
        Utils.sleep(1000);
        levy.setYellowOff();
        levy.setRedOn();
        Utils.sleep(2000);
        pravy.setYellowOn();
        Utils.sleep(1000);
        pravy.setRedOff();
        pravy.setYellowOff();
        pravy.setGreenOn();
    }
    
    public static void main(String[] args) {
        KyvadlovaDoprava_1Metoda kd = new KyvadlovaDoprava_1Metoda();
        while(true) {
        kd.nastavPrujezd();
        }
    }
}