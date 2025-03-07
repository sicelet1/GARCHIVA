package vlakna;

public class Liche implements Runnable {

    public void run() {

        for (int c = 1; c <= 100; c += 2)
            System.out.println(c);
    }
}
