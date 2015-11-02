/*
 * Figur: Dreieck
 */
package info.baethge.lk1516.Figuren;

/**
 *
 * @author frank.baethge
 */
public class Dreieck extends Figur {
  private Integer x1,y1,x2,y2;
  
  public Dreieck(Integer x, Integer y, Integer x1, Integer y1, Integer x2, Integer y2) {
	  //TODO: was, wenn alle Punkte auf einer Gerade liegen
    super(x,y);
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
  @Override
  public Double berechneFläche() {
    Double a,b,c; // Seitenlängen
    Integer aX, aY, bX, bY, cX, cY; // Differenzen der Seiten
    aX = getX() - x1;
    aY = getY() - y1;
    bX = x1 - x2;
    bY = y1 - y2;
    cX = x2 - getX();
    cY = y2 - getY();
    a = Math.sqrt(aX*aX+aY*aY);
    b = Math.sqrt(bX*bX+bY*bY);
    c = Math.sqrt(cX*cX+cY*cY);
    double halberUmfang = (a + b + c) / 2.0;
    return Math.sqrt(halberUmfang*(halberUmfang - a)*(halberUmfang -b)*(halberUmfang - c));
  }

  @Override
  public Double berechneUmfang() {
    Double a,b,c; // Seitenlängen
    Integer aX, aY, bX, bY, cX, cY; // Differenzen der Seiten
    aX = getX() - x1;
    aY = getY() - y1;
    bX = x1 - x2;
    bY = y1 - y2;
    cX = x2 - getX();
    cY = y2 - getY();
    a = Math.sqrt(aX*aX+aY*aY);
    b = Math.sqrt(bX*bX+bY*bY);
    c = Math.sqrt(cX*cX+cY*cY);
    return a + b + c;
  }
  
  @Override
  public String toString() {
    return "Dreieck ";
  }
}
