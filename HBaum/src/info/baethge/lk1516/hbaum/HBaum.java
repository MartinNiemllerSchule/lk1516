package info.baethge.lk1516.hbaum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frank.baethge
 */
public class HBaum {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    FileReader fileReader = null;
      // Datei lesen
      File file = new File("./data/input.txt");
    try {
      fileReader = new FileReader(file);
      char[] buchstaben = new char[(int)file.length()];
      fileReader.read(buchstaben);
	    String text =  (new String(buchstaben)).trim().replace("\uFEFF","");
      // Buchstaben zählen
      Hashtable<Character,Integer> anzBuchstaben = new Hashtable<>();
      for(Character c: text.toCharArray()) {
        if (anzBuchstaben.containsKey(c)) {
          anzBuchstaben.replace(c, anzBuchstaben.get(c) + 1);
        } else {
          anzBuchstaben.put(c, 1);
        }
      }

      // Baum bauen
      Baum baum = new Baum(anzBuchstaben);
	    // Ausgabe (Bitlänge)
      Long bitLänge = baum.getBitLänge();
      System.out.printf("Bitlänge: %d - Komprimierung auf %d%%%n", bitLänge,((((bitLänge / 8)+1)*100)/buchstaben.length));
      System.out.println(baum);

    } catch (FileNotFoundException ex) {
      Logger.getLogger(HBaum.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(HBaum.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}
