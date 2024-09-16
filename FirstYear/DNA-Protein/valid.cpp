#include "init.hpp"

int valD(std::string vD)
{
	int r = 0;

	for (uint32_t v = 0; v < vD.length(); v++)
	{
		if (vD[v] != 'A' && vD[v] != 'C' && vD[v] != 'T' && vD[v] != 'G' && vD[v] != 'a' && vD[v] != 'c'  && vD[v] != 't' && vD[v] != 'g')
		{
			r = 1;
		}
	}

	return r;
}

int valR(std::string vR)
{
	int r = 0;

	for (uint32_t v = 0; v < vR.length(); v++)
	{
		if (vR[v] != 'A' && vR[v] != 'C' && vR[v] != 'U' && vR[v] != 'G' && vR[v] != 'a' && vR[v] != 'c' && vR[v] != 'u' && vR[v] != 'g')
		{
			r = 1;
		}
	}

	return r;
}