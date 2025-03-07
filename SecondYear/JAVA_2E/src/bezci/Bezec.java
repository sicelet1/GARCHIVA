package bezci;

public class Bezec extends Thread {

    public String jmeno;
    public long tempo;

    public Bezec(String jmeno, long tempo) {

        this.jmeno = jmeno;
        this.tempo = tempo;
    }

    public void run() {

        long pocetKilometru = 0;

        System.out.println("START");

        while (pocetKilometru < 10) {

            try {

                this.sleep(1000 * tempo);

            } catch (InterruptedException e) {

                System.out.println("chyba");
            }

            pocetKilometru++;

            System.out.println(tempo * pocetKilometru + "s : " + jmeno + " je na " + pocetKilometru + ". kilomertu");
        }
    }
}
