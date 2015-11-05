package info.baethge.lk1516.Dame;
/**
 * Dameproblem zur Diskussion von rekusiven Methoden in Verbindung mit Backtracking
 * die Klasse Brett stellt die wesentlichen Eigenschaften und Methoden bereit
 * in Methode Dame wird die Lösung mittels Backtracking und rekursivem Aufrauf umgesetzt *
 */
public class Brett {
	private int[][] brett;
	private int anzahl;
	public final int DAME = -1;

	public Brett(int größe) {
		brett = new int[größe][größe];
	}
	public Brett() {
		this(8);
	}

	/**
	 * setzt einen Stein auf ein Feld (was, zeile, spalte)
	 * und sperrt dabei die betroffenen Linien (Diagonalen, Zeile und Spalte
	 * @param zeile
	 * @param spalte
	 * @param addiere
	 */
	public void setzeDame(int zeile, int spalte, int addiere) {
		if ((brett[zeile][spalte] != 0) && (addiere > 0) || (brett[zeile][spalte] != DAME) && (addiere < 0)) {
			throw new IllegalArgumentException("Die Dame soll auf ein gesperrtes Feld gesetzt werden.");
		}

		// setzen oder rücksetzen der Dame
		if (brett[zeile][spalte] != 0) {
			brett[zeile][spalte] = 0;
		} else {
			brett[zeile][spalte] = DAME;
		}
		// sperren der in Frage kommenden Felder
		int z, s; // Laufvariablen für Zeile und Spalte
		// sperre Zeile
		for (s = 0; s < brett.length; s++) {
			if (s != spalte) {
				brett[zeile][s] += addiere;
			}
		}
		// sperre Spalte
		for (z = 0; z < brett.length; z++) {
			if (z != zeile) {
				brett[z][spalte] += addiere;
			}
		}
		// sperre Diagonalen
		z = zeile +  1;
		s = spalte + 1; // rechts unten
		while ( (s < brett.length) && (z < brett.length)  ) {
			brett[z][s] += addiere;
			s++;
			z++;
		}
		z = zeile -  1;
		s = spalte - 1; // links oben
		while ( (0 <= s) && (0 <= z)  ) {
			brett[z][s] += addiere;
			s--;
			z--;
		}
		z = zeile +  1;
		s = spalte - 1; // links unten
		while ( (0 <= s) && (z < brett.length)  ) {
			brett[z][s] += addiere;
			s--;
			z++;
		}
		z = zeile -  1;
		s = spalte + 1; // rechts oben
		while ( (s < brett.length) && (0 <= z)  ) {
			brett[z][s] += addiere;
			s++;
			z--;
		}
		
	}

	public int nächsteFreieSpalte(int zeile, int spalte) {
		while ((spalte < brett.length) && (brett[zeile][spalte] != 0)) spalte++;
		return spalte;
	}

	public void dame(int zeile, int spalte) {
		int nfs = nächsteFreieSpalte(zeile, spalte);
		if (nfs < brett.length) { // es geht weiter
			if (zeile == brett.length - 1) { // Lösung gefunden -> Ausgabe
				setzeDame(zeile,nfs,1);
				System.out.println("Nr " + (++anzahl) + "\n" + this);;
				setzeDame(zeile,nfs,-1);
			} else { // gehe in die nächste Zeile
				setzeDame(zeile,nfs,1);
				dame(zeile + 1, 0);
				setzeDame(zeile,nfs,-1);
				if (nfs < 7) {
					dame(zeile, nfs + 1);
				}
			}
		} // else keine Lösung gefunden -> zurück
	}

	@Override
	public String toString() {
		String ergebnis = "";
		for (int zeile = 0; zeile < brett.length; zeile++) {
			for (int spalte = 0; spalte < brett.length; spalte++) {
				if (brett[zeile][spalte] == DAME) {
					ergebnis += "D";
				} else {
					ergebnis += " "; // oder brett[zeile][spalte];
				}
			}
			ergebnis += "\n";
		}
		return ergebnis;
	}
}
