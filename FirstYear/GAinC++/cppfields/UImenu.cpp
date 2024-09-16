#include "initBD.hpp"
arrays M; variables V02;

void mMenu()
{
	while (true)
	{
		system("CLS"); header(); V02.mUIl = false;

		if (M.fieldA.size() == NULL && M.fieldB.size() == NULL && M.fieldLog.size() == NULL) V02.mUIl = true;

		std::cout << "MAIN UI ROOT\n-----------------\nChoose, what you want to do next:\n\n";
		std::cout << "-------------------------------------------\n";
		std::cout << "|Press 1 to go to array filling menu      |\n";
		std::cout << "|Press 2 to go to array manipulation menu |\n";
		std::cout << "|Press 3 to show current state of arrays  |\n";
		std::cout << "-------------------------------------------\n";
		std::cout << "Or press 0 to terminate UI session.\n>>>";

		if (V02.mUIl == true) iN();
		else
		{
l2301:
			std::cin >> V02.mUI;

			if (V02.mUI == "0") std::exit(0);
			elif(V02.mUI == "1") { iN(); continue; }
			elif(V02.mUI == "2") { arrM1(); continue; }
			elif(V02.mUI == "3") { arStat(); continue; }
			else { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l2301; }
		}
	}
}

void iN()
{
	while (true)
	{
		system("CLS"); header(); V02.mUIl = false;

		if (M.fieldA.size() == NULL && M.fieldB.size() == NULL && M.fieldLog.size() == NULL) V02.mUIl = true;

		if (V02.mUIl == true) std::cout << "All arrays are empty, please insert something in.\nChoose which array you what to fill:\n\n";
		else std::cout << "Choose which array you what to fill:\n\n";

		std::cout << "-------------------------------------------\n";
		std::cout << "|Press 1 to fill array A [decimal numbers]|\n";
		std::cout << "|Press 2 to fill array B [decimal numbers]|\n";
		std::cout << "|Press 3 to fill array Log [true OR false]|\n";
		std::cout << "-------------------------------------------\n";

		if (V02.mUIl == false) std::cout << "Or press 0 to quit to main root.\n>>>";
		else std::cout << ">>>";
l5401:
		std::cin >> V02.mUI;

		if (V02.mUI == "0" && V02.mUIl == false) break;
		elif(V02.mUI == "1") { M.fieldA = fillA(); continue; }
		elif(V02.mUI == "2") { M.fieldB = fillB(); continue; }
		elif(V02.mUI == "3") { M.fieldLog = fillLog(); continue; }
		else { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l5401; }
	}
}

