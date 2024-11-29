package Lidi;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner vstup = new Scanner(System.in);
        Clovek[] lidi = new Clovek[5];

        for (int c = 0; c < 5; c++) {

            String typOsoby = vstup.next();

            switch (typOsoby) {

                case "clovek":
                    lidi[c] = new Clovek(vstup.next());
                    break;

                case "dite":
                    String jmenoDitete = vstup.next();
                    String chodiDoSkoly = vstup.next();

                    if (chodiDoSkoly.equals("ano")) {

                        int skolniRocnik = vstup.nextInt();

                        lidi[c] = new Dite(jmenoDitete, true, skolniRocnik);
                        break;
                    }

                    lidi[c] = new Dite(jmenoDitete, false, 0);
                    break;

                case "dospely":
                    String jmenoDospeleho = vstup.next();
                    String pracuje = vstup.next();

                    lidi[c] = new Dospely(jmenoDospeleho, pracuje.equals("ano"));
                    break;

                case "duchodce":
                    String jmenoDuchodce = vstup.next();
                    int letVDuchodu = vstup.nextInt();

                    lidi[c] = new Duchodce(jmenoDuchodce, letVDuchodu);
                    break;

                default:
                    System.out.println("Tento typ osoby neexistuje");
                    return;
            }
        }

        int celkovyPlat = 0;
        int celkovaVyseDavek = 0;

        for (Clovek osoba : lidi) {

            celkovyPlat += osoba.dejVyskuPlatu();
            celkovaVyseDavek += osoba.dejVysiDavky();
        }

        System.out.println(celkovyPlat + " " + celkovaVyseDavek);
    }
}
