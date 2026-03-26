package pole;

public class DvojrozmernePole {

    public static String[][] prevedPoleDoStringu(int[][] polePoli) {

        String[][] stringy = new String[polePoli.length][polePoli[0].length];

        for (int c = 0; c < polePoli.length; c++)
            for (int cc = 0; cc < polePoli[c].length; cc++)
                stringy[c][cc] = String.valueOf(polePoli[c][cc]);

        return stringy;
    }

    public static String pridejMezery(int pocetMezer) {

        String vysledek = "";

        for (int c = 0; c < pocetMezer; c++)
            vysledek = vysledek.concat(" ");

        return vysledek;
    }

    public static void vypisPole(String[][] polePoli) {

        if (polePoli.length == 0)
            return;
        
        if (polePoli[0].length == 0)
            return;

        int[] velikostNejvetsiho = new int[polePoli[0].length];

        for (int c = 0; c < polePoli[0].length; c++)
            for (int cc = 0; c < polePoli.length; c++)
                if (polePoli[cc][c].length() > velikostNejvetsiho[c])
                    velikostNejvetsiho[c] = polePoli[cc][c].length();

        System.out.print("\nPole cisel:\n");

        for (int c = 0; c < polePoli.length; c++) {
            for (int cc = 0; cc < polePoli[0].length; cc++)
                System.out.print(pridejMezery(velikostNejvetsiho[cc] - polePoli[c][cc].length()) + polePoli[c][cc] + " ");

            System.out.print("\n");
        }
    }

    public static int[][] vyrovnejSoucet(int[][] polePoli) {

        int nejvetsiSoucet = 0;
        int[] souctyRadku = new int[polePoli.length];

        for (int c = 0; c < polePoli.length; c++) {

            for (int prvek : polePoli[c])
                souctyRadku[c] += prvek;

            if (souctyRadku[c] > nejvetsiSoucet)
                nejvetsiSoucet = souctyRadku[c];
        }

        for (int c = 0; c < polePoli.length; c++)
            polePoli[c][polePoli[c].length - 1] = nejvetsiSoucet - souctyRadku[c];

        return polePoli;
    }

    public static void main(String[] args) {

        int[][] polePoli = {
                { 1, 5,  7, 0},
                {11, 5,  3, 0},
                { 1, 2, 13, 0}
        };

        vypisPole(prevedPoleDoStringu(polePoli));
        polePoli = vyrovnejSoucet(polePoli);
        vypisPole(prevedPoleDoStringu(polePoli));
    }
}
