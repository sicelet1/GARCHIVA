package usefulalgorithms;

import java.util.Scanner;


/**
 * Třída pro vytváření & skládání textového UI, používá {@code java.util.Scanner}.
 * <p> Všechny metody tisknou postupně za sebe, jak jsou volány, pro vymazání použijte {@code clearConsole()}. </p>
 * <p> Příklad instance: <blockquote> <pre> {@code private final MainUI myObj = new MainUI();} </pre> </blockquote> </p>
 * <p> Metody v konzoli tvoří: Hlavičky, Tabulkové menu, Malé menu & Menu s kontejnerem na hodnotu. </p>
 * <p> Příklad sestavení menu: 
 * <blockquote> <pre>
 * {@code myObj.clearConsole();}
 *{@code myObj.header("Hlavní menu", 12, false);}
 *{@code myObj.tableMenuBuild("Co chcete dělat:", myStringArrayObj, "Nebo stiskněte 0 pro vrácení se:");}
 * </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class MainUI
{
	/**
	 * Veřejný konstruktor UI třídy - {@code MainUI}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public MainUI() {}

	private final Scanner inputBuf = new Scanner(System.in); //měnitelný soukromý objekt třídy Scanner pro čtení vstupu z konzole [System.in]
	

	/**
	 * Veřejná metoda třídy {@code MainUI} - Vymaže vše vytištěné v konzoli & vypláchne {@code System.out} stream.
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void clearConsole()
	{
		System.out.print("\033[H\033[2J"); //řetězec pro vyčištení konzole
		System.out.flush(); return; //vypláchnutí výstupního streamu + //vrácení se z metody
	}


	/**
	 * Veřejná metoda třídy {@code MainUI} - Vytvoří v konzoli hlavičku s textem.
	 * <p> Hlavička - Vytiskne řetězec ohraničený zvrchu & zespodu separačnímy linkami, složených z znaku [{@code '-'}]. </p>
	 * 
	 * @param text : {@code final String} - hlavní text, který se tiskne mezi separačnímy linkami
	 * @param separCount : {@code final long} - počet znaků {@code '-'} v separační lince [délka separační linky]
	 * @param isBig : {@code final boolean} - true = extra mezera mezi každou separační linkou & textem, false = žádná extra mezera
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void header(final String text, final long separCount, final boolean isBig)
	{
		for (int c = 0; c < separCount; c++) System.out.print("-"); //vytištění zasebou separátoru '-' `separCount`-krát 
	
		//vytištění hlavního textu [`text`] + zjistění, jestli je potřeba extra mezera & její případné vytištění
		System.out.print((isBig == true ? "\n\n" : "\n") + text + (isBig == true ? "\n\n" : "\n")); 
	
		for (int c = 0; c < separCount; c++) System.out.print("-"); //vytištění zasebou separátoru '-' `separCount`-krát 
	
		System.out.print("\n"); return; //vrácení se z metody
	}


	/**
	 * Veřejná metoda třídy {@code MainUI} - Vytvoří v konsoli tabulkové menu s polem textů [ptá se na vstup]
	 * <p> Tabulkové menu - Vytiskne titulek, pod ním tabulku [obdélník s polem textů {uživatelské možnosti}] & nakonec konečnou větu, pak se ptá na vstup. </p>
	 * 
	 * @param title : {@code final String} - hlavní text [název], který se tiskne nazačátku, nad tabulkou [obdélníkem]
	 * @param valToChoose : {@code final String[]} - pole textů, tisknuté uvnitř tabulky, jehož prvky ukazují & popisují uživateli možnosti vstupů
	 * @param endSentence : {@code final String} - doplňující věta na konci [např. co má uživatel udělat, nebo jak se vrátit zpět]
	 * 
	 * @return {@code String} - hodnota zadaná uživatelem
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public String tableMenuBuild(final String title, final String valToChoose[], final String endSentence)
	{
		long LongestVal = 0; String menuUI = new String(); //měnitelný objekt třídy String pro uživatelský vstup na konci
		System.out.print(title + "\n\n"); //vytištění hlavního textu [`title`]

		//-------------------------------------------
		//nalezení nejdelšího prvku v `valToChoose[]`
		//-------------------------------------------
		for (int c = 0; c < valToChoose.length; c++)
			if (valToChoose[c].length() > LongestVal) LongestVal = valToChoose[c].length();
		//-------------------------------------------

		//vytištění zasebou separátoru '-' `LongestVal`-krát [podle nejdelšího prvku]
		for (int c = 0; c < LongestVal + 2; c++) { System.out.print("-"); } System.out.print("\n");

		//----------------------------------------------------------------------------
		//prvek, po prvku z `valToChoose[]` tištění mezi separační linky 
		//+ tištění horizontálního separátoru před & po každém prvku v `valToChoose[]`
		//----------------------------------------------------------------------------
		for (int c = 0; c < valToChoose.length; c++)
		{
			System.out.print("|" + valToChoose[c]); //vytištění horizontálního separátoru + jednoho prvku z `valToChoose`

			//doplnění mezerami pro zarovnání pozice druhého horizontálního separátoru s délkou nejdelšího prvku
			for (int cc = 0; cc < LongestVal - valToChoose[c].length(); cc++) { System.out.print(" "); }

			System.out.print("|\n"); //vytištění horizontálního separátoru
		}
		//----------------------------------------------------------------------------

		//vytištění zasebou separátoru '-' `LongestVal`-krát [podle nejdelšího prvku]
		for (int c = 0; c < LongestVal + 2; c++) { System.out.print("-"); } System.out.print("\n");

		System.out.print(endSentence + "\n>>>"); //vytištění `endSentence` + ukazovače uživatelského vstupu [>>>]
		menuUI = inputBuf.nextLine(); return menuUI; //uživatelský vstup + vrácení hodnoty `menuUI` z metody
	}


	/**
	 * Veřejná metoda třídy {@code MainUI} - Vytvoří v konsoli menší menu s jedním řetězcem textů [ptá se na vstup]
	 * <p> Malé menu - Vytiskne hlavní text & poté se ptá na vstup </p>
	 * 
	 * @param title : {@code final String} - hlavní & jediný text, který se vytiskne před uživatelský vstupem
	 * 
	 * @return {@code String} - hodnota zadaná uživatelem
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public String smallMenuBuild(final String title)
	{
		String menuUI = new String(); //měnitelný objekt třídy String pro uživatelský vstup na konci
		System.out.print("\n\n" + title + "\n>>>"); //vytištění `title` + ukazovače uživatelského vstupu [>>>]
		menuUI = inputBuf.nextLine(); return menuUI; //uživatelský vstup + vrácení hodnoty `menuUI` z metody
	}


	/**
	 * Veřejná metoda třídy {@code MainUI} - Vytvoří v konsoli větší menu s hlavičkou pro uložení & zobrazení zadané textové hodnoty [ptá se na vstup]
	 * <p> Menu s kontejnerem - Do hlavičky vytiskne hlavní text pro hlavičku, hned za to vytiskne aktuální hodnotu uloženou v kontejnetu, </p>
	 * <p> pod hlavičku vytiskne manuál [co má uživatel dělat] & extramanuál [dodatečné info] & nakonec se ptá na vstup </p>
	 * 
	 * @param headTitle : {@code final String} - hlavní text, který se tiskne v hlavičce, před zobrazením kontejneru
	 * @param valuesStorage : {@code String} - kontejner pro zobrazení/zadání vstupní hodnoty
	 * @param manual : {@code final String} - hlavní informační text [co má uživatel dělat]
	 * @param extraManual : {@code final String} - dodatečný text [např. jak se dostat ven z menu] {nepovinný}
	 * 
	 * @return {@code String} - hodnota zadaná uživatelem [změněný původní kontejner]
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public String storageMenuBuild(final String headTitle, String valuesStorage, final String manual, final String extraManual)
	{
		//vytištění zasebou separátoru '-' podle součtu délek `headTitle` & `valuesStorage`
		for (int c = 0; c < headTitle.length() + valuesStorage.length(); c++) System.out.print("-");

		System.out.print("\n" + headTitle + valuesStorage + "\n"); //vytištení `headTitle` + `valuesStorage`

		//vytištění zasebou separátoru '-' podle součtu délek `headTitle` & `valuesStorage`
		for (int c = 0; c < headTitle.length() + valuesStorage.length(); c++) System.out.print("-");

		System.out.print("\n" + manual); //vytištění hlavního informačního textu [`manual`]

		//vytištění dodatečného textu [`ExtraManual`], pokud neni prázdný
		if (extraManual != "") System.out.println("\n" + extraManual); 

		System.out.print("\n\n::\n"); //vytištění ukazovače uživatelského vstupu [::]
		valuesStorage = inputBuf.nextLine(); return valuesStorage; //uživatelský vstup + vrácení hodnoty `valuesStorage` z metody
	}
}