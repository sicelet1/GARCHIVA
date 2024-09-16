#include "init.hpp"
std::string m0;

void header()
{
	std::cout << "-----------------------\n" << "BIO sequence translator       v 1.0.4.68\n" << "-----------------------\n";
}

void menu0()
{
	std::cout << "\nPress 0 to terminate setup or press 1 to start session: ";
w0:
	std::cin >> m0;
	
	if (m0 == "0")
		std::exit(0);
	elif(m0 == "1")
		startSession();
	else
	{
		std::cout << "\n\nInvalid input, try it again: "; goto w0;
	}
}

void session()
{
w2:
	system("CLS"); header();
	std::cout << "Press 0 to enter DNA sequence input or press 1 to enter mRNA sequence input: ";
w1:
	std::cin >> m0;

	if (m0 == "0")
		inDNA();
	elif(m0 == "1")
		inMRNA();
	else
	{
		std::cout << "\n\nInvalid input, try it again: "; goto w1;
	}
	goto w2;
}

void toMMenu()
{
	std::cout << "Press 0 to go back to main menu: ";
w3:
	std::cin >> m0;

	if (m0 == "0")
		void session();
	else
	{
		std::cout << "\n\nInvalid input, try it again: "; goto w3;
	}
}

void finish(const outAP AP, const std::string D, const std::string R)
{
	header();
	std::cout << "Input DNA sequence is: '" << D << "'\n";
	std::cout << "Input mRNA sequence is: '" << R << "'\n\n";
	std::cout << "DNA/mRNA sequence translated to this Aminoacids chains:\n";
	std::cout << "1.: In one char per AminoAcid: 'Met | " << AP.inP1 << " | Stop'.\n";
	std::cout << "2.: In AminoAcid short name: 'Met | " << AP.inP2 << " | Stop'.\n\n";
	toMMenu();
}