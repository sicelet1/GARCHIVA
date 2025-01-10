package zvirata;

public class Had extends Zvire {

    private int delka;

    public Had(String jmeno, int delka) {

        super(jmeno);
        this.delka = delka;
    }

    public String getJmeno() {

        return super.getJmeno();
    }

    public int getDelka() {

        return delka;
    }

    @Override
    public String toString() {

        return super.getJmeno() + ":" + delka;
    }
}
