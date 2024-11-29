package selectionSort;

import java.security.*;

public class Main {

	public static void selectionSortProLidi(Clovek[] array) {

		for (int c = 0; c < array.length - 1; c++) {

			int smallestElemIndex = c;

			for (int cc = c + 1; cc < array.length; cc++) {

				if (array[cc].isSmallerThan(array[smallestElemIndex]))
					smallestElemIndex = cc;
			}

			Clovek temp = array[smallestElemIndex];
			array[smallestElemIndex] = array[c];
			array[c] = temp;
		}
	}

	public static void selectionSort(int[] array) {

		for (int c = 0; c < array.length - 1; c++) {

			int smallestElemIndex = c;

			for (int cc = c + 1; cc < array.length; cc++) {

				if (array[cc] < array[smallestElemIndex])
					smallestElemIndex = cc;
			}

			int temp = array[smallestElemIndex];
			array[smallestElemIndex] = array[c];
			array[c] = temp;
		}
	}

	public static int[] selectionSortWithRecursion(int[] array, int offset) {

		if (offset == array.length) return array;

		int smallestElemIndex = offset;

		for (int c = offset + 1; c < array.length; c++) {

			if (array[c] < array[smallestElemIndex])
				smallestElemIndex = c;
		}

		int temp = array[smallestElemIndex];
		array[smallestElemIndex] = array[offset];
		array[offset] = temp;

		return selectionSortWithRecursion(array, offset + 1);
	}

	public static void printArray(final String arrayName, final int[] array) {

		System.out.print(arrayName + " =\n{\n");

		for (int c = 0; c < array.length - 1; c++)
			System.out.print(array[c] + ",\n");

		System.out.print(array[array.length - 1] + "\n}\n\n");
	}

	public static void printArray(final String arrayName, final Clovek[] array) {

		System.out.print(arrayName + " =\n{\n");

		for (int c = 0; c < array.length - 1; c++)
			System.out.print(array[c] + ",\n");

		System.out.print(array[array.length - 1] + "\n}\n");
	}

	public static int[] generateRandom(final int count) {

		SecureRandom generator = new SecureRandom();
		int[] array = new int[count];

		for (int c = 0; c < count; c++) {

			array[c] = generator.nextInt(0, 1000);
		}

		return array;
	}

	public static void main(String[] args) {

		//int[] numbers = generateRandom(1000);
		Clovek[] lidi = { new Clovek("sfhbdfds","hddfh"), new Clovek("kujgh","ikbjhbh"), new Clovek("xsxds","hddesresfh"), new Clovek("zdt","kgsuiku"), new Clovek("iurezt","uzguze") };

		//int[] numbers = { 7, 89, 1, 85, 63, 47, 12, 4, 34, 7, 7, 30 };

		printArray("Input", lidi);
		selectionSortProLidi(lidi);
		printArray("Sorted", lidi);
	}
}
