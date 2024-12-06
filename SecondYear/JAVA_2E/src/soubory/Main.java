package soubory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		File file = new File("Z:\\JAVA_2E\\PROGRAMOVANI_2E\\.gitignore");
		FileReader reader = new FileReader(file);
		int CharCounter = 0;

		/*
		while (true) {

			int x = reader.read();

			if (x == -1)
				break;

			System.out.println((char)x);
		}


		for (int x = reader.read(); x != -1; x = reader.read(), CharCounter++) {

			System.out.print((char)x);
		}

		System.out.println("\n\n---------------\nChar count: " + CharCounter + "\n---------------");
		*/

		/*
		File file = new File("Random.txt");
		FileWriter writer = new FileWriter(file);
		Random generator = new Random();

		for (int c = 0; c < 2000000; c++) {

			Integer number = generator.nextInt();
			writer.append(number.toString() + ", ");
		}

		writer.close();
		 */

		File file = new File("Z:\\JAVA_2E\\PROGRAMOVANI_2E\\.gitignore");
		File file_copy_pervered = new File("Z:\\JAVA_2E\\PROGRAMOVANI_2E\\.gitignore_copy_pervered");
		FileReader reader = new FileReader(file);
		FileWriter writer = new FileWriter(file_copy_pervered);
/*
		for (int x = reader.read(); x != -1; x = reader.read()) {

			writer.append((char)x);
		}
*/
		String buffer = new String();

		for (int x = reader.read(); x != -1; x = reader.read()) {

			buffer += (char)x;
		}

		for (int c = buffer.length() - 1; c >= 0; c--) {

			writer.append(buffer.charAt(c));
		}

		reader.close();
		writer.close();
	}
}