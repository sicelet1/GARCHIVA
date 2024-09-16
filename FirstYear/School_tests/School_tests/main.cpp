#include <iostream>
#include <string>
#define elif else if

//Uloha 1
std::string Zrcadlo(std::string str)
{
	if (str.empty()) return "";

	for (int16_t c = str.length() - 2; c >= 0; c--)
	{
		char ch = str[c]; str += ch;
	}
	
	return str;
}

//Uloha 2
char Nejvyssi(std::string str) 
{
	if (str.empty()) return '\0';

	char ch = str[0];

	for (uint16_t c = NULL; c != str.length() - 1; c++)
	{
		if (str[c] < str[c + 1]) { ch = str[c + 1]; }
	}

	return ch;
}

int main(void)
{
	std::cout << Zrcadlo("ABCDE") << "\n"; // ABCDEDBCA
	std::cout << Zrcadlo("X") << "\n"; // X
	std::cout << Zrcadlo("") << "\n"; //

	std::cout << Nejvyssi("ABC") << "\n"; // C
	std::cout << Nejvyssi("0123456789") << "\n"; // 9
	std::cout << Nejvyssi("ZYX") << "\n"; // Z
	std::cout << Nejvyssi("") << "\n"; //

	return NULL;
}