package Lidi;

public class Dite extends Clovek implements DostavaDavky {

    public Boolean chodiDoSkoly;
    public Integer skolniRocnik;

    public Dite() {

        this.jmeno = null;
        this.chodiDoSkoly = null;
        this.skolniRocnik = null;
    }

    public Dite(final String jmeno, final boolean chodiDoskoly, final int skolniRocnik) {

        this.jmeno = jmeno;
        this.chodiDoSkoly = chodiDoskoly;
        this.skolniRocnik = skolniRocnik;
    }

    public int dejSkolniRocnik() {

        return skolniRocnik;
    }

    @Override
    public int vyseDavky() {

        return (chodiDoSkoly ? dejSkolniRocnik() * 100 : 0);
    }

    @Override
    public int dejVysiDavky() {

        return vyseDavky();
    }
}
