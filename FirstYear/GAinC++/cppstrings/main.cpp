#include "init.hpp"

int main(void)
{
	std::string mUI, sample; bool mUIb, line1 = true;
	mUI::animation::inicialising();
	std::cout << "!NOTE!\n";
	std::cout << "This program is C++ equivalent to Java task from PG. String input UI works different, but user only\n";
	std::cout << "needs to know, how to write '\\' [right alt + Q on CZ keyboard]. In calc menu there is a number 2 option,\n";
	std::cout << "that cannot be accessed. Maybe I add something in it later. UI is certified user-proof [I think], so\n";
	std::cout << "there's very small chance to break it. Because all inter-UI moving numbers uses 'string validation'.\n";
	std::cout << "This program is Open-Sourced for educational purposes.\n";
	std::cout << "|>K7(R) Industries, all rights reserved<|\n";
	std::cout << "\nPress 0 to enter UI:\n>>>";
	
	while (true)
	{
		std::cin >> mUI;

		if (mUI == "0") break;
		else std::cout << "\n\nInvalid input, try it again:\n>>>";
	}

	mUI::animation::loading();
	mUI::menuRoot(mUI, true);

	while (true)
	{
		if (mUI == "0") std::exit(0);
		elif(mUI == "1") 
		{
			mUI::menuString(mUI, sample, true);

			while (true)
			{
				if (mUI == "0") break;
				elif(mUI == "1") { mUIb = mUI::eValue(sample, line1); if (mUIb == true) { mUI::menuString(mUI, sample, true); } continue; }
				elif(mUI == "2") { sample.clear(); mUI::menuString(mUI, sample, true); continue; }
				else mUI::menuString(mUI, sample, false);
			}
			
			mUI::menuRoot(mUI, true); continue;
		}
		elif(mUI == "2") 
		{ 
			mUI::menuCalc(mUI, sample, true);

			while (true)
			{
				if (mUI == "0") break;
				elif(mUI == "1") { mUI::animation::calculating(); mUI::calcOut(mUI, &sample); mUI::menuCalc(mUI, sample, true); continue; }
				//elif(mUI == "2") {...} ~ coming soon
				else mUI::menuCalc(mUI, sample, false);
			}

			mUI::menuRoot(mUI, true); continue;
		}
		else mUI::menuRoot(mUI, false);
	}
}