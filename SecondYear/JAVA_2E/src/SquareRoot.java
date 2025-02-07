import java.math.BigInteger;

public class SquareRoot {

    public static long findSquareRoot(final long number) {

        for (long c = 1 ;; c++)
            if (c * c >= number) return c;
    }

    public static BigInteger findSquareRoot(final BigInteger number) {

        for (BigInteger c = BigInteger.ONE ;; c = c.add(BigInteger.ONE))
            if (c.multiply(c).compareTo(number) >= 0) return c;
    }

    public static void main(String[] args) {


        //long x1 = 404;
        long x2 = 9_460_730_472_580_800L;

        //System.out.println(findSquareRoot(x1));
        System.out.println(findSquareRoot(x2));

        //BigInteger bx1 = new BigInteger("404");
        BigInteger bx2 = new BigInteger("9460730472580800000");

        //System.out.println(findSquareRoot(bx1));
        System.out.println(findSquareRoot(bx2));
    }
}
