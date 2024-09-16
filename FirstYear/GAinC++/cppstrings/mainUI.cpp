#include "init.hpp"
namespace mUI
{

void wait(uint16_t time)
{
	std::this_thread::sleep_for(std::chrono::milliseconds(time));
}

void header()
{
	std::cout << N30 << "GA String statistic calculator       v 1.0.5.15\n" << N30;
}

void headerRoot()
{
	std::cout << N30 << "MAIN UI ROOT\n" << N30;
}

void headerS()
{
	std::cout << N30 << "STRING MENU\n" << N30;
}

void headerC()
{
	std::cout << N30 << "CALC MENU\n" << N30;
}

void menuRoot(std::string& menuUI, const bool menuUIb)
{
	if (menuUIb == true)
	{
		system("CLS"); header(); headerRoot();
		std::cout << "\nChoose, what you want to do next:\n";
		std::cout << "---------------------------------\n";
		std::cout << "|Press 1 to enter string menu   |\n";
		std::cout << "|Press 2 to calculate statistics|\n";
		std::cout << "---------------------------------\n";
		std::cout << "Or press 0 to terminate UI session.\n>>>";
	}
	elif(menuUIb == false) std::cout << "\n\nInvalid input, try it again:\n>>>";

	std::cin >> menuUI;
}


void menuString(std::string& menuUI, const std::string eSample, const bool menuUIb)
{
	if (menuUIb == true)
	{
		system("CLS"); header(); headerS();
		std::cout << "String status:\n'\n" << eSample << "\n'\n" << N30;
		std::cout << "\nChoose, what you want to do with string:\n";
		std::cout << "------------------------------------------\n";
		std::cout << "|Press 1 to enter another value to string|\n";
		std::cout << "|Press 2 to erase whole string           |\n";
		std::cout << "------------------------------------------\n";
		std::cout << "Or press 0 to go back to main UI root.\n>>>";
	}
	elif(menuUIb == false) std::cout << "\n\nInvalid input, try it again:\n>>>";

	std::cin >> menuUI;
}

bool eValue(std::string& eSample, bool& eLine1)
{
	system("CLS"); header(); headerS(); std::string eeSample;
	std::cout << "String status:\n'\n" << eSample << "\n'\n" << N30;

	if (eLine1 == true) std::cout << "Edit mode = input on one line [type '\\l' to change it]";
	elif(eLine1 == false) std::cout << "Edit mode = input on it's new line [type '\\l' to change it]";

	std::cout << "\n\nType here, what you want to add to string, then press enter to add it [type '\\e' to exit].\n\n::\n";
	std::getline(std::cin, eeSample);

	if (eeSample == "\\l" && eLine1 == true) { eLine1 = false; eSample += '\n'; }
	elif(eeSample == "\\l" && eLine1 == false) { eLine1 = true; if (eSample.length() != NULL) eSample.pop_back(); }

	if (eeSample == "\\e") return true;
	else
	{
		if (eLine1 == true && eeSample != "\\l") eSample += eeSample;
		elif(eLine1 == false && eeSample != "\\l") eSample += (eeSample + '\n');
	}

	return false;
}

void menuCalc(std::string& menuUI, const std::string eSample, const bool menuUIb)
{
	if (menuUIb == true)
	{
		system("CLS"); header(); headerC();
		std::cout << "String status:\n'\n" << eSample << "\n'\n" << N30;
		std::cout << "\nType here, what statistic do you want to calculate from string:\n";
		std::cout << "-----------------------------------------------\n";
		std::cout << "|Press 1 to calculate every possible statistic|\n";
		std::cout << "|Press 2 ... [coming soon]                    |\n";
		std::cout << "-----------------------------------------------\n";
		std::cout << "Or press 0 to go back to main UI root.\n>>>";
	}
	elif(menuUIb == false) std::cout << "\n\nInvalid input, try it again:\n>>>";

	std::cin >> menuUI;
}

void calcOut(std::string& menuUI, const std::string* eSample)
{
	system("CLS"); header(); headerC();
	std::cout << "String status:\n'\n" << *eSample << "\n'\n" << N30;
	std::cout << N30 << "Statistic result:\n\n";
	std::cout << "Numbers count:             " << calc::calc1(&eSample) << "x\n";
	std::cout << "Non-capital letters count: " << calc::calc2(&eSample) << "x\n";
	std::cout << "Capital letters count:     " << calc::calc3(&eSample) << "x\n";
	std::cout << "Blank spaces count:        " << calc::calc4(&eSample) << "x\n";
	std::cout << "ISO count:                 " << calc::calc5(&eSample) << "x\n";
	std::cout << "Lines count:               " << calc::calc6(&eSample) << "x\n";
	std::cout << "Longest line:              " << calc::calcB1(&eSample, true); std::cout << "x [" << calc::calcB1(&eSample, false) << "]\n";
	std::cout << "Average line length:       " << calc::calcB2(&eSample) << "x\n";
	std::cout << "Most letter:               " << calc::calcB3(&eSample, true); std::cout << "x [" << calc::calcB3(&eSample, false) << "]\n";
	std::cout << "Most symbol:               " << calc::calcB4(&eSample, true); std::cout << "x [" << calc::calcB4(&eSample, false) << "]\n";
	std::cout << "\nPress 0 to go back to main menu:\n>>>"; std::cin >> menuUI;

	while (true) { if (menuUI == "0") { break; } std::cout << "\n\nInvalid input, try it again:\n>>>"; std::cin >> menuUI; }
}

namespace animation
{

void inicialising()
{
	for (uint8_t c = NULL; c < 10; c++)
	{
		std::cout << NN15 << "INICIALISING     -\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "INICIALISING     \\\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "INICIALISING     |\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "INICIALISING     /\n\n" << NN15;
		wait(100); system("CLS");
	}
}

void loading()
{
	for (uint8_t c = NULL; c < 10; c++)
	{
		std::cout << NN15 << "LOADING     -\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "LOADING     \\\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "LOADING     |\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "LOADING     /\n\n" << NN15;
		wait(100); system("CLS");
	}
}

void calculating()
{
	for (uint8_t c = NULL; c < 10; c++)
	{
		std::cout << NN15 << "CALCULATING     -\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "CALCULATING     \\\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "CALCULATING     |\n\n" << NN15;
		wait(100); system("CLS");
		std::cout << NN15 << "CALCULATING     /\n\n" << NN15;
		wait(100); system("CLS");
	}
}

}

}