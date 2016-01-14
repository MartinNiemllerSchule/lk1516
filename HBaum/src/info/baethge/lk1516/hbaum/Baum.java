/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.baethge.lk1516.hbaum;

import java.util.*;

/**
 *
 * @author frank.baethge
 */
public class Baum {
  Knoten wurzel;
  public Baum(Hashtable<Character, Integer> anzahlBuchstaben)
  {
    // Liste produzieren
	ArrayList<Knoten> knotenListe = new ArrayList<Knoten>(anzahlBuchstaben.size());
    anzahlBuchstaben.forEach((c, i) -> {
      knotenListe.add(new Knoten(c, i));
    });

    // aus Liste Baum
	  while (knotenListe.size() > 1) {
		  Collections.sort(knotenListe);
		  Knoten k1 = knotenListe.get(0);
		  knotenListe.remove(0);
		  Knoten k2 = knotenListe.get(0);
		  knotenListe.remove(0);
		  knotenListe.add(new Knoten(k1,k2));
	  }
    wurzel = knotenListe.get(0);

    // Baum ist jetzt fertig, befülle die Blätter mit den restlichen Informationen (bitCode und tiefe)
    wurzel.fülleKnoten(0,"");
  }
	public Long getBitLänge(){
		return wurzel.getBitLänge();
	}

  @Override
  public String toString(){
    return wurzel.toString();
  }
}
