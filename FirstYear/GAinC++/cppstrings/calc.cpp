#include "init.hpp"
namespace calc
{

uint16_t calc1(const std::string** eeSample)
{
	uint16_t result = NULL;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++) 
	{ 
		if ((**eeSample)[c] >= 0x30 && (**eeSample)[c] <= 0x39) result++;
	}

	return result;
}

uint16_t calc2(const std::string** eeSample)
{
	uint16_t result = NULL;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++)
	{
		if ((**eeSample)[c] >= 0x61 && (**eeSample)[c] <= 0x7A) result++;
	}

	return result;
}

uint16_t calc3(const std::string** eeSample)
{
	uint16_t result = NULL;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++)
	{
		if ((**eeSample)[c] >= 0x41 && (**eeSample)[c] <= 0x5A) result++;
	}

	return result;
}

uint16_t calc4(const std::string** eeSample)
{
	uint16_t result = NULL;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++)
	{
		if ((**eeSample)[c] == 0x20) result++;
	}

	return result;
}

uint16_t calc5(const std::string** eeSample)
{
	uint16_t result = NULL;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++)
	{
		if (((**eeSample)[c] >= 0x00 && (**eeSample)[c] <= 0x1F) || (**eeSample)[c] == 0x7F) result++;
	}

	return result;
}

uint16_t calc6(const std::string** eeSample)
{
	uint16_t result = NULL;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++)
	{
		if ((**eeSample)[c] == '\n') result++;
	}

	return result + 1;
}

std::string calcB1(const std::string** eeSample, const bool calcType1)
{
	std::string resultS; static uint16_t result = NULL, rowLen = NULL, charP = NULL, charPNow = NULL;

	if (calcType1 == true)
	{
		result = NULL, rowLen = NULL, charP = NULL, charPNow = NULL;

		for (uint16_t c = NULL; c <= (**eeSample).length(); c++)
		{
			if (rowLen > result && c == (**eeSample).length())
			{
				result = rowLen;
				charP = charPNow;

				break;
			}
				
			if ((**eeSample)[c] != '\n') { rowLen++; charPNow++; }
			else 
			{
				if (rowLen > result)
				{
					result = rowLen;
					charP = charPNow;
				}

				rowLen = NULL;
			}
		}

		return std::to_string(result);
	}
	elif(calcType1 == false) 
	{
		for (int c = charP - 1; c >= 0; c--)
		{
			if ((**eeSample)[c] == '\n' || c == 0) { charP = c; break; }
		}

		if ((**eeSample)[charP] == '\n') charP++;

		resultS.clear();

		for (int c = charP; c < (**eeSample).length(); c++)
		{
			if ((**eeSample)[c] != '\n') resultS += (**eeSample)[c];
			else break;
		}

		return resultS;
	}

	return "";
}

float calcB2(const std::string** eeSample)
{
	float result = 0.0F, row = 0.0F, rowLenC = 0.0F, rowC = 0.0F;

	for (uint16_t c = NULL; c < (**eeSample).length(); c++)
	{
		if ((**eeSample)[c] == '\n') rowC++;
	}

	for (uint16_t c = NULL; c <= (**eeSample).length(); c++)
	{
		if (c == (**eeSample).length())
		{
			rowLenC += row; result = rowLenC / (rowC + 1); break;
		}

		if ((**eeSample)[c] != '\n') row++;
		else
		{
			rowLenC += row; row = NULL;
		}
	}

	return result;
}

std::string calcB3(const std::string** eeSample, const bool calcType1)
{
	static std::string resultS; static char resultC; uint16_t result = NULL, letter = NULL;

	if (calcType1 == true)
	{
		resultS.clear();

		for (char currLet = 0x40; currLet < 0x7A; currLet++)
		{
			letter = NULL;

			for (uint16_t c = NULL; c < (**eeSample).length(); c++)
			{
				if ((**eeSample)[c] == currLet) letter++;
			}

			if (letter > result)
			{
				result = letter;
				resultC = currLet;
			}

			if (currLet == 0x5A) currLet = 0x60;
		}

		if (result == NULL) resultC = NULL;

		return std::to_string(result);
	}
	elif(calcType1 == false)
	{
		resultS = resultC;

		return resultS;
	}

	return "";
}

std::string calcB4(const std::string** eeSample, const bool calcType1)
{
	static std::string resultS;  static char resultC; uint16_t result = NULL, letter = NULL;

	if (calcType1 == true)
	{
		resultS.clear();

		for (char currLet = 0x1F; currLet < 0x7E; currLet++)
		{
			letter = NULL;

			for (uint16_t c = NULL; c < (**eeSample).length(); c++) 
			{
				if ((**eeSample)[c] == currLet) letter++;
			}

			if (letter > result) 
			{
				result = letter;
				resultC = currLet;
			}
		}

		if (result == NULL) resultC = NULL;

		return std::to_string(result);
	}
	elif(calcType1 == false)
	{
		resultS = resultC;

		return resultS;
	}

	return "";
}

}