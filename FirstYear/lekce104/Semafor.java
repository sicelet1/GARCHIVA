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
public class Semafor {
    
    private Semaphore sem;
    
    public Semafor() {
        sem = Semaphore.createSemaphore();
        sem.showWindow();
        sem.setRedOn(); 
    }
    
    public void nastavNaVolno() {
        sem.setYellowOn();
        Utils.sleep(1000);
        sem.setRedOff();
        sem.setYellowOff();
        sem.setGreenOn();
    }
    
    public void nastavNaStuj() {
        sem.setGreenOff();
        sem.setYellowOn();
        Utils.sleep(1000);
        sem.setYellowOff();
        sem.setRedOn();
    }
    
    public static void main(String[] args) {
        Semafor semafor = new Semafor();
        Utils.sleep(2000);
        semafor.nastavNaVolno();
        Utils.sleep(3000);
        semafor.nastavNaStuj();
        
        
        //sem.setYellowOnOff(!sem.isYellowOn());
    }
}