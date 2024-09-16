
//Zdrojov� soubor obsahuj�c� spou�t��e & m��ic� se�azovac�ch algoritm�.

#include "init.hpp" //hlavi�ka se v�emi knihovnami, makry + deklaracemi
#include "K7lib.UI.hpp" //moje 'mini' knihovna s funkcemi pro vytv��en� & skl�d�n� textov�ho UI

namespace Floor_4_5
{
	
//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 1 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_1(std::wstring& MenuUI, std::vector<std::string>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::BubbleSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII(); 
	
	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 2 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_2(std::wstring& MenuUI, std::vector<std::string>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::SelectionSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII(); 
	
	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 3 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_3(std::wstring& MenuUI, std::vector<std::string>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::InsertionSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII(); 
	
	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 4 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_4(std::wstring& MenuUI, std::vector<std::string>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::QuickSort(FileValues, NULL, FileValues.size() - 1);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII(); 
	
	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 5 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_5(std::wstring& MenuUI, std::vector<std::string>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::MergeSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII(); 
	
	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 6 v 'UIfloor_main.cpp' v mo�nosti 4 z 'main.cpp'
void Option_4_6(std::wstring& MenuUI, std::vector<std::string>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::BucketSort(FileValues, (uint64_t)floor(FileValues.size() / 2));

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII(); 
	
	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 1 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_1(std::wstring& MenuUI, std::vector<uint64_t>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::BubbleSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII();

	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 2 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_2(std::wstring& MenuUI, std::vector<uint64_t>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::SelectionSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII();

	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 3 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_3(std::wstring& MenuUI, std::vector<uint64_t>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::InsertionSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII();

	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 4 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_4(std::wstring& MenuUI, std::vector<uint64_t>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::QuickSort(FileValues, NULL, FileValues.size() - 1);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII();

	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 5 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_5(std::wstring& MenuUI, std::vector<uint64_t>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::MergeSort(FileValues);

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII();

	return;
}

//spou�t� se�azovac� algoritmus & m��� jeho v�kon pro mo�nost 6 v 'UIfloor_main.cpp' v mo�nosti 5 z 'main.cpp'
void Option_5_6(std::wstring& MenuUI, std::vector<uint64_t>& FileValues)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracov�v�n�...\n"; K7::WINfunc::SET_TO_ASCII();
	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	Algorithm::Sorting::BucketSort(FileValues, (uint64_t)floor(FileValues.size() / 2));

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nDoba se�azov�n�: " << timeTaken.count() << L" milisekund!"; K7::WINfunc::SET_TO_ASCII();

	return;
}

}