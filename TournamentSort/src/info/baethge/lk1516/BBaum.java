package info.baethge.lk1516;

import java.util.ArrayList;

/**
 * Created by frank on 21.11.15.
 * Binärere Baum, ermöglicht später die Sortierung mittels TournamentSort
 */
public class BBaum {
	private Knoten wurzel;
	private int position;

	/**
	 * alle Adressen kommen in die Blätter (unterste Ebene)
	 * @param adressen - Liste der zu sortierenden Adressen
	 */
	public BBaum(ArrayList<Adresse> adressen) {
		int baumTiefe = 31 - Integer.numberOfLeadingZeros(adressen.size()); //http://stackoverflow.com/questions/3305059/how-do-you-calculate-log-base-2-in-java-for-integers
		wurzel = fülleBaumMitNull(baumTiefe);
		speichereEin(wurzel, adressen);
	}

	/**
	 * füllt zunächst den Baum auf, um anschließend das oberste Element zu entfernen und diese Stelle neu zu füllen
	 *
	 * @return - ArrayListe in absteigend sortierter Reihenfolge
	 */
	public ArrayList<Adresse> tournamentSort() {
		spieleRundenAus(wurzel);
		ArrayList<Adresse> sortiert = new ArrayList<>();
		while (!wurzel.istLeer()) {
			sortiert.add(wurzel.a);
			wurzel.a = null;
			fülleAuf(wurzel);
		}
		return sortiert;
	}

	/**
	 * in der ersten Phase werden alle Runden beginnend bei der untersten Ebene ausgespielt.
	 * Gewinner veranlassen, dass das zurückbleibende leere Feld von unten aufgefüllt wird
	 * @param k - Knoten, von dem ausgehend die Runden ausgespielt werden sollen (rekursiver Abstieg)
	 */
	private void spieleRundenAus(Knoten k) {
		if (!k.istBlatt() && k.links.istLeer() && k.rechts.istLeer()) {
			spieleRundenAus(k.links);
			spieleRundenAus(k.rechts);
		}
		fülleAuf(k);
	}

	/**
	 * ist ein oberes Feld leer geworden, wird es, wenn möglich, mit weiter unten stehenden Elementen gefüllt
	 * @param k - Knoten, von dem ausgehend die oberen Ebenen aufgefüllt werden (rekursiver Abstieg)
	 */
	private void fülleAuf(Knoten k){
		if (!k.istBlatt()) {
			if (k.links == null || k.links.istLeer()) {
				if (k.rechts == null || k.rechts.istLeer()) {
					// beide leer - dann kann da nichts weiter kommen -> lösche die Blätter, um später schneller zu merken, dass Schluss ist
					k.links = null;
					k.rechts = null;
				} else {
					rechtsRücktAuf(k);
				}
			} else {
				// links ist nicht leer
				if (k.rechts == null || k.rechts.istLeer()) {
					linksRücktAuf(k);
				} else {
					// beide sind noch gefüllt
					if (k.links.compareTo(k.rechts) > 0) {
						linksRücktAuf(k);
					} else {
						rechtsRücktAuf(k);
					}
				}
			}
		}
	}
	private void linksRücktAuf(Knoten k) {
		k.a = k.links.a;
		k.links.a = null;
		fülleAuf(k.links);
	}
	private void rechtsRücktAuf(Knoten k) {
		k.a = k.rechts.a;
		k.rechts.a = null;
		fülleAuf(k.rechts);
	}

	/**
	 * die in der ArrayListe a übergebenen Werte werden in der untersten Ebene ergänzt
	 * dadurch eintsteht eine Ebene mit Blättern, die zunächst die Nutzerdaten enthalten
	 * @param k - rekursiver Abstieg - in den Blätter werden die Einträge gespeichert
	 * @param a - TODO: vielleicht ist es besser die unsortierten Knoten global zu definieren (und nicht jedesmal zu übergeben)
	 */
	private void speichereEin(Knoten k, ArrayList<Adresse> a) {
		if (position<a.size()) {
			// weitere Elemente müssen hinzugefügt werden
			if (k.links == null && k.rechts == null) {
				// in unterster Ebene angekommen, werden die linken und rechten Knoten (falls nötig) befüllt
				k.links = new Knoten(a.get(position++));
				if (position<a.size()) k.rechts = new Knoten(a.get(position++));
			} else {
				// gehe in untere Ebene
				speichereEin(k.links, a);
				speichereEin(k.rechts, a);
			}
		}
	}
	/**
	 * Erzeugt einen binären Baum mit lauter leeren Knoten in ebene Ebenen
	 * anschließend kann der Baum 2^ebene Blätter aufnehmen
	 * @param ebene - Ebenenzähler
	 * @return - Wurzelknoten
	 */
	private Knoten fülleBaumMitNull(int ebene) {
		if (ebene == 0) {
			return new Knoten(null); // das sind die vorläufigen Blätter
		} else {
			return new Knoten(null,fülleBaumMitNull(ebene-1),fülleBaumMitNull(ebene-1));
		}
	}
	@Override
	public String toString() {
		return toStringPreOrder(wurzel);
	}
	private String toStringPreOrder(Knoten k) {
		return k + "\n" +
				((k.links != null) ? toStringPreOrder(k.links) : "") +
				((k.rechts != null) ? toStringPreOrder(k.rechts) : "");
	}
}