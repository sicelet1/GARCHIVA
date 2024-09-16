#pragma once
#include <iostream>
#include <string>
#include <chrono>
#include <thread>
#define elif else if
constexpr auto N30 = "------------------------------\n";
constexpr auto NN15 = "---------------\n\n";
namespace mUI
{
void wait(uint16_t time);
void header();
void headerRoot();
void headerS();
void headerC();
void menuRoot(std::string& menuUI, const bool menuUIb);
void menuString(std::string& menuUI, const std::string eSample, const bool menuUIb);
bool eValue(std::string& eSample, bool& eLine1);
void menuCalc(std::string& menuUI, const std::string eSample, const bool menuUIb);
void calcOut(std::string& menuUI, const std::string* eSample);
namespace animation
{
void inicialising();
void loading();
void calculating();
}
}
namespace calc
{
uint16_t calc1(const std::string** eeSample);
uint16_t calc2(const std::string** eeSample);
uint16_t calc3(const std::string** eeSample);
uint16_t calc4(const std::string** eeSample);
uint16_t calc5(const std::string** eeSample);
uint16_t calc6(const std::string** eeSample);
std::string calcB1(const std::string** eeSample, const bool calcType1);
float calcB2(const std::string** eeSample);
std::string calcB3(const std::string** eeSample, const bool calcType1);
std::string calcB4(const std::string** eeSample, const bool calcType1);
}