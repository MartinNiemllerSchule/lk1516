/**
 * Stellt die Grundfunktionalitäten zur Bruchrechnung bereit
 * ist nicht vollständig fertiggestellt, sondern soll das grundsätzliche Vorgehen zeigen
 */
package bruchrechnung;

import java.lang.ArithmeticException;

/**
 *
 * @author frank.baethge
 */
public class Bruch {
  private Integer zähler;
  private Integer nenner;
  private Integer getGanze() {
    return zähler / nenner;
  }
  private Integer getRest() {
    return zähler % nenner;
  }

  /**
   * Konstruktor
   * wirft einen Fehler, falls der Nenner Null ist
   * @param z - Zähler
   * @param n - Nenner
   */
  public Bruch (Integer z, Integer n) {
    zähler = z;
    if (n > 0) {
      nenner = n;
    } else if (n < 0) {
      nenner = -n;
      zähler *= -1;
    } else {
      // Fehlerausgabe falls nenner 0 ist
      throw ArithmeticException("Der Nenner eines Bruchs darf nicht Null werden");
    }
    
    kürze();
  }

  /**
   * kürzt den Bruch, falls das geht
   */
  private void kürze() {
    Integer ggt = ggT();
    if (ggt != 1) {
      zähler /= ggt;
      nenner /= ggt;
    } // else // ist schon gekürzt
  }
  /**
   * wird für das Kürzen von Brüchen benötigt
   * nach dem Euklidischen Algorithmus
   * @return größter gemeinsamer Teiler von Zähler und Nenner
   */
  public Integer ggT() {
    Integer z = Math.abs(zähler);
    Integer n = nenner;
    while (n != 0) {
     if (z > n) {
       z = z - n;
     } else {
       n = n - z;
     }
   }
   return z;
  }

  /**
   * addiert Bruch b zu diesem Bruch, ohne einen von beiden zu ändern
   * @param b - ein Summand
   * @return - neu angelegter Bruch
   */
  public Bruch addiere(Bruch b) {
    return new Bruch(
      zähler*b.nenner+nenner*b.zähler,
      nenner*b.nenner
    );
  }

  /**
   * subtrahiert von diesem (Minuend) den Bruch b (Subtrahent), Differenz ist ein neuer Bruch
   * @param b - Subtrahend
   * @return - Differenz als neuer Bruch
   */
  public Bruch subtrahiere(Bruch b) {
    return new Bruch(
      zähler*b.nenner-nenner*b.zähler,
      nenner*b.nenner
    );
  }

  /**
   * Ausgabe als gemeiner Bruch auf der Konsole
   *  Besonderheiten:
   *   - Null
   *   - Vorzeichenbehaftete Brüche
   *   - ganze Zahlen mit und ohne Vorzeichen
   * @return
   */
  @Override
  public String toString() {
    String s = "";
    Integer gG = getGanze();
    Integer gR = getRest();
    if (gG != 0) {
      s += gG.toString() + " ";
    }
    if (gR != 0) {
      if (gG < 0) {
        gR *= -1;
      }
      s += gR.toString() + "/" + nenner.toString();
    } else {
      if (gG == 0) {
        s += "0";
      }
    }
    return s;
  }
}
