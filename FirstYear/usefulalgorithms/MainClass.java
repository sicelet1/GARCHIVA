package usefulalgorithms;


/**
 * Hlavní třída {@code Java} implementace GA ročníkové práce. Slouží k spuštění programu & sestavuje UI "Kořenové menu".
 * <p> + Dědí vlastnosti třídy {@code usefulalgorithms.UItextStorage}.
 * <p> Jako jediná třída obsahuje spouštěcí metodu <blockquote> <pre> {@code public static void main(String[] args)} </pre> </blockquote> </p>
 * 
 * @author Jakub Wimmer 1.E GA
 */
public class MainClass extends usefulalgorithms.UItextStorage
{
	//-----------------------------------------------------------------------------------------------
	//konstrukce neměnitelných soukromých objektů jiných tříd pro tuto třídu [volají se konstruktory]
	//-----------------------------------------------------------------------------------------------
	private static final usefulalgorithms.MainUI UIbuilder = new MainUI(); //z třídy MainUI - pro sestavování textového UI
	private static final usefulalgorithms.UIfloor1 floor1 = new UIfloor1(); //z třídy UIfloor1 - další části/funcionality/rozcestníky UI
	//-----------------------------------------------------------------------------------------------
	
	private static String mUI = new String(); //měnitelný soukromý objekt třídy String pro uživatelské vstupy


	/**
	 * Spouštěcí metoda - odsud se volají metody objektů
	 * 
	 * @param args : {@code String[]} - nepoužívá se v tomto programu
	 * 
	 * @author Jakub Wimmer 1.E GA
	 */
	public static void main(String[] args)
	{
		//-------------------------------------------------------------------
		//sestavení UI kořenového menu + získání uživateského vstupu [String]
		//-------------------------------------------------------------------
		UIbuilder.clearConsole();
		UIbuilder.header(MainHeaderCZ, 20, false); 
		UIbuilder.header(RootHeaderCZ, 20, false);
		mUI = UIbuilder.tableMenuBuild(MenuRootTitle, MenuRootValues, MenuRootENDs);
		//-------------------------------------------------------------------

		//------------------------------------------------------------------------------
		//první UI rozcestník, podle uživalského vstupu se spustí další menu/jiná metoda
		//[používá se pouze první znak v řetězci uživatelského vstupu, více znaků nejde]
		//------------------------------------------------------------------------------
		while (true)
		{
			if (mUI.length() == 1) //pouze jeden znak ve vstupu
			{
				switch (mUI.charAt(0)) //rozcestník - první [jediný] znak vstupu
				{
				case '0':
					return; //ukončení celého programu

				case '1':
					floor1.UIrandomNumbers(); //volání metody třídy UIfloor1 [další část UI, možnost 1]
				
					//-------------------------------------------------------------------
					//sestavení UI kořenového menu + získání uživateského vstupu [String]
					//-------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RootHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuRootTitle, MenuRootValues, MenuRootENDs); continue;
					//-------------------------------------------------------------------

				case '2':
					floor1.UIprimeNumbers(); //volání metody třídy UIfloor1 [další část UI, možnost 2]

					//-------------------------------------------------------------------
					//sestavení UI kořenového menu + získání uživateského vstupu [String]
					//-------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RootHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuRootTitle, MenuRootValues, MenuRootENDs); continue;
					//-------------------------------------------------------------------

				case '3':
					floor1.UIstringSorting(); //volání metody třídy UIfloor1 [další část UI, možnost 3]

					//-------------------------------------------------------------------
					//sestavení UI kořenového menu + získání uživateského vstupu [String]
					//-------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RootHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuRootTitle, MenuRootValues, MenuRootENDs); continue;
					//-------------------------------------------------------------------

				case '4':
					floor1.UInumberSorting(); //volání metody třídy UIfloor1 [další část UI, možnost 4]

					//-------------------------------------------------------------------
					//sestavení UI kořenového menu + získání uživateského vstupu [String]
					//-------------------------------------------------------------------
					UIbuilder.clearConsole(); 
					UIbuilder.header(MainHeaderCZ, 20, false); 
					UIbuilder.header(RootHeaderCZ, 20, false);
					mUI = UIbuilder.tableMenuBuild(MenuRootTitle, MenuRootValues, MenuRootENDs); continue;
					//-------------------------------------------------------------------

				default:
					mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
				}
			}
			else { mUI = UIbuilder.smallMenuBuild(MenuWrong); continue; } //sestavení menu pro špatný vstup, když uživatelský vstup neodpovídá žádné z možností
		}
		//------------------------------------------------------------------------------
	}
}