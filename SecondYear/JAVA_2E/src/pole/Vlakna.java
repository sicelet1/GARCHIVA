package pole;

public class Vlakna extends Thread {

    private VelkePole pole;

    public Vlakna(VelkePole pole) {

        this.pole = pole;
    }

    public void run() {

        for (int c = 0; c < pole.delkaPole(); c++)
            pole.prictiJedna(c);
    }
}
