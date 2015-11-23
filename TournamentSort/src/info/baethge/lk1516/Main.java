package info.baethge.lk1516;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	private ArrayList<Adresse> adressen;
	private BBaum baum;

    public static void main(String[] args) {
	    Main prgm = new Main();
	    prgm.run();
    }

	public void run() {
		adressen = new ArrayList<>();
		if (einlesen("./data/adressdaten.csv",11)) {
			baum = new BBaum(adressen);
			System.out.println(baum + "\n\n");
			baum.tournamentSort();
		}
	}

	/**
	 * Liest die Adress-Daten aus der Datei ein und speichert sie in adressen ab
	 * @param dateiName
	 */
	public void einlesen(String dateiName) {
		einlesen(dateiName,Integer.MAX_VALUE);
	}
	/**
	 * Liest die ersten anzahl Adress-Daten aus der Datei ein und speichert sie in adressen ab
	 * @param dateiName
	 * @param anzahl - Liste nur anzahl-Zeilen ein
	 */
	public boolean einlesen(String dateiName, Integer anzahl) {
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(dateiName);
			br = new BufferedReader(fr);
			String zeile = "";
			while (((zeile = br.readLine()) != null) && (anzahl-- > 0)) adressen.add(new Adresse(zeile.split(",")));
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