void arrM1()
{
	while (true)
	{
		system("CLS"); header();
		std::cout << "Choose which operation/manipulation you what to make:\n\n";
		std::cout << "---------------------------------------------------\n";
		std::cout << "CURRENTLY AVAILABLE OPERATIONS\n";
		std::cout << "---------------------------------------------------\n";
		std::cout << "|Press 1 - Sumarize all elements in A             |\n";
		std::cout << "|Press 2 - Aritmetic average of all elements in A |\n";
		std::cout << "|Press 3 - Geometric average of all elements in A |\n";
		std::cout << "|Press 4 - Quadratic average of all elements in A |\n";
		std::cout << "|Press 5 - Standard deviation of all elements in A|\n";
		std::cout << "|Press 6 - Weight average of all elements in A & B|\n";
		std::cout << "|Press 7 - Logic OR of all elements in Log        |\n";
		std::cout << "|Press 8 - Logic AND of all elements in Log       |\n";
		std::cout << "|Press 9 - Clone all elements of A to new arr     |\n";
		std::cout << "|Press A - Paste all elements of A & B to new arr |\n";
		std::cout << "---------------------------------------------------\n";
		std::cout << "Or press 0 to quit to main root.\n>>>";
l8601:
		std::cin >> V02.mUI;

		if (V02.mUI != "0" && V02.mUI != "1" && V02.mUI != "2" && V02.mUI != "3" && V02.mUI != "4" && V02.mUI != "5" && V02.mUI != "6" && V02.mUI != "7" && V02.mUI != "8" && V02.mUI != "9" && V02.mUI != "A" && V02.mUI != "a")
			{ std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l8601; }

		if (V02.mUI == "0") break;
		else
		{
			calc0(); system("CLS"); header();
			std::cout << "----------------\nINPUT ELEMENTS\n----------------\n";

			if (V02.mUI == "1")
			{
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "SUMARIZATION RESULT = " << sum(M.fieldA, M.fieldA.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif(V02.mUI == "2") 
			{ 
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "ARITMETIC AVERAGE RESULT = " << arAv(M.fieldA, M.fieldA.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif(V02.mUI == "3") 
			{ 
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "GEOMETRIC AVERAGE RESULT = " << geoAv(M.fieldA, M.fieldA.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif(V02.mUI == "4")
			{
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "QUADRATIC AVERAGE RESULT = " << qvAv(M.fieldA, M.fieldA.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif(V02.mUI == "5") 
			{ 
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "STANDARD DEVIATION RESULT = " << stdD(M.fieldA, M.fieldA.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif(V02.mUI == "6") 
			{
				if (M.fieldA.size() != NULL && M.fieldB.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "B:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldB.size(); c++)
						std::cout << c << ".element of B = " << M.fieldB[c] << "\n----------------\n";

					std::cout << "----------------\n" << "WEIGHT AVERAGE RESULT = " << weightAv(M.fieldA, M.fieldB, M.fieldA.size(), M.fieldB.size()) << "\n----------------\n";
				}
				else
				{
					if (M.fieldA.size() == NULL) { std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break; }
					elif (M.fieldB.size() == NULL) { std::cout << "Array B is empty, calc cannot continue, please insert something in."; toMenu(); break; }
					elif (M.fieldA.size() == NULL || M.fieldB.size() == NULL) { std::cout << "Array A & B is empty, calc cannot continue, please insert something in."; toMenu(); break; }
				}
			}
			elif(V02.mUI == "7") 
			{ 
				if (M.fieldLog.size() != NULL)
				{
					std::cout << "Log:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of Log = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "LOGIC OR RESULT = " << logOr(M.fieldLog, M.fieldLog.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array Log is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif(V02.mUI == "8")
			{ 
				if (M.fieldLog.size() != NULL)
				{
					std::cout << "Log:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of Log = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\n" << "LOGIC AND RESULT = " << logAnd(M.fieldLog, M.fieldLog.size()) << "\n----------------\n";
				}
				else
				{
					std::cout << "Array Log is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif (V02.mUI == "9")
			{
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "----------------\nOUTPUT ELEMENETS\n----------------\nOut:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of out = " << cloneA(M.fieldA, M.fieldA.size())[c] << "\n----------------\n";
				}
				else
				{
					std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break;
				}
			}
			elif (V02.mUI == "A" || V02.mUI == "a")
			{
				if (M.fieldA.size() != NULL)
				{
					std::cout << "A:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size(); c++)
						std::cout << c << ".element of A = " << M.fieldA[c] << "\n----------------\n";

					std::cout << "B:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldB.size(); c++)
						std::cout << c << ".element of B = " << M.fieldB[c] << "\n----------------\n";

					std::cout << "----------------\nOUTPUT ELEMENETS\n----------------\nOut:\n----------------\n";

					for (uint16_t c = NULL; c < M.fieldA.size() + M.fieldB.size(); c++)
						std::cout << c << ".element of out = " << contAB(M.fieldA, M.fieldB, M.fieldA.size(), M.fieldB.size())[c] << "\n----------------\n";
				}
				else
				{
					if (M.fieldA.size() == NULL) { std::cout << "Array A is empty, calc cannot continue, please insert something in."; toMenu(); break; }
					elif(M.fieldB.size() == NULL) { std::cout << "Array B is empty, calc cannot continue, please insert something in."; toMenu(); break; }
					elif(M.fieldA.size() == NULL || M.fieldB.size() == NULL) { std::cout << "Array A & B is empty, calc cannot continue, please insert something in."; toMenu(); break; }
				}
			}

			toMenu(); continue;
		}
	}
}

void arStat()
{
	while (true)
	{
		system("CLS"); header();
		std::cout << "Choose which array status you want to see:\n";
		std::cout << "--------------------------\n";
		std::cout << "CURRENTLY AVAIABLE ARRAYS\n";
		std::cout << "---------------------------\n";
		std::cout << "|Press 1 to view array A  |\n";
		std::cout << "|Press 2 to view array B  |\n";
		std::cout << "|Press 3 to view array Log|\n";
		std::cout << "---------------------------\n";
		std::cout << "Or press 0 to quit to main root.\n>>>";
l29801:
		std::cin >> V02.mUI;

		if (V02.mUI == "0") break;
		elif(V02.mUI == "1")
		{
			system("CLS"); header(); headerWA(); std::cout << "A ELEMENTS LIST\n";

			for (uint16_t c = NULL; c < M.fieldA.size(); c++)
				std::cout << "----------------\n" << c << ".element of A = " << M.fieldA[c] << "\n";

			toMenu(); continue;
		}
		elif(V02.mUI == "2")
		{
			system("CLS"); header(); headerWB(); std::cout << "B ELEMENTS LIST\n";

			for (uint16_t c = NULL; c < M.fieldB.size(); c++)
				std::cout << "----------------\n" << c << ".element of B = " << M.fieldB[c] << "\n";

			toMenu(); continue;
		}
		elif(V02.mUI == "3")
		{
			system("CLS"); header(); headerWLog(); std::cout << "LOG ELEMENTS LIST\n";

			for (uint16_t c = NULL; c < M.fieldLog.size(); c++)
				std::cout << "----------------\n" << c << ".element of Log = " << M.fieldLog[c] << "\n";

			toMenu(); continue;
		}
		else { std::cout << "\n\nInvalid input, try it again:\n>>>"; goto l29801; }
	}
}