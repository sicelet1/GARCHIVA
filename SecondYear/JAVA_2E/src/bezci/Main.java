package bezci;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Bezec A = new Bezec("A", 6);
        Bezec B = new Bezec("B", 5);
        Bezec C = new Bezec("C", 10);

        A.start();
        B.start();
        C.start();

        A.join();
        B.join();
        C.join();

        System.out.println("ZAVOD SKONCIL");
    }
}
