package lekce111;

import java.io.FileInputStream;
import java.io.IOException;

public class Soubory
{
    static int ctiPrvniByte(String jmeno) throws IOException
    {
        FileInputStream fis = new FileInputStream(jmeno);
        return fis.read();
    };
    
    public static void main(String[] args)
    {
        try
        {
            ctiPrvniByte("soubor.txt");
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
            System.out.println("ahoj");
        }
    };
};
