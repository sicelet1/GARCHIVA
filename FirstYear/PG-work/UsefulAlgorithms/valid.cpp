
//Zdrojov� soubor obsahuj�c� funkce, pro kontrolu u�ivatelsk�ch vstup�.

#include "init.hpp" //hlavi�ka se v�emi knihovnami, makry + deklaracemi

namespace valid
{

//ov��uje, zda UTF-16 �et�zec obsahuje pouze ��slo & nen� pr�zdn�
bool OnlyNumber(const std::wstring& MenuUI, const uint16_t NumberSize)
{
	if (MenuUI.length() == NULL || MenuUI.length() > NumberSize) return false;
	
	for (uint64_t c = NULL; c < MenuUI.length(); c++)
		if (!(MenuUI[c] >= 0x30 && MenuUI[c] <= 0x39)) return false;

	return true;
}

//ov��uje, zda UTF-16 �et�zec kon�� znaky '.txt' & neobsahuje ��dn� z nepovolen�ch znak� v n�zvech soubor�
bool ValidFilename(const std::wstring& Filename)
{
	if (Filename.length() < 5) return false;

	if (Filename.substr(Filename.length() - 4, 4) != L".txt") return false;

	for (uint64_t c = NULL; c < Filename.length(); c++)
		if (Filename[c] == 0x5C || Filename[c] == 0x2F || Filename[c] == 0x3A || Filename[c] == 0x2A || Filename[c] == 0x3F || Filename[c] == 0x3C || Filename[c] == 0x22 || Filename[c] == 0x3E || Filename[c] == 0x7C) return false;

	return true;
}

}