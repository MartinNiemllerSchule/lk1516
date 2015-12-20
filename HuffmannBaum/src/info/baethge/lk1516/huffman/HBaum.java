/*
 * Huffman-Algorithmus
 * eine Umsetzung
 */
package info.baethge.lk1516.huffman;
import java.util.*;

/**
 * Baum erstellen -
 * http://www.ziegenbalg.ph-karlsruhe.de/materialien-homepage-jzbg/cc-interaktiv/huffman/index.htm
 * @author Frank Baethge
 */
public class HBaum extends Baum {
  private Hashtable<Character, Integer> buchstabenTabelle;
  public HBaum(String text) {
    /* Buchstaben-Häufigkeiten auszählen - Hash-Tabelle */
    buchstabenTabelle = new Hashtable<>();
    for (Character c : text.toCharArray()) {
      if (buchstabenTabelle.containsKey(c)) {
        buchstabenTabelle.put(c, buchstabenTabelle.get(c) + 1);
      } else {
        buchstabenTabelle.put(c, 1);
      }
    }
    /* Blätter in einer Liste erstellen - Collection of Knoten */
    List<Knoten> liste = new ArrayList<>();
    
    Iterator<Character> itr = buchstabenTabelle.keySet().iterator();
    while(itr.hasNext()) {
      Character c = itr.next();
      Knoten k = new Blatt(c,(Integer)buchstabenTabelle.get(c));
      liste.add(k);
    }
    
    /* Blätter nach Häufigkeit aufsteigend sortieren */
    Collections.sort(liste);
    
    /* HBaum-Baum bauen */
    while (liste.size() > 2) {
      /* erste zwei Elemente entfernen, verketten, einfügen und sortieren */
      Knoten k1 = liste.remove(0);
      Knoten k2 = liste.remove(0);
      Knoten k3 = new Knoten(k1,k2);
      liste.add(k3);
      Collections.sort(liste);
    }
    wurzel = new Knoten(liste.get(0),liste.get(1));
  }

  protected String buchstabenTabelleToString() {
    String ergebnis = "";
    Iterator<Character> itr = buchstabenTabelle.keySet().iterator();
    while(itr.hasNext()) {
      Character c = itr.next();
      Formatter formatter = new Formatter(new StringBuilder(), Locale.GERMAN);
      ergebnis += formatter.format("%c\t%d\t%d%n",c,(Integer)buchstabenTabelle.get(c),c.hashCode());
    }
    return ergebnis;
  }
}
