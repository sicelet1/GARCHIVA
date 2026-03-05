/*
package grafy;

import lombok.Data;
import org.checkerframework.checker.units.qual.N;

import java.io.File;
import java.util.*;

@Data
public class NovyGraf {

    ArrayList<NovyVrchol> vrcholy = new ArrayList<>();
    ArrayList<NovaHrana> hrany = new ArrayList<>();

    public NovyGraf(String jmenoSouboru) {

        HashMap<Integer, NovyVrchol> mapaIdVrchol = new HashMap<>();

        try (Scanner sc = new Scanner(new File(jmenoSouboru))) {

            while (sc.hasNext()) {
                switch (sc.next()) {

                    case "v":
                        mapaIdVrchol.put(sc.nextInt(), new NovyVrchol(sc.next()));

                        break;

                    case "e":
                        this.hrany.add(new NovaHrana(mapaIdVrchol.get(sc.nextInt()), mapaIdVrchol.get(sc.nextInt())));

                        break;

                    default:
                        throw new NoSuchElementException();
                }
            }

            this.vrcholy.addAll(mapaIdVrchol.values());

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public ArrayList<NovyVrchol> seznamVsechSousedu(NovyVrchol vrchol) {

        //...
    }

    public void projdiDoHloubky(NovyVrchol zacatek) {

        ArrayDeque zasobnik = new ArrayDeque();
        HashSet<NovyVrchol> navstiveneVrcholy = new HashSet<>();

        zasobnik.add(zacatek);
        navstiveneVrcholy.add(zacatek);
/*
        while (!zasobnik.isEmpty()) {

            NovyVrchol vrchol = zasobnik.poll();
            System.out.println(vrchol);

            for (NovyVrchol soused : seznamVsechSousedu(vrchol)) {
                if (!navstiveneVrcholy.contains(soused)) {
                    zasobnik.add(soused);
                    navstiveneVrcholy.add(soused);
                }
            }
        }
    }

    public static void main(String[] args) {

        NovyGraf g = new NovyGraf("elSit.txt");

        System.out.println(g);
    }
}
*/
