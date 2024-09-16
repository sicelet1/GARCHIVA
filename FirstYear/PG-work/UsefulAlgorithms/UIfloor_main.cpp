
//Zdrojový soubor obsahující UI rozcestníky pro možnosti v hlavním menu.

#include "init.hpp" //hlavièka se všemi knihovnami, makry + deklaracemi
#include "K7lib.UI.hpp" //moje 'mini' knihovna s funkcemi pro vytváøení & skládání textového UI
#include "K7lib.file.hpp" //moje 'mini' knihovna s funkcemi pro práci se soubory
#include "K7lib.random.hpp" //moje 'mini' knihovna s funkcemi pro generování náhodných hodnot

namespace FloorMain
{
	
//rozšiøující rozcestník pro možnost 1 v 'main.cpp'
void Option1(std::wstring& MenuUI)
{
	UItexts S;
	 
	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.SettingsHeaderCZ, 20);
	MenuUI = K7::UImenu::MenuBuild(S.MenuSettingsTitle, S.MenuSettingsValues, S.MenuMainENDs);

	while (true)
	{
		if (MenuUI == L"0") break;
		//elif() {} - coming soon
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	return;
}

//rozšiøující rozcestník pro možnost 2 v 'main.cpp'
void Option2(std::wstring& MenuUI)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE(); 
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
	MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuRandomNumbersValues, S.MenuMainENDs);

	while (true)
	{
		if (MenuUI == L"0") break;
		elif(MenuUI == L"1")
		{
			Floor_2_3::Option_2_1(MenuUI);

			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20);
			K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
			MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuRandomNumbersValues, S.MenuMainENDs); continue;
		}
		elif(MenuUI == L"2")
		{
			Floor_2_3::Option_2_2(MenuUI);

			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20);
			K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
			MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuRandomNumbersValues, S.MenuMainENDs); continue;
		}
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); }
	}

	return;
}

//rozšiøující rozcestník pro možnost 3 v 'main.cpp'
void Option3(std::wstring& MenuUI)
{
	UItexts S;

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
	MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuPrimeNumbersValues, S.MenuMainENDs);

	while (true)
	{
		if (MenuUI == L"0") break;
		elif(MenuUI == L"1")
		{
			Floor_2_3::Option_3_1(MenuUI);

			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20);
			K7::UIfunc::Header(S.RandomNumbersHeaderCZ, 20);
			MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuPrimeNumbersValues, S.MenuMainENDs); continue;
		}
		elif(MenuUI == L"2")
		{
			Floor_2_3::Option_3_2(MenuUI);

			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20);
			K7::UIfunc::Header(S.PrimeNumbersHeaderCZ, 20);
			MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuPrimeNumbersValues, S.MenuMainENDs); continue;
		}
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); }
	}

	return;
}

//Získání názvù vstupního & výstupního souboru pro možnost 4 v 'main.cpp'
void Option4(std::wstring& MenuUI)
{
	UItexts S;

	std::wstring FileToSort; std::wstring InBuf, InBufSave;

	while (InBuf != L"\\e" || FileToSort.length() == NULL)
	{
		if (InBuf == L"\\c") { FileToSort.clear(); InBuf.clear(); }

		if (valid::ValidFilename(InBuf) == true) { FileToSort = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE();
		K7::UIfunc::Header(S.MainHeaderCZ, 20); 
		K7::UIfunc::Header(S.SortingHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.SortingFileManual, S.AlgorithmsExtraManual);
	}

	std::vector<std::string> FileValues = K7::Fin::Read<std::wstring, std::vector<std::string>>(FileToSort);

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
	K7::UIfunc::Header(S.TitleAlgorithmFile, S.TitleAlgorithmFile.length() + FileToSort.length(), &FileToSort);
	MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuSortingValues, S.MenuMainENDs);

	while (true)
	{
		if (MenuUI == L"0") return;
		elif(MenuUI == L"1")
		{
			Floor_4_5::Option_4_1(MenuUI, FileValues); break;
		}
		elif(MenuUI == L"2")
		{
			Floor_4_5::Option_4_2(MenuUI, FileValues); break;
		}
		elif(MenuUI == L"3")
		{
			Floor_4_5::Option_4_3(MenuUI, FileValues); break;
		}
		elif(MenuUI == L"4")
		{
			Floor_4_5::Option_4_4(MenuUI, FileValues); break;
		}
		elif(MenuUI == L"5")
		{
			Floor_4_5::Option_4_5(MenuUI, FileValues); break;
		}
		elif(MenuUI == L"6")
		{
			Floor_4_5::Option_4_6(MenuUI, FileValues); break;
		}
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); }
	}

	MenuUI = K7::UImenu::MenuBuild(S.SortingFileENDmenu);

	while (true)
	{
		if (MenuUI == L"0") break;
		elif(MenuUI == L"1")
		{
			std::wstring FileToExport; std::wstring InBuf, InBufSave;

			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20); 
			K7::UIfunc::Header(S.SortingHeaderCZ, 20);

			while (InBuf != L"\\e" || FileToExport.length() == NULL)
			{
				if (InBuf == L"\\c") { FileToExport.clear(); InBuf.clear(); }

				if (valid::ValidFilename(InBuf) == true) { FileToExport = InBuf; InBufSave = InBuf; }
				else { InBuf = InBufSave; }

				K7::WINfunc::CLEAR_CONSOLE(); 
				K7::UIfunc::Header(S.MainHeaderCZ, 20); 
				K7::UIfunc::Header(S.SortingHeaderCZ, 20);
				K7::UIfunc::Header(S.AlgorithmOutHeaderCZ, 20);
				K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.SortingFileManual, S.AlgorithmsExtraManual);
			}

			K7::Fout::New<std::wstring>(FileToExport); K7::Fout::Write<std::wstring, std::vector<std::string>>(FileToExport, FileValues); break;
		}
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	return;
}

