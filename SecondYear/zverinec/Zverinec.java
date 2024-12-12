package zverinec;

public class Zverinec {

    public static void main(String[] args) {

        Zvire[] zvirata = new Zvire[4];
        zvirata[0] = new Pes();
        zvirata[1] = new Kocka();
        zvirata[2] = new Vrana();
        zvirata[3] = new Had();

        for (int c = 0; c < 4; c++)
            System.out.println("\n" + zvirata[c].info());
    }
}
