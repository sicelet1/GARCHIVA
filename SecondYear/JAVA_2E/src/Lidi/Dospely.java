package Lidi;

public class Dospely extends Clovek implements Zamestnanec {

    public Boolean pracuje;

    public Dospely() {

        this.jmeno = null;
        this.pracuje = null;
    }

    public Dospely(final String jmeno, final boolean pracuje) {

        this.jmeno = jmeno;
        this.pracuje = pracuje;
    }

    @Override
    public int vyskaPlatu() {

        return (pracuje ? 45854 : 0);
    }

    @Override
    public int dejVyskuPlatu() {

        return vyskaPlatu();
    }
}
