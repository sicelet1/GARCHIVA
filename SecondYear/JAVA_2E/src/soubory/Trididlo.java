package soubory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Trididlo {

    public static ArrayList<Long> selectionSort(ArrayList<Long> cisla) {

        for (int c = 0; c < cisla.size() - 1; c++) {

            int nejmensiPrvek = c;

            for (int cc = c + 1; cc < cisla.size(); cc++) {

                if (cisla.get(cc) < cisla.get(nejmensiPrvek))
                    nejmensiPrvek = cc;
            }

            long temp = cisla.get(nejmensiPrvek);
            cisla.set(nejmensiPrvek, cisla.get(c));
            cisla.set(c, temp);
        }

        return cisla;
    }

    public static void main(String[] args) throws IOException {

        File vstup = new File("vstup.txt");
        FileReader ctecka = new FileReader(vstup);

        String cteciZasobnik = new String();
        ArrayList<Long> cisla = new ArrayList<>(0);

        for (int x = ctecka.read(); x != -1; x = ctecka.read()) {

            if ((char) x != '\r' && (char) x != '\n') {

                cteciZasobnik += (char) x;

            } else if ((char) x == '\n') {

                try {

                    cisla.add(Long.parseLong(cteciZasobnik));

                } catch (NumberFormatException e) {

                    System.out.println("OK!!");

                    return;
                }

                cteciZasobnik = "";
            }
        }

        cisla = selectionSort(cisla);

        for (int c = 0; c < cisla.size() / 2; c++) {

            System.out.println(Long.toString(cisla.get(cisla.size() - 1 - c)));
            System.out.println(Long.toString(cisla.get(c)));
        }

        ctecka.close();
    }
}
