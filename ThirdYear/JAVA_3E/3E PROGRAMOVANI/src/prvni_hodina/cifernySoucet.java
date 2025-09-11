package prvni_hodina;

import java.util.Scanner;

public class cifernySoucet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int vstup, vysledek = 0;

        try {

            vstup = sc.nextInt();

        } catch (NumberFormatException e) {

            return;
        }

        for (; vstup > 0; vstup /= 10)
            vysledek += vstup % 10;

        System.out.println(vysledek);
    }
}
