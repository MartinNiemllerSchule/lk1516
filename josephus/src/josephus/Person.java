/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
  public void einfügen(Person p) {
    p.nächste = nächste;
    nächste = p;
  }
  public void töte() {
    // TODO
  }
}
