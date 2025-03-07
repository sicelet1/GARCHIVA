package modulo;

import java.util.Scanner;

public class Main {

    public static boolean areDividable(final int numberOne, final int numberTwo) {

        return (numberOne % numberTwo == 0);
    }

    public static int digitSum(int number) {

        int sum = 0;

        while (number != 0) {

            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static boolean isPrimeNumber(final int number) {

        for (int c = 2; c <= number / 2; c++)
            if (number % c == 0) return false;

        return true;
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        int count = 0;
        //int numberOne = userInput.nextInt(), numberTwo = userInput.nextInt();
/*
        System.out.println("Je první dělitelné druhým: " + (areDividable(numberOne, numberTwo) ? "Ano" : "Ne"));
        System.out.println("Ciferný součet prvního čísla: " + digitSum(numberOne));
        System.out.println("Je první prvočíslem: " + (isPrimeNumber(numberOne) ? "Ano" : "Ne"));
*/
        long timeShot1 = System.currentTimeMillis();

        for (int c = 2; c <= 1000000; c++)
            if (isPrimeNumber(c))
                count++;

        long timeShot2 = System.currentTimeMillis();

        System.out.println("Amount of prime numbers between 2 & 100000: " + count);
        System.out.println("\nTime taken: " + (timeShot2 - timeShot1) + "ms = " + (timeShot2 - timeShot1) / 1000 + "s");
    }
}
