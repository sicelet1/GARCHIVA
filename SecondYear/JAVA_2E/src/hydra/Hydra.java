package hydra;

public class Hydra extends Thread {

    private final int jmeno;

    public Hydra(final int jmeno) {

        this.jmeno = jmeno;
    }

    public void run() {

        System.out.println(jmeno);

        if (jmeno + 1 > 8)
            return;

        Hydra dalsiHlava = new Hydra(jmeno + 1);
        Hydra jesteDalsiHlava = new Hydra(jmeno + 1);

        dalsiHlava.start();
        jesteDalsiHlava.start();
    }
}