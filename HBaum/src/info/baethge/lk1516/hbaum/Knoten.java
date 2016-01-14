/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.baethge.lk1516.hbaum;

/**
 *
 * @author frank.baethge
 */
public class Knoten implements Comparable<Knoten> {
  protected Knoten kleiner, größer;
  protected Character zeichen;
  protected Integer anzahl, tiefe;
  protected String bitCode;

  public Knoten() {
    kleiner = null;
    größer = null;
    zeichen = null;
    anzahl = 0;
    tiefe = 0;
    bitCode = null;
  }
  public Knoten(Character zeichen, Integer anzahl) {
    kleiner = null;
    größer = null;
    this.zeichen = zeichen;
	  this.anzahl = anzahl;
  }
	public Knoten(Knoten links, Knoten rechts) {
		kleiner = links;
		größer = rechts;
		zeichen = null;
		anzahl = links.anzahl + rechts.anzahl;
      tiefe = 0;
      bitCode = null;
	}
  protected void fülleKnoten(Integer tiefe, String bitCode) {
    this.tiefe = tiefe;
    this.bitCode = bitCode;
    if (kleiner != null) {
      kleiner.fülleKnoten(tiefe+1,bitCode+"0");
    }
    if (größer != null) {
      größer.fülleKnoten(tiefe+1,bitCode+"1");
    }
  }
  protected Long getBitLänge() {
    Long länge = 0L;
    // wenn ein Blatt vorliegt endet die Rekursion
    if (kleiner == null && größer == null) {
      return new Long(anzahl * tiefe);
    } else {
      return kleiner.getBitLänge() + größer.getBitLänge();
    }
  }

  @Override
  public String toString() {
    String ergebnis = "";

	  if (kleiner == null && größer == null) {
		  ergebnis += zeichen + ": " + anzahl;
		  if (bitCode != null) ergebnis +=  " - " + bitCode + "\n";
	  } else {
		  if (kleiner != null) ergebnis += kleiner;
		  if (größer != null) ergebnis += größer;
	  }


    return ergebnis;
  }

	@Override
	public int compareTo(Knoten knoten) {
		return anzahl - knoten.anzahl;
	}
}