/*
 * Figur: Dreieck
 */
package info.baethge.lk1516.geometrischeObjekte;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author frank.baethge
 */
public class Dreieck extends Figur {
	private Point b, c;

	public Dreieck(Integer x, Integer y, Integer x1, Integer y1, Integer x2, Integer y2) {
		//TODO: was, wenn alle Punkte auf einer Gerade liegen
		super(x,y);
		meldung = "Dreieck";
		b = new Point(x1,y1);
		c = new Point(x2,y2);
	}
	@Override
	public Double berechneFläche() {
		Double aS,bS,cS; // Seitenlängen
		Integer aX, aY, bX, bY, cX, cY; // Differenzen der Seiten
		aX = getX() - b.x;
		aY = getY() - b.y;
		bX = b.x - c.x;
		bY = b.y - c.y;
		cX = c.x - getX();
		cY = c.y - getY();
		aS = Math.sqrt(aX*aX+aY*aY);
		bS = Math.sqrt(bX*bX+bY*bY);
		cS = Math.sqrt(cX*cX+cY*cY);
		double halberUmfang = (aS + bS + cS) / 2.0;
		return Math.sqrt(halberUmfang*(halberUmfang - aS)*(halberUmfang -bS)*(halberUmfang - cS));
	}

	@Override
	public Double berechneUmfang() {
		Double aS,bS,cS; // Seitenlängen
		Integer aX, aY, bX, bY, cX, cY; // Differenzen der Seiten
		aX = getX() - b.x;
		aY = getY() - b.y;
		bX = b.x - c.x;
		bY = b.y - c.y;
		cX = c.x - getX();
		cY = c.y - getY();
		aS = Math.sqrt(aX*aX+aY*aY);
		bS = Math.sqrt(bX*bX+bY*bY);
		cS = Math.sqrt(cX*cX+cY*cY);
		return aS + bS + cS;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g2.setStroke(rand);
		g2.setColor(randFarbe);
		Polygon p = new Polygon(new int[]{getX(), b.x, c.x},new int[]{getY(),b.y,c.y},3);
		g2.draw(p);
		g2.setPaint(füllung);
		g2.fill(p);

	}
}