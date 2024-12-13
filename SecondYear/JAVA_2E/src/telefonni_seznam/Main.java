package telefonni_seznam;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void zapis() throws IOException {

        ArrayList<TelCislo> arr = new ArrayList<>();
        arr.add(new TelCislo("Jan", "+420604958263"));
        arr.add(new TelCislo("Pepa", "+420135354686"));
        arr.add(new TelCislo("Eliska", "+420561819678"));

        FileOutputStream f = new FileOutputStream("soubor.dat");
        ObjectOutputStream out = new ObjectOutputStream(f);

        out.writeObject(arr);
        out.close(); //f.close();
    }

    public static void cti() throws IOException, ClassNotFoundException {

        FileInputStream f = new FileInputStream("soubor.dat");
        ObjectInputStream in = new ObjectInputStream(f);

        ArrayList<TelCislo> arr = (ArrayList<TelCislo>)in.readObject();

        System.out.println(arr);

        in.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        zapis();
        cti();
    }
}
