//(c) K7 corp. :: all rights reserved

//----------------------------------------------
//Hlavièka K7 knihovny pro komunikaci se soubory
//----------------------------------------------

//ochrana proti vícenásobné definici
#ifndef K7file
#define K7file

//!používám C++23 prewiew
//vložení standardních C++ knihoven pro mojí souborovou knihovnu
#include <fstream>
#include <string>
#include <vector>
#include <array>
#include <type_traits>

//mám radši elif, no
#ifndef elif
#define elif else if
#endif

namespace K7 //hlavní obor funkcí 'pseudo-standardní' knihovny K7 pro C++20/23
{

template<typename T> concept FILE_OnlyNUM = std::is_integral_v<T> && !std::same_as<T, bool>; //koncept pro omezení možných typù v šablonì na pouze èísla [tj. ne bool]
template<typename T> concept FILE_OnlySTRorWSTR = std::same_as<T, std::string> || std::same_as<T, std::wstring>; //koncept pro omezení možných typù v šablonì na pouze string, nebo wstring
template<typename T> concept FILE_OnlyVECTOR_STR = std::same_as<T, std::vector<std::string>>; //koncept pro omezení možných typù v šablonì na pouze vector stringù

namespace Fout //souborové výstupní funkce pro vytvoøení/zápis do souborù
{

//vytvoøí nový prázdný soubor podle zadaného názvu [pøípona musí být v názvu]
template<FILE_OnlySTRorWSTR STRorWSTR> inline void New(const STRorWSTR& Filename) noexcept { std::ofstream file(Filename); file.clear(); file.close(); return; }

//pøepíše vše v souboru se zadaným názvem [pøípona musí být v názvu] na jednu linku s hodnotou zadaného øetìzce
template<FILE_OnlySTRorWSTR STRorWSTR> inline void Write(const STRorWSTR& Filename, const std::string& DataToWrite) noexcept
{
	std::fstream file; file.open(Filename, std::ios::out | std::ios::app); file.clear();

	if (!file.is_open()) { file.close(); return; }

	file.write(DataToWrite.c_str(), (std::streamsize)DataToWrite.length());
	file.close(); return;
}

//pøepíše vše v souboru se zadaným názvem [pøípona musí být v názvu] na linky s hodnotami zadaného pole øetìzcù [každý prvek je na nové lince]
template<FILE_OnlySTRorWSTR STRorWSTR, FILE_OnlyVECTOR_STR ArrType> inline void Write(const STRorWSTR& Filename, const ArrType& DataToWrite) noexcept
{
	std::fstream file; file.open(Filename, std::ios::out | std::ios::app); file.clear();

	if (!file.is_open()) { file.close(); return; }

	for (std::string Elem : DataToWrite)
	{
		Elem.push_back('\n');
		file.write(Elem.c_str(), (std::streamsize)Elem.length());
	}

	file.close(); return;
}

//pøepíše vše v souboru se zadaným názvem [pøípona musí být v názvu] na linky s hodnotami zadaného pole èísel [každý prvek je na nové lince]
template<FILE_OnlySTRorWSTR STRorWSTR, FILE_OnlyNUM ArrType> inline void Write(const STRorWSTR& Filename, const std::vector<ArrType>& DataToWrite) noexcept
{
	std::fstream file; file.open(Filename, std::ios::out | std::ios::app); file.clear();

	if (!file.is_open()) { file.close(); return; }

	std::vector<std::string> DataToWriteSTR(0);

	for (ArrType Elem : DataToWrite)
	{
		DataToWriteSTR.push_back(std::to_string(Elem));
	}

	for (std::string Elem : DataToWriteSTR)
	{
		Elem.push_back('\n');
		file.write(Elem.c_str(), (std::streamsize)Elem.length());
	}

	file.close(); return;
}

}
namespace Fin //souborové vstupní funkce pro ètení ze souborù
{

//pøeète první linku v souboru se zadaným názvem [pøípona musí být v názvu] do øetìzce, který buï vrátí, nebo odkáže ukazovatelem
template<FILE_OnlySTRorWSTR STRorWSTR> inline std::string Read(const STRorWSTR& Filename, std::string* Container = nullptr) noexcept
{
	std::fstream file; file.open(Filename, std::ios::in); file.clear();

	if (!file.is_open()) { file.close(); return ""; }

	if (Container != nullptr)
	{
		std::getline(file, *Container, '\n'); file.close(); return "";
	}
	else
	{
		std::string Extract; std::getline(file, Extract, '\n'); file.close(); return Extract;
	}

	file.close(); return "";
}

//pøeète každou linku v souboru se zadaným názvem [pøípona musí být v názvu] do pole øetìzce, které buï vrátí, nebo odkáže ukazovatelem [jedna linka = nový prvek]
template<FILE_OnlySTRorWSTR STRorWSTR, FILE_OnlyVECTOR_STR ArrType> inline std::vector<std::string> Read(const STRorWSTR& Filename, ArrType* Container = nullptr) noexcept
{
	std::fstream file; file.open(Filename, std::ios::in); file.clear(); std::string FileBuf;

	if (!file.is_open()) { file.close(); return {}; }

	if (Container != nullptr)
	{
		(*Container).clear();

		while (!file.eof()) { std::getline(file, FileBuf, '\n'); (*Container).push_back(FileBuf); }

		if ((*Container)[(*Container).size() - 1] == "") { (*Container).pop_back(); }

		file.close(); return {};
	}
	else
	{
		std::vector<std::string> Extract(0); Extract.clear();

		while (!file.eof()) { std::getline(file, FileBuf, '\n'); Extract.push_back(FileBuf); }

		if (Extract[Extract.size() - 1] == "") { Extract.pop_back(); }

		file.close(); return Extract;
	}

	file.close(); return {};
}

}

}

#endif //konec bloku