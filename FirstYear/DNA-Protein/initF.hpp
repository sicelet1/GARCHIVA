#pragma once
#include "init.hpp"

void wait(const int16_t t)
{
	std::this_thread::sleep_for(std::chrono::milliseconds(t));
}

//more animations
void initSetup()
{
	for (int8_t iS = 0; iS < 10; iS++)
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
}

void startSession()
{
	for (int8_t iS = 0; iS < 10; iS++)
	{
		std::cout << "-------------------\n\n" << "STARTING SESSION    -\n\n" << "-------------------";
		wait(100); system("CLS");							   
		std::cout << "-------------------\n\n" << "STARTING SESSION    \\\n\n" << "-------------------";
		wait(100); system("CLS");							   
		std::cout << "-------------------\n\n" << "STARTING SESSION    |\n\n" << "-------------------";
		wait(100); system("CLS");							   
		std::cout << "-------------------\n\n" << "STARTING SESSION    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}
}

void validation()
{
	for (int8_t iS = 0; iS < 10; iS++)
	{
		std::cout << "-------------------\n\n" << "VALIDATING    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}
}

void tcA()
{
	for (int8_t aN = 0; aN < 10; aN++)
	{
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSCRIPT    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSCRIPT    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSCRIPT    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSCRIPT    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}

	for (int8_t aN = 0; aN < 10; aN++)
	{
		std::cout << "-------------------\n\n" << "TRANSCRIPTING TO MRNA    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "TRANSCRIPTING TO MRNA    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "TRANSCRIPTING TO MRNA    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "TRANSCRIPTING TO MRNA    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}
}

void tlA()
{
	for (int8_t aN = 0; aN < 10; aN++)
	{
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSLATE    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSLATE    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSLATE    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING TO TRANSLATE    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}

	for (int8_t aN = 0; aN < 10; aN++)
	{
		std::cout << "-------------------\n\n" << "TRANSLATING TO AMINOACIDS    -\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "TRANSLATING TO AMINOACIDS    \\\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "TRANSLATING TO AMINOACIDS    |\n\n" << "-------------------";
		wait(100); system("CLS");
		std::cout << "-------------------\n\n" << "TRANSLATING TO AMINOACIDS    /\n\n" << "-------------------";
		wait(100); system("CLS");
	}
}