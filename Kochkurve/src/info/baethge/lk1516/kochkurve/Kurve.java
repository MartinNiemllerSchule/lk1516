package info.baethge.lk1516.kochkurve;

import javax.swing.*;
import java.awt.*;

/**
 * Die Klasse Kurve erstellt einen Text der als Turtle-Grafik interpretiert die Kochkurve enthält
 * und in einem Fenster darstellt
 */
public class Kurve extends JFrame {
	private int maxLevel;
	private int gesamtLänge;
	private String initiator = "F";
	private String generator = "FlFrrFlF";
	private String[] kurven = new String[10];

	/**
	 * Creates new form Kurve
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

	private void erstelleKurven() {
		kurven[0] = initiator;
		for (int i = 1; i <= maxLevel; i++) {
			kurven[i] = kurven[i - 1].replaceAll(initiator, generator);
		}
	}

	public String KochkurveAlsText() {
		return kurven[maxLevel];
	}

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