package vlakna;

public class Main {

    public static void main(String[] args) {

        VypisDo10 v1 = new VypisDo10();
        VypisDoMinus10 v2 = new VypisDoMinus10();
        VypisPoPismenech v3 = new VypisPoPismenech("Programovani je nej!");
        VypisPoPismenech v4 = new VypisPoPismenech("Dalsi text k psaní");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
    }
}
