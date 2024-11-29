package clovek;

import selectionSort.Clovek;

import java.util.*;

public class Main {

	public static Clovek[] bubbleSort(Clovek[] pole) {

		boolean prohozeno = false;

		do {

			prohozeno = false;

			for (int c = 0; c < pole.length - 1; c++) {

				if (pole[c].isSmallerThan(pole[c + 1])) {

					String buf = pole[c].getJmeno();
					pole[c].setJmeno(pole[c + 1].getJmeno());
					pole[c + 1].setJmeno(buf);
					prohozeno = true;
				}
			}
		}
		while(prohozeno);

		return pole;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Clovek[] lidi = new Clovek[5];

		for (int c = 0; c < lidi.length; c++)
			lidi[c] = new Clovek(sc.next(), sc.next());

		lidi = bubbleSort(lidi);

		for (Clovek clovek : lidi)
			System.out.println(clovek.toString());
	}
}
