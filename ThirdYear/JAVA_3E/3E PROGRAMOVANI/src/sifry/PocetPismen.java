package sifry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PocetPismen {

    private static String abeceda = "aábcčdďeěéfghiíjklmnoópqrřsštťuúůvwxyýzž";

    public static int pocetPismena(final String vstup, final char pismeno) {

        int vysledek = 0;

        for (int c = 0; c < vstup.length(); c++)
            if (vstup.charAt(c) == pismeno)
                vysledek++;

        return vysledek;
    }

    public static void main(String[] args) throws IOException {

        String vstup = Files.readString(Paths.get("C:\\Users\\jakub.wimmer.s\\Downloads\\test.txt"));

        int celkovyPocet = 0;

        for (int c = 0; c < abeceda.length(); c++) {

            int pocet = pocetPismena(vstup, abeceda.charAt(c));
            celkovyPocet += pocet;

            System.out.println("Pocet pismena " + abeceda.charAt(c) + ": " + pocet + "x");
        }

        System.out.println("\nCelkem pismen: " + celkovyPocet + "x");


        for (char znak : vstup.toCharArray()) {

            if (znak == 'v')
                System.out.print("E");
            else if (znak == 'z')
                System.out.print("A");
            else if (znak == 'l')
                System.out.print("O");
            else if (znak == 'r')
                System.out.print("I");
            else if (znak == 'o')
                System.out.print("L");
            else if (znak == 'y')
                System.out.print("M");
            else
                System.out.print(znak);
        }
    }
}
