package spotrebice;

public abstract class ElSpotrebic implements InterfaceDelaZvuk {

	public boolean jeNaElektrinu() {

		return true;
	}

	@Override
	public int hlasitost() {

		return delaZvuk().length();
	}

	@Override
	public String toString() {

		return "ElSpotrebic: " + jeNaElektrinu() + "\nzvuk: " + delaZvuk();
	}
}
