package sifry;

import java.util.*;

public class MainClass {

    private static final String abeceda = "aábcčdďeáěfghiíjklmnoópqrřsštťuúůvwxyýzž";

    public static String caesarovaSifra(final String zprava, final int posunuti) {

        String zasifrovanaZprava = "";

        for (int c = 0; c < zprava.length(); c++) {

            int poziceZnaku = abeceda.indexOf(zprava.charAt(c));

            for (int cc = 0; cc < posunuti; cc++) {

                if (poziceZnaku == abeceda.length() - 1) {

                    poziceZnaku = 0;
                    continue;
                }

                poziceZnaku++;
            }

            zasifrovanaZprava += abeceda.charAt(poziceZnaku);
        }

        return zasifrovanaZprava;
    }

    public static String caesarovaSifraOpak(final String zasifrovanaZprava, final int posunuti) {

        String rozsifrovanaZprava = "";

        for (int c = 0; c < zasifrovanaZprava.length(); c++) {

            int poziceZnaku = abeceda.indexOf(zasifrovanaZprava.charAt(c));

            for (int cc = 0; cc < posunuti; cc++) {

                if (poziceZnaku == 0) {

                    poziceZnaku = abeceda.length() - 1;
                    continue;
                }

                poziceZnaku--;
            }

            rozsifrovanaZprava += abeceda.charAt(poziceZnaku);
        }

        return rozsifrovanaZprava;
    }

    public static void main(String[] args) {

        /*
        Scanner sc = new Scanner(System.in);
        int posunuti = 0;

        System.out.println("Zprava: ");
        final String zprava = sc.nextLine();

        try {

            System.out.println("Posunuti: ");
            posunuti = sc.nextInt();

        } catch (NumberFormatException e) {

            System.out.println("chyba cisla");
        }

        final String zasifrovanaZprava = caesarovaSifra(zprava, posunuti);
        System.out.println("\nZasifrovana zprava: " + zasifrovanaZprava);
        final String rozsifrovanaZprava = caesarovaSifraOpak(zasifrovanaZprava, posunuti);
        System.out.println("\nRozsifrovana zprava: " + rozsifrovanaZprava);
         */

        String vstup = "šťřkťdqřzďrn";

        for (int c = 0; c < abeceda.length(); c++) {

            System.out.println("Klíč = " + c + " ; Rozšifrovaná zpráva: " + caesarovaSifraOpak(vstup, c));
        }
    }
}
