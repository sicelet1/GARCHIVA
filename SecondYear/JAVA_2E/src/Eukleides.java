import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Eukleides {

    public static BigInteger findGCD(BigInteger u, BigInteger w) {

        while (!u.equals(w)) {

            if (u.compareTo(w) > 0) {

                u = u.subtract(w);

            } else {

                w = w.subtract(u);
            }
        }

        return u;
    }

    public static void characterPrint(char character, int count) {

        for (int c = 0; c < count; c++)
            System.out.print(character);
    }

    public static int determineLongestString(String first, String second) {

        if (first.length() >= second.length()) {

            return first.length();

        } else {

            return second.length();
        }
    }

    public static void printEquation(String u, String w, String uGCD, String wGCD) {

        int longestStringFirst = determineLongestString(u, w);
        int longestStringSecond = determineLongestString(uGCD, wGCD);

        System.out.print("\n\n\n" + u);

        characterPrint(' ', longestStringFirst - u.length() + 3);

        System.out.print(uGCD + '\n');

        characterPrint('-', longestStringFirst);

        System.out.print(" = ");

        characterPrint('-', longestStringSecond);

        System.out.print('\n' + w);

        characterPrint(' ', longestStringFirst - w.length() + 3);

        System.out.print(wGCD + '\n');
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BigInteger u = input.nextBigInteger(), w = input.nextBigInteger();
        BigInteger GCD = findGCD(u, w);

        printEquation(u.toString(), w.toString(), u.divide(GCD).toString(), w.divide(GCD).toString());

        //System.out.print((u.divide(GCD)) + " " + (w.divide(GCD)));
    }
}
