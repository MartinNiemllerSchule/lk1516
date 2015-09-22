/**
 * Stellt die Grundfunktionalitäten zur Bruchrechnung bereit
 */
package bruchrechnung;

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
  public Bruch (Integer z, Integer n) {
    zähler = z;
    if (n > 0) {
      nenner = n;
    } else if (n < 0) {
      nenner = -n;
      zähler *= -1;
    } else {
      // TODO: Fehlerausgabe falls nenner 0 ist
    }
    
    kürze();
  }
  private void kürze() {
    Integer ggt = ggT();
    zähler /= ggt;
    nenner /= ggt;
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
  public Bruch addiere(Bruch b) {
    return new Bruch(
      zähler*b.nenner+nenner*b.zähler,
      nenner*b.nenner
    );
  }
  public Bruch subtrahiere(Bruch b) {
    return new Bruch(
      zähler*b.nenner-nenner*b.zähler,
      nenner*b.nenner
    );
  }
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
