/**
 * Testet die Klasse Bruch
 */
package bruchrechnung;

/**
 *
 * @author frank.baethge
 */
public class Bruchrechnung {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // Zahlen festlegen
    Bruch zahl1 = new Bruch(new Long("15"), new Long("45"));
    Bruch zahl2 = new Bruch(new Long("154"), new Long("21"));
    // Ausgabe und Kürzen testen
    System.out.println("Zahl1: " + zahl1);
    System.out.println("Zahl2: " + zahl2);
    // Addieren und Subtrahieren testen
    System.out.println("Summe: " + zahl1.addiere(zahl2));
    System.out.println("Differenz: " + zahl1.subtrahiere(zahl2));

    Reihe reihe = new Reihe();
    System.out.println("Summe der Reihe: " + reihe.getSumme(3));

  }
}