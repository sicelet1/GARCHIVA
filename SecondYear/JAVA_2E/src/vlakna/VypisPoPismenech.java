package vlakna;

public class VypisPoPismenech extends Thread {

    private String slovo;

    public VypisPoPismenech(final String slovo) {

        this.slovo = slovo;
    }

    public void run()  {

        for (int c = 0; c < slovo.length(); c++) {

            System.out.println(slovo.charAt(c));

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                System.out.println("Chyba");
            }
        }
    }
}
