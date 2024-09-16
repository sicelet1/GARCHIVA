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
public class CtverecZObdelniku extends Obdelnik {

    public CtverecZObdelniku(double a, double x, double y) {
        super(a, a, x, y);
    }
    
    
    public static void main(String[] args) {
        CtverecZObdelniku ctverecZObdelniku = new CtverecZObdelniku(30, 0, 0);
        System.out.println(ctverecZObdelniku.obsah());
        System.out.println(ctverecZObdelniku.obvod());
    }
}