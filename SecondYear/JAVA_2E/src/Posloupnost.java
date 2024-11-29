import java.util.Scanner;

public class Posloupnost
{
	static int[] generate_sequence(final int _Index)
	{
		int[] _Container = new int[_Index];

		for (int c = 1; c <= _Index; c++)
		{
			if (c >= 1 && c <= 9)
			{
				_Container[c - 1] = c; continue;
			}
			else if (c >= 10 && c <= 19)
			{
				_Container[c - 1] = 10 + (c - 10) * 2; continue;
			}
			else if (c >= 20 && c <= 29)
			{
				_Container[c - 1] = 30 + (c - 20) * 3; continue;
			}
			else if (c >= 30 && c <= 39)
			{
				_Container[c - 1] = 60 + (c - 30) * 4; continue;
			}
			else if (c >= 40 && c <= 49)
			{
				_Container[c - 1] = 100 + (c - 40) * 5; continue;
			}
			else if (c >= 50 && c <= 59)
			{
				_Container[c - 1] = 150 + (c - 50) * 6; continue;
			}
			else if (c >= 60)
			{
				_Container[c - 1] = 210 + (c - 50) * 7; continue;
			}
		}

		return _Container;
	};

	static void print_sequence(int[] _Container, final int _Index)
	{
		System.out.println();

		for (int c = 0; c < _Index; c++)
		{
			System.out.print(_Container[c]);
			System.out.println();
		}

		return;
	};

	public static void main(String[] args)
	{
		Scanner Scan = new Scanner(System.in);
		int Input = Scan.nextInt();
		Scan.close();

		long first_timeshot = System.currentTimeMillis();
		int[] Result = generate_sequence(Input);
		print_sequence(Result, Input);
		long second_timeshot = System.currentTimeMillis();
		System.out.println("\nExecution taken: " + (second_timeshot - first_timeshot) + " ms");

		return;
	};
}