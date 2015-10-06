package info.baethge.lk1516.geometrischeObjekte;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import static java.lang.Math.PI;

/**
 * Klasse repräsentiert einen Kreis und stellt dessen Funktionalität dar
 */
public class Kreis extends Figur {
	private Integer radius;

	public Kreis(Integer x, Integer y, Integer radius) throws IllegalArgumentException {
		super(x,y);
		meldung = "Kreis";
		this.radius = Math.abs(radius);
		if (0 == radius) throw new IllegalArgumentException("Der Radius eines Kreises kann nicht Null sein.");
		füllung = Color.gray;
	}

	@Override
	public Double berechneFläche() {
		return PI*radius*radius;
	}

	@Override
	public Double berechneUmfang() {
		return 2*PI*radius;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g2.setStroke(rand);
		g2.setColor(randFarbe);
		Ellipse2D e = new Ellipse2D.Double(getX() - radius, getY() - radius, radius * 2, radius * 2);
		g2.draw(e);
		g2.setPaint(füllung);
		g2.fill(e);

	}
}
