package info.baethge.lk1516.permutation;

import java.util.Arrays;

/**
 *
 * @author frank.baethge
 */
public class Permutation {

   static int anzahl = 0;
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    String[] namen = {"Tim","Arne","Jan","Alex","Steffen","Marek","Frank"};
    ;
    ausgeben(new String[]{},namen);
  }
  
  public static void ausgeben(String[] n, String[] r) {
    if (r.length == 1) {
      System.out.println("Anzahl:" + anzahl++);
      System.out.println(Arrays.toString(n) + Arrays.toString(r)); // Rekursionsende
    } else {
      for (int i = 0; i < r.length; i++) {
        // Liste der Namen in der richtigen Reihenfolge mitführen (jetzt um das nächste Element verlängern)
        String[] namen = new String[n.length + 1];
        System.arraycopy(n, 0, namen, 0, n.length);
        namen[n.length] = r[i];
        // restNamen enthält den jetzt ausgegebene Namen nicht mehr (ist damit auch kleiner als zuvor - die Menge der unsortierten Namen)
        String[] restNamen = new String[r.length - 1];
        int pos = 0;
        for (int j = 0; j < r.length; j++) {
          if (i != j) {
            restNamen[pos] = r[j];
            pos++;
          }
        }
        ausgeben(namen, restNamen);
      }
    }
  }
}
