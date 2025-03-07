package pole;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        VelkePole pole = new VelkePole();

        System.out.println("Soucet: " + pole.secti());

        Vlakna v1 = new Vlakna(pole);
        Vlakna v2 = new Vlakna(pole);
        Vlakna v3 = new Vlakna(pole);

        long start = System.currentTimeMillis();

        v1.start();
        v2.start();
        v3.start();

        v1.join();
        v2.join();
        v3.join();

        long end = System.currentTimeMillis();
        long delka = end - start;

        System.out.println("Bezel " + delka + " ms");
        System.out.println("Soucet: " + pole.secti());
    }
}
