package mergeSort2;

public class Clovek implements Comparable<Clovek> {
	
	String jmeno;
	String prijmeni;

	public Clovek() {

		this.jmeno = null;
		this.prijmeni = null;
	}

	public Clovek(final String jmeno, final String prijmeni) {

		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
	}

	@Override public int compareTo(Clovek o) {

		return (this.prijmeni.compareTo(o.prijmeni) != 0 ? this.prijmeni.compareTo(o.prijmeni) : this.jmeno.compareTo(o.jmeno));
	}

	@Override
	public String toString() {

		return "[ " + jmeno + " ; " + prijmeni + " ]";
	}
}
