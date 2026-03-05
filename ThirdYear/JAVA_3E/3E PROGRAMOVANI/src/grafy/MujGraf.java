package grafy;

import java.util.ArrayList;
import java.util.List;

public class MujGraf {

    static List<String> vrcholy;
    static List<Hrana> hrany;

    public MujGraf() {

        vrcholy = new ArrayList<>();
        hrany = new ArrayList<>();
    }

    public static void vytvorDomecek(MujGraf g) {

        /*
        g.vrcholy.add("A");
        g.vrcholy.add("B");
        g.vrcholy.add("C");
        g.vrcholy.add("D");
        g.vrcholy.add("E");
        g.hrany.add(new Hrana("A", "B"));
        g.hrany.add(new Hrana("A", "C"));
        g.hrany.add(new Hrana("A", "D"));
        g.hrany.add(new Hrana("B", "C"));
        g.hrany.add(new Hrana("B", "D"));
        g.hrany.add(new Hrana("C", "D"));
        g.hrany.add(new Hrana("C", "E"));
        g.hrany.add(new Hrana("D", "E"));
        */
    }

    public static void main(String[] args) {

        MujGraf g = new MujGraf();
        vytvorDomecek(g);

        System.out.println("Seznam hran:");

        for (Hrana h : g.hrany)
            System.out.println(h.vrcholA + " - " + h.vrcholB);

        int pocetHranBodu = 0;

        for (Hrana h : g.hrany)
            if (h.vrcholA.equals("A") || h.vrcholB.equals("A"))
                pocetHranBodu++;

        System.out.println("pocet hran bodu A:" + pocetHranBodu);
    }
}
