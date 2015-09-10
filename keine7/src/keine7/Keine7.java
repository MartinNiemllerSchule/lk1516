/* Übung
Es sollen von 100 Zufallszahlen aus dem Bereich von 1 bis 1000 die nicht durch 7 teilbaren und keine Ziffer 7 enthaltenden Zahlen ausgegeben werden
 */
package keine7;

/**
 *
 * @author frank.baethge
 */
public class Keine7 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // 100 Zufalls-Zahlen abspeichern
    Integer zahl, anzahl = 0;
    for (Integer z = 1; z <= 100; z++) {
      zahl = (int)(Math.random()*1000);
      // gesuchte Zahlen ausgeben
      if (istKeine7(zahl)) {
        System.out.format("%4d", zahl);
        anzahl++;
      }
    }
     System.out.println("\nAnzahl: "+anzahl);
  }
  private static boolean istKeine7(Integer zahl) {
    boolean nichtTeilbar;
    boolean hatZiffer;
    nichtTeilbar = (0 != zahl % 7);
    hatZiffer = zahl.toString().contains("7");
    return nichtTeilbar && !hatZiffer;
  }
  
}