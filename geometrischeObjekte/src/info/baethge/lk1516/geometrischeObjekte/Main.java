package info.baethge.lk1516.geometrischeObjekte;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * erstellt das Fenster, enthält die Objekte und zeichnet sie
 */
public class Main extends JFrame {
	private static ArrayList<Figur> figuren = new ArrayList<Figur>(10);

	public static void main(String[] args) {
		// erstellen der geometrischen Objekte
		try {
			Figur k1 = new Kreis(100, 100, 80);
			figuren.add(k1);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		figuren.add(new Dreieck(100,200,500,200,600,150));

		// erstellen und anzeigen der Zeichenfläche
		JFrame frame = new Main();
		frame.setTitle("Zeichnung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frame.setPreferredSize(new Dimension(800, 300));
		frame.setSize(new Dimension(800, 300));
		frame.setLocation(new Point(50, 50));
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		for(Figur f: figuren) {
			f.paint(g);
		}
	}
}