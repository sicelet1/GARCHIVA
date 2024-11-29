package mergeSort2;

import java.util.*;

public class Main {

	public static int mergeCallCounter = 0;
	public static int mainComparisonCounter = 0;

	public static ArrayList<Clovek> merge(final ArrayList<Clovek> leftHalf, final ArrayList<Clovek> rightHalf) {

		mergeCallCounter++;

		ArrayList<Clovek> result = new ArrayList<>(0);

		while (!leftHalf.isEmpty() && !rightHalf.isEmpty()) {
			mainComparisonCounter++;

			if (leftHalf.getFirst().compareTo(rightHalf.getFirst()) <= 0) {

				result.add(leftHalf.getFirst());
				leftHalf.removeFirst();
			}
			else {

				result.add(rightHalf.getFirst());
				rightHalf.removeFirst();
			}
		}

		while (!leftHalf.isEmpty()) {

			result.add(leftHalf.getFirst());
			leftHalf.removeFirst();
		}

		while (!rightHalf.isEmpty()) {

			result.add(rightHalf.getFirst());
			rightHalf.removeFirst();
		}

		return result;
	}

	public static ArrayList<Clovek> mergeSort(final ArrayList<Clovek> values) {

		if (values.size() <= 1) return values;

		ArrayList<Clovek> leftHalf = new ArrayList<>(0);
		ArrayList<Clovek> rightHalf = new ArrayList<>(0);

		for (int c = 0; c < values.size(); c++) {

			if (c < values.size() / 2) leftHalf.add(values.get(c));
			else rightHalf.add(values.get(c));
		}

		mergeSort(leftHalf);
		mergeSort(rightHalf);

		values.clear();
		values.addAll(merge(leftHalf, rightHalf));

		return values;
	}

	public static void main(String[] args) {

		ArrayList<Clovek> lidi = new ArrayList<>(0);

		lidi.add(new Clovek("a", "A"));
		lidi.add(new Clovek("e", "E"));
		lidi.add(new Clovek("f", "F"));
		lidi.add(new Clovek("b", "B"));
		lidi.add(new Clovek("x", "X"));
		lidi.add(new Clovek("c", "C"));
		lidi.add(new Clovek("h", "H"));
		lidi.add(new Clovek("r", "R"));
		lidi.add(new Clovek("z", "Z"));
		lidi.add(new Clovek("t", "T"));

		System.out.println("\nUnsorted:");

		for (Clovek osoba : lidi)
			System.out.println(osoba.toString());
		
		mergeSort(lidi);

		System.out.println("\nSorted:");

		for (Clovek osoba : lidi)
			System.out.println(osoba.toString());

		System.out.println("\nLength of sorted array: " + lidi.size());
		System.out.println("Merge call count: " + mergeCallCounter);
		System.out.println("Main comparisons count: " + mainComparisonCounter);
	}
}
