import java.util.ArrayList;

public class Sito {

    public static void main(String[] args) {

        boolean[] arr = new boolean[Integer.MAX_VALUE-1000];

        for (int c = 2; c < arr.length; c++) {

            if (arr[c] == false) {

                System.out.println(c);

                for (int cc = c; cc < arr.length && cc > 0; cc += c) {

                    arr[cc] = true;
                }
            }
        }
    }
}
