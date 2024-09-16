#pragma once
#include <iostream>
#include <string>
#include <chrono>
#include <thread>
#define elif else if

struct outAP
{ 
std::string inP1; 
std::string inP2; 
};
void wait(const int16_t t);
void initSetup();
void startSession();
void validation();
void header();
void menu0();
void session();
void toMMenu();
void inDNA();
void inMRNA();
void tcA();
void tlA();
void finish(const outAP AP, const std::string D, const std::string R);
int valD(std::string valD);
int valR(std::string vR);
std::string transcription(std::string tD);
std::string toCap(std::string nCAP);
outAP translation(std::string tRc);