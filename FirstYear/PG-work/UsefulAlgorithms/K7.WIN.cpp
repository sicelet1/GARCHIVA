//(c) K7 corp. :: all rights reserved

//-------------------------------------------------------------------------------------------------
//Zdrojovı soubor K7.UI knihovny obsahující funkce pro modifikování konzole prostøednictvím Windows
//-------------------------------------------------------------------------------------------------

//hlavièka se všemi potøebnımi knihovnami + deklaracemi
#include "K7lib.UI.hpp"

//test hlavièky
#ifdef K7UI

//test pøítomnosti windows hlavièek
#ifdef WIN32_LEAN_AND_MEAN

namespace K7 //hlavní obor funkcí 'pseudo-standardní' knihovny K7 pro C++20/23
{

namespace WINfunc //funkce, které pouívají operaèní systém Windows k nastavování konzole podle potøeb
{

//nastaví název okna konzole na vstupní øetìzec [ASCII]
void TITLE_CONSOLE(const char* Title) noexcept { SetConsoleTitleA((CHAR*)Title); return; }

//nastaví název okna konzole na vstupní øetìzec [UTF-16]
void TITLE_CONSOLE(const wchar_t* Title) noexcept { SetConsoleTitleW((WCHAR*)Title); return; }

//nastaví vstupní / vıstupní mód konzole na ASCII znaky
void SET_TO_ASCII() noexcept
{
	(void)_setmode(_fileno(stdout), _O_TEXT);
	(void)_setmode(_fileno(stdin), _O_TEXT);

	return;
}

//nastaví vstupní / vıstupní mód konzole na UTF-16 znaky
void SET_TO_UTF16() noexcept
{
	(void)_setmode(_fileno(stdout), _O_U16TEXT);
	(void)_setmode(_fileno(stdin), _O_U16TEXT);

	return;
}

//zablokuje vstupní pamì konzole, kdy program dìlá nìco jiného, ne vstup
void BLOCK_INPUT() noexcept
{
	FlushConsoleInputBuffer(GetStdHandle(STD_INPUT_HANDLE)); return;
}

//vymae vše, co bylo vytištìno do konzole pomocí èernıch mezer & vrátí kurzor do vıchozí pozice [bohuel nefunguje stoprocentnì, pracuji na lepší verzi]
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