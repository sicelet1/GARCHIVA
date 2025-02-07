package vlakna;

public class VypisDoMinus10 extends Thread {

    public void run()  {

        for (int c = 1 ; c <= 10; c++) {

            System.out.println(c);

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println("Chyba");
            }
        }
    }
}
