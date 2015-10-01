/**
 * Stellt die Grundfunktionalitäten zur Bruchrechnung bereit
 * ist nicht vollständig fertiggestellt, sondern soll das grundsätzliche Vorgehen zeigen
 */
package bruchrechnung;

/**
 *
 * @author frank.baethge
 */
public class Bruch {
  private Long zähler;
  private Long nenner;

  /**
   * Konstruktor
   * wirft einen Fehler, falls der Nenner Null ist
   *
   * @param z - Zähler
   * @param n - Nenner
   */
  public Bruch(Long z, Long n) {
    zähler = z;
    if (n > 0) {
      nenner = n;
    } else if (n < 0) {
      nenner = -n;
      zähler *= -1;
    } else {
      // Fehlerausgabe falls nenner 0 ist
      throw new ArithmeticException("Der Nenner eines Bruchs darf nicht Null werden");
    }

    kürze();
  }

  private Long getGanze() {
    return zähler / nenner;
  }

  private Long getRest() {
    return zähler % nenner;
  }

  public double getDezimal() {
    return (double) zähler / nenner;
  }

  /**
   * kürzt den Bruch, falls das geht
   */
  private void kürze() {
    Long ggt = ggT();
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
  public Long ggT() {
    Long z = Math.abs(zähler);
    Long n = nenner;
    while (n != 0) {
     if (z > n) {
       z = z - n;
     } else {
       n = n - z;
     }
    }
    return z;
  }

  /* TODO: Überlauf im Zahlenbereich bemerken */
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
   * @return ganze Zahl für die Konsolenausgabe formatiert
   */
  @Override
  public String toString() {
    String s = "";
    Long gG = getGanze();
    Long gR = getRest();
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
