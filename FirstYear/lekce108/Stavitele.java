/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce108;

/**
 *
 * @author jakub.wimmer.s
 */
public class Stavitele {
    public static void main(String[] args) {
        //NEPOUZIVAT buffer, ale builder, je rychlejsi
        StringBuffer buf = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append("World");
        System.out.println(sb.toString());
       
        StringBuilder mail = new StringBuilder();
        boolean zena = true;
        double cena = 123.45;
        if(zena)
        {
            mail.append("Vazena pani");
        }
        else
        {
            mail.append("Vazeny pane");
        }
        mail.append(", na zaklade vasi objednavky vam zasilame ");
        mail.append("fakturu za ");
        mail.append(cena);
        mail.append(" kc.");
       
        System.out.println(mail.toString());
        System.out.println(serieCisel(3, 7));
    }
       
    public static String serieCisel(int odKolika, int doKolika) {
        StringBuffer sb = new StringBuffer();
       
        for(int c = odKolika; c <= doKolika; c++)
        {
        sb.append(c);
        sb.append(',');
        }
        sb.delete(sb.length() - 1, sb.length());
       
        //sb.append(doKolika);
       
           
        return sb.toString();
    }
   
}