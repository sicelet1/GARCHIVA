package Lidi;

public class Duchodce extends Clovek implements Zamestnanec, DostavaDavky {

    public Integer letVDuchodu;

    public Duchodce() {

        this.jmeno = null;
        this.letVDuchodu = null;
    }

    public Duchodce(final String jmeno, final int letVDuchodu) {

        this.jmeno = jmeno;
        this.letVDuchodu = letVDuchodu;
    }

    @Override
    public int vyskaPlatu() {

        return 10000;
    }

    @Override
    public int vyseDavky() {

        return 1000 + letVDuchodu;
    }

    @Override
    public int dejVyskuPlatu() {

        return vyskaPlatu();
    }

    @Override
    public int dejVysiDavky() {

        return vyseDavky();
    }
}
