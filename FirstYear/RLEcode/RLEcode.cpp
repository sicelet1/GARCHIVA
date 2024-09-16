//Program by Jakub Wimmer, made in 2023
//©K7industries, all rights reserved
//DO NOT COPY!!!

//includes, presets & definitions
#include <iostream>
#include <string>
#include <chrono>
#include <thread>
#define elif else if
int cc;
int i2;
int r2;
int p;
int v;
std::string a;
std::string b;
std::string i;
std::string o;
std::string ccs;
std::string ccs1;
std::string ccs2;
void wait(int64_t t)
{
	std::this_thread::sleep_for(std::chrono::milliseconds(t));
}

//Animations & Graphics
void header()
{
	std::cout << "-------------------\n" << "RLE code translator       v 1.0.1.29\n" << "-------------------\n";
}


void headerE()
{
	std::cout << "ENCODE MODE\n" << "-------------------\n";
}


void headerD()
{
	std::cout << "DECODE MODE\n" << "-------------------\n";
}


void backToMenu()
{
	std::cout << "\n" << "Press 0 to go back to main menu:";
	in2:
	std::cin >> b;

	if (b == "0")
	{
		system("CLS");
		header();
	}
	else
	{
		std::cout << "\n\n" << "Invalid input, try it again:";
		goto in2;
	}
}


void tableLoading()
{
	for (int tl = 0; tl <= 10; tl++)
	{
		std::cout << "-------------------\n\n" << "BUILDING TABLE    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "BUILDING TABLE    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "BUILDING TABLE    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "BUILDING TABLE    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}
}


void tableBuild()
{
	std::cout << "--------------------------------------------------\n" << "RLE code table: normal char to hexadecimal [ASCII]\n" << "--------------------------------------------------\n\n";
	std::cout << "--------------   --------------   --------------\n" << "| char | hex |   | char | hex |   | char | hex |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   0  | 30  |   |   A  | 41  |   |   a  | 61  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   1  | 31  |   |   B  | 42  |   |   b  | 62  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   2  | 32  |   |   C  | 43  |   |   c  | 63  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   3  | 33  |   |   D  | 44  |   |   d  | 64  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   4  | 34  |   |   E  | 45  |   |   e  | 65  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   5  | 35  |   |   F  | 46  |   |   f  | 66  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   6  | 36  |   |   G  | 47  |   |   g  | 67  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   7  | 37  |   |   H  | 48  |   |   h  | 68  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   8  | 38  |   |   I  | 49  |   |   i  | 69  |\n" << "--------------   --------------   --------------\n";
	std::cout << "|   9  | 39  |   |   J  | 4A  |   |   j  | 6A  |\n" << "--------------   --------------   --------------\n";
	std::cout << "                 |   K  | 4B  |   |   k  | 6B  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   L  | 4C  |   |   l  | 6C  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   M  | 4D  |   |   m  | 6D  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   N  | 4E  |   |   n  | 6E  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   O  | 4F  |   |   o  | 6F  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   P  | 50  |   |   p  | 70  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   Q  | 51  |   |   q  | 71  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   R  | 52  |   |   r  | 72  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   S  | 53  |   |   s  | 73  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   T  | 54  |   |   t  | 74  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   U  | 55  |   |   u  | 75  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   V  | 56  |   |   v  | 76  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   W  | 57  |   |   w  | 77  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   X  | 58  |   |   x  | 78  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   Y  | 59  |   |   y  | 79  |\n" << "                 --------------   --------------\n";
	std::cout << "                 |   Z  | 5A  |   |   z  | 7A  |\n" << "                 --------------   --------------\n";
}


