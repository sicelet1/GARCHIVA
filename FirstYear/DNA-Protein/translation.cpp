#include "init.hpp"
std::string inP1;
std::string inP2;
std::string CAP;
int16_t start = 0;
outAP out;

std::string toCap(std::string nCAP)
{
	CAP.clear();

	for (uint32_t t = 0; t < nCAP.length(); t++)
	{
		if (nCAP[t] == 'a' || nCAP[t] == 'A')
			CAP += 'A';
		elif(nCAP[t] == 'c' || nCAP[t] == 'C')
			CAP += 'C';
		elif(nCAP[t] == 'u' || nCAP[t] == 'U')
			CAP += 'U';
		elif(nCAP[t] == 'g' || nCAP[t] == 'G')
			CAP += 'G';
	};

	return CAP;
}

outAP translation(std::string tRc)
{
	std::string tR = toCap(tRc); 
	tlA(); start = 0;
	inP1.clear(); inP2.clear();

	for (uint32_t s = 0; s + 2 < tR.length(); s++)
	{
		if (tR[s] == 'A' && tR[s + 1] == 'U' && tR[s + 2] == 'G')
			break;

		start++;
	}

	for (uint32_t t = start + 3; t + 2 < tR.length(); t += 3)
	{
		if (tR[t] == 'U' && tR[t + 1] == 'A' && tR[t + 2] == 'G')
			break;
		if (tR[t] == 'U' && tR[t + 1] == 'G' && tR[t + 2] == 'A')
			break;
		if (tR[t] == 'U' && tR[t + 1] == 'A' && tR[t + 2] == 'A')
			break;

		if (tR[t] == 'U' && tR[t + 1] == 'U')
		{
			if (tR[t + 2] == 'U' || tR[t + 2] == 'C')
			{
				inP1 += 'F'; inP2 += "Phe-"; continue;
			}
			elif(tR[t + 2] == 'A' || tR[t + 2] == 'G')
			{
				inP1 += 'L'; inP2 += "Leu-"; continue;
			}
		}
		elif(tR[t] == 'C' && tR[t + 1] == 'U')
		{
			inP1 += 'L'; inP2 += "Leu-"; continue;
		}
		elif(tR[t] == 'A' && tR[t + 1] == 'U' && tR[t + 2] != 'G')
		{
			inP1 += 'I'; inP2 += "Ile-"; continue;
		}
		elif(tR[t] == 'A' && tR[t + 1] == 'U' && tR[t + 2] == 'G')
		{
			inP1 += 'M'; inP2 += "Met-"; continue;
		}
		elif(tR[t] == 'G' && tR[t + 1] == 'U')
		{
			inP1 += 'V'; inP2 += "Val-"; continue;
		}
		elif(tR[t] == 'U' && tR[t + 1] == 'C')
		{
			inP1 += 'S'; inP2 += "Ser-"; continue;
		}
		elif(tR[t] == 'C' && tR[t + 1] == 'C')
		{
			inP1 += 'P'; inP2 += "Pro-"; continue;
		}
		elif(tR[t] == 'A' && tR[t + 1] == 'C')
		{
			inP1 += 'T'; inP2 += "Thr-"; continue;
		}
		elif(tR[t] == 'G' && tR[t + 1] == 'C')
		{
			inP1 += 'A'; inP2 += "Ala-"; continue;
		}
		elif(tR[t] == 'U' && tR[t + 1] == 'A' && tR[t + 2] != 'A' && tR[t + 2] != 'G')
		{
			inP1 += 'Y'; inP2 += "Tyr-"; continue;
		}
		elif(tR[t] == 'C' && tR[t + 1] == 'A')
		{
			if (tR[t + 2] == 'U' || tR[t + 2] == 'C')
			{
				inP1 += 'H'; inP2 += "His-"; continue;
			}
			elif(tR[t + 2] == 'A' || tR[t + 2] == 'G')
			{
				inP1 += 'Q'; inP2 += "Gln-"; continue;
			}
		}
		elif(tR[t] == 'A' && tR[t + 1] == 'A')
		{
			if (tR[t + 2] == 'U' || tR[t + 2] == 'C')
			{
				inP1 += 'N'; inP2 += "Asn-"; continue;
			}
			elif(tR[t + 2] == 'A' || tR[t + 2] == 'G')
			{
				inP1 += 'K'; inP2 += "Lys-"; continue;
			}
		}
		elif(tR[t] == 'G' && tR[t + 1] == 'A')
		{
			if (tR[t + 2] == 'U' || tR[t + 2] == 'C')
			{
				inP1 += 'D'; inP2 += "Asp-"; continue;
			}
			elif(tR[t + 2] == 'A' || tR[t + 2] == 'G')
			{
				inP1 += 'E'; inP2 += "Glu-"; continue;
			}
		}
		elif(tR[t] == 'U' && tR[t + 1] == 'G' && tR[t + 2] != 'A')
		{
			if (tR[t + 2] == 'U' || tR[t + 2] == 'C')
			{
				inP1 += 'C'; inP2 += "Cys-"; continue;
			}
			elif(tR[t + 2] == 'G')
			{
				inP1 += 'W'; inP2 += "Trp-"; continue;
			}
		}
		elif(tR[t] == 'C' && tR[t + 1] == 'G')
		{
			inP1 += 'R'; inP2 += "Arg-"; continue;
		}
		elif(tR[t] == 'A' && tR[t + 1] == 'G')
		{
			if (tR[t + 2] == 'U' || tR[t + 2] == 'C')
			{
				inP1 += 'S'; inP2 += "Ser-"; continue;
			}
			elif(tR[t + 2] == 'A' || tR[t + 2] == 'G')
			{
				inP1 += 'R'; inP2 += "Arg-"; continue;
			}
		}
		elif(tR[t] == 'G' && tR[t + 1] == 'G')
		{
			inP1 += 'G'; inP2 += "Gly-"; continue;
		}
	}

	inP2.pop_back();
	out.inP1 = inP1;
	out.inP2 = inP2;
	return out;
}