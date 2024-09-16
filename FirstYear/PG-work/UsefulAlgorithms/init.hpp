
//Hlavní hlavièka pro správné linkování zdrojových souborù [pomocí deklarací funkcí] + dalších hlavièek.

//ochrana proti vícenásobné definici
#ifndef MainInit 
#define MainInit

//!používám C++23 prewiew
//vložení C++ standardních knihoven
#include <iostream>
#include <string>
#include <vector>
#include <array>
#include <random>
#include <chrono>
#include <thread>
#include <fstream>
#include <optional>

//mám radši elif, no
#ifndef elif
#define elif else if
#endif

//Vložení struktury [kontejneru] s texty pro konzolové UI
#ifndef IncludeUItext
#define IncludeUItext
#include "UItextStorage.hpp"
#endif

//UIfloor_main.cpp:
namespace FloorMain
{

//rozšiøující rozcestník pro možnost 1 v 'main.cpp'
void Option1(std::wstring& MenuUI);

//rozšiøující rozcestník pro možnost 2 v 'main.cpp'
void Option2(std::wstring& MenuUI);

//rozšiøující rozcestník pro možnost 3 v 'main.cpp'
void Option3(std::wstring& MenuUI);

//Získání názvù vstupního & výstupního souboru pro možnost 4 v 'main.cpp'
void Option4(std::wstring& MenuUI);

//Získání hodnot pro náhodný generátor èísel & názvu výstupního souboru pro možnost 5 v 'main.cpp'
void Option5(std::wstring& MenuUI);
}

//UIfloor_2&&3.cpp:
namespace Floor_2_3
{

//provádí algoritmus & funcionalitu okolo pro možnost 1 v 'UIfloor_main.cpp' v možnosti 2 z 'main.cpp'
void Option_2_1(std::wstring& MenuUI);

//provádí algoritmus & funcionalitu okolo pro možnost 2 v 'UIfloor_main.cpp' v možnosti 2 z 'main.cpp'
void Option_2_2(std::wstring& MenuUI);

//provádí algoritmus & funcionalitu okolo pro možnost 1 v 'UIfloor_main.cpp' v možnosti 3 z 'main.cpp'
void Option_3_1(std::wstring& MenuUI);

//provádí algoritmus & funcionalitu okolo pro možnost 2 v 'UIfloor_main.cpp' v možnosti 3 z 'main.cpp'
void Option_3_2(std::wstring& MenuUI);
}

//UIfloor_4.cpp:
namespace Floor_4_5
{

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 1 v 'UIfloor_main.cpp' v možnosti 4 z 'main.cpp'
void Option_4_1(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 2 v 'UIfloor_main.cpp' v možnosti 4 z 'main.cpp'
void Option_4_2(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 3 v 'UIfloor_main.cpp' v možnosti 4 z 'main.cpp'
void Option_4_3(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 4 v 'UIfloor_main.cpp' v možnosti 4 z 'main.cpp'
void Option_4_4(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 5 v 'UIfloor_main.cpp' v možnosti 4 z 'main.cpp'
void Option_4_5(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 6 v 'UIfloor_main.cpp' v možnosti 4 z 'main.cpp'
void Option_4_6(std::wstring& MenuUI, std::vector<std::string>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 1 v 'UIfloor_main.cpp' v možnosti 5 z 'main.cpp'
void Option_5_1(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 2 v 'UIfloor_main.cpp' v možnosti 5 z 'main.cpp'
void Option_5_2(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 3 v 'UIfloor_main.cpp' v možnosti 5 z 'main.cpp'
void Option_5_3(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 4 v 'UIfloor_main.cpp' v možnosti 5 z 'main.cpp'
void Option_5_4(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 5 v 'UIfloor_main.cpp' v možnosti 5 z 'main.cpp'
void Option_5_5(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);

//spouští seøazovací algoritmus & mìøí jeho výkon pro možnost 6 v 'UIfloor_main.cpp' v možnosti 5 z 'main.cpp'
void Option_5_6(std::wstring& MenuUI, std::vector<uint64_t>& FileValues);
}

//valid.cpp:
namespace valid
{

//ovìøuje, zda UTF-16 øetìzec obsahuje pouze èíslo & není prázdný
bool OnlyNumber(const std::wstring& MenuUI, const uint16_t NumberSize);

//ovìøuje, zda UTF-16 øetìzec konèí znaky '.txt' & neobsahuje žádný z nepovolených znakù v názvech souborù
bool ValidFilename(const std::wstring& Filename);
}

//algorithms.cpp:
namespace Algorithm
{

namespace RandomSequence
{

//Vygeneruje zadaný poèet èísel v zadaném rozmezí pomocí K7lib.random
std::vector<uint64_t> RandomNumberSequence(const uint64_t NumCount, const uint64_t MinValue, const uint64_t MaxValue) noexcept;

//Vygeneruje zadaný poèet ASCII hesel se zadanou délkou pomocí K7lib.random
std::vector<std::string> RandomPasswordSequence(const uint64_t PasswordCount, const uint64_t PasswordLength) noexcept;
}

namespace PrimeNumbers
{

//Vygeneruje prvoèíselnou øadu v zadaném rozmezí
std::vector<uint64_t> PrimeNumberGenerator(int64_t FromNum, const int64_t ToNum) noexcept;

//Vygeneruje prvoèíselnou øadu v zadaném rozmezí s pomocí matematické optimalizace
std::vector<uint64_t> OptimizedPrimeNumberGenerator(int64_t FromNum, const int64_t ToNum) noexcept;
}

namespace Sorting
{

//seøadí hodnoty v poli postupným porovnáváním dvojic hodnot vedle sebe & jejich pøípadným prohozením
void BubbleSort(std::vector<uint64_t>& Values) noexcept;
void BubbleSort(std::vector<std::string>& Values) noexcept;

//nejprve najde nejmenší prvek v poli hodnot & ten pak dá do seøazené èásti pole, takhle to opakuje dokud není pole seøazeno
void SelectionSort(std::vector<uint64_t>& Values) noexcept;
void SelectionSort(std::vector<std::string>& Values) noexcept;

//porovnává všechny prvky seøazené èásti pole s prvním prvkem v neseøazené èásti, poté posune prvek na pøíslušnou pozici v seøazené èásti, takhle to opakuje dokud není pole seøazeno
void InsertionSort(std::vector<uint64_t>& Values) noexcept;
void InsertionSort(std::vector<std::string>& Values) noexcept;

//zvolí poslední prvek pole, jako Pivot, s ním porovnává všechny ostatní prvky, nakonec jsou menší hodnoty nalevo, vìtší napravo [používá se sám na sebe]
void QuickSort(std::vector<uint64_t>& Values, const int64_t LowestIndex, const int64_t HighestIndex) noexcept;
void QuickSort(std::vector<std::string>& Values, const int64_t LowestIndex, const int64_t HighestIndex) noexcept;

//rozdìlí pole na levou & pravou polovinu, ty pak seøadí sám sebou & nakonec všechny poloviny spojí do jednoho seøazeného pole
void MergeSort(std::vector<uint64_t>& Values) noexcept;
void MergeSort(std::vector<std::string>& Values) noexcept;

//Rozdìlí prvky pole do stanoveného poètu kbelíkù, ty pak seøadí jiným algoritmem [v tomto pøípadì - 'Quick Sort'] & nakonec spojí kbelíky do jednoho seøazeného pole
void BucketSort(std::vector<uint64_t>& Values, uint64_t BucketCount) noexcept;
void BucketSort(std::vector<std::string>& Values, uint64_t BucketCount) noexcept;
}
}

#endif //konec bloku