//Získání hodnot pro náhodný generátor èísel & názvu výstupního souboru pro možnost 5 v 'main.cpp'
void Option5(std::wstring& MenuUI)
{
	UItexts S; std::wstring NumberCount, MinValue, MaxValue; std::wstring InBuf, InBufSave;

	while (InBuf != L"\\e" || NumberCount.length() == NULL)
	{
		if (InBuf == L"\\c") { NumberCount.clear(); InBufSave.clear(); InBuf.clear(); }

		if (valid::OnlyNumber(InBuf, 9) == true) { NumberCount = InBuf; InBufSave = InBuf; }
		else { InBuf = InBufSave; }

		K7::WINfunc::CLEAR_CONSOLE();
		K7::UIfunc::Header(S.MainHeaderCZ, 20);
		K7::UIfunc::Header(S.SortingHeaderCZ, 20);
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
		K7::UIfunc::Header(S.SortingHeaderCZ, 20);
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
		K7::UIfunc::Header(S.SortingHeaderCZ, 20);
		K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
		K7::UIfunc::Header(S.TitleRandomNumberCount, S.TitleRandomNumberCount.length() + NumberCount.length(), &NumberCount);
		K7::UIfunc::Header(S.TitleRandomNumberMIN, S.TitleRandomNumberMIN.length() + MinValue.length(), &MinValue);
		K7::UImenu::MenuBuild(S.TitleRandomNumberMAX, &InBuf, S.RandomNumbersManuals[2], S.AlgorithmsExtraManual);
	}

	std::vector<uint64_t> RandomNumbers(0);

	for (uint64_t c = NULL; c < std::stoull(NumberCount) && MinValue < MaxValue; c++)
		RandomNumbers.push_back(K7::Generator::RandomValue<uint64_t>(std::stoull(MinValue), std::stoull(MaxValue)));

	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20);
	K7::UIfunc::Header(S.SortingHeaderCZ, 20);
	K7::UIfunc::Header(S.AlgorithmInHeaderCZ, 20);
	K7::UIfunc::Header(S.TitleRandomNumberCount, S.TitleRandomNumberCount.length() + NumberCount.length(), &NumberCount);
	K7::UIfunc::Header(S.TitleRandomNumberMIN, S.TitleRandomNumberMIN.length() + MinValue.length(), &MinValue);
	K7::UIfunc::Header(S.TitleRandomNumberMAX, S.TitleRandomNumberMAX.length() + MaxValue.length(), &MaxValue);
	MenuUI = K7::UImenu::MenuBuild(S.MenuAlgorithmsTitle, S.MenuSortingValues, S.MenuMainENDs);

	while (true)
	{
		if (MenuUI == L"0") return;
		elif(MenuUI == L"1")
		{
			Floor_4_5::Option_5_1(MenuUI, RandomNumbers); break;
		}
		elif(MenuUI == L"2")
		{
			Floor_4_5::Option_5_2(MenuUI, RandomNumbers); break;
		}
		elif(MenuUI == L"3")
		{
			Floor_4_5::Option_5_3(MenuUI, RandomNumbers); break;
		}
		elif(MenuUI == L"4")
		{
			Floor_4_5::Option_5_4(MenuUI, RandomNumbers); break;
		}
		elif(MenuUI == L"5")
		{
			Floor_4_5::Option_5_5(MenuUI, RandomNumbers); break;
		}
		elif(MenuUI == L"6")
		{
			Floor_4_5::Option_5_6(MenuUI, RandomNumbers); break;
		}
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); }
	}

	MenuUI = K7::UImenu::MenuBuild(S.SortingFileENDmenu);

	while (true)
	{
		if (MenuUI == L"0") break;
		elif(MenuUI == L"1")
		{
			std::wstring FileToExport; std::wstring InBuf, InBufSave;

			K7::WINfunc::CLEAR_CONSOLE(); 
			K7::UIfunc::Header(S.MainHeaderCZ, 20);
			K7::UIfunc::Header(S.SortingHeaderCZ, 20);

			while (InBuf != L"\\e" || FileToExport.length() == NULL)
			{
				if (InBuf == L"\\c") { FileToExport.clear(); InBuf.clear(); }

				if (valid::ValidFilename(InBuf) == true) { FileToExport = InBuf; InBufSave = InBuf; }
				else { InBuf = InBufSave; }

				K7::WINfunc::CLEAR_CONSOLE();
				K7::UIfunc::Header(S.MainHeaderCZ, 20);
				K7::UIfunc::Header(S.SortingHeaderCZ, 20);
				K7::UIfunc::Header(S.AlgorithmOutHeaderCZ, 20);
				K7::UImenu::MenuBuild(S.TitleAlgorithmFile, &InBuf, S.SortingFileManual, S.AlgorithmsExtraManual);
			}

			K7::Fout::New<std::wstring>(FileToExport); K7::Fout::Write<std::wstring, uint64_t>(FileToExport, RandomNumbers); break;
		}
		else { MenuUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	return;
}

}