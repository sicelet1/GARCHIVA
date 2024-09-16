package usefulalgorithms;

import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


/**
 * Třída pro operace se soubory, používá {@code java.util.ArrayList}, {@code java.io.IOException}, {@code java.io.File}, {@code java.io.FileWriter} & {@code java.util.Scanner}.
 * <p> Příklad instance: <blockquote> <pre> {@code private final FileOperator myObj = new FileOperator();} </pre> </blockquote> </p>
 * <p> Metody čtou, nebo zapisují do nového souboru. Když je při zapisování zadán název existujícího souboru, obsah toho souboru se přepíše. </p>
 * <p> Příklad použití: 
 * <blockquote> <pre> 
 * {@code myDataObj = myObj.read("myFile.txt");}
 *{@code myObj.writeToNew("myNewFile.txt", myDataObj);}
 * </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class FileOperator 
{
	/**
	 * Veřejný konstruktor souborové třídy - {@code FileOperator}
	 * 
	 * @param nepřijímá žádné parametry
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public FileOperator() {}


	/**
	 * Veřejná metoda třídy {@code FileOperator} - vytvoří nový soubor se zadaným názvem & zapíše do něj hodnoty dynamického pole [1 prvek = nový řádek].
	 * 
	 * @param filename : {@code String} - název souboru, se kterým se má pracovat
	 * @param dataToWrite : {@code ArrayList<String>} - pole s řetězcovými daty k zapsání na řádky
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @throws {@code except.printStackTrace();}
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void writeToNew(final String filename, final ArrayList<String> dataToWrite)
	{
		try
		{
			final File file = new File(filename); //neměnitelný objekt třídy File pro práci se soubory - název `filename`

			file.createNewFile(); //vytvoření nového souboru s názvem `filename`
		}
		catch (IOException except) { except.printStackTrace(); } //výjimka v případě chyby souboru

		try
		{
			final FileWriter writer = new FileWriter(filename); //neměnitelný objekt třídy FileWriter pro zápisy do souboru - název `filename`

			//prvek po prvku zapsání řetězců v `dataToWrite`, každy na nový řádek
			for (String value : dataToWrite) writer.write(value + "\n");
			
			writer.close(); //zavření streamu, aby se zabránilo chybám
		}
		catch (IOException except) { except.printStackTrace(); } //výjimka v případě chyby souboru

		return; //vrácení se z metody
	}


	/**
	 * Veřejná metoda třídy {@code FileOperator} - vytvoří nový soubor se zadaným názvem & zapíše do něj hodnoty dynamického pole [1 prvek = nový řádek].
	 * <p> [Speciální verze - zapisuje přímo číselné hodnoty, místo řetězcových] </p>
	 * 
	 * @param filename : {@code String} - název souboru, se kterým se má pracovat
	 * @param dataToWrite : {@code ArrayList<Long>} - pole s číselnými daty k zapsání na řádky
	 * 
	 * @return {@code void} - nic nevrací
	 * 
	 * @throws {@code except.printStackTrace();}
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public void numWriteToNew(final String filename, final ArrayList<Long> dataToWrite)
	{
		try
		{
			final File file = new File(filename); //neměnitelný objekt třídy File pro práci se soubory - název `filename`

			file.createNewFile(); //vytvoření nového souboru s názvem `filename`
		}
		catch (IOException except) { except.printStackTrace(); } //výjimka v případě chyby souboru

		try
		{
			final FileWriter writer = new FileWriter(filename); //neměnitelný objekt třídy FileWriter pro zápisy do souboru - název `filename`

			//prvek po prvku zapsání čísel v `dataToWrite`, každy na nový řádek
			for (long value : dataToWrite) writer.write(value + "\n");

			writer.close(); //zavření streamu, aby se zabránilo chybám
		}
		catch (IOException except) { except.printStackTrace(); } //výjimka v případě chyby souboru

		return; //vrácení se z metody
	}


	/**
	 * Veřejná metoda třídy {@code FileOperator} - přečte hodnoty ze souboru & vloží je do dynamického pole [1 řádek = nový prvek].
	 * 
	 * @param filename : {@code String} - název souboru, se kterým se má pracovat
	 * @param dataToWrite : {@code ArrayList<Long>} - prázdné řetězcové pole k vložení přečtených dat
	 * 
	 * @return {@code ArrayList<String>} - dynamické pole přečtených hodnot
	 * 
	 * @throws {@code except.printStackTrace();}
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public ArrayList<String> read(final String filename)
	{
		ArrayList<String> readResult = new ArrayList<String>(0); //měnitelný objekt třídy ArrayList<String> pro dynamické uložení přečtených řádků

		try
		{
			final File file = new File(filename); //neměnitelný objekt třídy File pro práci se soubory - název `filename`
			final Scanner reader = new Scanner(file); //neměnitelný objekt třídy Scanner pro čtení souborů - název `file` [`filename`]

			//čtení řádků v souboru [dokud se nedostane na konec souboru] & uložení přečtených řádků do `readResult`, každý na nový prvek
			while (reader.hasNextLine()) readResult.add(reader.nextLine());
			
			reader.close(); //zavření streamu, aby se zabránilo chybám
		}
		catch (IOException except) { except.printStackTrace(); } //výjimka v případě chyby souboru

		return readResult; //vrácení `readResult` z metody
	}
}