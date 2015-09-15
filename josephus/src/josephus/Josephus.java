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
public class Josephus {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // 41 Personen anlegen
    Person erste = new Person("1");
    for (Integer i = 41; i>1; i--) {
      erste.einfügen(new Person(i.toString()));
    }
    // Ausgabe nach erstellen aller Personen in der Gruppe
    System.out.println("alle:\n" + erste.getGroup());
    // töten solange noch mehr als einer in der Gruppe enthalten sind
    while (erste.getNächste() != erste) {
      // zwei weiter und töte den Dritten
      erste = erste.getNächste().getNächste();
      erste.töte();
      System.out.println(erste.getGroup());
    }
    System.out.println("letzter: " + erste.getGroup());
  }
  
}
