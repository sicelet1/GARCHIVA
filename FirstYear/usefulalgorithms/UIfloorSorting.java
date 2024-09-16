package usefulalgorithms;

import java.util.ArrayList;


/**
 * Třída obsahující "Měřiče" výkonu jednotlivých seřazovacích algoritmů.
 * <p> Napojuje se na UI rozcestníky pro seřazovací algoritmy v {@code UIfloor2}. </p>
 * <p> + dědí vlastnosti třídy {@code usefulalgorithms.UItextStorage}. </p>
 * <p> + Spouští algoritmy v {@code SortingAlgorithms}. </p>
 * <p> Příklad instance: <blockquote> <pre> {@code private final UIfloorSorting myObj = new UIfloorSorting();} </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class UIfloorSorting extends usefulalgorithms.UItextStorage
{
	/**
	 * Veřejný konstruktor třídy druhého patra UI - {@code UIfloorSorting}.
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public UIfloorSorting() {};

	//-----------------------------------------------------------------------------------------------
	//konstrukce neměnitelných soukromých objektů jiných tříd pro tuto třídu [volají se konstruktory]
	//-----------------------------------------------------------------------------------------------
	private final usefulalgorithms.MainUI UIbuilder = new MainUI(); //z třídy MainUI - pro sestavování textového UI
	private final usefulalgorithms.SortingAlgorithms sorts = new SortingAlgorithms(); //z třídy SortingAlgorithms - pro použití seřazovacích algoritmů
	//-----------------------------------------------------------------------------------------------


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 1 v {@code UIsortingStrings()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Bubble Sort} algoritmem, pro řetězce hodnot] </p>
	 * 
	 * @param FileValues : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<String>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIfloorBubbleSortStrings(ArrayList<String> FileValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	
		//spuštění algoritmu + vrácení seřazených hodnot
		FileValues = sorts.BubbleSortStrings(FileValues);
	
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `FileValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return FileValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 2 v {@code UIsortingStrings()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Selection Sort} algoritmem, pro řetězce hodnot] </p>
	 * 
	 * @param FileValues : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<String>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIfloorSelectionSortStrings(ArrayList<String> FileValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		FileValues = sorts.SelectionSortStrings(FileValues);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `FileValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return FileValues; 
		//-------------------------------------------------------------------------------------------
	}

	
	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 3 v {@code UIsortingStrings()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Insertion Sort} algoritmem, pro řetězce hodnot] </p>
	 * 
	 * @param FileValues : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<String>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIfloorInsertionSortStrings(ArrayList<String> FileValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		FileValues = sorts.InsertionSortStrings(FileValues);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `FileValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return FileValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 4 v {@code UIsortingStrings()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Quick Sort} algoritmem, pro řetězce hodnot] </p>
	 * 
	 * @param FileValues : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<String>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIfloorQuickSortStrings(ArrayList<String> FileValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		FileValues = sorts.QuickSortStrings(FileValues, 0, FileValues.size() - 1);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `FileValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return FileValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 5 v {@code UIsortingStrings()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Merge Sort} algoritmem, pro řetězce hodnot] </p>
	 * 
	 * @param FileValues : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<String>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIfloorMergeSortStrings(ArrayList<String> FileValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		FileValues = sorts.MergeSortStrings(FileValues);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `FileValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return FileValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 6 v {@code UIsortingStrings()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Bucket Sort} algoritmem, pro řetězce hodnot] </p>
	 * 
	 * @param FileValues : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<String>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIfloorBucketSortStrings(ArrayList<String> FileValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//spuštění algoritmu + vrácení seřazených hodnot
		FileValues = sorts.BucketSortStrings(FileValues, (int)Math.floor(FileValues.size() / 2));
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `FileValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return FileValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 1 v {@code UIsortingNumbers()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Bubble Sort} algoritmem, pro celé číselné hodnoty] </p>
	 * 
	 * @param FileValues : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<Long>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIfloorBubbleSortNumbers(ArrayList<Long> NumberValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	
		//spuštění algoritmu + vrácení seřazených hodnot
		NumberValues = sorts.BubbleSortNumbers(NumberValues);
	
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `NumberValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return NumberValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 2 v {@code UIsortingNumbers()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Selection Sort} algoritmem, pro celé číselné hodnoty] </p>
	 * 
	 * @param FileValues : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<Long>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIfloorSelectionSortNumbers(ArrayList<Long> NumberValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		NumberValues = sorts.SelectionSortNumbers(NumberValues);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `NumberValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return NumberValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 3 v {@code UIsortingNumbers()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Insertion Sort} algoritmem, pro celé číselné hodnoty] </p>
	 * 
	 * @param FileValues : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<Long>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIfloorInsertionSortNumbers(ArrayList<Long> NumberValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		NumberValues = sorts.InsertionSortNumbers(NumberValues);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `NumberValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return NumberValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 4 v {@code UIsortingNumbers()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Quick Sort} algoritmem, pro celé číselné hodnoty] </p>
	 * 
	 * @param FileValues : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<Long>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIfloorQuickSortNumbers(ArrayList<Long> NumberValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		NumberValues = sorts.QuickSortNumbers(NumberValues, 0, NumberValues.size() - 1);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `NumberValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return NumberValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 5 v {@code UIsortingNumbers()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Merge Sort} algoritmem, pro celé číselné hodnoty] </p>
	 * 
	 * @param FileValues : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<Long>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIfloorMergeSortNumbers(ArrayList<Long> NumberValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	 
		//spuštění algoritmu + vrácení seřazených hodnot
		NumberValues = sorts.MergeSortNumbers(NumberValues);
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `NumberValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return NumberValues; 
		//-------------------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloorSorting} - spouští seřazovací algoritmus & měří jeho výkon pro možnost 6 v {@code UIsortingNumbers()} ve třídě {@code UIfloor2}.
	 * <p> [Tato metoda operuje s {@code Bucket Sort} algoritmem, pro celé číselné hodnoty] </p>
	 * 
	 * @param FileValues : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * 
	 * @return {@code ArrayList<Long>} - hodnoty seřazené algoritmem podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIfloorBucketSortNumbers(ArrayList<Long> NumberValues)
	{
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//spuštění algoritmu + vrácení seřazených hodnot
		NumberValues = sorts.BucketSortNumbers(NumberValues, (int)Math.floor(NumberValues.size() / 2));
	 
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		//-------------------------------------------------------------------------------------------
		//sestavení UI menu pro vytištění doby běhu algoritmu + vrácení hodnoty `NumberValues` z metody
		//-------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		System.out.print("\nDoba seřazování: " + (sysTime1 - sysTime0) + " milisekund!"); return NumberValues; 
		//-------------------------------------------------------------------------------------------
	}
}