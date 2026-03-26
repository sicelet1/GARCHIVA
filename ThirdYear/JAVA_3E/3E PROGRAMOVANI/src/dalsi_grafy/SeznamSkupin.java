package dalsi_grafy;

import java.util.*;

public class SeznamSkupin {

    List<Set<Vrchol>> skupiny = new ArrayList<>();
    List<Long> celkovaHodnota = new ArrayList<>();

    public static void udelejSkupiny(MujGraf graf, SeznamSkupin seznamSkupin, List<Vrchol> nezarazeneVrcholy, int indexVrcholu, int indexSkupiny) {

        Vrchol start = nezarazeneVrcholy.get(indexVrcholu);

        seznamSkupin.skupiny.get(indexSkupiny).add(start);
        seznamSkupin.celkovaHodnota.set(indexSkupiny, seznamSkupin.celkovaHodnota.get(indexSkupiny) + start.getHodnota());

        nezarazeneVrcholy.remove(indexVrcholu);
        List<Vrchol> sousedi = graf.sousedi(start);

        for (Vrchol v : sousedi)
            for (int c = 0; c < nezarazeneVrcholy.size(); c++)
                if (v.equals(nezarazeneVrcholy.get(c)))
                    udelejSkupiny(graf, seznamSkupin, nezarazeneVrcholy, c, indexSkupiny);
    }

    public static void main(String[] args) {

        MujGraf graf = new MujGraf();
        SeznamSkupin seznamSkupin = new SeznamSkupin();
        List<Vrchol> nezarazeneVrcholy = new ArrayList<>(graf.getVrcholy());

        for (int c = 0; !nezarazeneVrcholy.isEmpty(); c++) {

            seznamSkupin.skupiny.add(new HashSet<>());
            seznamSkupin.celkovaHodnota.add(0L);

            udelejSkupiny(graf, seznamSkupin, nezarazeneVrcholy, 0, c);
        }

        for (int c = 0; c <seznamSkupin.skupiny.size(); c++) {

            for (Vrchol v : seznamSkupin.skupiny.get(c))
                System.out.print(v.getName() + " ");

            System.out.print(seznamSkupin.celkovaHodnota.get(c) + "\n");
        }
    }
}
