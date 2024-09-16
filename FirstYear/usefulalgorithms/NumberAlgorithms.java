package usefulalgorithms;

import java.security.SecureRandom;
import java.util.ArrayList;


/**
 * Třída obsahující algortimy pracující s čísly & náhodnými hodnotami.
 * <p> Příklad instance: <blockquote> <pre> {@code private final NumberAlgorithms myObj = new NumberAlgorithms();} </pre> </blockquote> </p>
 * <p> Metody obsahují: Generátor náhodných čísel & hesel, standardní & optimizovaný generátor prvočíselné řady </p>
 * <p> [Všechny metody nic netisknou, ale vrací vždy dynamické pole [{@code ArrayList<>}], hodnoty z toho pole se pak musí vytisknout] </p>
 * <p> + Pokud chcete změřit čas pracování algoritmu, použijte před & po volání metody z této třídy {@code System.currentTimeMillis();} </p>
 * <p> Příklad měření algoritmu:
 * <blockquote> <pre>
 * {@code long sysTime0 = System.currentTimeMillis();}
 *{@code ArrayList<Integer> randNums = myObj.RandomPasswordSequence(passwordCount, passwordLength);}
 *{@code long sysTime1 = System.currentTimeMillis();}
 *{@code System.out.print(sysTime1 - sysTime0);}
 * </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class NumberAlgorithms 
{
	/**
	 * Veřejný konstruktor třídy číselných algoritmů - {@code NumberAlgorithms}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public NumberAlgorithms() {}


	/**
	 * Veřejná metoda třídy {@code NumberAlgorithms} - Vygeneruje zadaný počet čísel v zadaném rozmezí pomocí třídy {@code Random}.
	 * 
	 * @param NumCount : {@code long} - počet vygenerovaných náhodných čísel [počet prvků výstupního pole]
	 * @param MinValue : {@code int} - spodní hraniční hodnota náhodného čísla
	 * @param MaxValue : {@code int} - horní hraniční hodnota náhodného čísla
	 * 
	 * @return {@code ArrayList<Integer>} - vygenerovaná náhodná čísla
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Integer> RandomNumberSequence(final long NumCount, final int MinValue, final int MaxValue) 
	{
		SecureRandom rand = new SecureRandom(); //sestavení náhodného generátoru
		ArrayList<Integer> result = new ArrayList<Integer>(0); //měnitelný objekt třídy ArrayList<Integer> pro dynamické uložení vygenerovaných hodnot

		if (MinValue > MaxValue) return result; //pokud je `MinValue` větší, než `MaxValue`, tak se vrátí prázdný `result` z metody, aby se zabránilo chybám

		//přidání `NumCount`-krát nového prvku do `result` [jedno nově vygenerované číslo]
		for (long c = 0; c < NumCount; c++)
			result.add(rand.nextInt((MaxValue - MinValue) + 1) + MinValue);

		return result; //vrácení pole `result` z metody
	}

	
	/**
	 * Veřejná metoda třídy {@code NumberAlgorithms} - Vygeneruje zadaný počet ASCII hesel se zadanou délkou pomocí třídy {@code Random}.
	 * <p> [Hesla jsou interpretována, jako řetězec náhodných ASCII znaků] </p>
	 * 
	 * @param PasswordCount : {@code long} - počet vygenerovaných náhodných hesel [počet prvků výstupního pole]
	 * @param PasswordLength : {@code long} - délka každého vygenerovaného hesel [počet znaků v jednom řetězci]
	 * 
	 * @return {@code ArrayList<String>} - vygenerovaná náhodná hesla
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> RandomPasswordSequence(final long PasswordCount, final long PasswordLength)
	{
		SecureRandom rand = new SecureRandom(); //sestavení náhodného generátoru
		ArrayList<String> result = new ArrayList<String>(0); //měnitelný objekt třídy ArrayList<String> pro dynamické uložení vygenerovaných hesel
		String password = new String(); //měnitelný objekt třídy String pro uložení jednoho vygenerovaného hesla

		//-------------------------------------------------------------------------------------
		//přidání `PasswordCount`-krát nového prvku do `result` [jedno nově vygenerované heslo]
		//-------------------------------------------------------------------------------------
		for (long c = 0; c < PasswordCount; c++)
		{
			password = new String(); //vyčistění objektu `password`

			//přidání `PasswordLength`-krát nového znaky do `password` [jednen nově vygenerovaný ASCII znak]
			for (long cc = 0; cc < PasswordLength; cc++)
				password += (char)(rand.nextInt((0x7E - 0x21) + 1) + 0x21);

			result.add(password); //přidání nově vygenerovaného hesla to nového prvku v poli `result`
		}
		//-------------------------------------------------------------------------------------

		return result; //vrácení pole `result` z metody
	}


	/**
	 * Veřejná metoda třídy {@code NumberAlgorithms} - Vygeneruje prvočíselnou řadu v zadaném rozmezí.
	 * 
	 * @param FromNum : {@code long} - začátek prvočíselné řady
	 * @param ToNum : {@code long} - konec prvočíselné řady
	 * 
	 * @return {@code ArrayList<Long>} - vygenerovaná řady prvočísel [1 prvočíslo = 1 prvek]
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> PrimeNumberGenerator(long FromNum, final long ToNum)
	{
		ArrayList<Long> result = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> pro dynamické uložení vygenerovaných hodnot

		//pokud je `ToNum` menší než 2, nebo `FromNum` je vetší než `ToNum`, tak se vrátí prázdný `result` z metody, aby se zabránilo chybám
		if (ToNum < 2 || FromNum > ToNum) return result;

		if (FromNum < 2) FromNum = 2; //automatická změna `FromNum` na 2, pokud je menší než 2 [aby se zabránilo přidání čísel < 2 do prvočíselné řady]

		//-------------------------------------------------------------------------------------------------------
		//Prohledání všech čísel mezi `FromNum` & `ToNum` & uložení kažedého prvočísla do nového prvku v `result`
		//-------------------------------------------------------------------------------------------------------
		for (long c = FromNum; c <= ToNum; c++)
		{
			boolean IsNotPrime = false; //vyresetování hodnoty `IsNotPrime` na `false`

			//porovnání dělitelnosti všech čísel mezi 2 & číslem `c` s číslem `c`
			for (long i = 2; i < c; i++)
			{
				//když je číslo `c` dělitelné byť jediným číslem `i`, tak se nastaví hodnota `IsNotPrime` na `true` & cyklus se okamžitě ukončí
				//[všechna čísla jsou dělitelná číslem 1 & sebou samým, proto se začíná na čísle 2 & končí na čísle o jedno menší, než `c`]
				if (c % i == 0) { IsNotPrime = true; break; }
			}

			//pokud je `IsNotPrime` roven `false` [`c` je prvočíslo], přidá se do `result` číslo `c`
			if (IsNotPrime == false) { result.add(c); }
		}
		//-------------------------------------------------------------------------------------------------------

		return result; //vrácení pole `result` z metody
	}


	/**
	 * Veřejná metoda třídy {@code NumberAlgorithms} - Vygeneruje prvočíselnou řadu v zadaném rozmezí.
	 * <p> + Tento algoritmus je lépe optimizovám, pomocí matematiky, generuje znatelně rychleji. </p>
	 * 
	 * @param FromNum : {@code long} - začátek prvočíselné řady
	 * @param ToNum : {@code long} - konec prvočíselné řady
	 * 
	 * @return {@code ArrayList<Long>} - vygenerovaná řady prvočísel [1 prvočíslo = 1 prvek]
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> OptimizedPrimeNumberGenerator(long FromNum, final long ToNum)
	{
		ArrayList<Long> result = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> pro dynamické uložení vygenerovaných hodnot

		//pokud je `ToNum` menší než 2, nebo `FromNum` je vetší než `ToNum`, tak se vrátí prázdný `result` z metody, aby se zabránilo chybám
		if (ToNum < 2 || FromNum > ToNum) return result; 

		if (FromNum < 2) FromNum = 2; //pokud je `ToNum` menší než 2, nebo `FromNum` je vetší, než `ToNum`, tak se vrátí prázdný `result` z metody, aby se zabránilo chybám

		//-------------------------------------------------------------------------------------------------------
		//Prohledání všech čísel mezi `FromNum` & `ToNum` & uložení kažedého prvočísla do nového prvku v `result`
		//-------------------------------------------------------------------------------------------------------
		for (long c = FromNum; c <= ToNum; c++)
		{
			//pokud je `c` rovno 2, nebo 3 [je rovnou prvočíslo], tak se hned přidá do `result` číslo `c` & smyčka jde rovnou na další číslo
			if (c == 2 || c == 3) { result.add(c); continue; }

			//pokud je `c` dělitelné dvěma, nebo třemi [nejčastější možnost], tak smyčka jde rovnou na další číslo [nemá smysl porovnávat zbytek]
			if (c % 2 == 0 || c % 3 == 0) continue;

			boolean IsNotPrime = false; //vyresetování hodnoty `IsNotPrime` na `false`

			//porovnání dělitelnosti každého šestého čísla od 5 do poloviny čísla `c` s číslem `c` [porovnávat do čísla menšího, než 5 je zbytečné & navíc se to pak hezky nastaví na prvočísla]
			//[to přestě jde po prvočíslech + `(i + 2)` ohlídá zbylá prvočísla & to co je vetší, než polovina `c`, již nikdy nebude celočíselně dělitelné s číslem `c` - nemá smysl porovnávat]
			for (long i = 5; i * i <= c; i += 6)
			{
				//když je číslo `c` dělitelné byť jediným číslem `i`, nebo i číslem o dva větší, než `i`,
				//tak se nastaví hodnota `IsNotPrime` na `true` & cyklus se okamžitě ukončí
				if (c % i == 0 || c % (i + 2) == 0) { IsNotPrime = true; break; }
			}

			//pokud je `IsNotPrime` roven `false` [`c` je prvočíslo], přidá se do `result` číslo `c`
			if (IsNotPrime == false) { result.add(c); }
		}
		//-------------------------------------------------------------------------------------------------------

		return result; //vrácení pole `result` z metody
	}
}