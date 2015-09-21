/**
 * Bauplan für Personen die in einem Kreis stehen
 */
package josephus;

/**
 *
 * @author frank.baethge
 */
public class Person {
  private String name;
  private Person nächste;
  public Person(String name) {
    this.name = name;
    nächste = this;
  }
  public String getName() {
    return name;
  }
  public Person getNächste() {
    return nächste;
  }
  /**
   * stellt einen Text mit den Bezeichnungen der Personen im Kreis zusammen
   * @return Liste aller Namen im Kreis
   */
  public String getGroup() {
    Person p = nächste;
    String erg = getName();
    while (p != this) {
      erg += " " + p;
      p = p.nächste;
    }
    return erg;
  }
  /**
   * 
   * @return Anzahl der Elemente im Kreis
   */
   public Integer getLänge() {
    Person p = nächste;
    Integer anz = 1;
    while (p != this) {
      anz++;
      p = p.nächste;
    }
    return anz;
  }
  public void einfügen(Person p) {
    p.nächste = nächste;
    nächste = p;
  }
  public void töte() {
    nächste = nächste.nächste;
  }
  
  @Override
  public String toString() {
    return getName();
  }
}
