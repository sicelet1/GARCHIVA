package vlakna;

public class VypisDo10 extends Thread {

    public void run()  {

        for (int c = -10; c <= -1; c++) {

            System.out.println(c);

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println("Chyba");
            }
        }
    }
}
