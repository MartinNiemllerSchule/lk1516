package info.baethge.lk1516;

import processing.core.PApplet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main extends PApplet {
	private static final Integer ANZAHL = 30; // mehr als 256 Graustufen sind nicht sinnvoll -> also ANZAHL <= 256
	private static final Integer BREITE = 15; // BREITE*ANZAHL -> Größe des Bildes
	private ArrayList<Adresse> adressen;
	private BBaum baum;

    public static void main(String[] args) {
	    Main prgm = new Main();
	    PApplet.main(new String[] {"--present", "info.baethge.lk1516.Main"});
    }

	public void settings() {
		size(ANZAHL*BREITE,ANZAHL*BREITE);
	}
	public void setup() {
		adressen = new ArrayList<>();
		if (einlesen("./data/adressdaten.csv",ANZAHL)) {
			// Grauwerte zuweisen
			ArrayList<Adresse> sortierteAdressen = new ArrayList<>(adressen);
			Collections.sort(sortierteAdressen);
			for(int i = 0; i < sortierteAdressen.size(); i++) {
				sortierteAdressen.get(i).grauWert = color(255 - i*5);
			}
			// erste Zeile anzeigen
			int zeile = 0;
			zeigeZeile(zeile++, adressen);
			// Baum bauen
			baum = new BBaum(adressen);
			// schrittweise Sortieren
			ArrayList<ArrayList<Integer>> farbenByStep = baum.tournamentSortByStep();
			// Bild füllen
			for(ArrayList<Integer> farben: farbenByStep) zeigeFarben(zeile++, farben);
			// Bild speichern
			save("./data/tournamenSort04.png");
			/*
			System.out.println(baum + "\n\n");
			ArrayList<Adresse> sortiert = baum.tournamentSort();
			for (Adresse a : sortiert) {
				System.out.println(a);
			}
			*/
		}
	}
	public void zeigeZeile(int z, ArrayList<Adresse> adrn) {
		for(int i = 0; i < adrn.size(); i++) {
			fill(adrn.get(i).grauWert);
			rect(i*BREITE, z*BREITE, BREITE, BREITE);
		}
	}
	public void zeigeFarben(int z, ArrayList<Integer> farben) {
		for(int i = 0; i < farben.size(); i++) {
			fill(farben.get(i));
			rect(i*BREITE, z*BREITE, BREITE, BREITE);
		}
	}
	public void draw() { exit(); }

	/**
	 * Liest die Adress-Daten aus der Datei ein und speichert sie in adressen ab
	 * @param dateiName - Dateiname
	 */
	public void einlesen(String dateiName) {
		einlesen(dateiName,Integer.MAX_VALUE);
	}
	/**
	 * Liest die ersten anzahl Adress-Daten aus der Datei ein und speichert sie in adressen ab
	 * @param dateiName - Dateiname
	 * @param anzahl - Liste nur anzahl-Zeilen ein
	 */
	public boolean einlesen(String dateiName, Integer anzahl) {
		BufferedReader br;
		try {
			FileReader fr = new FileReader(dateiName);
			br = new BufferedReader(fr);
			String zeile;
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
