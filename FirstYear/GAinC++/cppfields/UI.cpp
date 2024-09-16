#include "initBD.hpp"
variables V01;

void toMenu()
{
	std::cout << "\n\nPress 0 to go back to main menu: ";
l701:
	std::cin >> V01.mUI;

	if (V01.mUI != "0")
	{
		std::cout << "\n\nInvalid input, try it again: "; goto l701;
	}
}

void uI0()
{
	system("CLS");

	for (uint8_t c = NULL; c < 10; c++)
	{
		std::cout << "-------------------\n\n" << "INICIALISING    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "INICIALISING    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "INICIALISING    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "INICIALISING    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}

	std::cout << "\nPress 0 to terminate setup, or press 1 to enter UI: ";
l3301:
	std::cin >> V01.mUI;

	if (V01.mUI == "0") std::exit(0);
	elif(V01.mUI == "1")
	{
		for (uint8_t c = NULL; c < 10; c++)
		{
			std::cout << "-------------------\n\n" << "PREPARING UI    -\n\n" << "-------------------";
			wait(100); system("CLS");
			std::cout << "-------------------\n\n" << "PREPARING UI    \\\n\n" << "-------------------";
			wait(100); system("CLS");
			std::cout << "-------------------\n\n" << "PREPARING UI    |\n\n" << "-------------------";
			wait(100); system("CLS");
			std::cout << "-------------------\n\n" << "PREPARING UI    /\n\n" << "-------------------";
			wait(100); system("CLS");
		}
	}
	else
	{
		std::cout << "\nInvalid input, try it again: "; goto l3301;
	}
}

void uI1()
{
	system("CLS");

	for (uint8_t c = NULL; c < 10; c++)
	{
		std::cout << "-------------------\n\n" << "LOADING    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "LOADING    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "LOADING    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "LOADING    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}
}

void calc0()
{
	system("CLS");

	for (uint8_t c = NULL; c < 10; c++)
	{
		std::cout << "-------------------\n\n" << "CALCULATING    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "CALCULATING    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "CALCULATING    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "CALCULATING    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}
}