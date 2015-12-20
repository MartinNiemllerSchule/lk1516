package info.baethge.lk1516.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Hauptprogramm
 * Created by frank on 20.12.15.
 */
public class Huffman {
	private GraphViz graphViz;
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		(new Huffman()).run();
	}

	private void run() {
		// UI initialisieren
		graphViz = new GraphViz();

		// Baum von Hand bauen
		Baum baum1 = new Baum();
		System.out.println("Bitlänge des komprimierten Textes 1: " + baum1.berechneBitlänge());
		graphViz.addPic(baum1.getGraphImage());

		// nach Huffman-Algorithmus den Baum bauen

		HBaum hBaum = new HBaum("Bäume sind auch in der Informatik ein wichtiges Thema. Viele Daten werden zunächst in Bäumen"+
				" abgespeichert. Sie werden vor allem zur Suche und Sortierung verwendet.");
		System.out.println("Bitlänge des komprimierten Textes 2: " + hBaum.berechneBitlänge());
		graphViz.addPic(hBaum.getGraphImage());

		// ABRAKADABRA
		HBaum hBaumA = new HBaum("ABRAKADABRA");
		System.out.println("Bitlänge des komprimierten Textes 3: " + hBaumA.berechneBitlänge());
		graphViz.addPic(hBaumA.getGraphImage());

		// MISSISSIPPI
		HBaum hBaumM = new HBaum("MISSISSIPPI");
		System.out.println("Bitlänge des komprimierten Textes 4: " + hBaumM.berechneBitlänge());
		graphViz.addPic(hBaumM.getGraphImage());

		// adressdaten.csv
		File file = new File("./data/adressdaten.csv");
		try {
			FileReader fileReader = new FileReader(file);
			char[] tmp = new char[(int)file.length()];
			fileReader.read(tmp);
			String adressen = new String(tmp);
			HBaum hBaumAdr = new HBaum(adressen);
			System.out.println("Bitlänge des komprimierten Textes 5: " + hBaumAdr.berechneBitlänge());
			System.out.println("BuchstabenTabelle:\n" + hBaumAdr.buchstabenTabelleToString());
			graphViz.addPic(hBaumAdr.getGraphImage());
			// System.out.println("GraphViz:\n" + hBaumAdr.getGraphviz());

		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		// saveAllTabs() sollte eigentlich mit Strg+S aufgerufen werden
		// graphViz.saveAllTabs();

	}

}
