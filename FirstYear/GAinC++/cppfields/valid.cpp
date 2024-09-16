#include "initBD.hpp"
variables V04;

void dscmr()
{
	std::cout << "!NOTE!\n\n";
	std::cout << "Please do not try to force array input, that is not asked for.\n";
	std::cout << "It may cause crashes, unpredictable behaviour, high CPU usage[high temps], memory leaks, ...\n";
	std::cout << "Program is using string input validation only at certain inputs, maybe I add it in future.\n";
	std::cout << "More updates and functions may come soon.\n";
	std::cout << "|>K7(R) industries, all rights reserved<|\n\nConfirm by pressing 0:\n>>>";
l1201:
	std::cin >> V04.mUI;

	if (V04.mUI != "0") { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l1201; }
	else uI1();
}