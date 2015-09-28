package info.baethge.lk1516.kochkurve;

import javax.swing.*;
import java.awt.*;

/**
 * Die Klasse Kurve erstellt einen Text der als Turtle-Grafik interpretiert die Kochkurve enthält
 * und in einem Fenster darstellt
 *
 * maxLevel - Anzahl der Iterationen (Maximal 10 - mehr ist nicht sinnvoll,
 *            denn 3^9 sind schon ca. 20.000 - so viele Pixel hat kein Bildschirm)
 * gesamtLänge - passt die Kurve dem Fenster an (TODO: könnte aus den Fenstermaßen bestimmt werden)
 * kurven - speichert alle Generationen der Kochkurve von 0 = F bis maxLevel = ... ab
 */

public class Kurve extends JFrame {
	private int maxLevel;
	private int gesamtLänge;
	private String initiator = "F";
	private String generator = "FlFrrFlF";
	private String[] kurven = new String[10];

	/**
	 * Konstruktoren
	 */
	public Kurve() {
		maxLevel = 1;
		gesamtLänge = 800;
		erstelleKurven();
	}

	public Kurve(int AnzahlLevel) {
		maxLevel = Math.min(AnzahlLevel, kurven.length - 1);
		gesamtLänge = 800;
		erstelleKurven();
	}

	/**
	 * Füllt Array kurven bis zu maxLevel
	 */
	private void erstelleKurven() {
		kurven[0] = initiator;
		for (int i = 1; i <= maxLevel; i++) {
			kurven[i] = kurven[i - 1].replaceAll(initiator, generator);
		}
	}

	/**
	 *
	 * @return Text für die Kochkurve mit den meisten Details
	 */
	public String KochkurveAlsText() {
		return kurven[maxLevel];
	}

	public String KochkurveAlsText(int level) {
		level = Math.min(level, maxLevel);
		return kurven[level];
	}

	/**
	 * Ergänzt die paint-Methode - zeichnet die Kurve entsprechend den Vorgaben aus KochkurveAlsText()
	 * @param g - zeichnet direkt in den Frame
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
		String k = KochkurveAlsText();
		double länge = gesamtLänge / Math.pow(3, maxLevel);
		double x = 10, y = 50, x1, y1, winkel = 0;
		for (char c : k.toCharArray()) {
			switch (c) {
				case 'F':
					x1 = x + länge * Math.cos(winkel);
					y1 = y + länge * Math.sin(winkel);
					g2d.drawLine((int) x, (int) y, (int) x1, (int) y1);
					x = x1;
					y = y1;
					break;
				case 'l':
					winkel += Math.PI / 3;
					break;
				case 'r':
					winkel -= Math.PI / 3;
					break;
			}
		}
	}
}