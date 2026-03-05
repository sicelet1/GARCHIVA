package grafy;

import java.util.ArrayList;

public class Vrchol {

    int id;
    boolean bylJsemTu = false;

    static int noveId = 0;

    public Vrchol() {

        this.id = noveId;
        noveId++;
    }

    public static void main(String[] args) {

        ArrayList<Vrchol> vrcholy =  new ArrayList<>();

        for (int c = 0; c < 10; c++)
            vrcholy.add(new Vrchol());

        for (Vrchol vrchol : vrcholy)
            System.out.println(vrchol.id);
    }
}
