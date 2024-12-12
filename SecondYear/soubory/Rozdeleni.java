package soubory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Rozdeleni {

	public static void main(String[] args) throws IOException {

		File file = new File("A:\\Programy\\JAVA\\PRG_2.E\\test\\src\\soubory\\numbers.txt");
		File filePart1 = new File("A:\\Programy\\JAVA\\PRG_2.E\\test\\src\\soubory\\numbers_part1.txt");
		File filePart2 = new File("A:\\Programy\\JAVA\\PRG_2.E\\test\\src\\soubory\\numbers_part2.txt");
		FileReader reader = new FileReader(file);
		FileWriter writerPart1 = new FileWriter(filePart1);
		FileWriter writerPart2 = new FileWriter(filePart2);

		String buffer = new String();
		int newLineCounter = 0;
		int writeIndex = 0;

		for (int x = reader.read(); x != -1; x = reader.read()) {

			buffer += (char)x;

			if ((char)x == '\n') newLineCounter++;
		}

		for (int lines = 0; lines <= newLineCounter / 2 && writeIndex < buffer.length(); writeIndex++) {

			writerPart1.write(buffer.charAt(writeIndex));

			if (buffer.charAt(writeIndex) == '\n') lines++;
		}

		for (int lines = newLineCounter / 2; lines < newLineCounter && writeIndex < buffer.length(); writeIndex++) {

			writerPart2.write(buffer.charAt(writeIndex));

			if (buffer.charAt(writeIndex) == '\n') lines++;
		}

		reader.close();
		writerPart1.close();
		writerPart2.close();
	}
}
