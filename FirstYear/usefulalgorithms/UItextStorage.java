package usefulalgorithms;


/**
 * Kontejner obsahující všechny texty tisknuté pomocí {@code mainUI.java}.
 * <p> [slouží pouze k uložení & zabalení neměnitelných hodnot pro K7.UI] </p>
 * <p> Pro přístup ke {@code String} / {@code String[]} hodnotám je potřeba tuto třídu zdědit </p>
 * <p> Příklad dědění: <blockquote> <pre> {@code public class myClass extends UItextStorage} </pre> </blockquote> </p>
 * @author Jakub Wimmer
 */
public class UItextStorage
{
	protected static final String MainHeaderCZ = "Použitelné Algoritmy        JAVA [64-BIT]";
	protected static final String RootHeaderCZ = "HLAVNÍ KOŘENOVÉ MENU";
	protected static final String RandomNumbersHeaderCZ = "NÁHODNÉ GENERÁTORY";
	protected static final String PrimeNumbersHeaderCZ = "PRVOČÍSELNÉ GENERÁTORY";
	protected static final String SortingHeaderCZ = "SEŘAZOVACÍ ALGORITMY";
	protected static final String AlgorithmInHeaderCZ = "VSTUPNÍ DATA";
	protected static final String AlgorithmOutHeaderCZ = "VÝSTUPNÍ DATA";

	protected static final String MenuRootTitle = "Vyberte, co chcete dělat:";
	protected static final String MenuRootValues[] =
	{
		"Stiskněte 1 pro algoritmus generování náhodných čísel nebo hesel",
		"Stiskněte 2 pro výběr algoritmů generování řady prvočísel",
		"Stiskněte 3 pro výběr algoritmů seřazování řádků souborů [abecedně]",
		"Stiskněte 4 pro výběr algoritmů seřazování náhodných číselných polí"
	};
	protected static final String MenuRootENDs = "Nebo stiskněte 0 pro ukončení programu:";

	protected static final String MenuAlgorithmsTitle = "Vyberte, který z možných algoritmů chcete použít:";

	protected static final String MenuRandomNumbersValues[] =
	{
		"Stiskněte 1 pro generátor náhodné řady čísel",
		"Stiskněte 2 pro generátor náhodné řady hesel [náhodné ASCII znaky]"
	};

	protected static final String MenuPrimeNumbersValues[] =
	{
		"Stiskněte 1 pro standardní generátor prvočíselné řady",
		"Stiskněte 2 pro optimizovaný generátor prvočíselné řady"
	};

	protected static final String MenuSortingValues[] =
	{
		"Stiskněte 1 pro 'Bubble Sort'",
		"Stiskněte 2 pro 'Selection Sort'",
		"Stiskněte 3 pro 'Insertion Sort'",
		"Stiskněte 4 pro 'Quick Sort'",
		"Stiskněte 5 pro 'Merge Sort'",
		"Stiskněte 6 pro 'Bucket Sort'"
	};

	protected static final String MenuMainENDs = "Stiskněte 0 pro vrácení se zpět do hlavního menu:";


	protected static final String MenuWrong = "Neplatný vstup, zkuste to znovu:";


	protected static final String TitleRandomNumberCount = "Počet náhodných čísel: ";
	protected static final String TitleRandomNumberMIN = "Minimální hodnota náhodných čísel: ";
	protected static final String TitleRandomNumberMAX = "Maximální hodnota náhodných čísel: ";

	protected static final String RandomNumbersManuals[] =
	{
		"Zadejte počet náhodných čísel, které chcete vygenerovat:",
		"Zadejte nejmenší možnou hodnotu náhodných čísel:",
		"Zadejte největší možnou hodnotu náhodných čísel:"
	};

	protected static final String TitleRandomPasswordCount = "Počet náhodných hesel: ";
	protected static final String TitleRandomPasswordLength = "Délka náhodných hesel: ";

	protected static final String RandomPasswordsManuals[] =
	{
		"Zadejte počet náhodných hesel, které chcete vygenerovat:",
		"Zadejte délku náhodných hesel:"
	};

	protected static final String TitlePrimeNumbersMIN = "Počáteční hodnota řady: ";
	protected static final String TitlePrimeNumbersMAX = "Konečná hodnota řady: ";

	protected static final String PrimeNumbersManuals[] =
	{
		"Zadejte počáteční hodnotu prvočíselné řady [nemusí to být prvočíslo]:",
		"Zadejte konečnou hodnotu prvočíselné řady [nemusí to být prvočíslo]:",
	};

	protected static final String TitleAlgorithmFile = "Název souboru: ";

	protected static final String NumberAlgorithmsSTARTmenu = "Stiskněte 1 pro spuštění & změření algoritmu, nebo stiskněte 0 pro vrácení se zpět do hlavního menu:";
	protected static final String NumberFileManual = "Zadejte název souboru [přípona musí být '.txt'], kam chcete zapsat vygenerované hodnoty:";

	protected static final String SortingFileManual = "Zadejte název souboru [přípona musí být '.txt'], jehož hodnoty chcete seřadit:";
	protected static final String ExportFileManual = "Zadejte název souboru [přípona musí být '.txt'], kam chcete zapsat seřazené hodnoty:";
	protected static final String SortingFileENDmenu = "Stiskněte 1 pro zapsání seřazených hodnot do souboru, nebo stiskněte 0 pro vrácení zpět do hlavního menu:";

	protected static final String AlgorithmsExtraManual = "[Zadejte '\\c' pro vymazání všeho zadaného, nebo zadejte '\\e' pro uložení hodnot & opuštění menu]";
}