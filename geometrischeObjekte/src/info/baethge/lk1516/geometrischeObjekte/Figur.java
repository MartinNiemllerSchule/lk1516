package info.baethge.lk1516.geometrischeObjekte;

import java.awt.*;

/**
 * Enthält alle grundlegenden Eigenschaften und Methoden der Zeichen-Objekte
 */
abstract class Figur {
	protected BasicStroke rand;
	protected BasicStroke randFett;
	protected Color füllung;
	protected Color randFarbe;
	protected String meldung;
	protected Point position;
	protected Graphics2D g2;

	public Figur() {
		rand = new BasicStroke(2.0f);
		randFett = new BasicStroke(6.0f);
		randFarbe = Color.BLUE;
		füllung = Color.DARK_GRAY;
		meldung = "Figur";
		position = null;
	}

	public void paint(Graphics g) {
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public String toString() {
		return meldung;
	}
}
