#include "initBD.hpp"
arrays I; variables V03;

ARRAY fillA()
{
	system("CLS"); header(); headerFA(); I.fieldA.clear();
	std::cout << "Press 0 to enter your own values or press 1 to enter random values:\n>>>"; 
l801:
	std::cin >> V03.mUI;

	if (V03.mUI == "0")
	{
		system("CLS"); header(); headerFA();
		std::cout << "Enter value, then press enter to enter another one, or enter '0' to finish entering:\n";
l1501:
		std::cout << "----------------\n" << I.fieldA.size() << ".element of A = "; std::cin >> V03.in;

		if (V03.in != NULL) { I.fieldA.push_back(V03.in); goto l1501; }
		else toMenu();
	}	
	elif(V03.mUI == "1")
	{
		system("CLS"); header(); headerFA();
		std::cout << "Enter min & max random value, then press enter to enter another one, or enter '0' to finish entering:\n";
l2501:
		std::cout << "----------------\n" << I.fieldA.size() << ".min value = "; std::cin >> V03.rInMin;

		if (V03.rInMin != NULL)
		{
			std::cout << "----------------\n" << I.fieldA.size() << ".max value = "; std::cin >> V03.rInMax;

			if (V03.rInMax != NULL && V03.rInMin < V03.rInMax)
			{
				I.fieldA.push_back(rdReal(V03.rInMin, V03.rInMax));
				std::cout << "----------------\n" << I.fieldA.size() - 1 << ".element of A = " << I.fieldA[I.fieldA.size() - 1] << "\n"; goto l2501;
			}
		}
		else toMenu();
	}
	else { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l801; }

	return I.fieldA;
}

ARRAY fillB()
{
	system("CLS"); header(); headerFB(); I.fieldB.clear();
	std::cout << "Press 0 to enter your own values or press 1 to enter random values:\n>>>"; 
l4901:
	std::cin >> V03.mUI;

	if (V03.mUI == "0")
	{
		system("CLS"); header(); headerFB();
		std::cout << "Enter value, then press enter to enter another one, or enter '0' to finish entering:\n";
l5601:
		std::cout << "----------------\n" << I.fieldB.size() << ".element of B = "; std::cin >> V03.in;

		if (V03.in != NULL) { I.fieldB.push_back(V03.in); goto l5601; }
		else toMenu();
	}
	elif(V03.mUI == "1")
	{
		system("CLS"); header(); headerFB();
		std::cout << "Enter min & max random value, then press enter to enter another one, or enter '0' to finish entering:\n";
l6601:
		std::cout << "----------------\n" << I.fieldB.size() << ".min value = "; std::cin >> V03.rInMin;

		if (V03.rInMin != NULL)
		{
			std::cout << "----------------\n" << I.fieldB.size() << ".max value = "; std::cin >> V03.rInMax;

			if (V03.rInMax != NULL && V03.rInMin < V03.rInMax)
			{
				I.fieldB.push_back(rdReal(V03.rInMin, V03.rInMax));
				std::cout << "----------------\n" << I.fieldA.size() - 1 << ".element of B = " << I.fieldB[I.fieldB.size() - 1] << "\n"; goto l6601;
			}
		}
		else toMenu();
	}
	else { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l4901; }

	return I.fieldB;
}

ARRLOG fillLog()
{
	system("CLS"); header(); headerFLog(); I.fieldLog.clear();
	std::cout << "Press 0 to enter 1 [true] or 0 [false] or press 1 to enter random values:\n>>>"; 
l9001:
	std::cin >> V03.mUI;

	if (V03.mUI == "0")
	{
		system("CLS"); header(); headerFLog();
		std::cout << "Enter 1 or 0 value, then press enter to enter another one, or enter '2' to finish entering:\n";
l9701:
		std::cout << "----------------\n" << I.fieldLog.size() << ".element of Log = "; std::cin >> V03.in;

		if (V03.in != 2) { I.fieldLog.push_back(V03.in); goto l9701; }
		else toMenu();
	}
	elif(V03.mUI == "1")
	{
		system("CLS"); header(); headerFLog();
		std::cout << "Press enter to get 1 or 0, or enter '2' to finish entering:\n";
l10701:
		std::cin >> V03.in; I.fieldLog.push_back(rdLog());

		if (V03.in != 2) { std::cout << "----------------\n" << I.fieldLog.size() - 1 << ".element of Log = " << I.fieldLog[I.fieldLog.size() - 1] << "\n"; goto l10701; }
		else toMenu();
	}
	else { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l9001; }

	return I.fieldLog;
}