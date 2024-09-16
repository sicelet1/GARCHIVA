/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce108;

import java.util.Arrays;

/**
 *
 * @author jakub.wimmer.s
 */
public class Retezec {
    public static void main(String[] args) {
        String s = new String("Hello");
        System.out.println(s);
        if (s == "Hello") {
            System.out.println("je to pozdrav z konstruktoru");
        }
        //   12345
        s = "Hello";
        if (s == "Hello") {
            System.out.println("je to pozdrav");
        }
        if (s.equals("Hello")) {
            System.out.println("je to pozdrav equals");
        }
        
        
        for (int i = 0; i < s.length(); i++)
        {
            System.out.println(s.charAt(i));
        }
        
        System.out.println(s.substring(1, 3));
        System.out.println(s.indexOf("lo"));
        System.out.println(s.endsWith("lol"));
        System.out.println(s.endsWith("llo"));
        System.out.println(s.isEmpty());
        
        s = "Nejlepší jazyk je Java. Java je super.";
        String[] p = s.split(" ");
        System.out.println(Arrays.toString(p));
        System.out.println(s.replace("Java", "Python"));
    }
}