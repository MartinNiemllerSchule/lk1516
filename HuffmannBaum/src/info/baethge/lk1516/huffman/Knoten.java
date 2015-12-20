/*
 * Astklasse
 *  nur in den Blättern des Baumes stehen unsere Informationen
 *  die Äste führen zu den Blättern
 */
package info.baethge.lk1516.huffman;

/**
 *
 * @author frank.baethge
 */
public class Knoten implements Comparable<Knoten> {
  protected Knoten rechts;
  protected Knoten links;
  protected Integer häufigkeit;
  
  public Knoten() {
    rechts = null;
    links = null;
    häufigkeit = 0;
  }

  public Knoten(Knoten l, Knoten r) {
    rechts = r;
    links = l;
    häufigkeit = 0;
    if (r != null) {
      häufigkeit += r.häufigkeit;
    }
    if (l != null) {
      häufigkeit += l.häufigkeit;
    }
  }  
    
  /**
   * Traversierung des Baums
   *  es gibt mehrere Möglichkeiten einen Baum zu durchlaufen
   *    - pre-order => W-L-R
   *    - post-order => L-R-W
   *    - in-order => L-W-R (reverse in-order => R-W-L)
   *    - level-order => Breitensuche (jede Ebene nacheinander)
   *  hier wird am ehesten pre-order verwendet (Wuzel-Links-Rechts)
   * @param kodierung
   * @return 
   */
  public String ausgeben(String kodierung) {
    return "Häufigkeit: " + häufigkeit + " l: (" + links.ausgeben(kodierung + '0') + ")" + 
           "r: (" + rechts.ausgeben(kodierung+'1') + ")";
  }
  /**
   * Berechnet die Summe für alle Blätter über das Produkt aus ebene * häufigkeit und 
   *  damit auch die Länge des komprimierten Textes
   * @param ebene - die Ebene kodiert gleichzeitig die neue Länge des jeweiligen Buchstabens 
   * @return 
   */
  public Integer berechneBitlänge(int ebene) {
    // Abstieg zu den Blättern und Rückgabe der berechneten Werte
    return links.berechneBitlänge(ebene + 1) + rechts.berechneBitlänge(ebene + 1);
  }

  protected String getGraphviz(int ebene) {
    String gv = String.format(" \"%s\" [label=\"%d\"]", this, häufigkeit);
    String linkedTo = String.format(
            "\"%s\" -> \"%s\"\n\"%s\" -> \"%s\"",
            this, links, this, rechts );
    return gv + "\n" + links.getGraphviz(ebene+1) + "\n" + rechts.getGraphviz(ebene+1) +
            "\n" + linkedTo;
  }
  
  @Override
  public int compareTo(Knoten k) {
    return häufigkeit.compareTo(k.häufigkeit);
  }
}
