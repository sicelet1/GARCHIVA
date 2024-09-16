
//Hlavièka obsahující kontejner s texty pro uživatelské rozhraní.

//ochrana proti vícenásobné definici
#ifndef UItextStorage
#define UItextStorage

//kontejner obsahující všechny texty tisknuté pomocí K7.UI [slouží pouze k uložení & zabalení nemìnitelných hodnot pro K7.UI]
struct UItexts
{
	const std::wstring MainHeaderCZ = L"Použitelné Algoritmy        v 1.1.7.62 STABLE    [64-BIT]    {by K7.UI}";
	const std::wstring RootHeaderCZ = L"HLAVNÍ KOØENOVÉ MENU";
	const std::wstring SettingsHeaderCZ = L"MENU NASTAVENÍ";
	const std::wstring RandomNumbersHeaderCZ = L"NÁHODNÉ GENERÁTORY";
	const std::wstring PrimeNumbersHeaderCZ = L"PRVOÈÍSELNÉ GENERÁTORY";
	const std::wstring SortingHeaderCZ = L"SEØAZOVACÍ ALGORITMY";
	const std::wstring AlgorithmInHeaderCZ = L"VSTUPNÍ DATA";
	const std::wstring AlgorithmOutHeaderCZ = L"VÝSTUPNÍ DATA";


	const std::wstring MenuRootTitle = L"Vyberte, co chcete dìlat:";
	const std::array<std::wstring, 5> MenuRootValues =
	{
		L"Stisknìte 1 pro vstup do menu nastavení",
		L"Stisknìte 2 pro algoritmus generování náhodných èísel nebo hesel",
		L"Stisknìte 3 pro výbìr algoritmù generování øady prvoèísel",
		L"Stisknìte 4 pro výbìr algoritmù seøazování øádkù souborù [abecednì]",
		L"Stisknìte 5 pro výbìr algoritmù seøazování náhodných èíselných polí"
	};
	const std::wstring MenuRootENDs = L"Nebo stisknìte 0 pro ukonèení programu:";

	const std::wstring MenuSettingsTitle = L"Vyberte, co chcete nastavit:";
	const std::array<std::wstring, 1> MenuSettingsValues =
	{
		L"{not_implemented}" //coming soon
	};
	

	const std::wstring MenuAlgorithmsTitle = L"Vyberte, který z možných algoritmù chcete použít:";

	const std::array<std::wstring, 2> MenuRandomNumbersValues =
	{
		L"Stisknìte 1 pro generátor náhodné øady èísel",
		L"Stisknìte 2 pro generátor náhodné øady hesel [náhodné ASCII znaky]"
	};

	const std::array<std::wstring, 2> MenuPrimeNumbersValues =
	{
		L"Stisknìte 1 pro standardní generátor prvoèíselné øady",
		L"Stisknìte 2 pro optimizovaný generátor prvoèíselné øady"
	};

	const std::array<std::wstring, 6> MenuSortingValues =
	{
		L"Stisknìte 1 pro 'Bubble Sort'",
		L"Stisknìte 2 pro 'Selection Sort'",
		L"Stisknìte 3 pro 'Insertion Sort'",
		L"Stisknìte 4 pro 'Quick Sort'",
		L"Stisknìte 5 pro 'Merge Sort'",
		L"Stisknìte 6 pro 'Bucket Sort'"
	};

	const std::wstring MenuMainENDs = L"Stisknìte 0 pro vrácení se zpìt do hlavního menu:";


	const std::wstring MenuWrong = L"Neplatný vstup, zkuste to znovu:";


	const std::wstring TitleRandomNumberCount = L"Poèet náhodných èísel: ";
	const std::wstring TitleRandomNumberMIN = L"Minimální hodnota náhodných èísel: ";
	const std::wstring TitleRandomNumberMAX = L"Maximální hodnota náhodných èísel: ";

	const std::array<std::wstring, 3> RandomNumbersManuals =
	{
		L"Zadejte poèet náhodných èísel, které chcete vygenerovat:",
		L"Zadejte nejmenší možnou hodnotu náhodných èísel:",
		L"Zadejte nejvìtší možnou hodnotu náhodných èísel:"
	};

	const std::wstring TitleRandomPasswordCount = L"Poèet náhodných hesel: ";
	const std::wstring TitleRandomPasswordLength = L"Délka náhodných hesel: ";

	const std::array<std::wstring, 2> RandomPasswordsManuals =
	{
		L"Zadejte poèet náhodných hesel, které chcete vygenerovat:",
		L"Zadejte délku náhodných hesel:"
	};

	const std::wstring TitlePrimeNumbersMIN = L"Poèáteèní hodnota øady: ";
	const std::wstring TitlePrimeNumbersMAX = L"Koneèná hodnota øady: ";

	const std::array<std::wstring, 2> PrimeNumbersManuals =
	{
		L"Zadejte poèáteèní hodnotu prvoèíselné øady [nemusí to být prvoèíslo]:",
		L"Zadejte koneènou hodnotu prvoèíselné øady [nemusí to být prvoèíslo]:",
	};

	const std::wstring TitleAlgorithmFile = L"Název souboru: ";

	const std::wstring NumberAlgorithmsSTARTmenu = L"Stisknìte 1 pro spuštìní & zmìøení algoritmu, nebo stisknìte 0 pro vrácení se zpìt do hlavního menu:";
	const std::wstring NumberFileManual = L"Zadejte název souboru [pøípona musí být '.txt'], kam chcete zapsat vygenerované hodnoty:";

	const std::wstring SortingFileManual = L"Zadejte název souboru [pøípona musí být '.txt'], jehož hodnoty chcete seøadit:";
	const std::wstring ExportFileManual = L"Zadejte název souboru [pøípona musí být '.txt'], kam chcete zapsat seøazené hodnoty:";
	const std::wstring SortingFileENDmenu = L"Stisknìte 1 pro zapsání seøazených hodnot do souboru, nebo stisknìte 0 pro vrácení zpìt do hlavního menu:";

	const std::wstring AlgorithmsExtraManual = L"[Zadejte '\\c' pro vymazání všeho zadaného, nebo zadejte '\\e' pro uložení hodnot & opuštìní menu]";
};

#endif //konec bloku