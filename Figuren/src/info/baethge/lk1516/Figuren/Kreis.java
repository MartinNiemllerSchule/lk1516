/*
 * Figur: Kreis
 */
package info.baethge.lk1516.Figuren;

import static java.lang.Math.PI;

/**
 *
 * @author frank.baethge
 */
public class Kreis extends Figur {
  private Integer radius;

  public Kreis(Integer radius, Integer xPos, Integer yPos) {
    //TODO: Was, wenn Radius kleiner als 1 eingegeben wird?
    super(xPos,yPos);
    this.radius = radius;
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
  public String toString() {
    return "Kreis (" + getX() +"," + getY() + ")," + radius;
  }
}