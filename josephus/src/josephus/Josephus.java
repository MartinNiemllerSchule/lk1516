/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package josephus;

import java.util.Random;

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
    System.out.println("Anzahl der Personen: " + erste.getLänge());
    // Ausgabe nach erstellen aller Personen in der Gruppe
    System.out.println("alle:\n" + erste.getGroup());
    // töten solange noch mehr als einer in der Gruppe enthalten sind
    while (erste.getNächste() != erste) {
      // zwei weiter und töte den Dritten
      Random rand = new Random();
      int anzahl = rand.nextInt(erste.getLänge());
      while (anzahl > 0) {
        erste = erste.getNächste();
        anzahl--;
      }
      System.out.print(" " + erste.getNächste().getName());
      erste.töte();
      
    }
    System.out.println("letzter: " + erste.getGroup());
  }
  
}
