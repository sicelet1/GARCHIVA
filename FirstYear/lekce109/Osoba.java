/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce109;

/**
 *
 * @author jakub.wimmer.s
 */
public class Osoba {
       
    public static final Osoba IRON_MAN = new Osoba();
    
    //{
    //IRON_MAN.setJmeno("Tony Stark");
    //IRON_MAN.setJmeno("Iron Man");
    //}
    
    private static Osoba vyrobIronMana()
    {
        Osoba im = new Osoba();
        im.setJmeno("Tony Stark");
        im.setPrezdivka("Iron Man");
        return im;
    }
    
    private String jmeno;
    private String prezdivka;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrezdivka() {
        return prezdivka;
    }

    public void setPrezdivka(String prezdivka) {
        this.prezdivka = prezdivka;
    }
    
    public static void main(String[] args)
    {
        vyrobIronMana();
    }
    
    
    
}
