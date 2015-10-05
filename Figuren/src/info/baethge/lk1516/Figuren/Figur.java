/*
 * Basisklasse für alle weiteren Klassen
 */
package info.baethge.lk1516.Figuren;

/**
 *
 * @author frank.baethge
 */
public abstract class Figur {
  private Integer x, y; // Position der Figur

  protected Figur(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }
  
  public abstract Double berechneFläche();
  public abstract Double berechneUmfang();
  protected void setX(Integer x) {
    this.x = x;
  }
  protected void setY(Integer y) {
    this.y = y;
  }
  protected Integer getX() {
    return x;
  }
  protected Integer getY() {
    return y;
  }

  @Override
  public String toString() {
    return "Figur";
  }
}
