package bubbleSort;

import java.util.ArrayList;

public class Main {

	public ArrayList<Long> BubbleSortNumbers(final ArrayList<Long> Values)
	{
		if (Values.size() == 0 || Values.size() == 1) return Values;

		boolean WasSorted = false;

		do
		{
			WasSorted = false;

			for (int c = 0; c < Values.size() - 1; c++)
			{
				if (Values.get(c) > Values.get(c + 1)) { long Buf = Values.get(c); Values.set(c, Values.get(c + 1)); Values.set(c + 1, Buf); WasSorted = true; }
			}
		}
		while (WasSorted == true);

		return Values;
	}

	public static void main(String[] args) {


	}
}
