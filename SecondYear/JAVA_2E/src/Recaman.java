import java.util.ArrayList;
import java.util.Scanner;

public class Recaman
{
	public static ArrayList<Long> _Container = new ArrayList<>(0);

	public static boolean check_if_repeats(final ArrayList<Long> _Container, final long _NumberToCheck)
	{
		for (long Number : _Container)
			if (Number == _NumberToCheck) return false;

		return true;
	};

	public static void generate_seq(final long _ElementCount)
	{
		long NewElemToAdd = _Container.get(_Container.size() - 1);

		_Container.add((NewElemToAdd - (long)(_Container.size() + 1) > 0 && check_if_repeats(_Container, NewElemToAdd - (long)(_Container.size() + 1)) ? NewElemToAdd - (long)(_Container.size() + 1) : NewElemToAdd + (long)(_Container.size() + 1)));

		if (_Container.size() < _ElementCount)
			generate_seq(_ElementCount);

		return;
	};

	public static ArrayList<Long> give_seq_to_pos(final long _Position)
	{
		_Container = new ArrayList<>(0);

		_Container.add((long)1);
		generate_seq(_Position);

		return _Container;
	};

	public static void print_seq()
	{
		System.out.print(_Container.get(0));

		for (int c = 1; c < _Container.size(); c++)
			System.out.print(" " + _Container.get(c));

		System.out.println(); return;
	};

	public static void main(String[] args)
	{
		final Scanner Input = new Scanner(System.in);
		long InputNumber = Input.nextLong();

		give_seq_to_pos(InputNumber);
		print_seq();

		return;
	};
}