package dalsi_grafy;

import lombok.Data;
import java.util.*;

@Data
public class MujGraf {

    private final List<Vrchol> vrcholy = Arrays.asList(
            new Vrchol("A", 1),
            new Vrchol("B", 2),
            new Vrchol("C", 3),
            new Vrchol("D", 4));

    private final List<Hrana> hrany = Arrays.asList(
            new Hrana(vrcholy.get(0), vrcholy.get(1)),
            new Hrana(vrcholy.get(1), vrcholy.get(2)));

    public List<Vrchol> sousedi(Vrchol v) {

        return hrany.stream().map(x -> x.soused(v)).filter(Objects::nonNull).toList();
    }

}