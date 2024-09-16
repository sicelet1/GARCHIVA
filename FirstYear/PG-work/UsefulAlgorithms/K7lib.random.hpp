//(c) K7 corp. :: all rights reserved

//------------------------------------------------------------
//Hlavi�ka K7 knihovny pro generov�n� r�zn�ch n�hodn�ch hodnot
//------------------------------------------------------------

//ochrana proti v�cen�sobn� definici
#ifndef K7random
#define K7random

//!pou��v�m C++23 prewiew
//vlo�en� standardn�ch C++ knihoven pro moj� gener�torovou knihovnu
#include <random>
#include <vector>
#include <type_traits>

//m�m rad�i elif, no
#ifndef elif
#define elif else if
#endif

namespace K7 //hlavn� obor funkc� 'pseudo-standardn�' knihovny K7 pro C++20/23
{

template<typename T> concept RANDOM_OnlyNUM = std::is_integral_v<T> && !std::same_as<T, bool>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze ��sla [tj. ne bool]
template<typename T> concept RANDOM_OnlyDEC = std::is_floating_point_v<T>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze na desetinn� ��sla
template<typename T> concept RANDOM_OnlyBOL = std::same_as<T, bool>; //koncept pro omezen� mo�n�ch typ� v �ablon� na pouze bool

namespace Generator //funkce pro generov�n� pseudon�hodn�ch ��sel r�zn�ch datov�ch typ�
{

//vr�t� pole cel�ch n�hodn�ch ��sel o po�tu 'NumCount' v rozmez� hodnot od 'Min' do 'Max'
template<RANDOM_OnlyNUM ValueType> inline std::vector<ValueType> RandomValue(const std::size_t NumCount, const ValueType Min, const ValueType Max)
{
	std::random_device random; std::vector<ValueType> randNum; randNum.reserve(NumCount);
	std::uniform_int_distribution<ValueType> randR(Min, Max);

	for (std::size_t c = NumCount; c != NULL; c--)
	{
		randNum.push_back(randR(random));
	}

	return randNum;
}

//vr�t� jedno cel� n�hodn� ��slo v rozmez� hodnot od 'Min' do 'Max'
template<RANDOM_OnlyNUM ValueType> inline ValueType RandomValue(const ValueType Min, const ValueType Max)
{
	std::random_device random; std::uniform_int_distribution<ValueType> randR(Min, Max);
	ValueType randNum = randR(random);

	return randNum;
}

//vr�t� pole desetinn�ch n�hodn�ch ��sel o po�tu 'NumCount' v rozmez� hodnot od 'Min' do 'Max'
template<RANDOM_OnlyDEC ValueType> inline std::vector<ValueType> RandomValue(const std::size_t NumCount, const ValueType Min, const ValueType Max)
{
	std::random_device random; std::vector<ValueType> randNum; randNum.reserve(NumCount);
	std::uniform_real_distribution<ValueType> randR(Min, Max);

	for (std::size_t c = ValueType; c != NULL; c--)
	{
		randNum.push_back(randR(random));
	}

	return randNum;
}

//vr�t� jedno desetinn� n�hodn� ��slo v rozmez� hodnot od 'Min' do 'Max'
template<RANDOM_OnlyDEC ValueType> inline ValueType RandomValue(const ValueType Min, const ValueType Max)
{
	std::random_device random; std::uniform_real_distribution<ValueType> randR(Min, Max);
	ValueType randNum = randR(random);

	return randNum;
}

//vr�t� pole n�hodn�ch pravdivostn�ch hodnot [true/false] o po�tu 'NumCount'
template<RANDOM_OnlyBOL ValueType> inline std::vector<ValueType> RandomValue(const std::size_t NumCount)
{
	std::random_device random; std::vector<ValueType> randBool; randBool.reserve(NumCount);
	std::uniform_int_distribution<uint16_t> randR(0, 1);

	for (std::size_t c = NumCount; c != NULL; c--)
	{
		uint16_t value = randR(random);
		value == 0 ? randBool.push_back(false) : randBool.push_back(true);
	}

	return randBool;
}

//vr�t� jednu n�hodnou pravdivostn� hodnotu [true/false]
template<RANDOM_OnlyBOL ValueType> inline ValueType RandomValue()
{
	std::random_device random; std::uniform_int_distribution<uint16_t> randR(0, 1);
	uint16_t value = randR(random); ValueType randNum = NULL;
	value == 0 ? randNum = false : randNum = true;

	return randNum;
}

}

}

#endif //konec bloku