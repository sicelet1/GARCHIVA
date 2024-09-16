package usefulalgorithms;


/**
 * Třída pro kontrolu uživatelských vstupů, aby se nezpůsobovaly chyby v jiných metodách, používá {@code java.io.File}.
 * <p> Všechny metody vracejí buď {@code true}, nebo {@code false}, podle vstupních hodnot. </p>
 * <p> Příklad instance: <blockquote> <pre> {@code private final Valid myObj = new Valid();} </pre> </blockquote> </p>
 * <p> Příklad použití: <blockquote> <pre> {@code myObj.onlyNumbers("536415", 8);} </pre> vrátí: {@code true} </blockquote> </p>
 * <p> <blockquote> <pre> {@code myObj.onlyNumbers("45s541dd", 10);} </pre> vrátí: {@code false} </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class Valid 
{
	/**
	 * Veřejný konstruktor validační třídy - {@code Valid}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public Valid() {}


	/**
	 * Veřejná metoda třídy {@code valid} - Ověří, zda vstupní řetězec obsahuje pouze číslo, není prázdný & menší/roven zadané maximální délce.
	 * 
	 * @param stringToTest : {@code String} - vstupní řetězec, který se má testovat na přítomnost pouze číslic
	 * @param numberRange : {@code int} - určuje maximální možnost délku [počet číslic] vstupního řetězce
	 * 
	 * @return {@code boolean} - {@code true}, když zadaný řetězec projde všemi testy / {@code false}, když zadaný řetězec neprojde jen jediným testem
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public boolean onlyNumbers(final String stringToTest, final int numberRange)
	{
		//pokud je `stringToTest` prázdný, nebo je delší, než `numberRange`, tak se vrácí `false` z metody
		if (stringToTest.length() == 0 || stringToTest.length() > numberRange) return false;

		//-----------------------------------------------------------------------------------
		//Postupné ověření každého znaku v `stringToTest`, zda je v rozmezí '0' - '9' v ASCII
		//-----------------------------------------------------------------------------------
		for (int c = 0; c < stringToTest.length(); c++)
		{
			//když se byť jediný znak nachází mimo toto rozmezí, tak se vrácí `false` z metody
			if (!(stringToTest.charAt(c) >= 0x30 && stringToTest.charAt(c) <= 0x39)) return false;
		}
		//-----------------------------------------------------------------------------------

		return true; //vrácení `true` z metody
	}

	
	/**
	 * Ověří, zda vstupní řetězec končí znaky {@code '.txt'} & neobsahuje žádný z nepovolených znaků v názvech souborů [Windows].
	 * 
	 * @param filename : {@code String} - vstupní řetězec, který se má testovat spravný Windows název souboru s příponou {@code '.txt'}
	 * 
	 * @return {@code boolean} - {@code true}, když zadaný řetězec projde všemi testy / {@code false}, když zadaný řetězec jen neprojde jediným testem
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public boolean validfilename(final String filename)
	{
		//pokud je délka `filename` menší, než 5 [nevejde se tam název + přípona], tak se vrácí `false` z metody
		if (filename.length() < 5) return false;

		//pokud se poslední 4 znak v `filename` nerovnájí ".txt", tak se vrácí `false` z metody
		if (!filename.substring(filename.length() - 4, filename.length()).equals(".txt")) return false;

		//pokud se byť jediný znak v `filename` rovná '\', nebo '/', nebo ':', nebo '*', nebo '?', nebo '"', nebo '<', nebo '>', nebo '|', tak se vrácí `false` z metody
		for (int c = 0; c < filename.length(); c++)
			if (filename.charAt(c) == 0x5C || filename.charAt(c) == 0x2F || filename.charAt(c) == 0x3A || filename.charAt(c) == 0x2A || filename.charAt(c) == 0x3F || filename.charAt(c) == 0x22 || filename.charAt(c) == 0x3C || filename.charAt(c) == 0x3E || filename.charAt(c) == 0x7C) return false;

		return true; //vrácení `true` z metody
	}
}