
//Zdrojový soubor obsahující funkce, pro kontrolu uživatelských vstupù.

#include "init.hpp" //hlavièka se všemi knihovnami, makry + deklaracemi

namespace valid
{

//ovìøuje, zda UTF-16 øetìzec obsahuje pouze èíslo & není prázdný
bool OnlyNumber(const std::wstring& MenuUI, const uint16_t NumberSize)
{
	if (MenuUI.length() == NULL || MenuUI.length() > NumberSize) return false;
	
	for (uint64_t c = NULL; c < MenuUI.length(); c++)
		if (!(MenuUI[c] >= 0x30 && MenuUI[c] <= 0x39)) return false;

	return true;
}

//ovìøuje, zda UTF-16 øetìzec konèí znaky '.txt' & neobsahuje žádný z nepovolených znakù v názvech souborù
bool ValidFilename(const std::wstring& Filename)
{
	if (Filename.length() < 5) return false;

	if (Filename.substr(Filename.length() - 4, 4) != L".txt") return false;

	for (uint64_t c = NULL; c < Filename.length(); c++)
		if (Filename[c] == 0x5C || Filename[c] == 0x2F || Filename[c] == 0x3A || Filename[c] == 0x2A || Filename[c] == 0x3F || Filename[c] == 0x3C || Filename[c] == 0x22 || Filename[c] == 0x3E || Filename[c] == 0x7C) return false;

	return true;
}

}