//(c) K7 corp. :: all rights reserved

//---------------------------------------------------------------------------
//Zdrojový soubor K7.UI knihovny obsahující funkce pro vytváøení UI v konzoli
//---------------------------------------------------------------------------

//hlavièka se všemi potøebnými knihovnami + deklaracemi
#include "K7lib.UI.hpp" 

//test hlavièky
#ifdef K7UI 

namespace K7 //hlavní obor funkcí 'pseudo-standardní' knihovny K7 pro C++20/23
{

namespace UIfunc //UI funkce, které jsou dùležité pro komfort uživatele, ale neinteraguje s nimi pøímo
{

//èeká na øádku po dobu uvedenou v parametru
void WaitFor(const std::size_t Duration) noexcept { std::this_thread::sleep_for(std::chrono::milliseconds(Duration)); return; }

//vytvoøí v konzoli hlavièku s textem v ASCII
void Header(const std::string& TextASCII, const std::size_t SeparCount, const char SeparASCII, const bool IsBig) noexcept
{
	WINfunc::SET_TO_ASCII();

	for (uint64_t c = NULL; c < SeparCount; c++) std::cout << SeparASCII;

	std::cout << (IsBig == true ? "\n\n" : "\n") << TextASCII << (IsBig == true ? "\n\n" : "\n");

	for (uint64_t c = NULL; c < SeparCount; c++) std::cout << SeparASCII;

	std::cout << "\n"; return;
}

//vytvoøí v konzoli hlavièku s textem v UTF-16
void Header(const std::wstring& TextUTF16, const std::size_t SeparCount, const wchar_t SeparUTF16, const bool IsBig) noexcept
{
	WINfunc::SET_TO_UTF16();

	for (uint64_t c = NULL; c < SeparCount; c++) std::wcout << SeparUTF16;

	std::wcout << (IsBig == true ? L"\n\n" : L"\n") << TextUTF16 << (IsBig == true ? L"\n\n" : L"\n");

	for (uint64_t c = NULL; c < SeparCount; c++) std::wcout << SeparUTF16;

	std::wcout << L"\n"; WINfunc::SET_TO_ASCII(); return;
}

//vytvoøí v konzoli hlavièku s textem v ASCII & zobrazením zadané textové hodnoty v ASCII
void Header(const std::string& TextASCII, const std::size_t SeparCount, const std::string* ValueStorageASCII, const char SeparASCII, const bool IsBig) noexcept
{
	if (ValueStorageASCII == nullptr) { return; } WINfunc::SET_TO_ASCII();

	for (uint64_t c = NULL; c < SeparCount; c++) std::cout << SeparASCII;

	std::cout << (IsBig == true ? "\n\n" : "\n") << TextASCII << *ValueStorageASCII << (IsBig == true ? "\n\n" : "\n");

	for (uint64_t c = NULL; c < SeparCount; c++) std::cout << SeparASCII;

	std::cout << "\n"; return;
}

//vytvoøí v konzoli hlavièku s textem v UTF-16 & zobrazením zadané textové hodnoty v UTF-16
void Header(const std::wstring& TextUTF16, const std::size_t SeparCount, const std::wstring* ValueStorageUTF16, const wchar_t SeparUTF16, const bool IsBig) noexcept
{
	if (ValueStorageUTF16 == nullptr) { return; } WINfunc::SET_TO_UTF16();

	for (uint64_t c = NULL; c < SeparCount; c++) std::wcout << SeparUTF16;

	std::wcout << (IsBig == true ? L"\n\n" : L"\n") << TextUTF16 << *ValueStorageUTF16 << (IsBig == true ? L"\n\n" : L"\n");

	for (uint64_t c = NULL; c < SeparCount; c++) std::wcout << SeparUTF16;

	std::wcout << L"\n"; WINfunc::SET_TO_ASCII(); return;
}

}

namespace UImenu //UI funkce pro vytvoøení rùzných menu, s kterými uživatel interaguje pomocí vstupù & ovládá tím UI
{

//vytvoøí v konsoli tabulkové menu s polem textù v ASCII [ptá se na vstup]
std::string MenuBuild(const std::string& TitleASCII, const std::vector<std::string>& ValToChooseASCII, const std::string& EndSentenceASCII, const char SeparLengthASCII, const char SeparWidthASCII) noexcept
{
	WINfunc::SET_TO_ASCII(); uint64_t LongestVal = NULL; std::string menuUI = {};
	std::cout << TitleASCII << "\n\n";

	for (uint64_t c = NULL; c < ValToChooseASCII.size(); c++)
		if (ValToChooseASCII[c].length() > LongestVal) LongestVal = ValToChooseASCII[c].length();

	for (uint64_t c = NULL; c < LongestVal + 2; c++) { std::cout << SeparLengthASCII; } std::cout << "\n";

	for (uint64_t c = NULL; c < ValToChooseASCII.size(); c++)
	{
		std::cout << SeparWidthASCII << ValToChooseASCII[c];

		for (uint64_t cc = NULL; cc < LongestVal - ValToChooseASCII[c].length(); cc++) { std::cout << " "; }

		std::cout << SeparWidthASCII << "\n";
	}

	for (uint64_t c = NULL; c < LongestVal + 2; c++) { std::cout << SeparLengthASCII; } std::cout << "\n";

	std::cout << EndSentenceASCII << "\n>>>"; WINfunc::BLOCK_INPUT();
	std::getline(std::cin, menuUI); return menuUI;
}

//vytvoøí v konsoli tabulkové menu s polem textù v UTF-16 [ptá se na vstup]
std::wstring MenuBuild(const std::wstring& TitleUTF16, const std::vector<std::wstring>& ValToChooseUTF16, const std::wstring& EndSentenceUTF16, const wchar_t SeparLengthUTF16, const wchar_t SeparWidthUTF16) noexcept
{
	WINfunc::SET_TO_UTF16(); uint64_t LongestVal = NULL; std::wstring menuUI = {};
	std::wcout << TitleUTF16 << L"\n\n";

	for (uint64_t c = NULL; c < ValToChooseUTF16.size(); c++)
		if (ValToChooseUTF16[c].length() > LongestVal) LongestVal = ValToChooseUTF16[c].length();

	for (uint64_t c = NULL; c < LongestVal + 2; c++) { std::wcout << SeparLengthUTF16; } std::wcout << L"\n";

	for (uint64_t c = NULL; c < ValToChooseUTF16.size(); c++)
	{
		std::wcout << SeparWidthUTF16 << ValToChooseUTF16[c];

		for (uint64_t cc = NULL; cc < LongestVal - ValToChooseUTF16[c].length(); cc++) { std::wcout << L" "; }

		std::wcout << SeparWidthUTF16 << L"\n";
	}

	for (uint64_t c = NULL; c < LongestVal + 2; c++) { std::wcout << SeparLengthUTF16; } std::wcout << L"\n";

	std::wcout << EndSentenceUTF16 << "\n>>>"; WINfunc::BLOCK_INPUT(); 
	std::getline(std::wcin, menuUI);  WINfunc::SET_TO_ASCII(); return menuUI;
}

//vytiskne v konsoli menší menu s jedním øetìzcem textù v ASCII [ptá se na vstup]
std::string MenuBuild(const std::string& TitleASCII) noexcept
{
	WINfunc::SET_TO_ASCII(); std::string menuUI = {};
	std::cout << "\n\n" << TitleASCII << "\n>>>";
	WINfunc::BLOCK_INPUT(); std::getline(std::cin, menuUI); return menuUI;
}

//vytiskne v konsoli menší menu s jedním øetìzcem textù v UTF-16 [ptá se na vstup]
std::wstring MenuBuild(const std::wstring& TitleUTF16) noexcept
{
	WINfunc::SET_TO_UTF16(); std::wstring menuUI = {};
	std::wcout << L"\n\n" << TitleUTF16 << "\n>>>";
	WINfunc::BLOCK_INPUT(); std::getline(std::wcin, menuUI); 
	WINfunc::SET_TO_ASCII(); return menuUI;
}

//vytiskne v konsoli vìtší menu s hlavièkou pro uložení & zobrazení zadané textové hodnoty v ASCII [ptá se na vstup]
void MenuBuild(const std::string& HeadTitleASCII, std::string* ValuesStorage, const std::string& Manual, const std::string& ExtraManual, const char SeparASCII) noexcept
{
	if (ValuesStorage == nullptr) { return; } WINfunc::SET_TO_ASCII();

	for (uint64_t c = NULL; c < HeadTitleASCII.length() + (*ValuesStorage).length(); c++) std::cout << SeparASCII;

	std::cout << "\n" << HeadTitleASCII << *ValuesStorage << "\n";

	for (uint64_t c = NULL; c < HeadTitleASCII.length() + (*ValuesStorage).length(); c++) std::cout << SeparASCII;

	std::cout << "\n" << Manual;

	if (ExtraManual != "") std::cout << "\n" << ExtraManual;

	std::cout << "\n\n::\n"; WINfunc::BLOCK_INPUT();
	std::getline(std::cin, *ValuesStorage); return;
}

//vytiskne v konsoli vìtší menu s hlavièkou pro uložení & zobrazení zadané textové hodnoty v UTF-16 [ptá se na vstup]
void MenuBuild(const std::wstring& HeadTitleUTF16, std::wstring* ValuesStorage, const std::wstring& Manual, const std::wstring& ExtraManual, const wchar_t SeparUTF16) noexcept
{
	if (ValuesStorage == nullptr) { return; } WINfunc::SET_TO_UTF16();

	for (uint64_t c = NULL; c < HeadTitleUTF16.length() + (*ValuesStorage).length(); c++) std::wcout << SeparUTF16;

	std::wcout << L"\n" << HeadTitleUTF16 << *ValuesStorage << L"\n";

	for (uint64_t c = NULL; c < HeadTitleUTF16.length() + (*ValuesStorage).length(); c++) std::wcout << SeparUTF16;

	std::wcout << L"\n" << Manual;

	if (ExtraManual != L"") std::wcout << L"\n" << ExtraManual;

	std::wcout << L"\n\n::\n"; WINfunc::BLOCK_INPUT(); 
	std::getline(std::wcin, *ValuesStorage); WINfunc::SET_TO_ASCII(); return;
}

//vytiskne v konsoli vìtší menu s hlavièkou pro uložení & zobrazení zadaných textových hodnot v poli v ASCII [ptá se na vstup]
void MenuBuild(const std::string& HeadTitleASCII, std::vector<std::string>* ValuesStorage, const std::size_t StorageMaxSize, const std::string& Manual, const std::string& ExtraManual, const char SeparASCII) noexcept
{
	if (ValuesStorage == nullptr) { return; } WINfunc::SET_TO_ASCII();

	std::string InBuf; uint64_t AllElemLength = NULL;

	if (ValuesStorage != nullptr)
	{
		if ((*ValuesStorage).size() != NULL)
		{
			for (std::string Elem : *ValuesStorage) { AllElemLength += Elem.length() - 1; } AllElemLength += ((*ValuesStorage).size() - 1) * 2;
		}

		for (uint64_t c = NULL; c < HeadTitleASCII.length() + AllElemLength; c++) std::cout << SeparASCII;

		std::cout << "\n" << HeadTitleASCII;

		for (std::string Elem : *ValuesStorage) { Elem == (*ValuesStorage)[(*ValuesStorage).size() - 1] ? std::cout << Elem : std::cout << Elem << ", "; } std::cout << "\n";

		for (uint64_t c = NULL; c < HeadTitleASCII.length() + AllElemLength; c++) std::cout << SeparASCII;

		std::cout << "\n" << Manual;

		if (ExtraManual != "") std::cout << "\n" << ExtraManual;

		std::cout << "\n\n::\n"; WINfunc::BLOCK_INPUT();
		std::getline(std::cin, InBuf);

		if ((*ValuesStorage).size() < StorageMaxSize) (*ValuesStorage).push_back(InBuf);
	}
	
	return;
}

//vytiskne v konsoli vìtší menu s hlavièkou pro uložení & zobrazení zadaných textových hodnot v poli v UTF-16 [ptá se na vstup]
void MenuBuild(const std::wstring& HeadTitleUTF16, std::vector<std::wstring>* ValuesStorage, const std::size_t StorageMaxSize, const std::wstring& Manual, const std::wstring& ExtraManual, const wchar_t SeparUTF16) noexcept
{
	if (ValuesStorage == nullptr) { return; } WINfunc::SET_TO_UTF16();

	std::wstring InBuf; uint64_t AllElemLength = NULL;

	if (ValuesStorage != nullptr)
	{
		if ((*ValuesStorage).size() != NULL)
		{
			for (std::wstring Elem : *ValuesStorage) { AllElemLength += Elem.length() - 1; } AllElemLength += ((*ValuesStorage).size() - 1) * 2;
		}

		for (uint64_t c = NULL; c < HeadTitleUTF16.length() + AllElemLength; c++) std::wcout << SeparUTF16;

		std::wcout << L"\n" << HeadTitleUTF16;

		for (std::wstring Elem : *ValuesStorage) { Elem == (*ValuesStorage)[(*ValuesStorage).size() - 1] ? std::wcout << Elem : std::wcout << Elem << L", "; } std::wcout << L"\n";

		for (uint64_t c = NULL; c < HeadTitleUTF16.length() + AllElemLength; c++) std::wcout << SeparUTF16;

		std::wcout << L"\n" << Manual;

		if (ExtraManual != L"") std::wcout << L"\n" << ExtraManual;

		std::wcout << L"\n\n::\n"; WINfunc::BLOCK_INPUT();
		std::getline(std::wcin, InBuf); WINfunc::SET_TO_ASCII();

		if ((*ValuesStorage).size() < StorageMaxSize) (*ValuesStorage).push_back(InBuf);
	}

	return;
}

}

}

#endif //konec bloku