#include "init.hpp"
std::string inD;
std::string inR;

void inDNA()
{ 
	system("CLS"); header();
	std::cout << "DNA sequence input mode\n-----------------------\n";
	std::cout << "Please type DNA sequence [only A, C, T, G]: ";
	std::cin >> inD;
	validation();
	bool r = valD(inD);

	if (r == true)
	{
		std::cout << "Validation failed, cannot recognise this input: '" << inD << "'.\n\n";
		toMMenu();
	}
	elif(r == false)
	{
		tcA(); finish(translation(transcription(inD)), inD, transcription(inD));
	}
}

void inMRNA()
{
	system("CLS"); header();
	std::cout << "mRNA sequence input mode\n-----------------------\n";
	std::cout << "Please type mRNA sequence [only A, C, U, G]: ";
	std::cin >> inR;
	validation();
	bool r = valR(inR);


	if (r == true)
	{
		std::cout << "Validation failed, cannot recognise this input: '" << inR << "'.\n\n";
		toMMenu();
	}
	elif(r == false)
	{
		finish(translation(inR), "not_entered", inR);
	}
}