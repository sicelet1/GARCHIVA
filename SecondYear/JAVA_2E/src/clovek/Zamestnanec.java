package clovek;

import selectionSort.Clovek;

public class Zamestnanec extends Clovek {

	private Integer plat;

	public Zamestnanec() {

		this.jmeno = null;
		this.prijmeni = null;
		this.plat = null;
	}

	public Zamestnanec(final String jmeno, final String prijmeni, final Integer plat) {

		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.plat = plat;
	}

	@Override
	public String toString() {

		return "{jmeno= " + jmeno + ", prijmeni= " + prijmeni + ", plat= " + plat + "}";
	}
}
