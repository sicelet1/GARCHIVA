package grafy_2;

public class Hrana {

    private final Vrchol v1;
    private final Vrchol v2;
    private final double delkaVMetrech;
    private final String jmeno;

    public Hrana(final Vrchol v1, final Vrchol v2, final double delkaVMetrech, final String jmeno) {

        this.v1 = v1;
        this.v2 = v2;
        this.delkaVMetrech = delkaVMetrech;
        this.jmeno = jmeno;
    }
}
