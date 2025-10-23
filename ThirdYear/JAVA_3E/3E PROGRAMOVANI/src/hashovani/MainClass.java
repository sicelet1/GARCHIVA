package hashovani;

import java.util.Scanner;

public class MainClass {

    public static int hash(final String vstup) {

        int hodnotaZnaku = 0;

        for (int c = 0; c < vstup.length(); c++) {
            hodnotaZnaku += vstup.charAt(c);
            hodnotaZnaku = (hodnotaZnaku * hodnotaZnaku + 3) % 1013;
        }

        return hodnotaZnaku;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String vstup = sc.nextLine();

        System.out.println(hash(vstup));

    }


}
