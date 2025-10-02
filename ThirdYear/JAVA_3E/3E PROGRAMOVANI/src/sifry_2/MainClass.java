package sifry_2;

import java.math.BigInteger;

public class MainClass {

    public static BigInteger factorial(BigInteger vstup) {

        BigInteger vysledek = BigInteger.ONE;

        for (; !vstup.equals(BigInteger.ZERO); vstup = vstup.subtract(BigInteger.ONE))
            vysledek = vysledek.multiply(vstup);

        return vysledek;
    }

    public static void main(String[] args) {

        BigInteger vstup = new BigInteger("26");

        System.out.println("Pocet znaku v AJ: " + (Math.abs((int)'a' - (int)'z') + 1));
        System.out.println("Pocet moznosti: " + factorial(vstup));
    }
}
