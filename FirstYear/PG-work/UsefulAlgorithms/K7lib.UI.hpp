//(c) K7 corp. :: all rights reserved

//----------------------------------------------------------------------------------
//Hlavièka K7 knihovny pro vytváøení jednoduchého konzolového uivatelského rozhraní
//----------------------------------------------------------------------------------

//ochrana proti vícenásobné definici
#ifndef K7UI
#define K7UI

//!pouívám C++23 prewiew
//vloení standardních C++ knihoven pro mojí UI knihovnu
#include <iostream>
#include <string>
#include <vector>
#include <array>
#include <chrono>
#include <thread>
#include <type_traits>

//vloení Windows knihoven pro funkce v souboru K7.WIN.cpp [souèást mojí knihovny]
#ifndef WIN32_LEAN_AND_MEAN
#include <io.h>
#include <fcntl.h>
#define WIN32_LEAN_AND_MEAN
#include "windows.h"
#include "tchar.h"
#endif

//mám radši elif, no
#ifndef elif
#define elif else if
#endif

//K7.UI.cpp & K7.WIN.cpp:
namespace K7 //hlavní obor funkcí 'pseudo-standardní' knihovny K7 pro C++20/23
{
namespace WINfunc //funkce, které pouívají operaèní systém Windows k nastavování konzole podle potøeb
{

//nastaví název okna konzole na vstupní øetìzec [ASCII]
void TITLE_CONSOLE(const char* Title) noexcept;

//nastaví název okna konzole na vstupní øetìzec [UTF-16]
void TITLE_CONSOLE(const wchar_t* Title) noexcept;

//nastaví vstupní / vıstupní mód konzole na ASCII znaky
void SET_TO_ASCII() noexcept;

//nastaví vstupní / vıstupní mód konzole na UTF-16 znaky
void SET_TO_UTF16() noexcept;

//zablokuje vstupní pamì konzole, kdy program dìlá nìco jiného, ne vstup
void BLOCK_INPUT() noexcept;

//vymae vše, co bylo vytištìno do konzole pomocí èernıch mezer & vrátí kurzor do vıchozí pozice [bohuel nefunguje stoprocentnì, pracuji na lepší verzi]
void CLEAR_CONSOLE() noexcept;
}

template<typename T> concept UI_OnlyNUM = std::is_integral_v<T> && !std::same_as<T, bool>; //koncept pro omezení monıch typù v šablonì na pouze èísla [tj. bez 'bool']

namespace UIfunc //UI funkce, které jsou dùleité pro komfort uivatele, ale neinteraguje s nimi pøímo
{

//èeká na øádku po dobu uvedenou v parametru
void WaitFor(const std::size_t DurationMS) noexcept;

//vytvoøí v konzoli hlavièku s textem v ASCII
void Header(const std::string& TextASCII, const std::size_t SeparCount, const char SeparASCII = '-', const bool IsBig = false) noexcept;

//vytvoøí v konzoli hlavièku s textem v UTF16
void Header(const std::wstring& TextUTF16, const std::size_t SeparCount, const wchar_t SeparUTF16 = L'-', const bool IsBig = false) noexcept;

//vytvoøí v konzoli hlavièku s textem v ASCII & zobrazením zadané textové hodnoty v ASCII
void Header(const std::string& TextASCII, const std::size_t SeparCount, const std::string* ValueStorageASCII, const char SeparASCII = '-', const bool IsBig = false) noexcept;

//vytvoøí v konzoli hlavièku s textem v UTF-16 & zobrazením zadané textové hodnoty v UTF-16
void Header(const std::wstring& TextUTF16, const std::size_t SeparCount, const std::wstring* ValueStorageUTF16, const wchar_t SeparUTF16 = L'-', const bool IsBig = false) noexcept;
}
namespace UImenu //UI funkce pro vytvoøení rùznıch menu, s kterımi uivatel interaguje pomocí vstupù & ovládá tím UI
{

//vytvoøí v konsoli tabulkové menu s polem textù v ASCII [ptá se na vstup]
std::string MenuBuild(const std::string& TitleASCII, const std::vector<std::string>& ValToChooseASCII, const std::string& EndSentenceASCII, const char SeparLengthASCII = '-', const char SeparWidthASCII = '|') noexcept;

//vytvoøí v konsoli tabulkové menu s pevnım polem textù v ASCII [ptá se na vstup]
template<UI_OnlyNUM ArrSizeType, ArrSizeType ArrSizeValue> inline std::string MenuBuild(const std::string& TitleASCII, const std::array<std::string, ArrSizeValue>& ValToChooseASCII, const std::string& EndSentenceASCII, const char SeparLengthASCII = '-', const char SeparWidthASCII = '|') noexcept
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
std::wstring MenuBuild(const std::wstring& TitleUTF16, const std::vector<std::wstring>& ValToChooseUTF16, const std::wstring& EndSentenceUTF16, const wchar_t SeparLengthUTF16 = L'-', const wchar_t SeparWidthUTF16 = L'|') noexcept;

//vytvoøí v konsoli tabulkové menu s pevnım polem textù v UTF-16 [ptá se na vstup]
template<UI_OnlyNUM ArrSizeType, ArrSizeType ArrSizeValue> inline std::wstring MenuBuild(const std::wstring& TitleUTF16, const std::array<std::wstring, ArrSizeValue>& ValToChooseUTF16, const std::wstring& EndSentenceUTF16, const wchar_t SeparLengthUTF16 = L'-', const wchar_t SeparWidthUTF16 = L'|') noexcept
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
	std::getline(std::wcin, menuUI); WINfunc::SET_TO_ASCII(); return menuUI;
}

//vytiskne v konsoli menší menu s jedním øetìzcem textù v ASCII [ptá se na vstup]
std::string MenuBuild(const std::string& TitleASCII) noexcept;

//vytiskne v konsoli menší menu s jedním øetìzcem textù v UTF-16 [ptá se na vstup]
std::wstring MenuBuild(const std::wstring& TitleUTF16) noexcept;

//vytiskne v konsoli vìtší menu s hlavièkou pro uloení & zobrazení zadané textové hodnoty v ASCII [ptá se na vstup]
void MenuBuild(const std::string& HeadTitleASCII, std::string* ValuesStorage, const std::string& Manual, const std::string& ExtraManual = "", const char SeparASCII = '-') noexcept;

//vytiskne v konsoli vìtší menu s hlavièkou pro uloení & zobrazení zadané textové hodnoty v UTF-16 [ptá se na vstup]
void MenuBuild(const std::wstring& HeadTitleUTF16, std::wstring* ValuesStorage, const std::wstring& Manual, const std::wstring& ExtraManual = L"", const wchar_t SeparUTF16 = L'-') noexcept;

//vytiskne v konsoli vìtší menu s hlavièkou pro uloení & zobrazení zadanıch textovıch hodnot v poli v ASCII [ptá se na vstup]
void MenuBuild(const std::string& HeadTitleASCII, std::vector<std::string>* ValuesStorage, const std::size_t StorageMaxSize, const std::string& Manual, const std::string& ExtraManual, const char SeparASCII = '-') noexcept;

//vytiskne v konsoli vìtší menu s hlavièkou pro uloení & zobrazení zadanıch textovıch hodnot v poli v UTF-16 [ptá se na vstup]
void MenuBuild(const std::wstring& HeadTitleUTF16, std::vector<std::wstring>* ValuesStorage, const std::size_t StorageMaxSize, const std::wstring& Manual, const std::wstring& ExtraManual, const wchar_t SeparUTF16 = L'-') noexcept;
}

}

#endif //konec bloku