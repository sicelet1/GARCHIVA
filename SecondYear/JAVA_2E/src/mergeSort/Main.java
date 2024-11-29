package mergeSort;

import java.util.ArrayList;

public class Main {

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

	public static void printArray(final String arrayName, final ArrayList<Long> array, final boolean vertical) {

		System.out.print(arrayName + " =" + (vertical ? "\n{\n" : " { "));

		for (int c = 0; c < array.size() - 1; c++)
			System.out.print(array.get(c) + "," + (vertical ? "\n" : " "));

		System.out.print(array.getLast() + (vertical ? "\n}\n\n" : " }\n"));
	}

	public static void main(String[] args) {

		ArrayList<Long> numbers = new ArrayList<>(0);
		numbers.add((long)7);
		numbers.add((long)89);
		numbers.add((long)1);
		numbers.add((long)85);
		numbers.add((long)63);
		numbers.add((long)47);
		numbers.add((long)12);
		numbers.add((long)404);
		numbers.add((long)4);
		numbers.add((long)34);
		numbers.add((long)7);
		numbers.add((long)7);
		numbers.add((long)30);

		printArray("Input ", numbers, false);
		mergeSort(numbers);
		printArray("Sorted", numbers, false);
	}
}
