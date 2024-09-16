/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce107;

/**
 *
 * @author jakub.wimmer.s
 */
public class Dama {
    private int[][] sachovnice = new int [8][8];

/*
       0 1 2 3 4 5 6 7
      0
      1
      2
      3
      4
      5
      6
      7
*/

    public Dama() {
        for (int i = 0; i < 8; i+=2) {
        sachovnice[7][0 + i] = 1;
        sachovnice[6][1 + i] = 1;
        sachovnice[1][0 + i] = -1;
        sachovnice[0][1 + i] = -1;
        }
    }
}
