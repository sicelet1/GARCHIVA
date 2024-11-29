import java.util.ArrayList;

public class Kryptogram
{
	//jde to zrychlit, ještě jsem to neudělal
	public static void main(String[] args)
	{
		int counter = 0;

		for (int s = 0; s < 10; s++)
			for (int e = 0; e < 10; e++)
				for (int n = 0; n < 10; n++)
					for (int d = 0; d < 10; d++)
						for (int m = 0; m < 10; m++)
							for (int o = 0; o < 10; o++)
								for (int r = 0; r < 10; r++)
									for (int y = 0; y < 10; y++)
									{
										int send = s * 1000 + e * 100 + n * 10 + d;
										int more = m * 1000 + o * 100 + r * 10 + e;
										int money = m * 10000 + o * 1000 + n * 100 + e * 10 + y;


										ArrayList<Integer> tmp = new ArrayList<>(0);
										tmp.add(s);
										tmp.add(e);
										tmp.add(n);
										tmp.add(d);
										tmp.add(m);
										tmp.add(o);
										tmp.add(r);
										tmp.add(y);

										int iterator = 0, comparator = 0; boolean NOT = false;

										while (true)
										{
											if (comparator == iterator)
												iterator++;

											if (iterator >= tmp.size())
											{
												iterator = 0;
												comparator++;
											}

											if (comparator >= tmp.size())
												break;

											if (tmp.get(comparator) == tmp.get(iterator))
											{
												NOT = true; break;
											}
											else
											{
												iterator++;
											}
										}

										if (!NOT && send + more == money && s != 0 && m != 0)
										{
											System.out.println("SEND = " + send);
											System.out.println("MORE = " + more);
											System.out.println("MONEY = " + money);
											System.out.println();

											counter++;
										}
									}

		System.out.println();
		System.out.println("Possible solutions: " + counter);
	};
};