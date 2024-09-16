package test;

//Importing some utilities required by the program
import java.util.*;

public class Main
{
	//The program starts executing from here:
	public static void main(String[] args)
	{
		//Variables / Objects initialization on the memory
		final Scanner InputBuf = new Scanner(System.in);
		List<Long> Input = new ArrayList<Long>();

		//Asking for a numeric input until zero is entered
		do
		{
			Input.add((Long)InputBuf.nextLong());
		}
		while (Input.getLast() != 0);

		InputBuf.close();
		//Getting rid of that zero [last element]
		Input.removeLast();
		//Sorting the array of numbers [Input] using a sort algorithm from the Collections class [Quick sort]
		Collections.sort(Input);
		//Calculating & printing the median of that SORTED number array [Input]
		//Calculation is based on the element count of that SORTED number array [Input]:
		//If the size is odd => Median is simply the middle element of that SORTED number array [Input]
		//If the size is even => Median is an arithmetic average of the two middle elements of that SORTED number array [Input]
		System.out.print("\nMedian = ");
		System.out.print(Input.size() % 2 == 0 ? (double)(Input.get(Input.size() / 2) + Input.get((Input.size() / 2) - 1)) / 2.0 : Input.get((Input.size() - 1) / 2));

		//The execution ends
		return;
	};
};