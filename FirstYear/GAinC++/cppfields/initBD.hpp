#pragma once
#include <iostream>
#include <random>
#include <chrono>
#include <thread>
#include <string>
#include "math.h"
#define elif else if
#define rMIN int64_t rmin
#define rMAX int64_t rmax
#define ARRAY std::vector<double> 
#define ARRLOG std::vector<bool>
struct arrays
{
	ARRAY fieldA;
	ARRAY fieldB;
	ARRLOG fieldLog;
	ARRAY outA;
};
struct variables
{
	std::string mUI;
	double in = NULL;
	double p1 = NULL;
	double p2 = NULL;
	double out = NULL;
	bool outLog = NULL;
	bool mUIl = NULL;
	int64_t rInMin = NULL;
	int64_t rInMax = NULL;
};
void wait(uint16_t time);
void header();
void headerFA();
void headerFB();
void headerFLog();
void headerWA();
void headerWB();
void headerWLog();
bool rdLog();
int64_t rdInt(rMIN, rMAX);
double rdReal(rMIN, rMAX);
void toMenu();
void uI0();
void uI1();
void calc0();
void mMenu();
void iN();
void arrM1();
void arStat();
ARRAY fillA();
ARRAY fillB();
ARRLOG fillLog();
void dscmr();
double sum(ARRAY fieldA, uint16_t sizeA);
double arAv(ARRAY fieldA, uint16_t sizeA);
double geoAv(ARRAY fieldA, uint16_t sizeA);
double qvAv(ARRAY fieldA, uint16_t sizeA);
double stdD(ARRAY fieldA, uint16_t sizeA);
double weightAv(ARRAY fieldA, ARRAY fieldB, uint16_t sizeA, uint16_t sizeB);
bool logOr(ARRLOG fieldLog, uint16_t sizeLog);
bool logAnd(ARRLOG fieldLog, uint16_t sizeLog);
ARRAY cloneA(ARRAY fieldA, uint16_t sizeA);
ARRAY contAB(ARRAY fieldA, ARRAY fieldB, uint16_t sizeA, uint16_t sizeB);