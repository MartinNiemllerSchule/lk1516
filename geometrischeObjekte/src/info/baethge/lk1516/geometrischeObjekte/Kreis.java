package info.baethge.lk1516.geometrischeObjekte;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Klasse repräsentiert einen Kreis und stellt dessen Funktionalität dar
 */
public class Kreis extends Figur {
	private Integer radius;

	public Kreis(Integer radius, Point position) throws IllegalArgumentException {
		meldung = "Kreis";
		this.radius = Math.abs(radius);
		if (0 == radius) throw new IllegalArgumentException("Der Radius eines Kreises kann nicht Null sein.");
		this.position = position;

		füllung = Color.gray;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g2.setStroke(rand);
		g2.setColor(randFarbe);
		g2.draw(new Ellipse2D.Double(position.getX() - radius - 1, position.getY() - radius - 1, radius * 2, radius * 2));
		g2.setPaint(füllung);
		g2.fill(new Ellipse2D.Double(position.getX() - radius, position.getY() - radius, radius * 2, radius * 2));

	}
}
