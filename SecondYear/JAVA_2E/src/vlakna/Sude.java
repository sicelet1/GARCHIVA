package vlakna;

public class Sude implements Runnable {

    public void run() {

        for (int c = 0; c <= 100; c += 2)
            System.out.println(c);
    }
}
