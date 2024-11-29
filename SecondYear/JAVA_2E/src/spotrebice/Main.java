package spotrebice;

public class Main {

	public static void main(String[] args) {

		InterfaceDelaZvuk[] array = new InterfaceDelaZvuk[4];

		array[0] = new Kocka();
		array[1] = new Klokan();
		array[2] = new Vrtacka();
		array[3] = new Kavovar();

		for (InterfaceDelaZvuk elem : array)
			System.out.println(elem.delaZvuk() + " | " + elem.hlasitost());
	}
}
