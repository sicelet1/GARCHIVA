//(c) K7 corp. :: all rights reserved

//------------------------------------------------------------
//Hlavièka K7 knihovny pro generování rùzných náhodných hodnot
//------------------------------------------------------------

//ochrana proti vícenásobné definici
#ifndef K7random
#define K7random

//!používám C++23 prewiew
//vložení standardních C++ knihoven pro mojí generátorovou knihovnu
#include <random>
#include <vector>
#include <type_traits>

//mám radši elif, no
#ifndef elif
#define elif else if
#endif

namespace K7 //hlavní obor funkcí 'pseudo-standardní' knihovny K7 pro C++20/23
{

template<typename T> concept RANDOM_OnlyNUM = std::is_integral_v<T> && !std::same_as<T, bool>; //koncept pro omezení možných typù v šablonì na pouze èísla [tj. ne bool]
template<typename T> concept RANDOM_OnlyDEC = std::is_floating_point_v<T>; //koncept pro omezení možných typù v šablonì na pouze na desetinná èísla
template<typename T> concept RANDOM_OnlyBOL = std::same_as<T, bool>; //koncept pro omezení možných typù v šablonì na pouze bool

namespace Generator //funkce pro generování pseudonáhodných èísel rùzných datových typù
{

//vrátí pole celých náhodných èísel o poètu 'NumCount' v rozmezí hodnot od 'Min' do 'Max'
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

//vrátí jedno celé náhodné èíslo v rozmezí hodnot od 'Min' do 'Max'
template<RANDOM_OnlyNUM ValueType> inline ValueType RandomValue(const ValueType Min, const ValueType Max)
{
	std::random_device random; std::uniform_int_distribution<ValueType> randR(Min, Max);
	ValueType randNum = randR(random);

	return randNum;
}

//vrátí pole desetinných náhodných èísel o poètu 'NumCount' v rozmezí hodnot od 'Min' do 'Max'
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

//vrátí jedno desetinné náhodné èíslo v rozmezí hodnot od 'Min' do 'Max'
template<RANDOM_OnlyDEC ValueType> inline ValueType RandomValue(const ValueType Min, const ValueType Max)
{
	std::random_device random; std::uniform_real_distribution<ValueType> randR(Min, Max);
	ValueType randNum = randR(random);

	return randNum;
}

//vrátí pole náhodných pravdivostních hodnot [true/false] o poètu 'NumCount'
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

//vrátí jednu náhodnou pravdivostní hodnotu [true/false]
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