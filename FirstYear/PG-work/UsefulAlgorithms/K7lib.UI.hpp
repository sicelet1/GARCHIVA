//(c) K7 corp. :: all rights reserved

//----------------------------------------------------------------------------------
//Hlavi�ka K7 knihovny pro vytv��en� jednoduch�ho konzolov�ho u�ivatelsk�ho rozhran�
//----------------------------------------------------------------------------------

//ochrana proti v�cen�sobn� definici
#ifndef K7UI
#define K7UI

//!pou��v�m C++23 prewiew
//vlo�en� standardn�ch C++ knihoven pro moj� UI knihovnu
#include <iostream>
#include <string>
#include <vector>
#include <array>
#include <chrono>
#include <thread>
#include <type_traits>

//vlo�en� Windows knihoven pro funkce v souboru K7.WIN.cpp [sou��st moj� knihovny]
#ifndef WIN32_LEAN_AND_MEAN
#include <io.h>
#include <fcntl.h>
#define WIN32_LEAN_AND_MEAN
#include "windows.h"
#include "tchar.h"
#endif

//m�m rad�i elif, no
#ifndef elif
#define elif else if
#endif

//K7.UI.cpp & K7.WIN.cpp:
namespace K7 //hlavn� obor funkc� 'pseudo-standardn�' knihovny K7 pro C++20/23
{
namespace WINfunc //funkce, kter� pou��vaj� opera�n� syst�m Windows k nastavov�n� konzole podle pot�eb
{

//nastav� n�zev okna konzole na vstupn� �et�zec [ASCII]
void TITLE_CONSOLE(const char* Title) noexcept;

//nastav� n�zev okna konzole na vstupn� �et�zec [UTF-16]
void TITLE_CONSOLE(const wchar_t* Title) noexcept;

//nastav� vstupn� / v�stupn� m�d konzole na ASCII znaky
void SET_TO_ASCII() noexcept;

//nastav� vstupn� / v�stupn� m�d konzole na UTF-16 znaky
void SET_TO_UTF16() noexcept;

//zablokuje vstupn� pam� konzole, kdy� program d�l� n�co jin�ho, ne� vstup
void BLOCK_INPUT() noexcept;

//vyma�e v�e, co bylo vyti�t�no do konzole pomoc� �ern�ch mezer & vr�t� kurzor do v�choz� pozice [bohu�el nefunguje stoprocentn�, pracuji na lep�� verzi]
void CLEAR_CONSOLE() noexcept;
}

template<typename T> concept UI_OnlyNUM = std::is_integral_v<T> && !std::same_as<T, bool>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze ��sla [tj. bez 'bool']

namespace UIfunc //UI funkce, kter� jsou d�le�it� pro komfort u�ivatele, ale neinteraguje s nimi p��mo
{

//�ek� na ��dku po dobu uvedenou v parametru
void WaitFor(const std::size_t DurationMS) noexcept;

//vytvo�� v konzoli hlavi�ku s textem v ASCII
void Header(const std::string& TextASCII, const std::size_t SeparCount, const char SeparASCII = '-', const bool IsBig = false) noexcept;

//vytvo�� v konzoli hlavi�ku s textem v UTF16
void Header(const std::wstring& TextUTF16, const std::size_t SeparCount, const wchar_t SeparUTF16 = L'-', const bool IsBig = false) noexcept;

//vytvo�� v konzoli hlavi�ku s textem v ASCII & zobrazen�m zadan� textov� hodnoty v ASCII
void Header(const std::string& TextASCII, const std::size_t SeparCount, const std::string* ValueStorageASCII, const char SeparASCII = '-', const bool IsBig = false) noexcept;

//vytvo�� v konzoli hlavi�ku s textem v UTF-16 & zobrazen�m zadan� textov� hodnoty v UTF-16
void Header(const std::wstring& TextUTF16, const std::size_t SeparCount, const std::wstring* ValueStorageUTF16, const wchar_t SeparUTF16 = L'-', const bool IsBig = false) noexcept;
}
namespace UImenu //UI funkce pro vytvo�en� r�zn�ch menu, s kter�mi u�ivatel interaguje pomoc� vstup� & ovl�d� t�m UI
{

//vytvo�� v konsoli tabulkov� menu s polem text� v ASCII [pt� se na vstup]
std::string MenuBuild(const std::string& TitleASCII, const std::vector<std::string>& ValToChooseASCII, const std::string& EndSentenceASCII, const char SeparLengthASCII = '-', const char SeparWidthASCII = '|') noexcept;

//vytvo�� v konsoli tabulkov� menu s pevn�m polem text� v ASCII [pt� se na vstup]
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

//vytvo�� v konsoli tabulkov� menu s polem text� v UTF-16 [pt� se na vstup]
std::wstring MenuBuild(const std::wstring& TitleUTF16, const std::vector<std::wstring>& ValToChooseUTF16, const std::wstring& EndSentenceUTF16, const wchar_t SeparLengthUTF16 = L'-', const wchar_t SeparWidthUTF16 = L'|') noexcept;

//vytvo�� v konsoli tabulkov� menu s pevn�m polem text� v UTF-16 [pt� se na vstup]
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

//vytiskne v konsoli men�� menu s jedn�m �et�zcem text� v ASCII [pt� se na vstup]
std::string MenuBuild(const std::string& TitleASCII) noexcept;

//vytiskne v konsoli men�� menu s jedn�m �et�zcem text� v UTF-16 [pt� se na vstup]
std::wstring MenuBuild(const std::wstring& TitleUTF16) noexcept;

//vytiskne v konsoli v�t�� menu s hlavi�kou pro ulo�en� & zobrazen� zadan� textov� hodnoty v ASCII [pt� se na vstup]
void MenuBuild(const std::string& HeadTitleASCII, std::string* ValuesStorage, const std::string& Manual, const std::string& ExtraManual = "", const char SeparASCII = '-') noexcept;

//vytiskne v konsoli v�t�� menu s hlavi�kou pro ulo�en� & zobrazen� zadan� textov� hodnoty v UTF-16 [pt� se na vstup]
void MenuBuild(const std::wstring& HeadTitleUTF16, std::wstring* ValuesStorage, const std::wstring& Manual, const std::wstring& ExtraManual = L"", const wchar_t SeparUTF16 = L'-') noexcept;

//vytiskne v konsoli v�t�� menu s hlavi�kou pro ulo�en� & zobrazen� zadan�ch textov�ch hodnot v poli v ASCII [pt� se na vstup]
void MenuBuild(const std::string& HeadTitleASCII, std::vector<std::string>* ValuesStorage, const std::size_t StorageMaxSize, const std::string& Manual, const std::string& ExtraManual, const char SeparASCII = '-') noexcept;

//vytiskne v konsoli v�t�� menu s hlavi�kou pro ulo�en� & zobrazen� zadan�ch textov�ch hodnot v poli v UTF-16 [pt� se na vstup]
void MenuBuild(const std::wstring& HeadTitleUTF16, std::vector<std::wstring>* ValuesStorage, const std::size_t StorageMaxSize, const std::wstring& Manual, const std::wstring& ExtraManual, const wchar_t SeparUTF16 = L'-') noexcept;
}

}

#endif //konec bloku