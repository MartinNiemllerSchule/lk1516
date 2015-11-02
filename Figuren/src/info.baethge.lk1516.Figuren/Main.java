/*
 * 
 */
package info.baethge.lk1516.Figuren;

/**
 *
 * @author frank.baethge
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Figur k = new Kreis(10,20,30);
    System.out.println("k: " + k);
    System.out.println("k.umfang: " + k.berechneUmfang());
    System.out.println("k.fläche: " + k.berechneFläche());
    Figur d = new Dreieck(10,20,30,40,60,60);
    System.out.println("d: " + d);
    System.out.println("d.umfang: " + d.berechneUmfang());
    System.out.println("d.fläche: " + d.berechneFläche());
  }
  
}
