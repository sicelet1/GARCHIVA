package grafy_2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class NejkratsiCesta {

    private final Map<Vrchol, List<Hrana>> seznamSousedu;
    private final Map<Long, Vrchol> seznamVrcholu;

    public NejkratsiCesta() {

        this.seznamSousedu = new HashMap<>();
        this.seznamVrcholu = new HashMap<>();
    }

    public void nactiVrcholy(final String soubor) throws IOException {

        Scanner sc = new Scanner(Paths.get(soubor));

        while (sc.hasNext()) {

            long id = sc.nextLong();
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Vrchol vrchol = new Vrchol(id, x, y);
            this.seznamSousedu.put(vrchol, new ArrayList<>());
            this.seznamVrcholu.put(id, vrchol);
        }
    }

    public void nactiHrany(final String soubor) throws IOException {

        Scanner sc = new Scanner(Paths.get(soubor));

        while(sc.hasNext()) {

            long id1 = sc.nextLong();
            long id2 = sc.nextLong();
            double delka = sc.nextDouble();
            String jmeno = sc.nextLine();
            Vrchol v1 = seznamVrcholu.get(id1);
            Vrchol v2 = seznamVrcholu.get(id2);
            Hrana hrana = new Hrana(v1, v2, delka, jmeno);
            seznamSousedu.get(v1).add(hrana);
            seznamSousedu.get(v2).add(hrana);
        }
    }

    public static void main(String[] args) throws IOException {

        NejkratsiCesta graf = new NejkratsiCesta();
        graf.nactiVrcholy("praha_uzly.csv");
        graf.nactiHrany("praha_hrany.csv");


    }
}
