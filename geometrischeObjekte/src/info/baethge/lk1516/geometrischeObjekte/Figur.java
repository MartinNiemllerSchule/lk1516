package info.baethge.lk1516.geometrischeObjekte;

import java.awt.*;

/**
 * Enthält alle grundlegenden Eigenschaften und Methoden der Zeichen-Objekte
 */
abstract class Figur {
	private Point position;

	protected BasicStroke rand;
	protected Color füllung, randFarbe;
	protected String meldung;
	protected Graphics2D g2;

	/**
	 * Konstruktor - übergeben wird die Position der Figur
	 * beim Kreis ist das das Zentrum
	 * beim Dreieck ist das der erste zu zeichnende Punkt
	 *
	 * @param x - x-Koordinate der Position
	 * @param y - y-Koordinate der Position
	 */
	public Figur(Integer x, Integer y) {
		rand = new BasicStroke(2.0f);
		randFarbe = Color.BLUE;
		füllung = Color.DARK_GRAY;
		meldung = "Figur";
		position = new Point(x,y);
	}

	public abstract Double berechneFläche();
	public abstract Double berechneUmfang();

	protected Integer getX() {
		return position.x;
	}
	protected Integer getY() {
		return position.y;
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