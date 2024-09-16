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
public class KyvadlovaDoprava {
    private Semaphore levy = Semaphore.createSemaphoreUpsideRight();
    private Semaphore pravy = Semaphore.createSemaphoreUpsideLeft();

    public KyvadlovaDoprava() {
        levy.setTitle("levý semafor");
        pravy.setTitle("pravý semafor");
        levy.setRedOn();
        pravy.setGreenOn();
        levy.showWindow();
        pravy.showWindow();
    }
    
    public void nastavPrujezdZleva() {
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
    }
    
    public void nastavPrujezdZprava() {
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
        KyvadlovaDoprava kd = new KyvadlovaDoprava();
        while(true) {
        Utils.sleep(5000);
        kd.nastavPrujezdZleva();
        Utils.sleep(5000);
        kd.nastavPrujezdZprava();
        }
    }
}