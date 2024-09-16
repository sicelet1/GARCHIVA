
//Hlavn� zdrojov� soubor C++ implementace GA ro�n�kov� pr�ce. Slou�� k spu�t�n� programu & sestavuje UI "Ko�enov� menu".

#include "init.hpp" //hlavi�ka se v�emi knihovnami, makry + deklaracemi
#include "K7lib.UI.hpp" //moje 'mini' knihovna s funkcemi pro vytv��en� & skl�d�n� textov�ho UI

//odsud se spou�t� program
int main(void)
{
	UItexts S; std::wstring mUI;

	K7::WINfunc::TITLE_CONSOLE("Useful Algorithms");
	K7::WINfunc::CLEAR_CONSOLE();
	K7::UIfunc::Header(S.MainHeaderCZ, 20); 
	K7::UIfunc::Header(S.RootHeaderCZ, 20);
	mUI = K7::UImenu::MenuBuild(S.MenuRootTitle, S.MenuRootValues, S.MenuRootENDs);
	
	while (true)
	{
		if (mUI == L"0") std::exit(0);
		elif(mUI == L"1")
		{
			FloorMain::Option1(mUI);
	
			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20); 
			K7::UIfunc::Header(S.RootHeaderCZ, 20);
			mUI = K7::UImenu::MenuBuild(S.MenuRootTitle, S.MenuRootValues, S.MenuRootENDs); continue;
		}
		elif(mUI == L"2")
		{
			FloorMain::Option2(mUI);

			K7::WINfunc::CLEAR_CONSOLE(); 
			K7::UIfunc::Header(S.MainHeaderCZ, 20); 
			K7::UIfunc::Header(S.RootHeaderCZ, 20);
			mUI = K7::UImenu::MenuBuild(S.MenuRootTitle, S.MenuRootValues, S.MenuRootENDs); continue;
		}
		elif(mUI == L"3")
		{
			FloorMain::Option3(mUI);

			K7::WINfunc::CLEAR_CONSOLE(); 
			K7::UIfunc::Header(S.MainHeaderCZ, 20); 
			K7::UIfunc::Header(S.RootHeaderCZ, 20);
			mUI = K7::UImenu::MenuBuild(S.MenuRootTitle, S.MenuRootValues, S.MenuRootENDs); continue;
		}
		elif(mUI == L"4")
		{
			FloorMain::Option4(mUI);

			K7::WINfunc::CLEAR_CONSOLE(); 
			K7::UIfunc::Header(S.MainHeaderCZ, 20); 
			K7::UIfunc::Header(S.RootHeaderCZ, 20);
			mUI = K7::UImenu::MenuBuild(S.MenuRootTitle, S.MenuRootValues, S.MenuRootENDs); continue;
		}
		elif(mUI == L"5")
		{
			FloorMain::Option5(mUI);

			K7::WINfunc::CLEAR_CONSOLE();
			K7::UIfunc::Header(S.MainHeaderCZ, 20);
			K7::UIfunc::Header(S.RootHeaderCZ, 20);
			mUI = K7::UImenu::MenuBuild(S.MenuRootTitle, S.MenuRootValues, S.MenuRootENDs); continue;
		}
		//elif(mUI == L"seqfault") {} - easter egg [coming soon]
		else { mUI = K7::UImenu::MenuBuild(S.MenuWrong); continue; }
	}

	return NULL;
}