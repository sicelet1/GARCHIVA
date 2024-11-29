package selectionSort;

public class Clovek {

	protected String jmeno;
	protected String prijmeni;

	public Clovek() {

		this.jmeno = null;
		this.prijmeni = null;
	}

	public Clovek(final String jmeno, final String prijmeni) {

		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
	}

	public String getJmeno() {

		return jmeno;
	}

	public String getPrijmeni() {

		return prijmeni;
	}

	public void setJmeno(String jmeno) {

		this.jmeno = jmeno;
	}

	public void setPrijmeni(String prijmeni) {

		this.prijmeni = prijmeni;
	}

	public boolean isSmallerThan(final Clovek c) {

		int provnaniPrijmeni = this.prijmeni.compareTo(c.prijmeni);

		return provnaniPrijmeni < 0 || (provnaniPrijmeni == 0 && this.jmeno.compareTo(c.jmeno) < 0);
	}

	@Override
	public String toString() {

		return "{jmeno= " + jmeno + ", prijmeni= " + prijmeni + "}";
	}
}
