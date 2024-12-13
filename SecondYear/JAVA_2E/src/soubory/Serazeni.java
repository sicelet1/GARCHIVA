package soubory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Serazeni {

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

	public static void main(String[] args) throws IOException {

		File file = new File("A:\\Programy\\JAVA\\PRG_2.E\\test\\src\\soubory\\numbers.txt");
		File fileSorted = new File("A:\\Programy\\JAVA\\PRG_2.E\\test\\src\\soubory\\numbers_sorted.txt");
		FileReader reader = new FileReader(file);
		FileWriter writer = new FileWriter(fileSorted);
		String buffer = new String();
		ArrayList<Long> numbersToSort = new ArrayList<>(0);

		for (int x = reader.read(); x != -1; x = reader.read()) {

			if ((char)x != '\r' && (char)x != '\n') {

				buffer += (char)x;
			}
			else if ((char)x == '\r') {

				numbersToSort.add(Long.parseLong(buffer));
				buffer = "";
			}
		}

		numbersToSort = mergeSort(numbersToSort);

		for (int c = 0; c < numbersToSort.size(); c++) {

			writer.write(Long.toString(numbersToSort.get(c)) + "\r\n");
		}

		reader.close();
		writer.close();
	}
}
