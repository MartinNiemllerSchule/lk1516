package info.baethge.lk1515;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * erstellt und verwaltet die PrimzahlListe
 */
public class PrimzahlListe {
	private final String pzTxt = "./data/primzahlen.txt";

	private int posLetztePZinTxt;
	protected ArrayList<Primzahl> liste;


	public PrimzahlListe() {
		liste = new ArrayList<>(10000);
		String line = "";
		BigInteger bi;
		try {
			FileReader fr = new FileReader(pzTxt);
			BufferedReader br = new BufferedReader(fr);
			while ((line = br.readLine()) != null && (line.length() > 0)) {
				bi = new BigInteger(line);
				liste.add(new Primzahl(bi));
			}
			posLetztePZinTxt = liste.size() - 1;
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace(); //"Fehler beim Einlesen von ->" + line
		}
	}

	public BigInteger getFactor(BigInteger zahl) {
		Primzahl pz;
		int i = 0;
		do {
			pz = liste.get(i);
			i++;
			if (i >= liste.size()) setNextPrime();
			if ((zahl.mod(pz.zahl).compareTo(BigInteger.ZERO)) == 0) return pz.zahl;
		} while (pz.quadrat.compareTo(zahl) <= 0);
		return zahl;
	}

	private void setNextPrime() {
		Primzahl pz = liste.get(liste.size()-1);
		BigInteger p = pz.zahl;
		BigInteger z2 = new BigInteger("2");
		do {
			p = p.add(z2);
		} while (!istPrim(p));
		liste.add(new Primzahl(p));
	}

	public boolean istPrim(BigInteger zahl) {
		return zahl.compareTo(getFactor(zahl)) == 0;
	}

	public void write(){
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(pzTxt,true)))){
			for (int i = posLetztePZinTxt + 1; i < liste.size(); i++) {
				pw.println(liste.get(i).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
