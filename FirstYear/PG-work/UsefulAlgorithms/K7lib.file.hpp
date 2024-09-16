//(c) K7 corp. :: all rights reserved

//----------------------------------------------
//Hlavi�ka K7 knihovny pro komunikaci se soubory
//----------------------------------------------

//ochrana proti v�cen�sobn� definici
#ifndef K7file
#define K7file

//!pou��v�m C++23 prewiew
//vlo�en� standardn�ch C++ knihoven pro moj� souborovou knihovnu
#include <fstream>
#include <string>
#include <vector>
#include <array>
#include <type_traits>

//m�m rad�i elif, no
#ifndef elif
#define elif else if
#endif

namespace K7 //hlavn� obor funkc� 'pseudo-standardn�' knihovny K7 pro C++20/23
{

template<typename T> concept FILE_OnlyNUM = std::is_integral_v<T> && !std::same_as<T, bool>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze ��sla [tj. ne bool]
template<typename T> concept FILE_OnlySTRorWSTR = std::same_as<T, std::string> || std::same_as<T, std::wstring>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze string, nebo wstring
template<typename T> concept FILE_OnlyVECTOR_STR = std::same_as<T, std::vector<std::string>>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze vector string�

namespace Fout //souborov� v�stupn� funkce pro vytvo�en�/z�pis do soubor�
{

//vytvo�� nov� pr�zdn� soubor podle zadan�ho n�zvu [p��pona mus� b�t v n�zvu]
template<FILE_OnlySTRorWSTR STRorWSTR> inline void New(const STRorWSTR& Filename) noexcept { std::ofstream file(Filename); file.clear(); file.close(); return; }

//p�ep�e v�e v souboru se zadan�m n�zvem [p��pona mus� b�t v n�zvu] na jednu linku s hodnotou zadan�ho �et�zce
template<FILE_OnlySTRorWSTR STRorWSTR> inline void Write(const STRorWSTR& Filename, const std::string& DataToWrite) noexcept
{
	std::fstream file; file.open(Filename, std::ios::out | std::ios::app); file.clear();

	if (!file.is_open()) { file.close(); return; }

	file.write(DataToWrite.c_str(), (std::streamsize)DataToWrite.length());
	file.close(); return;
}

//p�ep�e v�e v souboru se zadan�m n�zvem [p��pona mus� b�t v n�zvu] na linky s hodnotami zadan�ho pole �et�zc� [ka�d� prvek je na nov� lince]
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

//p�ep�e v�e v souboru se zadan�m n�zvem [p��pona mus� b�t v n�zvu] na linky s hodnotami zadan�ho pole ��sel [ka�d� prvek je na nov� lince]
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
namespace Fin //souborov� vstupn� funkce pro �ten� ze soubor�
{

//p�e�te prvn� linku v souboru se zadan�m n�zvem [p��pona mus� b�t v n�zvu] do �et�zce, kter� bu� vr�t�, nebo odk�e ukazovatelem
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

//p�e�te ka�dou linku v souboru se zadan�m n�zvem [p��pona mus� b�t v n�zvu] do pole �et�zce, kter� bu� vr�t�, nebo odk�e ukazovatelem [jedna linka = nov� prvek]
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