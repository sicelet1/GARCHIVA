#include "init.hpp"
std::string inP0;

std::string transcription(std::string tD)
{
	inP0.clear();

	for (uint32_t t = 0; t < tD.length(); t++)
	{ 
		if (tD[t] == 'A' || tD[t] == 'a')
			inP0 += 'U';
		elif(tD[t] == 'C' || tD[t] == 'c')
			inP0 += 'G';
		elif(tD[t] == 'T' || tD[t] == 't')
			inP0 += 'A';
		elif(tD[t] == 'G' || tD[t] == 'g')
			inP0 += 'C';
	};

	return inP0;
}