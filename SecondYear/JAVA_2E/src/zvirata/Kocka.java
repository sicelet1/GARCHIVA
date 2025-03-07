package zvirata;

public class Kocka extends Zvire {

    private int pocetZivotu;

    public Kocka(String jmeno) {

        super(jmeno);
        this.pocetZivotu = 9;
    }

    public String getJmeno() {

        return super.getJmeno();
    }

    public int getPocetZivotu() {

        return pocetZivotu;
    }

    public void setPocetZivotu(int pocetZivotu) {

        if (pocetZivotu == 0) {

            jeZive = false;

        } else if (pocetZivotu > 0) {

            jeZive = true;
        }

        this.pocetZivotu = pocetZivotu;
    }

    @Override
    public String toString() {

        return super.getJmeno() + ":" + pocetZivotu;
    }
}
