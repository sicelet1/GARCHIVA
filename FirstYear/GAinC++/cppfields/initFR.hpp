#pragma once
#include "initBD.hpp"
std::random_device rd;

void wait(uint16_t time)
{
	std::this_thread::sleep_for(std::chrono::milliseconds(time));
}

void header()
{
	std::cout << "-----------------\n" << "Field Manipulator       v 1.0.7.99\n" << "-----------------\n";
}

void headerFA()
{
	std::cout << "Now filling: array A\n-----------------\n";
}

void headerFB()
{
	std::cout << "Now filling: array B\n-----------------\n";
}

void headerFLog()
{
	std::cout << "Now filling: array Log\n-----------------\n";
}

void headerWA()
{
	std::cout << "Now viewing: array A\n-----------------\n";
}

void headerWB()
{
	std::cout << "Now viewing: array B\n-----------------\n";
}

void headerWLog()
{
	std::cout << "Now viewing: array Log\n-----------------\n";
}

bool rdLog()
{
	std::uniform_int_distribution<uint16_t> logR(0, 1);
	return logR(rd);
}

int64_t rdInt(rMIN, rMAX)
{
	std::uniform_int_distribution<int64_t> intR(rmin, rmax);
	return intR(rd);
}

double rdReal(rMIN, rMAX)
{
	std::uniform_real_distribution<double> realR(rmin, rmax);
	return realR(rd);
}