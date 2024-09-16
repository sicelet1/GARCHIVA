//(c) K7 corp. :: all rights reserved

//-------------------------------------------------------------------------------------------------
//Zdrojov� soubor K7.UI knihovny obsahuj�c� funkce pro modifikov�n� konzole prost�ednictv�m Windows
//-------------------------------------------------------------------------------------------------

//hlavi�ka se v�emi pot�ebn�mi knihovnami + deklaracemi
#include "K7lib.UI.hpp"

//test hlavi�ky
#ifdef K7UI

//test p��tomnosti windows hlavi�ek
#ifdef WIN32_LEAN_AND_MEAN

namespace K7 //hlavn� obor funkc� 'pseudo-standardn�' knihovny K7 pro C++20/23
{

namespace WINfunc //funkce, kter� pou��vaj� opera�n� syst�m Windows k nastavov�n� konzole podle pot�eb
{

//nastav� n�zev okna konzole na vstupn� �et�zec [ASCII]
void TITLE_CONSOLE(const char* Title) noexcept { SetConsoleTitleA((CHAR*)Title); return; }

//nastav� n�zev okna konzole na vstupn� �et�zec [UTF-16]
void TITLE_CONSOLE(const wchar_t* Title) noexcept { SetConsoleTitleW((WCHAR*)Title); return; }

//nastav� vstupn� / v�stupn� m�d konzole na ASCII znaky
void SET_TO_ASCII() noexcept
{
	(void)_setmode(_fileno(stdout), _O_TEXT);
	(void)_setmode(_fileno(stdin), _O_TEXT);

	return;
}

//nastav� vstupn� / v�stupn� m�d konzole na UTF-16 znaky
void SET_TO_UTF16() noexcept
{
	(void)_setmode(_fileno(stdout), _O_U16TEXT);
	(void)_setmode(_fileno(stdin), _O_U16TEXT);

	return;
}

//zablokuje vstupn� pam� konzole, kdy� program d�l� n�co jin�ho, ne� vstup
void BLOCK_INPUT() noexcept
{
	FlushConsoleInputBuffer(GetStdHandle(STD_INPUT_HANDLE)); return;
}

//vyma�e v�e, co bylo vyti�t�no do konzole pomoc� �ern�ch mezer & vr�t� kurzor do v�choz� pozice [bohu�el nefunguje stoprocentn�, pracuji na lep�� verzi]
void CLEAR_CONSOLE() noexcept
{
	COORD topLeft = { 0, 0 };
	HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
	CONSOLE_SCREEN_BUFFER_INFO screen; DWORD written;
	GetConsoleScreenBufferInfo(console, &screen);
	FillConsoleOutputCharacterA(console, ' ', screen.dwSize.X * screen.dwSize.Y, topLeft, &written);
	FillConsoleOutputAttribute(console, FOREGROUND_GREEN | FOREGROUND_RED | FOREGROUND_BLUE, screen.dwSize.X * screen.dwSize.Y, topLeft, &written);
	SetConsoleCursorPosition(console, topLeft); return;
}

}

}

#endif //konec bloku
#endif //konec bloku