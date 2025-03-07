package vlakna2;

public class Main extends Thread {

    public static void main(String[] args) throws InterruptedException {

        for (int c = 1; c <= 10; c++) {

            final int threadParameter = c;

            Thread tr = new Thread(() -> {

                for (int cc = 1; cc <= 100; cc++)
                    System.out.println(threadParameter * cc);
            });

            tr.start();
            tr.join();
        }

        System.out.println("HOTOVO");
    }
}
