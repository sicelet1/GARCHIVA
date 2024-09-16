
//Zdrojový soubor obsahující spouštìèe & mìøièe èíselných algoritmù.

#include "init.hpp" //hlavièka se všemi knihovnami, makry + deklaracemi
#include "K7lib.UI.hpp" //moje 'mini' knihovna s funkcemi pro vytváøení & skládání textového UI
#include "K7lib.file.hpp" //moje 'mini' knihovna s funkcemi pro práci se soubory

namespace Floor_2_3
{

//provádí algoritmus & funcionalitu okolo pro možnost 1 v 'UIfloor_main.cpp' v možnosti 2 z 'main.cpp'
void Option_2_1(std::wstring& MenuUI)
{
	UItexts S; std::wstring NumberCount, MinValue, MaxValue; std::wstring InBuf, InBufSave; std::wstring FileToExport;
	
	while (InBuf != L"\\e" || NumberCount.length() == NULL)
	{
		if (InBuf == L"\\c") { NumberCount.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { NumberCount = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20);
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UImenu::MenuBuild(S.TitleRandomNumberCount, &InBuf, S.RandomNumbersManuals[0], S.AlgorithmsExtraManual);
	}

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || MinValue.length() == NULL)
	{
		if (InBuf == L"\\c") { MinValue.clear(); InBufSave.clear(); InBuf.clear(); }
		
		if (valid::OnlyNumber(InBuf, 9) == true) { MinValue = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UIfunc::Header(S.TitleRandomNumberCount, S.TitleRandomNumberCount.length() + NumberCount.length(), &NumberCount);
		K7::UImenu::MenuBuild(S.TitleRandomNumberMIN, &InBuf, S.RandomNumbersManuals[1], S.AlgorithmsExtraManual);
	}

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || MaxValue.length() == NULL)
	{
		if (InBuf == L"\\c") { MaxValue.clear(); InBufSave.clear();  InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { MaxValue = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UIfunc::Header(S.TitleRandomNumberCount, S.TitleRandomNumberCount.length() + NumberCount.length(), &NumberCount);
		K7::UIfunc::Header(S.TitleRandomNumberMIN, S.TitleRandomNumberMIN.length() + MinValue.length(), &MinValue);
		K7::UImenu::MenuBuild(S.TitleRandomNumberMAX, &InBuf, S.RandomNumbersManuals[2], S.AlgorithmsExtraManual);
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
	K7::UIfunc::Header(S.TitleRandomNumberCount, S.TitleRandomNumberCount.length() + NumberCount.length(), &NumberCount);
	K7::UIfunc::Header(S.TitleRandomNumberMIN, S.TitleRandomNumberMIN.length() + MinValue.length(), &MinValue);
	K7::UIfunc::Header(S.TitleRandomNumberMAX, S.TitleRandomNumberMAX.length() + MaxValue.length(), &MaxValue);
	MenuUI = K7::UImenu::MenuBuild(S.NumberAlgorithmsSTARTmenu);

	while (true)
	{
		if (MenuUI == L"0") return;
		elif(MenuUI == L"1") break;
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracovávání...\n"; K7::WINfunc::SET_TO_ASCII();

	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	std::vector<uint64_t> Result = Algorithm::RandomSequence::RandomNumberSequence(std::stoull(NumberCount), std::stoull(MinValue), std::stoull(MaxValue));

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || FileToExport.length() == NULL)
	{
		if (InBuf == L"\\c") { FileToExport.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::ValidFilename(InBuf) == true) { FileToExport = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE();
		K7::UIfunc::Header(S.MainHeaderCZ, 20);
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nHotovo!\n\nDoba generování: " << timeTaken.count() << L" milisekund!\n\n"; K7::WINfunc::SET_TO_ASCII();

		K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.NumberFileManual, S.AlgorithmsExtraManual);
	}

	K7::Fout::New<std::wstring>(FileToExport); K7::Fout::Write<std::wstring, uint64_t>(FileToExport, Result);
	
	return;
}

//provádí algoritmus & funcionalitu okolo pro možnost 2 v 'UIfloor_main.cpp' v možnosti 2 z 'main.cpp'
void Option_2_2(std::wstring& MenuUI)
{
	UItexts S; std::wstring PasswordCount, PasswordLength; std::wstring InBuf, InBufSave; std::wstring FileToExport;
	
	while (InBuf != L"\\e" || PasswordCount.length() == NULL)
	{
		if (InBuf == L"\\c") { PasswordCount.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { PasswordCount = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UImenu::MenuBuild(S.TitleRandomPasswordCount, &InBuf, S.RandomPasswordsManuals[0], S.AlgorithmsExtraManual);
	}

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || PasswordLength.length() == NULL)
	{
		if (InBuf == L"\\c") { PasswordLength.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { PasswordLength = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UIfunc::Header(S.TitleRandomPasswordCount, S.TitleRandomPasswordCount.length() + PasswordCount.length(), &PasswordCount);
		K7::UImenu::MenuBuild(S.TitleRandomPasswordLength, &InBuf, S.RandomPasswordsManuals[1], S.AlgorithmsExtraManual);
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
	K7::UIfunc::Header(S.TitleRandomPasswordCount, S.TitleRandomPasswordCount.length() + PasswordCount.length(), &PasswordCount);
	K7::UIfunc::Header(S.TitleRandomPasswordLength, S.TitleRandomPasswordLength.length() + PasswordLength.length(), &PasswordLength);
	MenuUI = K7::UImenu::MenuBuild(S.NumberAlgorithmsSTARTmenu);

	while (true)
	{
		if (MenuUI == L"0") return;
		elif(MenuUI == L"1") break;
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracovávání...\n"; K7::WINfunc::SET_TO_ASCII();

	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	std::vector<std::string> Result = Algorithm::RandomSequence::RandomPasswordSequence(std::stoull(PasswordCount), std::stoull(PasswordLength));

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || FileToExport.length() == NULL)
	{
		if (InBuf == L"\\c") { FileToExport.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::ValidFilename(InBuf) == true) { FileToExport = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE();
		K7::UIfunc::Header(S.MainHeaderCZ, 20);
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nHotovo!\n\nDoba generování: " << timeTaken.count() << L" milisekund!\n\n"; K7::WINfunc::SET_TO_ASCII();

		K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.NumberFileManual, S.AlgorithmsExtraManual);
	}

	K7::Fout::New<std::wstring>(FileToExport); K7::Fout::Write<std::wstring, std::vector<std::string>>(FileToExport, Result);

	return;
}

//provádí algoritmus & funcionalitu okolo pro možnost 1 v 'UIfloor_main.cpp' v možnosti 3 z 'main.cpp'
void Option_3_1(std::wstring& MenuUI)
{
	UItexts S; std::wstring PrimeNumMIN, PrimeNumMAX; std::wstring InBuf, InBufSave; std::wstring FileToExport;

	while (InBuf != L"\\e" || PrimeNumMIN.length() == NULL)
	{
		if (InBuf == L"\\c") { PrimeNumMIN.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { PrimeNumMIN = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UImenu::MenuBuild(S.TitlePrimeNumbersMIN, &InBuf, S.PrimeNumbersManuals[0], S.AlgorithmsExtraManual);
	}

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || PrimeNumMAX.length() == NULL)
	{
		if (InBuf == L"\\c") { PrimeNumMAX.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { PrimeNumMAX = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UIfunc::Header(S.TitlePrimeNumbersMIN, S.TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), &PrimeNumMIN);
		K7::UImenu::MenuBuild(S.TitlePrimeNumbersMAX, &InBuf, S.PrimeNumbersManuals[1], S.AlgorithmsExtraManual);
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
	K7::UIfunc::Header(S.TitlePrimeNumbersMIN, S.TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), &PrimeNumMIN);
	K7::UIfunc::Header(S.TitlePrimeNumbersMAX, S.TitlePrimeNumbersMAX.length() + PrimeNumMAX.length(), &PrimeNumMAX);
	MenuUI = K7::UImenu::MenuBuild(S.NumberAlgorithmsSTARTmenu);

	while (true)
	{
		if (MenuUI == L"0") return;
		elif(MenuUI == L"1") break;
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracovávání...\n"; K7::WINfunc::SET_TO_ASCII();

	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	std::vector<uint64_t> Result = Algorithm::PrimeNumbers::PrimeNumberGenerator(std::stoll(PrimeNumMIN), std::stoll(PrimeNumMAX));

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || FileToExport.length() == NULL)
	{
		if (InBuf == L"\\c") { FileToExport.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::ValidFilename(InBuf) == true) { FileToExport = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE();
		K7::UIfunc::Header(S.MainHeaderCZ, 20);
		K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
		K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nHotovo!\n\nDoba generování: " << timeTaken.count() << L" milisekund!\n\n"; K7::WINfunc::SET_TO_ASCII();

		K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.NumberFileManual, S.AlgorithmsExtraManual);
	}

	K7::Fout::New<std::wstring>(FileToExport); K7::Fout::Write<std::wstring, uint64_t>(FileToExport, Result);

	return;
}

//provádí algoritmus & funcionalitu okolo pro možnost 2 v 'UIfloor_main.cpp' v možnosti 3 z 'main.cpp'
void Option_3_2(std::wstring& MenuUI)
{
	UItexts S; std::wstring PrimeNumMIN, PrimeNumMAX; std::wstring InBuf, InBufSave; std::wstring FileToExport;

	while (InBuf != L"\\e" || PrimeNumMIN.length() == NULL)
	{
		if (InBuf == L"\\c") { PrimeNumMIN.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { PrimeNumMIN = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UImenu::MenuBuild(S.TitlePrimeNumbersMIN, &InBuf, S.PrimeNumbersManuals[0], S.AlgorithmsExtraManual);
	}

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || PrimeNumMAX.length() == NULL)
	{
		if (InBuf == L"\\c") { PrimeNumMAX.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { PrimeNumMAX = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE(); 
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UIfunc::Header(S.TitlePrimeNumbersMIN, S.TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), &PrimeNumMIN);
		K7::UImenu::MenuBuild(S.TitlePrimeNumbersMAX, &InBuf, S.PrimeNumbersManuals[1], S.AlgorithmsExtraManual);
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
	K7::UIfunc::Header(S.TitlePrimeNumbersMIN, S.TitlePrimeNumbersMIN.length() + PrimeNumMIN.length(), &PrimeNumMIN);
	K7::UIfunc::Header(S.TitlePrimeNumbersMAX, S.TitlePrimeNumbersMAX.length() + PrimeNumMAX.length(), &PrimeNumMAX);
	MenuUI = K7::UImenu::MenuBuild(S.NumberAlgorithmsSTARTmenu);

	while (true)
	{
		if (MenuUI == L"0") return;
		elif(MenuUI == L"1") break;
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
	K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nZpracovávání...\n"; K7::WINfunc::SET_TO_ASCII();

	std::chrono::system_clock::time_point sysTime0 = std::chrono::system_clock::now();

	std::vector<uint64_t> Result = Algorithm::PrimeNumbers::OptimizedPrimeNumberGenerator(std::stoll(PrimeNumMIN), std::stoll(PrimeNumMAX));

	std::chrono::system_clock::time_point sysTime1 = std::chrono::system_clock::now();
	std::chrono::milliseconds timeTaken = std::chrono::duration_cast<std::chrono::milliseconds>(sysTime1 - sysTime0);

	InBuf.clear(); InBufSave.clear();

	while (InBuf != L"\\e" || FileToExport.length() == NULL)
	{
		if (InBuf == L"\\c") { FileToExport.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::ValidFilename(InBuf) == true) { FileToExport = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE();
		K7::UIfunc::Header(S.MainHeaderCZ, 20);
		K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
		K7::WINfunc::SET_TO_UTF16(); std::wcout << L"\nHotovo!\n\nDoba generování: " << timeTaken.count() << L" milisekund!\n\n"; K7::WINfunc::SET_TO_ASCII();

		K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.NumberFileManual, S.AlgorithmsExtraManual);
	}

	K7::Fout::New<std::wstring>(FileToExport); K7::Fout::Write<std::wstring, uint64_t>(FileToExport, Result);

	return;
}


}