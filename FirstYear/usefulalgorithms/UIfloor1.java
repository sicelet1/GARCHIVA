package usefulalgorithms;

import java.util.ArrayList;
import java.util.Random;


/**
 * Třída obsahující komplexní UI rozcestníky & menu pro zadávání vstupů.
 * <p> Obsahuje další UI možnosti pro každou existující vstupní možnost v {@code mainClass}. </p>
 * <p> + dědí vlastnosti třídy {@code usefulalgorithms.UItextStorage}. </p>
 * <p> Příklad instance: <blockquote> <pre> {@code private final UIfloor1 myObj = new UIfloor1();} </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class UIfloor1 extends usefulalgorithms.UItextStorage
{
	/**
	 * Veřejný konstruktor třídy prvního patra UI - {@code UIfloor1}.
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public UIfloor1() {}

	//-----------------------------------------------------------------------------------------------
	//konstrukce neměnitelných soukromých objektů jiných tříd pro tuto třídu [volají se konstruktory]
	//-----------------------------------------------------------------------------------------------
	private final usefulalgorithms.MainUI UIbuilder = new MainUI(); //z třídy MainUI - pro sestavování textového UI
	private final usefulalgorithms.UIfloor2 floor2 = new UIfloor2(); //z třídy UIfloor1 - další části/funcionality/rozcestníky UI
	private final usefulalgorithms.FileOperator fileIO = new FileOperator(); //z třídy FileOperator - čtení z/zápis do souborů
	private final usefulalgorithms.Valid validator = new Valid(); //z třídy Valid - kontrola uživatelských vstupů
	//-----------------------------------------------------------------------------------------------

	private String mUI = new String(); //měnitelný soukromý objekt třídy String pro uživatelské vstupy

	/**
	 * Veřejná metoda třídy {@code UIfloor1} - rozšiřující rozcestník pro možnost 1 v {@code mainClass}.
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIrandomNumbers()
	{
		//-----------------------------------------------------------------------------
		//sestavení UI menu náhodných generátorů + získání uživateského vstupu [String]
		//-----------------------------------------------------------------------------
		UIbuilder.clearConsole();
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
		mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuRandomNumbersValues, MenuMainENDs);
		//-----------------------------------------------------------------------------

		//------------------------------------------------------------------------------
		//druhý UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (mUI.length() == 1) //pouze jeden znak ve vstupu
			{
				switch(mUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0':
					return; //vrácení se z metody

				case '1':
					floor2.UIpartRandomNumbers(); //volání metody třídy UIfloor2 [další část UI, možnost 1_1]

					//-----------------------------------------------------------------------------
					//sestavení UI menu náhodných generátorů + získání uživateského vstupu [String]
					//-----------------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuRandomNumbersValues, MenuMainENDs); continue;
					//-----------------------------------------------------------------------------

				case '2':
					floor2.UIpartRandomPasswords(); //volání metody třídy UIfloor2 [další část UI, možnost 1_2]

					//-----------------------------------------------------------------------------
					//sestavení UI menu náhodných generátorů + získání uživateského vstupu [String]
					//-----------------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuRandomNumbersValues, MenuMainENDs); continue;
					//-----------------------------------------------------------------------------

				default:
					mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		} 
		//------------------------------------------------------------------------------  
	}

	/**
	 * Veřejná metoda třídy {@code UIfloor1} - rozšiřující rozcestník pro možnost 2 v {@code mainClass}.
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIprimeNumbers()
	{
		//-----------------------------------------------------------------------------
		//sestavení UI menu náhodných generátorů + získání uživateského vstupu [String]
		//-----------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
		mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuPrimeNumbersValues, MenuMainENDs);
		//-----------------------------------------------------------------------------
				
		//------------------------------------------------------------------------------
		//druhý UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (mUI.length() == 1) //pouze jeden znak ve vstupu
			{   
				switch(mUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0':
					return; //vrácení se z metody

				case '1':
					floor2.UIpartStandardPrimeNumbers(); //volání metody třídy UIfloor2 [další část UI, možnost 2_1]

					//---------------------------------------------------------------------------------
					//sestavení UI menu prvočíselných generátorů + získání uživateského vstupu [String]
					//---------------------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RandomNumbersHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuPrimeNumbersValues, MenuMainENDs); continue;
					//---------------------------------------------------------------------------------

				case '2':
					floor2.UIpartOptimisedPrimeNumbers(); //volání metody třídy UIfloor2 [další část UI, možnost 2_2]

					//---------------------------------------------------------------------------------
					//sestavení UI menu prvočíselných generátorů + získání uživateského vstupu [String]
					//---------------------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(PrimeNumbersHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuPrimeNumbersValues, MenuMainENDs); continue;
					//---------------------------------------------------------------------------------

				default:
					mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
		//------------------------------------------------------------------------------
	}

	/**
	 * Veřejná metoda třídy {@code UIfloor1} - Získání názvů vstupního & výstupního souboru pro možnost 3 v {@code mainClass}.
	 * <p> + uvnitř se volá rozšiřující rozcestník ve třídě {@code UIfloor2} pro možnost 3 v {@code mainClass}. </p>
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UIstringSorting()
	{
		//------------------------------
		//Konstrukce řetězcových objektů
		//------------------------------
		String FileToSort = new String(); //měnitelný objekt třídy String pro uložení názvu souboru k seřazení
		String InBuf = new String(); //měnitelný objekt třídy String pro krátkodobé uložení vstupní hodnoty
		//------------------------------
		
		//-----------------------------------------------------------------------------------
		//Cyklické tištění UI menu pro získání uživatelského vstupu - názvu vstupního souboru
		//[opakuje se dokud se hodnota v `InBuf` nerovná "\e" nebo v `FileToSort` je prázdný]
		//-----------------------------------------------------------------------------------
		while (!InBuf.equals("\\e") || FileToSort.length() == 0)
		{
			//pokud je hodntota v `InBuf` rovna "\c" - vymaže se vše v `FileToSort` & `InBuf`
			if (InBuf.equals("\\c")) { FileToSort = new String(); InBuf = new String(); }
				
			//kontrola, jestli hodnota v `InBuf` odpovídá pravidlům tohoto validátoru [pokud ano, hodnota je uložena do `FileToSort`]
			if (validator.validfilename(InBuf) == true) FileToSort = InBuf; 

			//--------------------------------------------------------------------------------------------
			//sestavení UI menu pro získání názvu vstupního souboru + získání uživateského vstupu [String]
			//--------------------------------------------------------------------------------------------
			UIbuilder.clearConsole(); 
			UIbuilder.header(MainHeaderCZ, 20, false); 
			UIbuilder.header(SortingHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToSort, SortingFileManual, AlgorithmsExtraManual);
			//--------------------------------------------------------------------------------------------
		}
		//-----------------------------------------------------------------------------------
	
		//uložení všech řádků v zadaném souboru do dynamického pole [1 řádek = nový prvek]
		ArrayList<String> fileValues = fileIO.read(FileToSort);

		//-----------------------------------------------------------------------------------------
		//sestavení UI menu pro výběr seřazovacího algoritmu + získání uživateského vstupu [String]
		//-----------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
		UIbuilder.header(TitleAlgorithmFile + FileToSort, TitleAlgorithmFile.length() + FileToSort.length(), false);
		mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuSortingValues, MenuMainENDs);
		//-----------------------------------------------------------------------------------------

		fileValues = floor2.UIsortingStrings(fileValues, mUI); //volání metody třídy UIfloor2 [druhý rozcestník UI pro možnost 3]

		mUI = UIbuilder.smallMenuBuild(SortingFileENDmenu); //sestavení UI menu pro výběr zápisu do souboru + získání uživateského vstupu [String]
	
		//------------------------------------------------------------------------------
		//třetí UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (mUI.length() == 1) //pouze jeden znak ve vstupu
			{
				switch (mUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0': 
					return; //vrácení se z metody

				case '1':
					//------------------------------
					//Konstrukce řetězcových objektů
					//------------------------------
					String FileToExport = new String(); //měnitelný objekt třídy String pro uložení názvu souboru pro zapsání seřazených hodnot
					InBuf = new String(); //vyčištění objektu `InBuf`
					//------------------------------
				
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
						
						//---------------------------------------------------------------------------------------------
						//sestavení UI menu pro získání názvu výstupního souboru + získání uživateského vstupu [String]
						//---------------------------------------------------------------------------------------------
						UIbuilder.clearConsole(); 
						UIbuilder.header(MainHeaderCZ, 20, false); 
						UIbuilder.header(SortingHeaderCZ, 20, false);
						UIbuilder.header(AlgorithmOutHeaderCZ, 20, false);
						InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToExport, SortingFileManual, AlgorithmsExtraManual);
						//---------------------------------------------------------------------------------------------
					}
					//-------------------------------------------------------------------------------------
				
					//zapsání hodnot dynamického pole do nového/existujícího souboru [1 prvek = nový řádek] + vrácení se z metody
					fileIO.writeToNew(FileToExport, fileValues); return;
				
				default:
					mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
		//------------------------------------------------------------------------------
	}

	/**
	 * Veřejná metoda třídy {@code UIfloor1} - Získání hodnot pro náhdoný generátor čísel & názvu výstupního souboru pro možnost 4 v {@code mainClass}.
	 * <p> + uvnitř se volá rozšiřující rozcestník ve třídě {@code UIfloor2} pro možnost 4 v {@code mainClass}. </p>
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void UInumberSorting()
	{
		//------------------------------
		//Konstrukce řetězcových objektů
		//------------------------------
		String NumberCount = new String(); //měnitelný objekt třídy String pro uložení počtu náhodný čísel k vygenerování
		String MinValue = new String(); //měnitelný objekt třídy String pro uložení nejmenší hodnoty náhodného čísla
		String MaxValue = new String(); //měnitelný objekt třídy String pro uložení největší hodnoty náhodného čísla
		String InBuf = new String(); //měnitelný objekt třídy String pro krátkodobé uložení vstupní hodnoty
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
			UIbuilder.header(SortingHeaderCZ, 20, false);
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
			UIbuilder.header(SortingHeaderCZ, 20, false);
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
			UIbuilder.header(SortingHeaderCZ, 20, false);
			UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
			UIbuilder.header(TitleRandomNumberCount + NumberCount, TitleRandomNumberCount.length() + NumberCount.length(), false);
			UIbuilder.header(TitleRandomNumberMIN + MinValue, TitleRandomNumberMIN.length() + MinValue.length(), false);
			InBuf = UIbuilder.storageMenuBuild(TitleRandomNumberMAX, MaxValue, RandomNumbersManuals[2], AlgorithmsExtraManual);
			//-----------------------------------------------------------------------------------------------------
		} 
		//--------------------------------------------------------------------------------------------
		
		ArrayList<Long> numsToSort = new ArrayList<Long>(0); //měnitelný objekt třídy ArrayList<Long> pro dynamické uložení vygenerovaných hodnot
		long timeSeed = System.currentTimeMillis(); Random rand = new Random(timeSeed); //nastavení semínka náhody na aktuální systémový čas

		//přidání `NumberCount`-krát nového prvku do `numsToSort` [jedno nově vygenerované číslo]
		for (int c = 0; c < Integer.parseInt(NumberCount); c++)
			numsToSort.add((long)rand.nextInt((Integer.parseInt(MaxValue) - Integer.parseInt(MinValue)) + 1) + Integer.parseInt(MinValue));
		
		//-----------------------------------------------------------------------------------------
		//sestavení UI menu pro výběr seřazovacího algoritmu + získání uživateského vstupu [String]
		//-----------------------------------------------------------------------------------------
		UIbuilder.clearConsole(); 
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(SortingHeaderCZ, 20, false);
		UIbuilder.header(AlgorithmInHeaderCZ, 20, false);
		UIbuilder.header(TitleRandomNumberCount + NumberCount, TitleRandomNumberCount.length() + NumberCount.length(), false);
		UIbuilder.header(TitleRandomNumberMIN + MinValue, TitleRandomNumberMIN.length() + MinValue.length(), false);
		UIbuilder.header(TitleRandomNumberMAX + MaxValue, TitleRandomNumberMAX.length() + MaxValue.length(), false);
		mUI = UIbuilder.tableMenuBuild(MenuAlgorithmsTitle, MenuSortingValues, MenuMainENDs);
		//-----------------------------------------------------------------------------------------

		numsToSort = floor2.UIsortingNumbers(numsToSort, mUI); //volání metody třídy UIfloor2 [druhý rozcestník UI pro možnost 4]

		mUI = UIbuilder.smallMenuBuild(SortingFileENDmenu); //sestavení UI menu pro výběr zápisu do souboru + získání uživateského vstupu [String]

		//------------------------------------------------------------------------------
		//třetí UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (mUI.length() == 1) //pouze jeden znak ve vstupu
			{
				switch (mUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0': 
					return; //vrácení se z metody

				case '1':
					//------------------------------
					//Konstrukce řetězcových objektů
					//------------------------------
					String FileToExport = new String(); //měnitelný objekt třídy String pro uložení názvu souboru pro zapsání seřazených hodnot
					InBuf = new String(); //vyčištění objektu `InBuf`
					//------------------------------
				
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
						
						//---------------------------------------------------------------------------------------------
						//sestavení UI menu pro získání názvu výstupního souboru + získání uživateského vstupu [String]
						//---------------------------------------------------------------------------------------------
						UIbuilder.clearConsole(); 
						UIbuilder.header(MainHeaderCZ, 20, false); 
						UIbuilder.header(SortingHeaderCZ, 20, false);
						UIbuilder.header(AlgorithmOutHeaderCZ, 20, false);
						InBuf = UIbuilder.storageMenuBuild(TitleAlgorithmFile, FileToExport, SortingFileManual, AlgorithmsExtraManual);
						//---------------------------------------------------------------------------------------------
					}
					//-------------------------------------------------------------------------------------
				
					//zapsání hodnot dynamického pole do nového/existujícího souboru [1 prvek = nový řádek] + vrácení se z metody
					fileIO.numWriteToNew(FileToExport, numsToSort); return;

				default:
					mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
	}
}