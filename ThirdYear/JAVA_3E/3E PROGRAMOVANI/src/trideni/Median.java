package trideni;

import java.io.*;
import java.util.*;

public class Median {

    public static ArrayList<Long> InsertionSortNumbers(final ArrayList<Long> Values)
    {
        if (Values.size() == 0 || Values.size() == 1) return Values;

        for (int SortingPos = 0; SortingPos < Values.size(); SortingPos++)
            for (int c = SortingPos; c > 0; c--) {

                if (Values.get(c) < Values.get(c - 1)) {

                    long Buf = Values.get(c);
                    Values.set(c, Values.get(c - 1));
                    Values.set(c - 1, Buf);
                }
                else break;
            }

        return Values;
    }

    public static ArrayList<Long> mergeSort(final ArrayList<Long> values) {

        if (values.size() <= 1) return values;

        ArrayList<Long> leftHalf = new ArrayList<>(0);
        ArrayList<Long> rightHalf = new ArrayList<>(0);

        for (int c = 0; c < values.size(); c++) {

            if (c < values.size() / 2) leftHalf.add(values.get(c));
            else rightHalf.add(values.get(c));
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        values.clear();

        while (!leftHalf.isEmpty() && !rightHalf.isEmpty()) {

            if (leftHalf.getFirst() <= rightHalf.getFirst()) {

                values.add(leftHalf.getFirst());
                leftHalf.removeFirst();
            }
            else {

                values.add(rightHalf.getFirst());
                rightHalf.removeFirst();
            }
        }

        while (!leftHalf.isEmpty()) {

            values.add(leftHalf.getFirst());
            leftHalf.removeFirst();
        }

        while (!rightHalf.isEmpty()) {

            values.add(rightHalf.getFirst());
            rightHalf.removeFirst();
        }

        return values;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Z:\\JAVA_3E\\3E PROGRAMOVANI\\src\\trideni\\vstup.txt");
        Scanner input = new Scanner(file);
        ArrayList<Long> vstupy = new ArrayList<>();

        while (input.hasNext())
            vstupy.add(Long.parseLong(input.nextLine()));

        //vstupy.sort((a, b) -> a - b);
        //vstupy.sort(null);
        vstupy = InsertionSortNumbers(vstupy);

        System.out.println(vstupy.get(vstupy.size() - 1) / 2);
    }
}
