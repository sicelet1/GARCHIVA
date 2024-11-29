package spotrebice;

public abstract class Zvire implements InterfaceDelaZvuk {

	@Override
	public int hlasitost() {

		return delaZvuk().length();
	}

	@Override
	public String toString() {

		return "zvuk: " + delaZvuk();
	}
};