void inicialising()
{
	for (int init0 = 0; init0 <= 10; init0++)
	{
		std::cout << "-------------------\n\n" << "INICIALISING    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "INICIALISING    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "INICIALISING    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "INICIALISING    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	for (int init1 = 0; init1 <= 10; init1++)
	{
		header();
		std::cout << "-------------------\n\n" << "LOADING FROM DRIVE    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		header();
		std::cout << "-------------------\n\n" << "LOADING FROM DRIVE    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		header();
		std::cout << "-------------------\n\n" << "LOADING FROM DRIVE    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		header();
		std::cout << "-------------------\n\n" << "LOADING FROM DRIVE    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	for (int init2 = 0; init2 <= 10; init2++)
	{
		header();
		std::cout << "-------------------\n\n" << "BUILDING CODE TABLE    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		header();
		std::cout << "-------------------\n\n" << "BUILDING CODE TABLE    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		header();
		std::cout << "-------------------\n\n" << "BUILDING CODE TABLE    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		header();
		std::cout << "-------------------\n\n" << "BUILDING CODE TABLE    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	system("CLS");
	header();
}


void encodeProc()
{
	for (int eP = 0; eP <= 10; eP++)
	{
		std::cout << "-------------------\n\n" << "PREPARING FOR ENCODE    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING FOR ENCODE    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING FOR ENCODE    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING FOR ENCODE    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	for (int eP = 0; eP <= 10; eP++)
	{
		std::cout << "-------------------\n\n" << "ENCODING    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "ENCODING    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "ENCODING    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "ENCODING    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}
}


void decodeProc()
{
	for (int dP = 0; dP <= 10; dP++)
	{
		std::cout << "-------------------\n\n" << "PREPARING FOR DECODE    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING FOR DECODE    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING FOR DECODE    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "PREPARING FOR DECODE    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	for (int dP = 0; dP <= 10; dP++)
	{
		std::cout << "-------------------\n\n" << "DECODING    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "DECODING    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "DECODING    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "DECODING    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}
}

//Validations
void validateEncodeInput01()
{
	for (int initE = 0; initE <= 10; initE++)
	{
		std::cout << "-------------------\n\n" << "VALIDATING    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	if (i.length() > 100)
	{
		header();
		headerE();
		std::cout << "Validation failed, input is too long [max. 100 chars].\n";
	}
}


void validateEncodeInput02()
{
	v = 0;

	while (i[v] == '0' || i[v] == '1' || i[v] == '2' || i[v] == '3' || i[v] == '4' || i[v] == '5' || i[v] == '6' || i[v] == '7' || i[v] == '8' || i[v] == '9' || i[v] == 'A' || i[v] == 'B' || i[v] == 'C' || i[v] == 'D' || i[v] == 'E' || i[v] == 'F' || i[v] == 'G' || i[v] == 'H' || i[v] == 'I' || i[v] == 'J' || i[v] == 'K' || i[v] == 'L' || i[v] == 'M' || i[v] == 'N' || i[v] == 'O' || i[v] == 'P' || i[v] == 'Q' || i[v] == 'R' || i[v] == 'S' || i[v] == 'T' || i[v] == 'U' || i[v] == 'V' || i[v] == 'W' || i[v] == 'X' || i[v] == 'Y' || i[v] == 'Z' || i[v] == 'a' || i[v] == 'b' || i[v] == 'c' || i[v] == 'd' || i[v] == 'e' || i[v] == 'f' || i[v] == 'g' || i[v] == 'h' || i[v] == 'i' || i[v] == 'j' || i[v] == 'k' || i[v] == 'l' || i[v] == 'm' || i[v] == 'n' || i[v] == 'o' || i[v] == 'p' || i[v] == 'q' || i[v] == 'r' || i[v] == 's' || i[v] == 't' || i[v] == 'u' || i[v] == 'v' || i[v] == 'w' || i[v] == 'x' || i[v] == 'y' || i[v] == 'z')
	{
		v++;
	}

	if (v != i.length())
	{
		header();
		headerE();
		std::cout << "Validation failed, cannot recognise this input: " << i << ".\n";
	}
}


void validateDecodeInput01()
{
	for (int initE = 0; initE <= 10; initE++)
	{
		std::cout << "-------------------\n\n" << "VALIDATING    -\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    \\\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    |\n\n" << "-------------------";
		wait(100);
		system("CLS");
		std::cout << "-------------------\n\n" << "VALIDATING    /\n\n" << "-------------------";
		wait(100);
		system("CLS");
	}

	if (i.length() > 100)
	{
		header();
		headerD();
		std::cout << "Validation failed, input is too long [max. 100 chars].\n";
	}
}


void validateDecodeInput02()
{
	v = 0;

	while (i[v] == '-' || i[v] == '0' || i[v] == '1' || i[v] == '2' || i[v] == '3' || i[v] == '4' || i[v] == '5' || i[v] == '6' || i[v] == '7' || i[v] == '8' || i[v] == '9' || i[v] == 'A' || i[v] == 'B' || i[v] == 'C' || i[v] == 'D' || i[v] == 'E' || i[v] == 'F')
	{
		v++;
	}

	if (v != i.length())
	{
		header();
		headerD();
		std::cout << "Validation failed, cannot recognise this input: " << i << ".\n";
	}
}

//Encode & decode
void encode()
{
	cc = 0;
	o.clear();
	header();
	headerE();
	for (int r = 0; r <= i.length(); r++)
	{
		if (i2 != i.length())
		{
			if (i[i2] == i[i2++])
			{
				cc = cc++;
			}
			else
			{
				cc = cc++;
				ccs = std::to_string(cc);

				if (i[i2 - 1] == '0')
				{
					o = o + ccs + "30-";
				}
				elif(i[i2 - 1] == '1')
				{
					o = o + ccs + "31-";
				}
				elif(i[i2 - 1] == '2')
				{
					o = o + ccs + "32-";
				}
				elif(i[i2 - 1] == '3')
				{
					o = o + ccs + "33-";
				}
				elif(i[i2 - 1] == '4')
				{
					o = o + ccs + "34-";
				}
				elif(i[i2 - 1] == '5')
				{
					o = o + ccs + "35-";
				}
				elif(i[i2 - 1] == '6')
				{
					o = o + ccs + "36-";
				}
				elif(i[i2 - 1] == '7')
				{
					o = o + ccs + "37-";
				}
				elif(i[i2 - 1] == '8')
				{
					o = o + ccs + "38-";
				}
				elif(i[i2 - 1] == '9')
				{
					o = o + ccs + "39-";
				}
				elif(i[i2 - 1] == 'A')
				{
					o = o + ccs + "41-";
				}
				elif(i[i2 - 1] == 'B')
				{
					o = o + ccs + "42-";
				}
				elif(i[i2 - 1] == 'C')
				{
					o = o + ccs + "43-";
				}
				elif(i[i2 - 1] == 'D')
				{
					o = o + ccs + "44-";
				}
				elif(i[i2 - 1] == 'E')
				{
					o = o + ccs + "45-";
				}
				elif(i[i2 - 1] == 'F')
				{
					o = o + ccs + "46-";
				}
				elif(i[i2 - 1] == 'G')
				{
					o = o + ccs + "47-";
				}
				elif(i[i2 - 1] == 'H')
				{
					o = o + ccs + "48-";
				}
				elif(i[i2 - 1] == 'I')
				{
					o = o + ccs + "49-";
				}
				elif(i[i2 - 1] == 'J')
				{
					o = o + ccs + "4A-";
				}
				elif(i[i2 - 1] == 'K')
				{
					o = o + ccs + "4B-";
				}
				elif(i[i2 - 1] == 'L')
				{
					o = o + ccs + "4C-";
				}
				elif(i[i2 - 1] == 'M')
				{
					o = o + ccs + "4D-";
				}
				elif(i[i2 - 1] == 'N')
				{
					o = o + ccs + "4E-";
				}
				elif(i[i2 - 1] == 'O')
				{
					o = o + ccs + "4F-";
				}
				elif(i[i2 - 1] == 'P')
				{
					o = o + ccs + "50-";
				}
				elif(i[i2 - 1] == 'Q')
				{
					o = o + ccs + "51-";
				}
				elif(i[i2 - 1] == 'R')
				{
					o = o + ccs + "52-";
				}
				elif(i[i2 - 1] == 'S')
				{
					o = o + ccs + "53-";
				}
				elif(i[i2 - 1] == 'T')
				{
					o = o + ccs + "54-";
				}
				elif(i[i2 - 1] == 'U')
				{
					o = o + ccs + "55-";
				}
				elif(i[i2 - 1] == 'V')
				{
					o = o + ccs + "56-";
				}
				elif(i[i2 - 1] == 'W')
				{
					o = o + ccs + "57-";
				}
				elif(i[i2 - 1] == 'X')
				{
					o = o + ccs + "58-";
				}
				elif(i[i2 - 1] == 'Y')
				{
					o = o + ccs + "59-";
				}
				elif(i[i2 - 1] == 'Z')
				{
					o = o + ccs + "5A-";
				}
				elif(i[i2 - 1] == 'a')
				{
					o = o + ccs + "61-";
				}
				elif(i[i2 - 1] == 'b')
				{
					o = o + ccs + "62-";
				}
				elif(i[i2 - 1] == 'c')
				{
					o = o + ccs + "63-";
				}
				elif(i[i2 - 1] == 'd')
				{
					o = o + ccs + "64-";
				}
				elif(i[i2 - 1] == 'e')
				{
					o = o + ccs + "65-";
				}
				elif(i[i2 - 1] == 'f')
				{
					o = o + ccs + "66-";
				}
				elif(i[i2 - 1] == 'g')
				{
					o = o + ccs + "67-";
				}
				elif(i[i2 - 1] == 'h')
				{
					o = o + ccs + "68-";
				}
				elif(i[i2 - 1] == 'i')
				{
					o = o + ccs + "69-";
				}
				elif(i[i2 - 1] == 'j')
				{
					o = o + ccs + "6A-";
				}
				elif(i[i2 - 1] == 'k')
				{
					o = o + ccs + "6B-";
				}
				elif(i[i2 - 1] == 'l')
				{
					o = o + ccs + "6C-";
				}
				elif(i[i2 - 1] == 'm')
				{
					o = o + ccs + "6D-";
				}
				elif(i[i2 - 1] == 'n')
				{
					o = o + ccs + "6E-";
				}
				elif(i[i2 - 1] == 'o')
				{
					o = o + ccs + "6F-";
				}
				elif(i[i2 - 1] == 'p')
				{
					o = o + ccs + "70-";
				}
				elif(i[i2 - 1] == 'q')
				{
					o = o + ccs + "71-";
				}
				elif(i[i2 - 1] == 'r')
				{
					o = o + ccs + "72-";
				}						
				elif(i[i2 - 1] == 's')
				{						
					o = o + ccs + "73-";
				}						
				elif(i[i2 - 1] == 't')
				{						
					o = o + ccs + "74-";
				}						
				elif(i[i2 - 1] == 'u')
				{						
					o = o + ccs + "75-";
				}						
				elif(i[i2 - 1] == 'v')
				{						
					o = o + ccs + "76-";
				}						
				elif(i[i2 - 1] == 'w')
				{						
					o = o + ccs + "77-";
				}						
				elif(i[i2 - 1] == 'x')
				{						
					o = o + ccs + "78-";
				}						
				elif(i[i2 - 1] == 'y')
				{						
					o = o + ccs + "79-";
				}						
				elif(i[i2 - 1] == 'z')
				{						
					o = o + ccs + "7A-";
				}
				cc = 0;
			}
		}
	}
	o.pop_back();
}


void transToChar(int r2)
{
	while (r2 > 0)
	{
		if (ccs == std::to_string(30))
		{
			o = o + "0";
		}
		elif(ccs == std::to_string(31))
		{
			o = o + "1";
		}
		elif(ccs == std::to_string(32))
		{
			o = o + "2";
		}
		elif(ccs == std::to_string(33))
		{
			o = o + "3";
		}
		elif(ccs == std::to_string(34))
		{
			o = o + "4";
		}
		elif(ccs == std::to_string(35))
		{
			o = o + "5";
		}
		elif(ccs == std::to_string(36))
		{
			o = o + "6";
		}
		elif(ccs == std::to_string(37))
		{
			o = o + "7";
		}
		elif(ccs == std::to_string(38))
		{
			o = o + "8";
		}
		elif(ccs == std::to_string(39))
		{
			o = o + "9";
		}
		elif(ccs == std::to_string(41))
		{
			o = o + "A";
		}
		elif(ccs == std::to_string(42))
		{
			o = o + "B";
		}
		elif(ccs == std::to_string(43))
		{
			o = o + "C";
		}
		elif(ccs == std::to_string(44))
		{
			o = o + "D";
		}
		elif(ccs == std::to_string(45))
		{
			o = o + "E";
		}
		elif(ccs == std::to_string(46))
		{
			o = o + "F";
		}
		elif(ccs == std::to_string(47))
		{
			o = o + "G";
		}
		elif(ccs == std::to_string(48))
		{
			o = o + "H";
		}
		elif(ccs == std::to_string(49))
		{
			o = o + "I";
		}
		elif(ccs == std::to_string(4) + "A")
		{
			o = o + "J";
		}
		elif(ccs == std::to_string(4) + "B")
		{
			o = o + "K";
		}
		elif(ccs == std::to_string(4) + "C")
		{
			o = o + "L";
		}
		elif(ccs == std::to_string(4) + "D")
		{
			o = o + "M";
		}
		elif(ccs == std::to_string(4) + "E")
		{
			o = o + "N";
		}
		elif(ccs == std::to_string(4) + "F")
		{
			o = o + "O";
		}
		elif(ccs == std::to_string(50))
		{
			o = o + "P";
		}
		elif(ccs == std::to_string(51))
		{
			o = o + "Q";
		}
		elif(ccs == std::to_string(52))
		{
			o = o + "R";
		}
		elif(ccs == std::to_string(53))
		{
			o = o + "S";
		}
		elif(ccs == std::to_string(54))
		{
			o = o + "T";
		}
		elif(ccs == std::to_string(55))
		{
			o = o + "U";
		}
		elif(ccs == std::to_string(56))
		{
			o = o + "V";
		}
		elif(ccs == std::to_string(57))
		{
			o = o + "W";
		}
		elif(ccs == std::to_string(58))
		{
			o = o + "X";
		}
		elif(ccs == std::to_string(59))
		{
			o = o + "Y";
		}
		elif(ccs == std::to_string(5) + "A")
		{
			o = o + "Z";
		}
		elif(ccs == std::to_string(61))
		{
			o = o + "a";
		}
		elif(ccs == std::to_string(62))
		{
			o = o + "b";
		}
		elif(ccs == std::to_string(63))
		{
			o = o + "c";
		}
		elif(ccs == std::to_string(64))
		{
			o = o + "d";
		}
		elif(ccs == std::to_string(65))
		{
			o = o + "e";
		}
		elif(ccs == std::to_string(66))
		{
			o = o + "f";
		}
		elif(ccs == std::to_string(67))
		{
			o = o + "g";
		}
		elif(ccs == std::to_string(68))
		{
			o = o + "h";
		}
		elif(ccs == std::to_string(69))
		{
			o = o + "i";
		}
		elif(ccs == std::to_string(6) + "A")
		{
			o = o + "j";
		}
		elif(ccs == std::to_string(6) + "B")
		{
			o = o + "k";
		}
		elif(ccs == std::to_string(6) + "C")
		{
			o = o + "l";
		}
		elif(ccs == std::to_string(6) + "D")
		{
			o = o + "m";
		}
		elif(ccs == std::to_string(6) + "E")
		{
			o = o + "n";
		}
		elif(ccs == std::to_string(6) + "F")
		{
			o = o + "o";
		}
		elif(ccs == std::to_string(70))
		{
			o = o + "p";
		}
		elif(ccs == std::to_string(71))
		{
			o = o + "q";
		}
		elif(ccs == std::to_string(72))
		{
			o = o + "r";
		}
		elif(ccs == std::to_string(73))
		{
			o = o + "s";
		}
		elif(ccs == std::to_string(74))
		{
			o = o + "t";
		}
		elif(ccs == std::to_string(75))
		{
			o = o + "u";
		}
		elif(ccs == std::to_string(76))
		{
			o = o + "v";
		}
		elif(ccs == std::to_string(77))
		{
			o = o + "w";
		}
		elif(ccs == std::to_string(78))
		{
			o = o + "x";
		}
		elif(ccs == std::to_string(79))
		{
			o = o + "y";
		}
		elif(ccs == std::to_string(7) + "A")
		{
			o = o + "z";
		}
		r2--;
	}
}


void decode()
{
	o.clear();
	header();
	headerD();
	if (i[i.length()] != '-')
	{
		i = i + "-";
	}

	for (int r = 0; r <= i.length(); r++)
	{
		if (i2 != i.length())
		{
			if (i[i2] == '-')
			{
				ccs1 = i[i2 - 2];
				ccs2 = i[i2 - 1];
				ccs = ccs1 + ccs2;

				if (i2 == 3)
				{
					p = i[0] - 48;
				}
				elif(i2 == 4)
				{
					p = std::stoi(std::to_string(i[0] - 48) + std::to_string(i[1] - 48));
				}
				elif(i2 > 4)
				{
					if (i[i2 - 4] == '-')
					{
						p = i[i2 - 3] - 48;
					}
					elif(i[i2 - 5] == '-')
					{
						p = std::stoi(std::to_string(i[i2 - 4] - 48) + std::to_string(i[i2 - 3] - 48));
					}
				}
				transToChar(p);
				p = 0;
			}
			i2++;
		}
	}
	i.pop_back();
}

//Main menu
void startup()
{
in3:
	i2 = 0;
	cc = 0;
	std::cout << "Type 0 for Encode or 1 for Decode or 2 for view Coding table:";
in1:
	std::cin >> a;

	if (a == "0")
	{
		system("CLS");
		header();
		headerE();
		std::cout << "NOTE: only 100 char can be encoded at once & only chars, that are in the code table can be recognised [spaces aren't working].\n\n" << "Please type here, what you want to translate to RLE:";
		std::cin >> i;
		validateEncodeInput01();
		if (i.length() > 100)
		{
			backToMenu();
			goto in3;
		}
		validateEncodeInput02();
		if (v == i.length())
		{
			system("CLS");
			encodeProc();
			encode();
			std::cout << "Encoding result:\n\n" << "'" << i << "' encoded to '" << o << "'\n\n";
			backToMenu();
			goto in3;
		}
		else
		{
			backToMenu();
			goto in3;
		}
	}
	elif(a == "1")
	{
		system("CLS");
		header();
		headerD();
		std::cout << "NOTE: RLE need to be in following order: char count, char's HEX code, - , [Example: 332-145A].\n\n" << "Please type here, what you want to translate to normal characters:";
		std::cin >> i;
		validateDecodeInput01();
		if (i.length() > 100)
		{
			backToMenu();
			goto in3;
		}
		validateDecodeInput02();
		if (v == i.length())
		{
			system("CLS");
			decodeProc();
			decode();
			std::cout << "Decoding result:\n\n" << "'" << i << "' decoded to '" << o << "'\n\n";
			backToMenu();
			goto in3;
		}
		else
		{
			backToMenu();
			goto in3;
		}
	}
	elif(a == "2")
	{
		system("CLS");
		tableLoading();
		tableBuild();
		backToMenu();
		goto in3;
	}
	else
	{
		std::cout << "\n\n" << "Invalid input, try it again:";
		goto in1;
	}
}


//Just main function...
int main()
{
	inicialising();
	startup();
}