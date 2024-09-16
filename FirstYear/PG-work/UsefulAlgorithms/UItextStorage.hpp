
//Hlavi�ka obsahuj�c� kontejner s texty pro u�ivatelsk� rozhran�.

//ochrana proti v�cen�sobn� definici
#ifndef UItextStorage
#define UItextStorage

//kontejner obsahuj�c� v�echny texty tisknut� pomoc� K7.UI [slou�� pouze k ulo�en� & zabalen� nem�niteln�ch hodnot pro K7.UI]
struct UItexts
{
	const std::wstring MainHeaderCZ = L"Pou�iteln� Algoritmy        v 1.1.7.62 STABLE    [64-BIT]    {by K7.UI}";
	const std::wstring RootHeaderCZ = L"HLAVN� KO�ENOV� MENU";
	const std::wstring SettingsHeaderCZ = L"MENU NASTAVEN�";
	const std::wstring RandomNumbersHeaderCZ = L"N�HODN� GENER�TORY";
	const std::wstring PrimeNumbersHeaderCZ = L"PRVO��SELN� GENER�TORY";
	const std::wstring SortingHeaderCZ = L"SE�AZOVAC� ALGORITMY";
	const std::wstring AlgorithmInHeaderCZ = L"VSTUPN� DATA";
	const std::wstring AlgorithmOutHeaderCZ = L"V�STUPN� DATA";


	const std::wstring MenuRootTitle = L"Vyberte, co chcete d�lat:";
	const std::array<std::wstring, 5> MenuRootValues =
	{
		L"Stiskn�te 1 pro vstup do menu nastaven�",
		L"Stiskn�te 2 pro algoritmus generov�n� n�hodn�ch ��sel nebo hesel",
		L"Stiskn�te 3 pro v�b�r algoritm� generov�n� �ady prvo��sel",
		L"Stiskn�te 4 pro v�b�r algoritm� se�azov�n� ��dk� soubor� [abecedn�]",
		L"Stiskn�te 5 pro v�b�r algoritm� se�azov�n� n�hodn�ch ��seln�ch pol�"
	};
	const std::wstring MenuRootENDs = L"Nebo stiskn�te 0 pro ukon�en� programu:";

	const std::wstring MenuSettingsTitle = L"Vyberte, co chcete nastavit:";
	const std::array<std::wstring, 1> MenuSettingsValues =
	{
		L"{not_implemented}" //coming soon
	};
	

	const std::wstring MenuAlgorithmsTitle = L"Vyberte, kter� z mo�n�ch algoritm� chcete pou��t:";

	const std::array<std::wstring, 2> MenuRandomNumbersValues =
	{
		L"Stiskn�te 1 pro gener�tor n�hodn� �ady ��sel",
		L"Stiskn�te 2 pro gener�tor n�hodn� �ady hesel [n�hodn� ASCII znaky]"
	};

	const std::array<std::wstring, 2> MenuPrimeNumbersValues =
	{
		L"Stiskn�te 1 pro standardn� gener�tor prvo��seln� �ady",
		L"Stiskn�te 2 pro optimizovan� gener�tor prvo��seln� �ady"
	};

	const std::array<std::wstring, 6> MenuSortingValues =
	{
		L"Stiskn�te 1 pro 'Bubble Sort'",
		L"Stiskn�te 2 pro 'Selection Sort'",
		L"Stiskn�te 3 pro 'Insertion Sort'",
		L"Stiskn�te 4 pro 'Quick Sort'",
		L"Stiskn�te 5 pro 'Merge Sort'",
		L"Stiskn�te 6 pro 'Bucket Sort'"
	};

	const std::wstring MenuMainENDs = L"Stiskn�te 0 pro vr�cen� se zp�t do hlavn�ho menu:";


	const std::wstring MenuWrong = L"Neplatn� vstup, zkuste to znovu:";


	const std::wstring TitleRandomNumberCount = L"Po�et n�hodn�ch ��sel: ";
	const std::wstring TitleRandomNumberMIN = L"Minim�ln� hodnota n�hodn�ch ��sel: ";
	const std::wstring TitleRandomNumberMAX = L"Maxim�ln� hodnota n�hodn�ch ��sel: ";

	const std::array<std::wstring, 3> RandomNumbersManuals =
	{
		L"Zadejte po�et n�hodn�ch ��sel, kter� chcete vygenerovat:",
		L"Zadejte nejmen�� mo�nou hodnotu n�hodn�ch ��sel:",
		L"Zadejte nejv�t�� mo�nou hodnotu n�hodn�ch ��sel:"
	};

	const std::wstring TitleRandomPasswordCount = L"Po�et n�hodn�ch hesel: ";
	const std::wstring TitleRandomPasswordLength = L"D�lka n�hodn�ch hesel: ";

	const std::array<std::wstring, 2> RandomPasswordsManuals =
	{
		L"Zadejte po�et n�hodn�ch hesel, kter� chcete vygenerovat:",
		L"Zadejte d�lku n�hodn�ch hesel:"
	};

	const std::wstring TitlePrimeNumbersMIN = L"Po��te�n� hodnota �ady: ";
	const std::wstring TitlePrimeNumbersMAX = L"Kone�n� hodnota �ady: ";

	const std::array<std::wstring, 2> PrimeNumbersManuals =
	{
		L"Zadejte po��te�n� hodnotu prvo��seln� �ady [nemus� to b�t prvo��slo]:",
		L"Zadejte kone�nou hodnotu prvo��seln� �ady [nemus� to b�t prvo��slo]:",
	};

	const std::wstring TitleAlgorithmFile = L"N�zev souboru: ";

	const std::wstring NumberAlgorithmsSTARTmenu = L"Stiskn�te 1 pro spu�t�n� & zm��en� algoritmu, nebo stiskn�te 0 pro vr�cen� se zp�t do hlavn�ho menu:";
	const std::wstring NumberFileManual = L"Zadejte n�zev souboru [p��pona mus� b�t '.txt'], kam chcete zapsat vygenerovan� hodnoty:";

	const std::wstring SortingFileManual = L"Zadejte n�zev souboru [p��pona mus� b�t '.txt'], jeho� hodnoty chcete se�adit:";
	const std::wstring ExportFileManual = L"Zadejte n�zev souboru [p��pona mus� b�t '.txt'], kam chcete zapsat se�azen� hodnoty:";
	const std::wstring SortingFileENDmenu = L"Stiskn�te 1 pro zaps�n� se�azen�ch hodnot do souboru, nebo stiskn�te 0 pro vr�cen� zp�t do hlavn�ho menu:";

	const std::wstring AlgorithmsExtraManual = L"[Zadejte '\\c' pro vymaz�n� v�eho zadan�ho, nebo zadejte '\\e' pro ulo�en� hodnot & opu�t�n� menu]";
};

#endif //konec bloku