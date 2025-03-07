import java.util.Random;

public class Test {

    public static int countOfDigits(final int number) {

        return (int)Math.floor(Math.log10(number)) + 1;
    }

    public static void main(String[] args) {

        Random generator = new Random();
        int number = 0, digits = 0;

        while (digits != 1) {

            number = Math.abs(generator.nextInt());
            digits = countOfDigits(number);

            System.out.println("Number = " + number);
            System.out.println("Digit count = " + digits);
        }
    }
}
