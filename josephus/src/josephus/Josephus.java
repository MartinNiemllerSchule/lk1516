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
    Person erste = new Person("Frank");
    Person zweite = new Person("Marek");
    erste.einfügen(zweite);
    System.out.println("erste :" + erste.getName());
    System.out.println("zweite :" + erste.getNächste().getName());
    System.out.println("dritte :" + erste.getNächste().getNächste().getName());
  }
  
}
