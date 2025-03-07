import java.util.ArrayList;

public class Prvocisla {

    public static ArrayList<Long> OptimizedPrimeNumberGenerator(long FromNum, final long ToNum)
    {
        ArrayList<Long> result = new ArrayList<Long>(0);

        if (ToNum < 2 || FromNum > ToNum) return result;

        if (FromNum < 2) FromNum = 2;

        for (long c = FromNum; c <= ToNum; c++)
        {
            if (c == 2 || c == 3) { result.add(c); continue; }

            if (c % 2 == 0 || c % 3 == 0) continue;

            boolean IsNotPrime = false;

            for (long i = 5; i * i <= c; i += 6)
                if (c % i == 0 || c % (i + 2) == 0) { IsNotPrime = true; break; }

            if (!IsNotPrime) result.add(c);
        }

        return result;
    }

    public static void printArray(final ArrayList<Long> numbers) {

        for (long element : numbers)
            System.out.println(element);
    }

    public static void main(String[] args) {

        long timeShot1 = System.currentTimeMillis();

        //printArray(
                OptimizedPrimeNumberGenerator(2, 100000);
        //);

        long timeShot2 = System.currentTimeMillis();

        //System.out.println("Amount of prime numbers between 2 & 100000: " + count);
        System.out.println("\nTime taken: " + (timeShot2 - timeShot1) + "ms");
    }
}
