
//Zdrojový soubor obsahující všechny algoritmy, použité v roèníkovém projektu.

#include "init.hpp" //hlavièka se všemi knihovnami, makry + deklaracemi
#include "K7lib.UI.hpp" //moje 'mini' knihovna s funkcemi pro vytváøení & skládání textového UI
#include "K7lib.random.hpp" //moje 'mini' knihovna s funkcemi pro generování náhodných hodnot

namespace Algorithm
{

namespace RandomSequence
{

//Vygeneruje zadaný poèet èísel v zadaném rozmezí pomocí K7lib.random
std::vector<uint64_t> RandomNumberSequence(const uint64_t NumCount, const uint64_t MinValue, const uint64_t MaxValue) noexcept
{
	if (MinValue > MaxValue) return {};

	std::vector<uint64_t> RandomResults = K7::Generator::RandomValue<uint64_t>(NumCount, MinValue, MaxValue);

	return RandomResults;
}

//Vygeneruje zadaný poèet ASCII hesel se zadanou délkou pomocí K7lib.random
std::vector<std::string> RandomPasswordSequence(const uint64_t PasswordCount, const uint64_t PasswordLength) noexcept
{
	std::vector<std::string> RandomResults(0); std::string password; RandomResults.reserve(PasswordCount);

	for (uint64_t c = NULL; c < PasswordCount; c++)
	{
		password.clear(); password.reserve(PasswordLength);

		for (uint64_t cc = NULL; cc < PasswordLength; cc++)
			password.push_back((char)K7::Generator::RandomValue<uint16_t>(0x21, 0x7E));

		RandomResults.push_back(password);
	}

	return RandomResults;
}

}

namespace PrimeNumbers
{

//Vygeneruje prvoèíselnou øadu v zadaném rozmezí
std::vector<uint64_t> PrimeNumberGenerator(int64_t FromNum, const int64_t ToNum) noexcept
{
	if (ToNum < 2 || FromNum > ToNum) return {};

	std::vector<uint64_t> PrimeResults(0);

	if (FromNum < 2) FromNum = 2;

	for (int64_t c = FromNum; c <= ToNum; c++)
	{
		bool IsNotPrime = false;

		for (int64_t i = 2; i < c; i++)
		{
			if (c % i == 0) { IsNotPrime = true; break; }
		}

		if (IsNotPrime == false) { PrimeResults.push_back(c); }
	}

	return PrimeResults;
}

//Vygeneruje prvoèíselnou øadu v zadaném rozmezí s pomocí matematické optimalizace
std::vector<uint64_t> OptimizedPrimeNumberGenerator(int64_t FromNum, const int64_t ToNum) noexcept
{
	if (ToNum < 2 || FromNum > ToNum) return {};

	std::vector<uint64_t> PrimeResults(0);

	if (FromNum < 2) FromNum = 2;

	for (int64_t c = FromNum; c <= ToNum; c++)
	{
		if (c == 2 || c == 3) PrimeResults.push_back(c);

		if (c % 2 == 0 || c % 3 == 0) continue;

		bool IsNotPrime = false;

		for (int64_t i = 5; i * i <= c; i += 6)
		{
			if (c % i == 0 || c % (i + 2) == 0) { IsNotPrime = true; break; }
		}

		if (IsNotPrime == false) { PrimeResults.push_back(c); }
	}

	return PrimeResults;
}

}

namespace Sorting
{

//seøadí hodnoty v poli postupným porovnáváním dvojic hodnot vedle sebe & jejich pøípadným prohozením
void BubbleSort(std::vector<uint64_t>& Values) noexcept
{
	if (Values.size() == 0 || Values.size() == 1) return;

	bool WasSorted = false;

	do
	{
		WasSorted = false;

		for (uint64_t c = NULL; c < Values.size() - 1; c++)
		{
			if (Values[c] > Values[c + 1]) { uint64_t Buf = Values[c]; Values[c] = Values[c + 1]; Values[c + 1] = Buf; WasSorted = true; }
		}
	}
	while (WasSorted == true);
}

//seøadí hodnoty v poli postupným porovnáváním dvojic hodnot vedle sebe & jejich pøípadným prohozením
void BubbleSort(std::vector<std::string>& Values) noexcept
{
	if (Values.size() == 0 || Values.size() == 1) return;

	bool WasSorted = false;

	do
	{
		WasSorted = false;

		for (uint64_t c = NULL; c < Values.size() - 1; c++)
		{
			if (Values[c] > Values[c + 1]) { std::string Buf = Values[c]; Values[c] = Values[c + 1]; Values[c + 1] = Buf; WasSorted = true; }
		}
	} 
	while (WasSorted == true);
}

//nejprve najde nejmenší prvek v poli hodnot & ten pak dá do seøazené èásti pole, takhle to opakuje dokud není pole seøazeno
void SelectionSort(std::vector<uint64_t>& Values) noexcept
{
	if (Values.size() == 0 || Values.size() == 1) return;

	uint64_t SortingPos = NULL, ChangePos = NULL; uint64_t SmallestElem = UINT64_MAX;

	while (SortingPos < Values.size())
	{
		SmallestElem = UINT64_MAX;

		for (uint64_t c = SortingPos; c < Values.size(); c++)
		{
			if (Values[c] < SmallestElem) { SmallestElem = Values[c]; ChangePos = c; }
		}

		uint64_t Buf = Values[SortingPos]; Values[SortingPos] = Values[ChangePos]; Values[ChangePos] = Buf; SortingPos++;
	}
}

//nejprve najde nejmenší prvek v poli hodnot & ten pak dá do seøazené èásti pole, takhle to opakuje dokud není pole seøazeno
void SelectionSort(std::vector<std::string>& Values) noexcept
{
	if (Values.size() == 0 || Values.size() == 1) return;

	uint64_t SortingPos = NULL, ChangePos = NULL; std::string SmallestElem = "~";
	
	while (SortingPos < Values.size())
	{
		SmallestElem = "~";

		for (uint64_t c = SortingPos; c < Values.size(); c++)
		{
			if (Values[c] < SmallestElem) { SmallestElem = Values[c]; ChangePos = c; }
		}

		std::string Buf = Values[SortingPos]; Values[SortingPos] = Values[ChangePos]; Values[ChangePos] = Buf; SortingPos++;
	}
}

//porovnává všechny prvky seøazené èásti pole s prvním prvkem v neseøazené èásti, poté posune prvek na pøíslušnou pozici v seøazené èásti, takhle to opakuje dokud není pole seøazeno
void InsertionSort(std::vector<uint64_t>& Values) noexcept
{
	if (Values.size() == 0 || Values.size() == 1) return;

	uint64_t SortingPos = NULL;

	while (SortingPos < Values.size())
	{
		for (uint64_t c = SortingPos; c > NULL; c--)
		{
			if (Values[c] < Values[c - 1]) { uint64_t Buf = Values[c]; Values[c] = Values[c - 1]; Values[c - 1] = Buf; }
			else break;
		}

		SortingPos++;
	}
}

//porovnává všechny prvky seøazené èásti pole s prvním prvkem v neseøazené èásti, poté posune prvek na pøíslušnou pozici v seøazené èásti, takhle to opakuje dokud není pole seøazeno
void InsertionSort(std::vector<std::string>& Values) noexcept
{
	if (Values.size() == 0 || Values.size() == 1) return;

	uint64_t SortingPos = NULL;

	while (SortingPos < Values.size())
	{
		for (uint64_t c = SortingPos; c > NULL; c--)
		{
			if (Values[c] < Values[c - 1]) { std::string Buf = Values[c]; Values[c] = Values[c - 1]; Values[c - 1] = Buf; }
			else break;
		}

		SortingPos++;
	}
}

//zvolí poslední prvek pole, jako Pivot, s ním porovnává všechny ostatní prvky, nakonec jsou menší hodnoty nalevo, vìtší napravo [používá se sám na sebe]
void QuickSort(std::vector<uint64_t>& Values, const int64_t LowestIndex, const int64_t HighestIndex) noexcept
{
	if (LowestIndex >= HighestIndex || LowestIndex < 0) return;

	int64_t CurrentPivot = Values[HighestIndex], SortingPos = LowestIndex - 1;

	for (int64_t c = LowestIndex; c < HighestIndex; c++)
	{
		if ((int64_t)Values[c] <= CurrentPivot) { SortingPos++; int64_t Buf = Values[SortingPos]; Values[SortingPos] = Values[c]; Values[c] = Buf; }
	}

	SortingPos++; uint64_t Buf = Values[SortingPos]; Values[SortingPos] = Values[HighestIndex]; Values[HighestIndex] = Buf;

	Algorithm::Sorting::QuickSort(Values, LowestIndex, SortingPos - 1);
	Algorithm::Sorting::QuickSort(Values, SortingPos + 1, HighestIndex);
}

//zvolí poslední prvek pole, jako Pivot, s ním porovnává všechny ostatní prvky, nakonec jsou menší hodnoty nalevo, vìtší napravo [používá se sám na sebe]
void QuickSort(std::vector<std::string>& Values, const int64_t LowestIndex, const int64_t HighestIndex) noexcept
{
	if (LowestIndex >= HighestIndex || LowestIndex < 0) return;

	std::string CurrentPivot = Values[HighestIndex]; int64_t SortingPos = LowestIndex - 1;

	for (int64_t c = LowestIndex; c < HighestIndex; c++)
	{
		if (Values[c] <= CurrentPivot) { SortingPos++; std::string Buf = Values[SortingPos]; Values[SortingPos] = Values[c]; Values[c] = Buf; }
	}

	SortingPos++; std::string Buf = Values[SortingPos]; Values[SortingPos] = Values[HighestIndex]; Values[HighestIndex] = Buf;

	Algorithm::Sorting::QuickSort(Values, LowestIndex, SortingPos - 1);
	Algorithm::Sorting::QuickSort(Values, SortingPos + 1, HighestIndex);
}

//rozdìlí pole na levou & pravou polovinu, ty pak seøadí sám sebou & nakonec všechny poloviny spojí do jednoho seøazeného pole
void MergeSort(std::vector<uint64_t>& Values) noexcept
{
	if (Values.size() <= 1) return;

	std::vector<uint64_t> LeftHalf(0);
	std::vector<uint64_t> RightHalf(0);

	for (uint64_t c = NULL; c < Values.size(); c++)
	{
		if (c < Values.size() / 2) LeftHalf.push_back(Values[c]);
		else RightHalf.push_back(Values[c]);
	}

	Algorithm::Sorting::MergeSort(LeftHalf);
	Algorithm::Sorting::MergeSort(RightHalf);
	Values.clear();

	while (LeftHalf.size() != 0 && RightHalf.size() != 0)
	{
		if (LeftHalf[0] <= RightHalf[0])
		{
			Values.push_back(LeftHalf[0]);
			LeftHalf.erase(LeftHalf.begin());
		}
		else
		{
			Values.push_back(RightHalf[0]);
			RightHalf.erase(RightHalf.begin());
		}
	}

	while (LeftHalf.size() != 0)
	{
		Values.push_back(LeftHalf[0]);
		LeftHalf.erase(LeftHalf.begin());
	}

	while (RightHalf.size() != 0)
	{
		Values.push_back(RightHalf[0]);
		RightHalf.erase(RightHalf.begin());
	}
}

//rozdìlí pole na levou & pravou polovinu, ty pak seøadí sám sebou & nakonec všechny poloviny spojí do jednoho seøazeného pole
void MergeSort(std::vector<std::string>& Values) noexcept
{
	if (Values.size() <= 1) return;

	std::vector<std::string> LeftHalf(0); LeftHalf.reserve(Values.size() / 2);
	std::vector<std::string> RightHalf(0); RightHalf.reserve(Values.size() / 2);

	for (uint64_t c = NULL; c < Values.size(); c++)
	{
		if (c < Values.size() / 2) LeftHalf.push_back(Values[c]);
		else RightHalf.push_back(Values[c]);
	}

	Algorithm::Sorting::MergeSort(LeftHalf);
	Algorithm::Sorting::MergeSort(RightHalf);
	Values.clear();

	while (LeftHalf.size() != 0 && RightHalf.size() != 0)
	{
		if (LeftHalf[0] <= RightHalf[0])
		{
			Values.push_back(LeftHalf[0]);
			LeftHalf.erase(LeftHalf.begin());
		}
		else
		{
			Values.push_back(RightHalf[0]);
			RightHalf.erase(RightHalf.begin());
		}
	}

	while (LeftHalf.size() != 0)
	{
		Values.push_back(LeftHalf[0]);
		LeftHalf.erase(LeftHalf.begin());
	}

	while (RightHalf.size() != 0)
	{
		Values.push_back(RightHalf[0]);
		RightHalf.erase(RightHalf.begin());
	}
}

//Rozdìlí prvky pole do stanoveného poètu kbelíkù, ty pak seøadí jiným algoritmem [v tomto pøípadì - 'Quick Sort'] & nakonec spojí kbelíky do jednoho seøazeného pole
void BucketSort(std::vector<uint64_t>& Values, uint64_t BucketCount) noexcept
{
	if (Values.size() <= 1 || BucketCount <= 0) return;

	std::vector<std::vector<uint64_t>> Buckets(BucketCount); uint64_t BiggestElem = NULL, SavedSize = Values.size();

	for (uint64_t c = NULL; c < Values.size(); c++)
	{
		if (Values[c] > BiggestElem) BiggestElem = Values[c];
	}

	BiggestElem++;

	for (uint64_t c = NULL; c < Values.size(); c++)
	{
		Buckets[(uint64_t)floor(BucketCount * Values[c] / BiggestElem)].push_back(Values[c]);
	}

	for (uint64_t c = NULL; c < BucketCount; c++)
	{
		if (Buckets[c].size() == 0 || Buckets[c].size() == 1) continue;

		Algorithm::Sorting::QuickSort(Buckets[c], NULL, Buckets[c].size() - 1);
	}

	Values.clear(); Values.resize(SavedSize); uint64_t InsertPos = NULL;

	for (uint64_t c = NULL; c < BucketCount; c++)
	{
		for (uint64_t cc = NULL; cc < Buckets[c].size(); cc++)
		{
			Values[InsertPos] = Buckets[c][cc]; InsertPos++;
		}
	}
}

//Rozdìlí prvky pole do stanoveného poètu kbelíkù, ty pak seøadí jiným algoritmem [v tomto pøípadì - 'Quick Sort'] & nakonec spojí kbelíky do jednoho seøazeného pole
void BucketSort(std::vector<std::string>& Values, uint64_t BucketCount) noexcept
{
	if (Values.size() <= 1 || BucketCount <= 0) return;

	std::vector<std::vector<std::string>> Buckets(BucketCount); std::string BiggestElem; uint64_t SavedSize = Values.size();

	for (uint64_t c = NULL; c < Values.size(); c++)
	{
		if (Values[c] > BiggestElem) BiggestElem = Values[c];
	}

	for (uint64_t c = NULL; c < Values.size(); c++)
	{
		Buckets[(uint64_t)floor(BucketCount * (uint64_t)Values[c][0] / (uint64_t)(BiggestElem[0] + (char)0x01))].push_back(Values[c]);
	}
	
	for (uint64_t c = NULL; c < BucketCount; c++)
	{
		if (Buckets[c].size() == 0 || Buckets[c].size() == 1) continue;

		Algorithm::Sorting::QuickSort(Buckets[c], NULL, Buckets[c].size() - 1);
	}

	Values.clear(); Values.resize(SavedSize); uint64_t InsertPos = NULL;

	for (uint64_t c = NULL; c < BucketCount; c++)
	{
		for (uint64_t cc = NULL; cc < Buckets[c].size(); cc++)
		{
			Values[InsertPos] = Buckets[c][cc]; InsertPos++;
		}
	}
}

}

}