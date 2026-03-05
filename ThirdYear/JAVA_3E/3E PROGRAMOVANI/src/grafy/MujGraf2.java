package grafy;

import java.util.*;

public class MujGraf2 {

    ArrayList<Vrchol> vrcholy = new ArrayList<>();
    ArrayList<Hrana> hrany = new ArrayList<>();

    public void vyrobKrabici() {

        for (int c = 0; c < 8; c++)
            vrcholy.add(new Vrchol());

        //...
    }

    public ArrayList<Vrchol> seznamSousedu(Vrchol zacatek) {

        ArrayList<Vrchol> vysledek = new ArrayList<>();

        for (Hrana hrana : hrany)
            if (hrana.vrcholA == zacatek)
                vysledek.add(hrana.vrcholB);

            else if (hrana.vrcholB == zacatek)
                vysledek.add(hrana.vrcholA);

        return vysledek;
    }

    public void projdiGraf(Vrchol zacatek) {

        System.out.println(zacatek);
        zacatek.bylJsemTu = true;

        ArrayList<Vrchol> mojiSousede = seznamSousedu(zacatek);

        for (Vrchol v : mojiSousede)
            if (!v.bylJsemTu)
                projdiGraf(v);
    }

    public static void main(String[] args) {


    }
}
