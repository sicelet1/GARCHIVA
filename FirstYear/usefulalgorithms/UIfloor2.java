package usefulalgorithms;

import java.util.ArrayList;


/**
 * Třída obsahující komplexní UI rozcestníky & menu pro zadávání vstupů.
 * <p> Obsahuje další UI možnosti pro každou existující vstupní možnost v {@code UIfloor1}. </p>
 * <p> + dědí vlastnosti třídy {@code usefulalgorithms.UItextStorage}. </p>
 * <p> + Spouští algoritmy v {@code numberAlgorithms}. </p>
 * <p> Příklad instance: <blockquote> <pre> {@code private final UIfloor2 myObj = new UIfloor2();} </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class UIfloor2 extends usefulalgorithms.UItextStorage
{
	/**
	 * Veřejný konstruktor třídy druhého patra UI - {@code UIfloor2}.
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public UIfloor2() {}

	//-----------------------------------------------------------------------------------------------
	//konstrukce neměnitelných soukromých objektů jiných tříd pro tuto třídu [volají se konstruktory]
	//-----------------------------------------------------------------------------------------------
	private final usefulalgorithms.MainUI UIbuilder = new MainUI(); //z třídy MainUI - pro sestavování textového UI
	private final usefulalgorithms.UIfloorSorting UIsorts = new UIfloorSorting(); //z třídy UIfloorSorting - použití & změření seřazovacích algoritmů
	private final usefulalgorithms.NumberAlgorithms nums = new NumberAlgorithms(); //z třídy NumberAlgorithms - pro použití číselných algoritmů
	private final usefulalgorithms.FileOperator fileIO = new FileOperator(); //z třídy FileOperator - čtení z/zápis do souborů
	private final usefulalgorithms.Valid validator = new Valid(); //z třídy Valid - kontrola uživatelských vstupů
	//-----------------------------------------------------------------------------------------------

	//------------------------------
	//Konstrukce řetězcových objektů
	//------------------------------
	private String mUI = new String(); //měnitelný soukromý objekt třídy String pro uživatelské vstupy
	private String InBuf = new String(); //měnitelný objekt třídy String pro krátkodobé uložení vstupní hodnoty
	//------------------------------


	/**
	 * Veřejná metoda třídy {@code UIfloor2} - provádí algoritmus & funcionalitu okolo pro možnost 1 v {@code UIrandomNumbers()} ve třídě {@code UIfloor1}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIpartRandomNumbers()
	{
		//------------------------------
		//Konstrukce řetězcových objektů
		//------------------------------
		String NumberCount = new String(); //měnitelný objekt třídy String pro uložení počtu náhodný čísel k vygenerování
		String MinValue = new String(); //měnitelný objekt třídy String pro uložení nejmenší hodnoty náhodného čísla
		String MaxValue = new String(); //měnitelný objekt třídy String pro uložení největší hodnoty náhodného čísla
		String FileToExport = new String(); //měnitelný objekt třídy String pro uložení názvu souboru pro zapsání vygenerovaných hodnot
		InBuf = new String(); //vyčištění objektu `InBuf`
		//------------------------------
	
		//------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - počtu náhodných čísel
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `NumberCount` je prázdný]
		//------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || NumberCount.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `NumberCount` & `InBuf`
			if (InBuf.equals("\\c")) { NumberCount = new String(); InBuf = new String(); } 
					  
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `NumberCount`]
			if (validator.onlyNumbers(InBuf, 9) == true) NumberCount = InBuf;

			//------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání počtu náhodných čísel + získání uživateského vstupu [String]
			//------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			InBuf = UIbuilder.storageMenuBuild(TitleRandomNumberCount, NumberCount, RandomNumbersManuals[0], AlgorithmsExtraManual);
			//------------------------------------------------------------------------------------------
		} 
		//------------------------------------------------------------------------------------
	
		InBuf = new String(); //vyčištění objektu `InBuf`
	
		//--------------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - nejmenší hodnoty náhodného čísla
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `MinValue` je prázdný]
		//--------------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || MinValue.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `MinValue` & `InBuf`
			if (InBuf.equals("\\c")) { MinValue = new String();  InBuf = new String(); } 
				
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `MinValue`]
			if (validator.onlyNumbers(InBuf, 9) == true) MinValue = InBuf;

			//-----------------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání nejmenší hodnoty náhodného čísla + získání uživateského vstupu [String]
			//-----------------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			UIbuilder.header(TitleRandomNumberCount + NumberCount, TitleRandomNumberCount.length() + NumberCount.length(), false);
			InBuf = UIbuilder.storageMenuBuild(TitleRandomNumberMIN, MinValue, RandomNumbersManuals[1], AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------
		} 
		//--------------------------------------------------------------------------------------------
	
		InBuf = new String(); //vyčištění objektu `InBuf`
	
		//--------------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - největší hodnoty náhodného čísla
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `MaxValue` je prázdný]
		//--------------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || MaxValue.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `MaxValue` & `InBuf`
			if (InBuf.equals("\\c")) { MaxValue = new String();  InBuf = new String(); } 

			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `MaxValue`]
			if (validator.onlyNumbers(InBuf, 9) == true) MaxValue = InBuf;

			//-----------------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání největší hodnoty náhodného čísla + získání uživateského vstupu [String]
			//-----------------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			UIbuilder.header(TitleRandomNumberCount + NumberCount, TitleRandomNumberCount.length() + NumberCount.length(), false);
			UIbuilder.header(TitleRandomNumberMIN + MinValue, TitleRandomNumberMIN.length() + MinValue.length(), false);
			InBuf = UIbuilder.storageMenuBuild(TitleRandomNumberMAX, MaxValue, RandomNumbersManuals[2], AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------
		} 
		//--------------------------------------------------------------------------------------------

		//------------------------------------------------------------------------------------------------------
		//sestavení UI menu pro získání podtvrzení pro spuštění algoritmu + získání uživateského vstupu [String]
		//------------------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
		UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
		UIbuilder.header(TitleRandomNumberCount + NumberCount, TitleRandomNumberCount.length() + NumberCount.length(), false);
		UIbuilder.header(TitleRandomNumberMIN + MinValue, TitleRandomNumberMIN.length() + MinValue.length(), false);
		UIbuilder.header(TitleRandomNumberMAX + MaxValue, TitleRandomNumberMAX.length() + MaxValue.length(), false);
		mUI = UIbuilder.smallMenuBuild(NumberAlgorithmsSTARTmenu);
		//------------------------------------------------------------------------------------------------------

		while (true) //mini-rozcestník - podtvrzení pro spuštění algoritmu
		{   
			if (mUI.equals("0")) return; //vrácení se z metody
			else if(mUI.equals("1")) break; //ukončení smyčky
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
	
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
								
		//spuštění algoritmu + vrácení vygenerovaných hodnot
		ArrayList<Integer> randNums = nums.RandomNumberSequence(Long.parseLong(NumberCount), Integer.parseInt(MinValue), Integer.parseInt(MaxValue));
	
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		InBuf = new String(); //vyčištění objektu `InBuf`

		//-------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - názvu výstupního souboru
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `FileToExport` je prázdný]
		//-------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || FileToExport.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `FileToExport` & `InBuf`
			if (InBuf.equals("\\c")) { FileToExport = new String(); InBuf = new String(); }
		
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `FileToExport`]
			if (validator.validfilename(InBuf) == true) FileToExport = InBuf;
		
			//-----------------------------------------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání názvu výstupního souboru + vytištění doby běhu algoritmu + získání uživateského vstupu [String]
			//-----------------------------------------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false);
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			System.out.print("\nHotovo!\n\nDoba generování: " + (sysTime1 - sysTime0) + " milisekund!\n\n");
			InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToExport, NumberFileManual, AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------------------------------
		}
		//-------------------------------------------------------------------------------------

		ArrayList<Long> randNumsToWrite = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> - přetypování z ArrayList<Integer>

		//prvek po prvku z `randNums` z int přetypování na long do `randNumsToWrite`, kvůli zápisu do souboru
		for (int elem : randNums) randNumsToWrite.add((long)elem); 

		//zapsání hodnot dynamického pole do nového/existujícího souboru [1 prvek = nový řádek] + vrácení se z metody
		fileIO.numWriteToNew(FileToExport, randNumsToWrite); return;
	}


	/**
	 * Veřejná metoda třídy {@code UIfloor2} - provádí algoritmus & funcionalitu okolo pro možnost 2 v {@code UIrandomNumbers()} ve třídě {@code UIfloor1}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIpartRandomPasswords()
	{
		//------------------------------
		//Konstrukce řetězcových objektů
		//------------------------------
		String PasswordCount = new String(); //měnitelný objekt třídy String pro uložení počtu náhodně vygenerovaných hesel
		String PasswordLength = new String(); //měnitelný objekt třídy String pro uložení délky náhodně vygenerovaného hesla
		String FileToExport = new String(); //měnitelný objekt třídy String pro uložení názvu souboru pro zapsání vygenerovaných hodnot
		InBuf = new String(); //vyčištění objektu `InBuf`
		//------------------------------

		//--------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - počtu náhodných hesel
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `PasswordCount` je prázdný]
		//--------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || PasswordCount.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `PasswordCount` & `InBuf`
			if (InBuf.equals("\\c")) { PasswordCount = new String(); InBuf = new String(); }
				
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `PasswordCount`]
			if (validator.onlyNumbers(InBuf, 9) == true) PasswordCount = InBuf;

			//------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání počtu náhodných hesel + získání uživateského vstupu [String]
			//------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			InBuf = UIbuilder.storageMenuBuild(TitleRandomPasswordCount, PasswordCount, RandomPasswordsManuals[0], AlgorithmsExtraManual);
			//------------------------------------------------------------------------------------------
		}
		//--------------------------------------------------------------------------------------
	
		InBuf = new String(); //vyčištění objektu `InBuf`
	
		//---------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - délky náhodného hesla
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `PasswordLength` je prázdný]
		//---------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || PasswordLength.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `PasswordLength` & `InBuf`
			if (InBuf.equals("\\c")) { PasswordLength = new String(); InBuf = new String(); }
				
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `PasswordLength`]
			if (validator.onlyNumbers(InBuf, 9) == true) PasswordLength = InBuf;

			//------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání délky náhodného hesla + získání uživateského vstupu [String]
			//------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			UIbuilder.header(TitleRandomPasswordCount + PasswordCount, TitleRandomPasswordCount.length() + PasswordCount.length(), false);
			InBuf = UIbuilder.storageMenuBuild(TitleRandomPasswordLength, PasswordLength, RandomPasswordsManuals[1], AlgorithmsExtraManual);
			//------------------------------------------------------------------------------------------
		} 
		//---------------------------------------------------------------------------------------
	
		//------------------------------------------------------------------------------------------------------
		//sestavení UI menu pro získání podtvrzení pro spuštění algoritmu + získání uživateského vstupu [String]
		//------------------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
		UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
		UIbuilder.header(TitleRandomPasswordCount + PasswordCount, TitleRandomPasswordCount.length() + PasswordCount.length(), false);
		UIbuilder.header(TitleRandomPasswordLength + PasswordLength, TitleRandomPasswordLength.length() + PasswordLength.length(), false);
		mUI = UIbuilder.smallMenuBuild(NumberAlgorithmsSTARTmenu);
		//------------------------------------------------------------------------------------------------------

		while (true) //mini-rozcestník - podtvrzení pro spuštění algoritmu
		{
			if (mUI.equals("0")) return; //vrácení se z metody
			else if(mUI.equals("1")) break; //ukončení smyčky
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
	
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
	
		//spuštění algoritmu + vrácení vygenerovaných hodnot
		ArrayList<String> randPass = nums.RandomPasswordSequence(Long.parseLong(PasswordCount), Long.parseLong(PasswordLength));
	
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		InBuf = new String(); //vyčištění objektu `InBuf`

		//-------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - názvu výstupního souboru
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `FileToExport` je prázdný]
		//-------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || FileToExport.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `FileToExport` & `InBuf`
			if (InBuf.equals("\\c")) { FileToExport = new String(); InBuf = new String(); }
		
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `FileToExport`]
			if (validator.validfilename(InBuf) == true) FileToExport = InBuf;
		
			//-----------------------------------------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání názvu výstupního souboru + vytištění doby běhu algoritmu + získání uživateského vstupu [String]
			//-----------------------------------------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false);
			UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
			System.out.print("\nHotovo!\n\nDoba generování: " + (sysTime1 - sysTime0) + " milisekund!\n\n");
			InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToExport, NumberFileManual, AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------------------------------
		}
		//-------------------------------------------------------------------------------------

		//zapsání hodnot dynamického pole do nového/existujícího souboru [1 prvek = nový řádek] + vrácení se z metody
		fileIO.writeToNew(FileToExport, randPass); return;
	}

	/**
	 * Veřejná metoda třídy {@code UIfloor2} - provádí algoritmus & funcionalitu okolo pro možnost 1 v {@code UIprimeNumbers()} ve třídě {@code UIfloor1}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIpartStandardPrimeNumbers()
	{
		//------------------------------
		//Konstrukce řetězcových objektů
		//------------------------------
		String PrimeNumMIN = new String(); //měnitelný objekt třídy String pro uložení začátku prvočíselné řady
		String PrimeNumMAX = new String(); //měnitelný objekt třídy String pro uložení konce prvočíselné řady
		String FileToExport = new String(); //měnitelný objekt třídy String pro uložení názvu souboru pro zapsání vygenerovaných hodnot
		InBuf = new String(); //vyčištění objektu `InBuf`
		//------------------------------
	
		//------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - začátku prvočíselné řady
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `PrimeNumMIN` je prázdný]
		//------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || PrimeNumMIN.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `PrimeNumMIN` & `InBuf`
			if (InBuf.equals("\\c")) { PrimeNumMIN = new String(); InBuf = new String(); }
			
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `PrimeNumMIN`]
			if (validator.onlyNumbers(InBuf, 9) == true) PrimeNumMIN = InBuf;

			//---------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání začátku prvočíselné řady + získání uživateského vstupu [String]
			//---------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			InBuf = UIbuilder.storageMenuBuild(TitlePrimeNumbersMIN, PrimeNumMIN, PrimeNumbersManuals[0], AlgorithmsExtraManual);
			//---------------------------------------------------------------------------------------------
		}
		//------------------------------------------------------------------------------------
	
		InBuf = new String(); //vyčištění objektu `InBuf`
	
		//------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - konce prvočíselné řady
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `PrimeNumMAX` je prázdný]
		//------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || PrimeNumMAX.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `PrimeNumMAX` & `InBuf`
			if (InBuf.equals("\\c")) { PrimeNumMAX = new String(); InBuf = new String(); } 
				
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `PrimeNumMAX`]
			if (validator.onlyNumbers(InBuf, 9) == true) PrimeNumMAX = InBuf;

			//-------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání konce prvočíselné řady + získání uživateského vstupu [String]
			//-------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			UIbuilder.header(TitlePrimeNumbersMIN + PrimeNumMIN, TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), false);
			InBuf = UIbuilder.storageMenuBuild(TitlePrimeNumbersMAX, PrimeNumMAX, PrimeNumbersManuals[1], AlgorithmsExtraManual);
			//-------------------------------------------------------------------------------------------
		}
		//------------------------------------------------------------------------------------
	
		//------------------------------------------------------------------------------------------------------
		//sestavení UI menu pro získání podtvrzení pro spuštění algoritmu + získání uživateského vstupu [String]
		//------------------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
		UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
		UIbuilder.header(TitlePrimeNumbersMIN + PrimeNumMIN, TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), false);
		UIbuilder.header(TitlePrimeNumbersMAX + PrimeNumMAX, TitlePrimeNumbersMAX.length() + PrimeNumMAX.length(), false);
		mUI = UIbuilder.smallMenuBuild(NumberAlgorithmsSTARTmenu);
		//------------------------------------------------------------------------------------------------------

		while (true) //mini-rozcestník - podtvrzení pro spuštění algoritmu
		{
			if (mUI.equals("0")) return; //vrácení se z metody
			else if(mUI.equals("1")) break; //ukončení smyčky
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
	
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
  
		//spuštění algoritmu + vrácení vygenerovaných hodnot
		ArrayList<Long> primeNums = nums.PrimeNumberGenerator(Long.parseLong(PrimeNumMIN), Long.parseLong(PrimeNumMAX));
   
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		InBuf = new String(); //vyčištění objektu `InBuf`

		//-------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - názvu výstupního souboru
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `FileToExport` je prázdný]
		//-------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || FileToExport.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `FileToExport` & `InBuf`
			if (InBuf.equals("\\c")) { FileToExport = new String(); InBuf = new String(); }
		
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `FileToExport`]
			if (validator.validfilename(InBuf) == true) FileToExport = InBuf;
		
			//-----------------------------------------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání názvu výstupního souboru + vytištění doby běhu algoritmu + získání uživateského vstupu [String]
			//-----------------------------------------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false);
			UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
			System.out.print("\nHotovo!\n\nDoba generování: " + (sysTime1 - sysTime0) + " milisekund!\n\n");
			InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToExport, NumberFileManual, AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------------------------------
		}

		//zapsání hodnot dynamického pole do nového/existujícího souboru [1 prvek = nový řádek] + vrácení se z metody
		fileIO.numWriteToNew(FileToExport, primeNums); return;
	}


	/**
	 * Veřejná metoda třídy {@code UIfloor2} - provádí algoritmus & funcionalitu okolo pro možnost 2 v {@code UIprimeNumbers()} ve třídě {@code UIfloor1}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIpartOptimisedPrimeNumbers()
	{
		//------------------------------
		//Konstrukce řetězcových objektů
		//------------------------------
		String PrimeNumMIN = new String(); //měnitelný objekt třídy String pro uložení začátku prvočíselné řady
		String PrimeNumMAX = new String(); //měnitelný objekt třídy String pro uložení konce prvočíselné řady
		String FileToExport = new String(); //měnitelný objekt třídy String pro uložení názvu souboru pro zapsání vygenerovaných hodnot
		InBuf = new String(); //vyčištění objektu `InBuf`
		//------------------------------

		//------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - začátku prvočíselné řady
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `PrimeNumMIN` je prázdný]
		//------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || PrimeNumMIN.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `PrimeNumMIN` & `InBuf`
			if (InBuf.equals("\\c")) { PrimeNumMIN = new String(); InBuf = new String(); }
			
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `PrimeNumMIN`]
			if (validator.onlyNumbers(InBuf, 9) == true) PrimeNumMIN = InBuf;

			//---------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání začátku prvočíselné řady + získání uživateského vstupu [String]
			//---------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			InBuf = UIbuilder.storageMenuBuild(TitlePrimeNumbersMIN, PrimeNumMIN, PrimeNumbersManuals[0], AlgorithmsExtraManual);
			//---------------------------------------------------------------------------------------------
		}
		//------------------------------------------------------------------------------------
	
		InBuf = new String(); //vyčištění objektu `InBuf`
	
		//------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - konce prvočíselné řady
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `PrimeNumMAX` je prázdný]
		//------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || PrimeNumMAX.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `PrimeNumMAX` & `InBuf`
			if (InBuf.equals("\\c")) { PrimeNumMAX = new String(); InBuf = new String(); } 
				
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `PrimeNumMAX`]
			if (validator.onlyNumbers(InBuf, 9) == true) PrimeNumMAX = InBuf;

			//-------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání konce prvočíselné řady + získání uživateského vstupu [String]
			//-------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			UIbuilder.header(TitlePrimeNumbersMIN + PrimeNumMIN, TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), false);
			InBuf = UIbuilder.storageMenuBuild(TitlePrimeNumbersMAX, PrimeNumMAX, PrimeNumbersManuals[1], AlgorithmsExtraManual);
			//-------------------------------------------------------------------------------------------
		}
		//------------------------------------------------------------------------------------
	
		//------------------------------------------------------------------------------------------------------
		//sestavení UI menu pro získání podtvrzení pro spuštění algoritmu + získání uživateského vstupu [String]
		//------------------------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
		UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
		UIbuilder.header(TitlePrimeNumbersMIN + PrimeNumMIN, TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), false);
		UIbuilder.header(TitlePrimeNumbersMAX + PrimeNumMAX, TitlePrimeNumbersMAX.length() + PrimeNumMAX.length(), false);
		mUI = UIbuilder.smallMenuBuild(NumberAlgorithmsSTARTmenu);
		//------------------------------------------------------------------------------------------------------

		while (true) //mini-rozcestník - podtvrzení pro spuštění algoritmu
		{
			if (mUI.equals("0")) return; //vrácení se z metody
			else if(mUI.equals("1")) break; //ukončení smyčky
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
	
		//----------------------------------------
		//sestavení UI rozhraní při běhu algoritmu
		//----------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
		System.out.print("\nZpracovávání...\n");
		//----------------------------------------

		long sysTime0 = System.currentTimeMillis(); //sejmutí aktuálního systémového času
		
		//spuštění algoritmu + vrácení vygenerovaných hodnot
		ArrayList<Long> primeNums = nums.OptimizedPrimeNumberGenerator(Long.parseLong(PrimeNumMIN), Long.parseLong(PrimeNumMAX));
		
		long sysTime1 = System.currentTimeMillis(); //sejmutí aktuálního systémového času

		InBuf = new String(); //vyčištění objektu `InBuf`

		//-------------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - názvu výstupního souboru
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `FileToExport` je prázdný]
		//-------------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || FileToExport.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `FileToExport` & `InBuf`
			if (InBuf.equals("\\c")) { FileToExport = new String(); InBuf = new String(); }
		
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `FileToExport`]
			if (validator.validfilename(InBuf) == true) FileToExport = InBuf;
		
			//-----------------------------------------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání názvu výstupního souboru + vytištění doby běhu algoritmu + získání uživateského vstupu [String]
			//-----------------------------------------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false);
			UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
			System.out.print("\nHotovo!\n\nDoba generování: " + (sysTime1 - sysTime0) + " milisekund!\n\n");
			InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToExport, NumberFileManual, AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------------------------------
		}

		//zapsání hodnot dynamického pole do nového/existujícího souboru [1 prvek = nový řádek] + vrácení se z metody
		fileIO.numWriteToNew(FileToExport, primeNums); return;
	}


	/**
	 * Veřejná metoda třídy {@code UIfloor2} -  rozšiřující rozcestník pro {@code UIstringSorting()} ve třídě {@code UIfloor1}.
	 * 
	 * @param valsToSort : {@code ArrayList<String>} - hodnoty k seřazení pomocí algoritmu
	 * @param menuUI : {@code String} - řetězec pro uživatelské vstupy
	 * 
	 * @return {@code ArrayList<String>} - seřazené/neseřazené hodnoty, podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> UIsortingStrings(ArrayList<String> valsToSort, String menuUI)
	{
		//------------------------------------------------------------------------------
		//druhý UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (menuUI.length() == 1) //pouze jeden znak ve vstupu
			{
				switch(menuUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0':
					return valsToSort; //vrácení hodnoty `valsToSort` z metody

				case '1':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 1_1] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorBubbleSortStrings(valsToSort); return valsToSort;

				case '2':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 1_2] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorSelectionSortStrings(valsToSort); return valsToSort;

				case '3':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 1_3] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorInsertionSortStrings(valsToSort); return valsToSort;

				case '4':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 1_4] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorQuickSortStrings(valsToSort); return valsToSort;

				case '5':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 1_5] + vrácení hodnoty `valsToSort` z metody
					valsToSort =  UIsorts.UIfloorMergeSortStrings(valsToSort); return valsToSort;

				case '6':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 1_6] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorBucketSortStrings(valsToSort); return valsToSort;

				default:
					menuUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { menuUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
		//------------------------------------------------------------------------------
	}


	/**
	 * Veřejná metoda třídy {@code UIfloor2} -  rozšiřující rozcestník pro {@code UInumberSorting()} ve třídě {@code UIfloor1}.
	 * 
	 * @param valsToSort : {@code ArrayList<Long>} - hodnoty k seřazení pomocí algoritmu
	 * @param menuUI : {@code String} - řetězec pro uživatelské vstupy
	 * 
	 * @return {@code ArrayList<Long>} - seřazené/neseřazené hodnoty, podle výběru uživatele
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<Long> UIsortingNumbers(ArrayList<Long> valsToSort, String menuUI)
	{
		//------------------------------------------------------------------------------
		//druhý UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (menuUI.length() == 1) //pouze jeden znak ve vstupu
			{
				switch(menuUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0':
					return valsToSort; //vrácení hodnoty `valsToSort` z metody

				case '1':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 2_1] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorBubbleSortNumbers(valsToSort); return valsToSort;

				case '2':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 2_2] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorSelectionSortNumbers(valsToSort); return valsToSort;

				case '3':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 2_3] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorInsertionSortNumbers(valsToSort); return valsToSort;

				case '4':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 2_4] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorQuickSortNumbers(valsToSort); return valsToSort;

				case '5':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 2_5] + vrácení hodnoty `valsToSort` z metody
					valsToSort =  UIsorts.UIfloorMergeSortNumbers(valsToSort); return valsToSort;

				case '6':
					//volání metody třídy UIfloorSorting [měřič seřazovacích algoritmů, možnost 2_6] + vrácení hodnoty `valsToSort` z metody
					valsToSort = UIsorts.UIfloorBucketSortNumbers(valsToSort); return valsToSort;

				default:
					menuUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { menuUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
		//------------------------------------------------------------------------------
	}
}