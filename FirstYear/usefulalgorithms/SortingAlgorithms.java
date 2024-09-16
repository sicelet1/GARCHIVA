package usefulalgorithms;

import java.util.ArrayList;


/**
 * Třída obsahující algortimy, seřazující prvky v polích hodnot.
 * <p> Příklad instance: <blockquote> <pre> {@code private final SortingAlgorithms myObj = new SortingAlgorithms();} </pre> </blockquote> </p>
 * <p> Metody obsahují: Bubble, Selection, Insertion, Quick, Merge & Bucket Sort. </p>
 * <p> [Všechny metody nic netisknou, ale vrací vždy dynamické pole [{@code ArrayList<>}], hodnoty z toho pole se pak musí vytisknout] </p>
 * <p> + Pokud chcete změřit čas pracování algoritmu, použijte před & po volání metody z této třídy {@code System.currentTimeMillis();} </p>
 * <p> Příklad měření algoritmu:
 * <blockquote> <pre>
 * {@code long sysTime0 = System.currentTimeMillis();}
 *{@code ArrayList<Long> sortedNums = myObj.QuickSortNumbers(numsToSort, 0, numsToSort.length() - 1);}
 *{@code long sysTime1 = System.currentTimeMillis();}
 *{@code System.out.print(sysTime1 - sysTime0);}
 * </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class SortingAlgorithms 
{
	/**
	 * Veřejný konstruktor třídy seřazovacích algoritmů - {@code SortingAlgorithms}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public SortingAlgorithms() {}


    //Bubble sort - čísla
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí číselné hodnoty v poli pomocí algoritmu {@code Bubble Sort}.
	 * <p> {@code Bubble Sort} seřadí hodnoty v poli postupným porovnáváním dvojic hodnot vedle sebe & jejich případným prohozením. </p>
	 * 
	 * @param Values : {@code ArrayList<Long>} - pole číselných hodnot k seřazení
	 * 
	 * @return {@code ArrayList<Long>} - seřazené pole číselných hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> BubbleSortNumbers(final ArrayList<Long> Values)
	{
		//pokud je počet prvků v poli `Values` 0 nebo 1 [pole je seřazeno], tak se vrátí pole `Values` z metody
		if (Values.size() == 0 || Values.size() == 1) return Values;

		boolean WasSorted = false; //pravdivostní hodnota pro případ, že něco bylo v poli přemístěno

		//---------------------------------------------------------
		do
		{
			//nastavení `WasSorted` na `false`
			WasSorted = false;

			//prohledání pole prvek po prvku
			for (int c = 0; c < Values.size() - 1; c++)
			{
				//pokud je vybraný prvek větší, než prvek po něm, tak dojde k jejich prohození & nastavení hodnoty `WasSorted` na `true`
				if (Values.get(c) > Values.get(c + 1)) { long Buf = Values.get(c); Values.set(c, Values.get(c + 1)); Values.set(c + 1, Buf); WasSorted = true; }
			}
		}
		while (WasSorted == true);
		//---------------------------------------------------------
		//Opakování postupu, dokud je alespoň jednou něco prohozeno
		//---------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Bubble sort - řetězce
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí řetězcové hodnoty v poli pomocí algoritmu {@code Bubble Sort}.
	 * <p> {@code Bubble Sort} seřadí hodnoty v poli postupným porovnáváním dvojic hodnot vedle sebe & jejich případným prohozením. </p>
	 * 
	 * @param Values : {@code ArrayList<String>} - pole řetězcových hodnot k seřazení
	 * 
	 * @return {@code ArrayList<String>} - seřazené pole řetězcových hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> BubbleSortStrings(final ArrayList<String> Values)
	{
		//pokud je počet prvků v poli `Values` 0 nebo 1 [pole je seřazeno], tak se vrátí pole `Values` z metody
		if (Values.size() == 0 || Values.size() == 1) return Values;

		boolean WasSorted = false; //pravdivostní hodnota pro případ, že něco bylo v poli přemístěno

		//---------------------------------------------------------
		do
		{
			//nastavení `WasSorted` na `false`
			WasSorted = false;

			//------------------------------
			//prohledání pole prvek po prvku
			//------------------------------
			for (int c = 0; c < Values.size() - 1; c++)
			{
				int LetterPos = 0; //pozice znaku k porovnání v řetězcích

				//---------------------------------------------------------------------------------------------------------
				//prohledávání znak po znaku jednoho řetězce z pole, dokud alepoň jednomu z nich nedojdou znaky k porovnání
				//---------------------------------------------------------------------------------------------------------
				while (Values.get(c).length() > LetterPos && Values.get(c + 1).length() > LetterPos)
				{
					//když se znaky rovnají, tak jde se na další znak v pořadí
					if (Values.get(c).charAt(LetterPos) == Values.get(c + 1).charAt(LetterPos)) { LetterPos++; }
					//pokud je vybraný znak větší, než znak po něm, tak dojde k prohození příslušných řetezců & nastavení hodnoty `WasSorted` na `true` & ukončení cyklu
					else if (Values.get(c).charAt(LetterPos) > Values.get(c + 1).charAt(LetterPos)) { String Buf = Values.get(c); Values.set(c, Values.get(c + 1)); Values.set(c + 1, Buf); WasSorted = true; break; }
					else break; //jinak nedojde k prohození & cyklus končí
				}
				//---------------------------------------------------------------------------------------------------------
			}
			//------------------------------
		} 
		while (WasSorted == true);
		//---------------------------------------------------------
		//Opakování postupu, dokud je alespoň jednou něco prohozeno
		//---------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Selection sort - čísla
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí číselné hodnoty v poli pomocí algoritmu {@code Selection Sort}.
	 * <p> {@code Selection Sort} nejprve najde nejmenší prvek v poli hodnot & ten pak dá do seřazené části pole, takhle to opakuje, dokud není pole seřazeno. </p>
	 * 
	 * @param Values : {@code ArrayList<Long>} - pole číselných hodnot k seřazení
	 * 
	 * @return {@code ArrayList<Long>} - seřazené pole číselných hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> SelectionSortNumbers(final ArrayList<Long> Values)
	{
		//pokud je počet prvků v poli `Values` 0 nebo 1 [pole je seřazeno], tak se vrátí pole `Values` z metody
		if (Values.size() == 0 || Values.size() == 1) return Values;

		//proměnné `SortingPos` k uložení pozice začátku neseřazené části pole & `ChangePos` k uložení pozice nejmenšího prvku v neseřazené části pole
		int SortingPos = 0, ChangePos = 0; 
		long SmallestElem = 0xffffffffffffffffL; //proměnná pro uložení hodnoty nejmenšího prvku

		//--------------------------------------------------------------------------------
		//cyklické opakování, dokud není velikost seřazené části pole rovna velikosti pole
		//--------------------------------------------------------------------------------
		while (SortingPos < Values.size())
		{
			SmallestElem = 0xffffffffffffffffL; //nastavení `SmallestElem` na maximální hodnotu `long` proměnné

			//prohledání neseřazené části pole prvek po prvku & nalezení nejmenšího prvku
			for (int c = SortingPos; c < Values.size(); c++)
			{
				//pokud je vybraný prvek menší, než `SmallestElem`, tak dojde jeho uložení do `SmallestElem` & uložení jeho pozice v poli do `ChangePos`
				if (Values.get(c) < SmallestElem) { SmallestElem = Values.get(c); ChangePos = c; }
			}

			//prohození nejmenšího prvku s prvkem na začátku neseřazené části pole & zvýšení `SortingPos` o 1
			long Buf = Values.get(SortingPos); Values.set(SortingPos, Values.get(ChangePos)); Values.set(ChangePos, Buf); SortingPos++;
		}
		//--------------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Selection sort - řetězce
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí řetězcových hodnoty v poli pomocí algoritmu {@code Selection Sort}.
	 * <p> {@code Selection Sort} nejprve najde nejmenší prvek v poli hodnot & ten pak dá do seřazené části pole, takhle to opakuje dokud není pole seřazeno. </p>
	 * 
	 * @param Values : {@code ArrayList<String>} - pole řetězcových hodnot k seřazení
	 * 
	 * @return {@code ArrayList<String>} - seřazené pole řetězcových hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> SelectionSortStrings(final ArrayList<String> Values)
	{
		//pokud je počet prvků v poli `Values` 0 nebo 1 [pole je seřazeno], tak se vrátí pole `Values` z metody
		if (Values.size() == 0 || Values.size() == 1) return Values;

		//proměnné `SortingPos` k uložení pozice začátku neseřazené části pole & `ChangePos` k uložení pozice nejmenšího prvku v neseřazené části pole
		int SortingPos = 0, ChangePos = 0; 
		String SmallestElem = "" + (char)0xFF; //proměnná pro uložení hodnoty nejmenšího prvku

		//--------------------------------------------------------------------------------
		//cyklické opakování, dokud není velikost seřazené části pole rovna velikosti pole
		//--------------------------------------------------------------------------------
		while (SortingPos < Values.size())
		{
			SmallestElem = "" + (char)0xFF; //nastavení `SmallestElem` na maximální hodnotu ASCII znaku

			//---------------------------------------------------------------------------
			//prohledání neseřazené části pole prvek po prvku & nalezení nejmenšího prvku
			//---------------------------------------------------------------------------
			for (int c = SortingPos; c < Values.size(); c++)
			{
				int LetterPos = 0; //pozice znaku k porovnání v řetězcích

				//---------------------------------------------------------------------------------------------------------
				//prohledávání znak po znaku jednoho řetězce z pole, dokud alepoň jednomu z nich nedojdou znaky k porovnání
				//---------------------------------------------------------------------------------------------------------
				while (Values.get(c).length() > LetterPos && SmallestElem.length() > LetterPos)
				{
					//když se znaky rovnají, tak jde se na další znak v pořadí
					if (Values.get(c).charAt(LetterPos) == SmallestElem.charAt(LetterPos)) { LetterPos++; }
					//pokud je vybraný znak menší, než `SmallestElem`, tak dojde k jeho uložení do `SmallestElem` & uložení jeho pozice v poli do `ChangePos` & ukončení cyklu
					else if (Values.get(c).charAt(LetterPos) < SmallestElem.charAt(LetterPos)) { SmallestElem = Values.get(c); ChangePos = c; break; }
					else break; //jinak nedojde k uložení & cyklus končí
				}
				//---------------------------------------------------------------------------------------------------------
			}
			//---------------------------------------------------------------------------

			//prohození nejmenšího prvku s prvkem na začátku neseřazené části pole & zvýšení `SortingPos` o 1
			String Buf = Values.get(SortingPos); Values.set(SortingPos, Values.get(ChangePos)); Values.set(ChangePos, Buf); SortingPos++;
		}
		//--------------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Insertion sort - čísla
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí číselné hodnoty v poli pomocí algoritmu {@code Insertion Sort}.
	 * <p> {@code Insertion Sort} porovnává všechny prvky seřazené části pole s prvním prvkem v neseřazené části, poté posune prvek na příslušnou pozici v seřazené části, takhle to opakuje dokud není pole seřazeno. </p>
	 * 
	 * @param Values : {@code ArrayList<Long>} - pole číselných hodnot k seřazení
	 *  
	 * @return {@code ArrayList<Long>} - seřazené pole číselných hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> InsertionSortNumbers(final ArrayList<Long> Values)
	{
		//pokud je počet prvků v poli `Values` 0 nebo 1 [pole je seřazeno], tak se vrátí pole `Values` z metody
		if (Values.size() == 0 || Values.size() == 1) return Values;

		//proměnné `SortingPos` k uložení pozice začátku neseřazené části pole
		int SortingPos = 0;

		//--------------------------------------------------------------------------------
		//cyklické opakování, dokud není velikost seřazené části pole rovna velikosti pole
		//--------------------------------------------------------------------------------
		while (SortingPos < Values.size())
		{
			//prohledání seřazené části pole prvek po prvku & zařazení posledního prvku do seřazené části
			for (int c = SortingPos; c > 0; c--)
			{
				//pokud je prvek menší, než prvek před ním, tak dojde k jejich prohození
				if (Values.get(c) < Values.get(c - 1)) { long Buf = Values.get(c); Values.set(c, Values.get(c - 1)); Values.set(c - 1, Buf); }
				else break; //jinak k prohození nedojde & cyklus končí
			}

			SortingPos++; //zvýšení `SortingPos` o 1
		}
		//--------------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Insertion sort - řetězce
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí řetězcové hodnoty v poli pomocí algoritmu {@code Insertion Sort}.
	 * <p> {@code Insertion Sort} porovnává všechny prvky seřazené části pole s prvním prvkem v neseřazené části, poté posune prvek na příslušnou pozici v seřazené části, takhle to opakuje dokud není pole seřazeno. </p>
	 * 
	 * @param Values : {@code ArrayList<String>} - pole řetězcových hodnot k seřazení
	 * 
	 * @return {@code ArrayList<String>} - seřazené pole řetězcových hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> InsertionSortStrings(final ArrayList<String> Values)
	{
		//pokud je počet prvků v poli `Values` 0 nebo 1 [pole je seřazeno], tak se vrátí pole `Values` z metody
		if (Values.size() == 0 || Values.size() == 1) return Values;

		//proměnná `SortingPos` k uložení pozice začátku neseřazené části pole
		int SortingPos = 0;

		//--------------------------------------------------------------------------------
		//cyklické opakování, dokud není velikost seřazené části pole rovna velikosti pole
		//--------------------------------------------------------------------------------
		while (SortingPos < Values.size())
		{
			//-------------------------------------------------------------------------------------------
			//prohledání seřazené části pole prvek po prvku & zařazení posledního prvku do seřazené části
			//-------------------------------------------------------------------------------------------
			for (int c = SortingPos; c > 0; c--)
			{
				int LetterPos = 0; //pozice znaku k porovnání v řetězcích

				//---------------------------------------------------------------------------------------------------------
				//prohledávání znak po znaku jednoho řetězce z pole, dokud alepoň jednomu z nich nedojdou znaky k porovnání
				//---------------------------------------------------------------------------------------------------------
				while (Values.get(c).length() > LetterPos && Values.get(c - 1).length() > LetterPos)
				{
					//když se znaky rovnají, tak jde se na další znak v pořadí
					if (Values.get(c).charAt(LetterPos) == Values.get(c - 1).charAt(LetterPos)) { LetterPos++; }
					//pokud je vybraný znak menší, než znak před ním, tak dojde k prohození příslušných řetezců & nastavení hodnoty & ukončení cyklu
					else if (Values.get(c).charAt(LetterPos) < Values.get(c - 1).charAt(LetterPos)) { String Buf = Values.get(c); Values.set(c, Values.get(c - 1)); Values.set(c - 1, Buf); break; }
					else break; //jinak nedojde k prohození & cyklus končí
				}
				//---------------------------------------------------------------------------------------------------------
			}
			//-------------------------------------------------------------------------------------------

			SortingPos++; //zvýšení `SortingPos` o 1
		}
		//--------------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//QuickSort - čísla
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí číselné hodnoty v poli pomocí algoritmu {@code Quick Sort}.
	 * <p> {@code Quick Sort} zvolí poslední prvek pole, jako Pivot, s ním porovnává všechny ostatní prvky, nakonec jsou menší hodnoty nalevo, větší napravo [používá se sám na sebe]. </p>
	 * 
	 * @param Values : {@code ArrayList<Long>} - pole číselných hodnot k seřazení
	 * @param LowestIndex : {@code int} - pozice prvního prvku v poli k seřazení
	 * @param HighestIndex : {@code int} - pozice posledního prvku v poli k seřazení
	 * 
	 * @return {@code ArrayList<Long>} - seřazené pole číselných hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> QuickSortNumbers(final ArrayList<Long> Values, final int LowestIndex, final int HighestIndex)
	{
		//pokud je `LowestIndex` větší nebo roven `HighestIndex` [neplatné], nebo `LowestIndex` je menší než 0, tak se vrátí pole `Values` z metody / rekurzivního volání
		if (LowestIndex >= HighestIndex || LowestIndex < 0) return Values;

		long CurrentPivot = Values.get(HighestIndex); //proměnná `CurrentPivot` pro uložení hodnoty zvoleného pivotu
		int SortingPos = LowestIndex - 1; //proměnná `SortingPos` k uložení pozice konce části pole s hodnotami menšími, než `CurrentPivot`

		//prohledání pole prvek po prvku do zadané pozice prvního až do zadané pozice posledního prvku & přeházení hodnot menších, než `CurrentPivot` nalevo
		for (int c = LowestIndex; c < HighestIndex; c++)
		{
			//pokud je prvek menší, nebo roven `CurrentPivot`, tak se zvýší `SortingPos` o 1 & dojde k prohození daného prvku s prvkem na pozici `SortingPos`
			if (Values.get(c) <= CurrentPivot) { SortingPos++; long Buf = Values.get(SortingPos); Values.set(SortingPos, Values.get(c)); Values.set(c, Buf); }
		}

		//zvýší se `SortingPos` o 1 & dojde k prohození daného pivotu s prvkem na pozici `SortingPos` [pivot se dostane přesně mezi hodnoty menší & větší]
		SortingPos++; long Buf = Values.get(SortingPos); Values.set(SortingPos, Values.get(HighestIndex)); Values.set(HighestIndex, Buf);

		//---------------------------------------------------------------
		//rekurzivní volání pro levou & pravou stranu od vybraného Pivotu
		//---------------------------------------------------------------
		QuickSortNumbers(Values, LowestIndex, SortingPos - 1);
		QuickSortNumbers(Values, SortingPos + 1, HighestIndex);
		//---------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//QuickSort - řetězce
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí řetězcové hodnoty v poli pomocí algoritmu {@code Quick Sort}.
	 * <p> {@code Quick Sort} zvolí poslední prvek pole, jako Pivot, s ním porovnává všechny ostatní prvky, nakonec jsou menší hodnoty nalevo, větší napravo [používá se sám na sebe]. </p>
	 * 
	 * @param Values : {@code ArrayList<String>} - pole řetězcových hodnot k seřazení
	 * @param LowestIndex : {@code int} - pozice prvního prvku v poli k seřazení
	 * @param HighestIndex : {@code int} - pozice posledního prvku v poli k seřazení
	 * 
	 * @return {@code ArrayList<String>} - seřazené pole řetězcových hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> QuickSortStrings(final ArrayList<String> Values, final int LowestIndex, final int HighestIndex)
	{
		//pokud je `LowestIndex` větší nebo roven `HighestIndex` [neplatné], nebo `LowestIndex` je menší než 0, tak se vrátí pole `Values` z metody / rekurzivního volání
		if (LowestIndex >= HighestIndex || LowestIndex < 0) return Values;

		String CurrentPivot = Values.get(HighestIndex); //řetězec `CurrentPivot` pro uložení hodnoty zvoleného pivotu
		int SortingPos = LowestIndex - 1; //proměnná `SortingPos` k uložení pozice konce části pole s hodnotami menšími, než `CurrentPivot`

		//--------------------------------------------------------------------------------------------------------------------------------------------------
		//prohledání pole prvek po prvku do zadané pozice prvního až do zadané pozice posledního prvku & přeházení hodnot menších, než `CurrentPivot` nalevo
		//--------------------------------------------------------------------------------------------------------------------------------------------------
		for (int c = LowestIndex; c < HighestIndex; c++)
		{
			int LetterPos = 0; //pozice znaku k porovnání v řetězcích

			//---------------------------------------------------------------------------------------------------------
			//prohledávání znak po znaku jednoho řetězce z pole, dokud alepoň jednomu z nich nedojdou znaky k porovnání
			//---------------------------------------------------------------------------------------------------------
			while (Values.get(c).length() > LetterPos && CurrentPivot.length() > LetterPos)
			{
				//když se znaky rovnají, tak jde se na další znak v pořadí
				if (Values.get(c).charAt(LetterPos) == CurrentPivot.charAt(LetterPos)) { LetterPos++; }
				//pokud je vybraný znak menší, nebo roven znaku z `CurrentPivot`, tak se zvýší `SortingPos` o 1 & dojde k prohození daného prvku s prvkem na pozici `SortingPos` & ukončení cyklu
				else if (Values.get(c).charAt(LetterPos) <= CurrentPivot.charAt(LetterPos)) { SortingPos++; String Buf = Values.get(SortingPos); Values.set(SortingPos, Values.get(c)); Values.set(c, Buf); break; }
				else break; //jinak nedojde k prohození & cyklus končí
			}
			//---------------------------------------------------------------------------------------------------------
		}
		//--------------------------------------------------------------------------------------------------------------------------------------------------

		//zvýší se `SortingPos` o 1 & dojde k prohození daného pivotu s prvkem na pozici `SortingPos` [pivot se dostane přesně mezi hodnoty menší & větší]
		SortingPos++; String Buf = Values.get(SortingPos); Values.set(SortingPos, Values.get(HighestIndex)); Values.set(HighestIndex, Buf);

		//---------------------------------------------------------------
		//rekurzivní volání pro levou & pravou stranu od vybraného Pivotu
		//---------------------------------------------------------------
		QuickSortStrings(Values, LowestIndex, SortingPos - 1);
		QuickSortStrings(Values, SortingPos + 1, HighestIndex);
		//---------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Merge sort - čísla
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí číselné hodnoty v poli pomocí algoritmu {@code Merge Sort}.
	 * <p> {@code Merge Sort} rozdělí pole na levou & pravou polovinu, ty pak seřadí sám sebou & nakonec všechny poloviny spojí do jednoho seřazeného pole. </p>
	 * 
	 * @param Values : {@code ArrayList<Long>} - pole číselných hodnot k seřazení
	 * 
	 * @return {@code ArrayList<Long>} - seřazené pole číselných hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> MergeSortNumbers(final ArrayList<Long> Values)
	{
		//pokud je počet prvků v poli `Values` 1 & menší [pole je seřazeno], tak se vrátí pole `Values` z metody / rekurzivního volání
		if (Values.size() <= 1) return Values;

		ArrayList<Long> LeftHalf = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> pro dynamické uložení levé poloviny rozděleného pole
		ArrayList<Long> RightHalf = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> pro dynamické uložení pravé poloviny rozděleného pole

		//prohledání pole prvek po prvku & hodnoty s pozicí menší, než polovina délky pole jsou dány do `LeftHalf`, ostatní do `RightHalf`
		for (int c = 0; c < Values.size(); c++)
		{
			//pokud je pozice prvku menší, než polovina délky pole, tak je hodnota prvku uložena do `LeftHalf`
			if (c < Values.size() / 2) LeftHalf.add(Values.get(c));
			else RightHalf.add(Values.get(c)); //jinak je hodnota prvku uložena do `RightHalf`
		}

		//------------------------------------------------------------
		//rekurzivní volání pro levou & pravou stranu rozděleného pole
		//------------------------------------------------------------
		MergeSortNumbers(LeftHalf);
		MergeSortNumbers(RightHalf);
		//------------------------------------------------------------

		Values.clear(); //vymazání všeho v `Values`

		//----------------------------------------------------------------------
		//cyklické opakování, dokud není délka levé, nebo pravé poloviny rovna 0
		//----------------------------------------------------------------------
		while (LeftHalf.size() != 0 && RightHalf.size() != 0)
		{
			//když je vybraný prvek `LeftHalf` menší, nebo roven vybranému prvku `RightHalf`, tak je z `LeftHalf` zařazen do `Values` & vymazán z `LeftHalf`
			if (LeftHalf.get(0) <= RightHalf.get(0))
			{
				Values.add(LeftHalf.get(0));
				LeftHalf.remove(0);
			}
			//jinak je prvek z `RightHalf` zařazen do `Values` & vymazán z `RightHalf`
			else
			{
				Values.add(RightHalf.get(0));
				RightHalf.remove(0);
			}
		}
		//----------------------------------------------------------------------

		//----------------------------------------------------------------------------------------
		//pokud v `LeftHalf` zbyde nějaký prvek, tak je zařazen do `Values` & vymazán z `LeftHalf`
		//----------------------------------------------------------------------------------------
		while (LeftHalf.size() != 0)
		{
			Values.add(LeftHalf.get(0));
			LeftHalf.remove(0);
		}
		//----------------------------------------------------------------------------------------

		//------------------------------------------------------------------------------------------
		//pokud v `RightHalf` zbyde nějaký prvek, tak je zařazen do `Values` & vymazán z `RightHalf`
		//------------------------------------------------------------------------------------------
		while (RightHalf.size() != 0)
		{
			Values.add(RightHalf.get(0));
			RightHalf.remove(0);
		}
		//------------------------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Merge sort - řetězce
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí řetězcové hodnoty v poli pomocí algoritmu {@code Merge Sort}.
	 * <p> {@code Merge Sort} rozdělí pole na levou & pravou polovinu, ty pak seřadí sám sebou & nakonec všechny poloviny spojí do jednoho seřazeného pole. </p>
	 * 
	 * @param Values : {@code ArrayList<String>} - pole řetězcových hodnot k seřazení
	 * 
	 * @return {@code ArrayList<String>} - seřazené pole řetězcových hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> MergeSortStrings(final ArrayList<String> Values) 
	{
		//pokud je počet prvků v poli `Values` 1 & menší [pole je seřazeno], tak se vrátí pole `Values` z metody / rekurzivního volání
		if (Values.size() <= 1) return Values;

		ArrayList<String> LeftHalf = new ArrayList<String>(0); //měnitelný objekt třídy ArrayList<String> pro dynamické uložení levé poloviny rozděleného pole
		ArrayList<String> RightHalf = new ArrayList<String>(0); //měnitelný objekt třídy ArrayList<String> pro dynamické uložení pravé poloviny rozděleného pole

		//prohledání pole prvek po prvku & hodnoty s pozicí menší, než polovina délky pole jsou dány do `LeftHalf`, ostatní do `RightHalf`
		for (int c = 0; c < Values.size(); c++)
		{
			//pokud je pozice prvku menší, než polovina délky pole, tak je hodnota prvku uložena do `LeftHalf`
			if (c < Values.size() / 2) LeftHalf.add(Values.get(c));
			else RightHalf.add(Values.get(c)); //jinak je hodnota prvku uložena do `RightHalf`
		}

		//------------------------------------------------------------
		//rekurzivní volání pro levou & pravou stranu rozděleného pole
		//------------------------------------------------------------
		MergeSortStrings(LeftHalf);
		MergeSortStrings(RightHalf);
		//------------------------------------------------------------

		Values.clear(); //vymazání všeho v `Values`

		//----------------------------------------------------------------------
		//cyklické opakování, dokud není délka levé, nebo pravé poloviny rovna 0
		//----------------------------------------------------------------------
		while (LeftHalf.size() != 0 && RightHalf.size() != 0)
		{
			int LetterPos = 0;  //pozice znaku k porovnání v řetězcích

			//---------------------------------------------------------------------------------------------------------
			//prohledávání znak po znaku jednoho řetězce z pole, dokud alepoň jednomu z nich nedojdou znaky k porovnání
			//---------------------------------------------------------------------------------------------------------
			while (LeftHalf.get(0).length() > LetterPos && RightHalf.get(0).length() > LetterPos)
			{
				//když se znaky rovnají, tak jde se na další znak v pořadí
				if (LeftHalf.get(0).charAt(LetterPos) == RightHalf.get(0).charAt(LetterPos)) { LetterPos++; }
				//pokud je vybraný znak z `LeftHalf` menší, než vybraný znak z `RightHalf`, tak je z `LeftHalf` zařazen do `Values` & vymazán z `LeftHalf` & cyklus končí
				else if (LeftHalf.get(0).charAt(LetterPos) < RightHalf.get(0).charAt(LetterPos))
				{
					Values.add(LeftHalf.get(0));
					LeftHalf.remove(0); break;
				}
				//jinak je prvek z `RightHalf` zařazen do `Values` & vymazán z `RightHalf` & cyklus končí
				else
				{
					Values.add(RightHalf.get(0));
					RightHalf.remove(0); break;
				}
			}
		}
		//----------------------------------------------------------------------

		//----------------------------------------------------------------------------------------
		//pokud v `LeftHalf` zbyde nějaký prvek, tak je zařazen do `Values` & vymazán z `LeftHalf`
		//----------------------------------------------------------------------------------------
		while (LeftHalf.size() != 0)
		{
			Values.add(LeftHalf.get(0));
			LeftHalf.remove(0);
		}
		//----------------------------------------------------------------------------------------

		//------------------------------------------------------------------------------------------
		//pokud v `RightHalf` zbyde nějaký prvek, tak je zařazen do `Values` & vymazán z `RightHalf`
		//------------------------------------------------------------------------------------------
		while (RightHalf.size() != 0)
		{
			Values.add(RightHalf.get(0));
			RightHalf.remove(0);
		}
		//------------------------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Bucket sort - čísla
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí číselné hodnoty v poli pomocí algoritmu {@code Bucket Sort}.
	 * <p> {@code Bucket Sort} Rozdělí prvky pole do stanoveného počtu kbelíků, ty pak seřadí jiným algoritmem [v tomto případě - {@code Quick Sort}] & nakonec spojí kbelíky do jednoho seřazeného pole. </p>
	 * 
	 * @param Values : {@code ArrayList<Long>} - pole číselných hodnot k seřazení
	 * @param BucketCount : {@code int} - počet kbelíků pro rozdělení pole k seřazení
	 * 
	 * @return {@code ArrayList<Long>} - seřazené pole číselných hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> BucketSortNumbers(final ArrayList<Long> Values, final int BucketCount)
	{
		//pokud je počet prvků v poli `Values` 1 & menší [pole je seřazeno], nebo je `BucketCount` menší, nebo rovno 0 [nejde], tak se vrátí pole `Values` z metody
		if (Values.size() <= 1 || BucketCount <= 0) return Values;

		ArrayList<ArrayList<Long>> Buckets = new ArrayList<ArrayList<Long>>(0); //měnitelný objekt třídy ArrayList<ArrayList<Long>> pro dynamické uložení kbelíků
		long BiggestElem = 0; //proměnná pro uložení hodnoty největšího prvku v poli `Values`
		
		//------------------------------------------------
		//opakování `BucketCount`-krát & vytvoření kbelíků
		//------------------------------------------------
		for (int c = 0; c < BucketCount; c++)
		{			
			ArrayList<Long> NewBucket = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> přestavující jeden kbelík

			Buckets.add(NewBucket); //přidání kbelíku `NewBucket` do ostatním v `Buckets`
		}
		//------------------------------------------------

		//prohledání pole prvek po prvku & nalezení největšího prvku
		for (int c = 0; c < Values.size(); c++)
		{
			//pokud je vybraný prvek větší, než `BiggestElem`, tak dojde jeho uložení do `BiggestElem`
			if (Values.get(c) > BiggestElem) BiggestElem = Values.get(c);
		}

		BiggestElem++; //zvýšení `BiggestElem` o 1

		//prohledání pole prvek po prvku & uložení každého prvku do správného kbelíku
		for (int c = 0; c < Values.size(); c++)
		{
			//prvek je zařazen do kbelíku v `Buckets` s pozicí `BucketCount` × hodnota vybraného prvku ÷ `BiggestElem` [useknuto na celé číslo]
			Buckets.get((int)Math.floor(BucketCount * Values.get(c) / BiggestElem)).add(Values.get(c));
		}

		//---------------------------------------------------------
		//Použití algoritmu `Quick Sort` na každý prvek v `Buckets`
		//---------------------------------------------------------
		for (int c = 0; c < BucketCount; c++)
		{
			//když je v kbelíku 0 nebo jeden prvek, nemá smysl to seřazovat, jde se na další
			if (Buckets.get(c).size() == 0 || Buckets.get(c).size() == 1) continue;

			//spuštění algoritmu + vrácení seřazených hodnot
			QuickSortNumbers(Buckets.get(c), 0, Buckets.get(c).size() - 1);
		}
		//---------------------------------------------------------
		
		Values.clear(); //vymazání všeho v `Values`

		//---------------------------------------------------------------------------
		//prohledání prvek po prvku pole `Buckets` & spojení kbelíků do pole `Values`
		//---------------------------------------------------------------------------
		for (int c = 0; c < BucketCount; c++)
		{
			//přidání prvek po prvku každý prvek do pole `Values`
			for (int cc = 0; cc < Buckets.get(c).size(); cc++)
			{
				Values.add(Buckets.get(c).get(cc));
			}
		}
		//---------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}


	//Bucket sort - řetězce
	/**
	 * Veřejná metoda třídy {@code SortingAlgorithms} - Seřadí řetězcové hodnoty v poli pomocí algoritmu {@code Bucket Sort}.
	 * <p> {@code Bucket Sort} Rozdělí prvky pole do stanoveného počtu kbelíků, ty pak seřadí jiným algoritmem [v tomto případě - {@code Quick Sort}] & nakonec spojí kbelíky do jednoho seřazeného pole. </p>
	 * 
	 * @param Values : {@code ArrayList<String>} - pole řetězcových hodnot k seřazení
	 * @param BucketCount : {@code int} - počet kbelíků pro rozdělení pole k seřazení
	 * 
	 * @return {@code ArrayList<String>} - seřazené pole řetězcových hodnot
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> BucketSortStrings(final ArrayList<String> Values, final int BucketCount)
	{
		//pokud je počet prvků v poli `Values` 1 & menší [pole je seřazeno], nebo je `BucketCount` menší, nebo rovno 0 [nejde] tak se vrátí pole `Values` z metody
		if (Values.size() <= 1 || BucketCount <= 0) return Values;

		ArrayList<ArrayList<String>> Buckets = new ArrayList<ArrayList<String>>(0); //měnitelný objekt třídy ArrayList<ArrayList<String>> pro dynamické uložení kbelíků
		String BiggestElem = " "; //řetězec pro uložení hodnoty největšího prvku v poli `Values`
		
		//------------------------------------------------
		//opakování `BucketCount`-krát & vytvoření kbelíků
		//------------------------------------------------
		for (int c = 0; c < BucketCount; c++)
		{			
			ArrayList<String> NewBucket = new ArrayList<String>(0); //měnitelný objekt třídy ArrayList<String> přestavující jeden kbelík

			Buckets.add(NewBucket); //přidání kbelíku `NewBucket` do ostatním v `Buckets`
		}
		//------------------------------------------------

		//----------------------------------------------------------
		//prohledání pole prvek po prvku & nalezení největšího prvku
		//----------------------------------------------------------
		for (int c = 0; c < Values.size(); c++)
		{
			int LetterPos = 0; //pozice znaku k porovnání v řetězcích

			//---------------------------------------------------------------------------------------------------------
			//prohledávání znak po znaku jednoho řetězce z pole, dokud alepoň jednomu z nich nedojdou znaky k porovnání
			//---------------------------------------------------------------------------------------------------------
			while (Values.get(c).length() > LetterPos && BiggestElem.length() > LetterPos)
			{
				//když se znaky rovnají, tak jde se na další znak v pořadí
				if (Values.get(c).charAt(LetterPos) == BiggestElem.charAt(LetterPos)) { LetterPos++; }
				//pokud je vybraný znak z `Values`, než vybraný znak z `BiggestElem`, tak dojde jeho uložení do `BiggestElem` & cyklus končí
				else if (Values.get(c).charAt(LetterPos) > BiggestElem.charAt(LetterPos)) { BiggestElem = Values.get(c); break; }
				else break; //jinak k uložení nedojde & cyklus končí
			}
		}
		//----------------------------------------------------------

		//prohledání pole prvek po prvku & uložení každého prvku do správného kbelíku
		for (int c = 0; c < Values.size(); c++)
		{
			//prvek je zařazen do kbelíku v `Buckets` s pozicí `BucketCount` × hodnota prvního znaku vybraného prvku ÷ hodnotou prvního znaku z `BiggestElem` [useknuto na celé číslo]
			Buckets.get((int)Math.floor(BucketCount * Values.get(c).charAt(0) / (BiggestElem.charAt(0) + 0x01))).add(Values.get(c));
		}

		//---------------------------------------------------------
		//Použití algoritmu `Quick Sort` na každý prvek v `Buckets`
		//---------------------------------------------------------
		for (int c = 0; c < BucketCount; c++)
		{
			//když je v kbelíku 0 nebo jeden prvek, nemá smysl to seřazovat, jde se na další
			if (Buckets.get(c).size() == 0 || Buckets.get(c).size() == 1) continue;

			//spuštění algoritmu + vrácení seřazených hodnot
			QuickSortStrings(Buckets.get(c), 0, Buckets.get(c).size() - 1);
		}
		//---------------------------------------------------------

		Values.clear(); //vymazání všeho v `Values`

		//---------------------------------------------------------------------------
		//prohledání prvek po prvku pole `Buckets` & spojení kbelíků do pole `Values`
		//---------------------------------------------------------------------------
		for (int c = 0; c < BucketCount; c++)
		{
			//přidání prvek po prvku každý prvek do pole `Values`
			for (int cc = 0; cc < Buckets.get(c).size(); cc++)
			{
				Values.add(Buckets.get(c).get(cc));
			}
		}
		//---------------------------------------------------------------------------

		return Values; //vrácení pole `Values` z metody
	}
}