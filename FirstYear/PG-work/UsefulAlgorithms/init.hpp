
//Hlavn� hlavi�ka pro spr�vn� linkov�n� zdrojov�ch soubor� [pomoc� deklarac� funkc�] + dal��ch hlavi�ek.

//ochrana proti v�cen�sobn� definici
#ifndef MainInit 
#define MainInit

//!pou��v�m C++23 prewiew
//vlo�en� C++ standardn�ch knihoven
#include <iostream>
#include <string>
#include <vector>
#include <array>
#include <random>
#include <chrono>
#include <thread>
#include <fstream>
#include <optional>

//m�m rad�i elif, no
#ifndef elif
#define elif else if
#endif

//Vlo�en� struktury [kontejneru] s texty pro konzolov� UI
#ifndef IncludeUItext
#define IncludeUItext
#include "UItextStorage.hpp"
#endif

//UIfloor_main.cpp:
namespace FloorMain
{

//roz�i�uj�c� rozcestn�k pro mo�nost 1 v 'main.cpp'
void Option1(std::wstring& MenuUI);

//roz�i�uj�c� rozcestn�k pro mo�nost 2 v 'main.cpp'
void Option2(std::wstring& MenuUI);

//roz�i�uj�c� rozcestn�k pro mo�nost 3 v 'main.cpp'
void Option3(std::wstring& MenuUI);

//Z�sk�n� n�zv� vstupn�ho & v�stupn�ho souboru pro mo�nost 4 v 'main.cpp'
void Option4(std::wstring& MenuUI);

//Z�sk�n� hodnot pro n�hodn� gener�tor ��sel & n�zvu v�stupn�ho souboru pro mo�nost 5 v 'main.cpp'
void Option5(std::wstring& MenuUI);
}

//UIfloor_2&&3.cpp:
namespace Floor_2_3
{

//prov�d� algoritmus & funcionalitu okolo pro mo�nost 1 v 'UIfloor_main.cpp' v mo�nosti 2 z 'main.cpp'
void Option_2_1(std::wstring& MenuUI);

//prov�d� algoritmus & funcionalitu okolo pro mo�nost 2 v 'UIfloor_main.cpp' v mo�nosti 2 z 'main.cpp'
void Option_2_2(std::wstring& MenuUI);

//prov�d� algoritmus & funcionalitu okolo pro mo�nost 1 v 'UIfloor_main.cpp' v mo�nosti 3 z 'main.cpp'
void Option_3_1(std::wstring& MenuUI);

//prov�d� algoritmus & funcionalitu okolo pro mo�nost 2 v 'UIfloor_main.cpp' v mo�nosti 3 z 'main.cpp'
void Option_3_2(std::wstring& MenuUI);
}

//UIfloor_4.cpp:
namespace Floor_4_5
{

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 1 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_1(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 2 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_2(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 3 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_3(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 4 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_4(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 5 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_5(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 6 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_6(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 1 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_1(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 2 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_2(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 3 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_3(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 4 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_4(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 5 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_5(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 6 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_6(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);
}

//valid.cpp:
namespace valid
{

//ov��uje, zda UTF-16 �et�zec obsahuje pouze ��slo & nen� pr�zdn�
bool OnlyNumber(const std::wstring& MenuUI, const uint16_t NumberSize);

//ov��uje, zda UTF-16 �et�zec kon�� znaky '.txt' & neobsahuje ��dn� z nepovolen�ch znak� v n�zvech soubor�
bool ValidFilename(const std::wstring& Filename);
}

//algorithms.cpp:
namespace Algorithm
{

namespace RandomSequence
{

//Vygeneruje zadan� po�et ��sel v zadan�m rozmez� pomoc� K7lib.random
std::vector<uint64_t> RandomNumberSequence(const uint64_t NumCount, const uint64_t MinValue, const uint64_t MaxValue) noexcept;

//Vygeneruje zadan� po�et ASCII hesel se zadanou d�lkou pomoc� K7lib.random
std::vector<std::string> RandomPasswordSequence(const uint64_t PasswordCount, const uint64_t PasswordLength) noexcept;
}

namespace PrimeNumbers
{

//Vygeneruje prvo��selnou �adu v zadan�m rozmez�
std::vector<uint64_t> PrimeNumberGenerator(int64_t FromNum, const int64_t ToNum) noexcept;

//Vygeneruje prvo��selnou �adu v zadan�m rozmez� s pomoc� matematick� optimalizace
std::vector<uint64_t> OptimizedPrimeNumberGenerator(int64_t FromNum, const int64_t ToNum) noexcept;
}

namespace Sorting
{

//se�ad� hodnoty v poli postupn�m porovn�v�n�m dvojic hodnot vedle sebe & jejich p��padn�m prohozen�m
void BubbleSort(std::vector<uint64_t>& Values) noexcept;
void BubbleSort(std::vector<std::string>& Values) noexcept;

//nejprve najde nejmen�� prvek v poli hodnot & ten pak d� do se�azen� ��sti pole, takhle to opakuje dokud nen� pole se�azeno
void SelectionSort(std::vector<uint64_t>& Values) noexcept;
void SelectionSort(std::vector<std::string>& Values) noexcept;

//porovn�v� v�echny prvky se�azen� ��sti pole s prvn�m prvkem v nese�azen� ��sti, pot� posune prvek na p��slu�nou pozici v se�azen� ��sti, takhle to opakuje dokud nen� pole se�azeno
void InsertionSort(std::vector<uint64_t>& Values) noexcept;
void InsertionSort(std::vector<std::string>& Values) noexcept;

//zvol� posledn� prvek pole, jako Pivot, s n�m porovn�v� v�echny ostatn� prvky, nakonec jsou men�� hodnoty nalevo, v�t�� napravo [pou��v� se s�m na sebe]
void QuickSort(std::vector<uint64_t>& Values, const int64_t LowestIndex, const int64_t HighestIndex) noexcept;
void QuickSort(std::vector<std::string>& Values, const int64_t LowestIndex, const int64_t HighestIndex) noexcept;

//rozd�l� pole na levou & pravou polovinu, ty pak se�ad� s�m sebou & nakonec v�echny poloviny spoj� do jednoho se�azen�ho pole
void MergeSort(std::vector<uint64_t>& Values) noexcept;
void MergeSort(std::vector<std::string>& Values) noexcept;

//Rozd�l� prvky pole do stanoven�ho po�tu kbel�k�, ty pak se�ad� jin�m algoritmem [v tomto p��pad� - 'Quick Sort'] & nakonec spoj� kbel�ky do jednoho se�azen�ho pole
void BucketSort(std::vector<uint64_t>& Values, uint64_t BucketCount) noexcept;
void BucketSort(std::vector<std::string>& Values, uint64_t BucketCount) noexcept;
}
}

#endif //konec bloku