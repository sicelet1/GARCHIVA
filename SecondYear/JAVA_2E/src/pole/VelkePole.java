package pole;

public class VelkePole {

    private int[] pole;

    public VelkePole() {

        pole = new int[10_000_000];
    }

    public int delkaPole() {

        return pole.length;
    }

    public synchronized void prictiJedna(int index) {

        pole[index]++;
    }

    int secti() {

        int suma = 0;

        for (int cislo : pole)
            suma += cislo;

        return suma;
    }
}
