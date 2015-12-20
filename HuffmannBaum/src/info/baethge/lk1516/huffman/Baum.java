/*
 * binäre Bäume
 *  und wie man damit umgeht
 * 
 * Thema: Komprimiere einen Text
 * Beispiel: iQ1Bäume_131203
 * "Bäume sind auch in der Informatik ein wichtiges Thema. Viele Daten werden zunächst in Bäumen abgespeichert. Sie werden vor allem zur Suche und Sortierung verwendet." 
 * 
 * bessere Fassung wäre
 * "Bäume sind auch in der Informatik ein wichtiges Thema. Viele Daten werden zunächst in Binärbäumen abgespeichert. Bäume werden beispielsweise zur Suche und Sortierung verwendet."
 * 
 * in der Stunde ausgezählt:
 * "Bäume sind auch in der Informatik ein wichtiges Thema. Viele"
 */
package info.baethge.lk1516.huffman;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author frank.baethge
 */
public class Baum {
  protected Knoten wurzel;

  /**
   * erstellt den Baum für den gesamten Text: siehe Notebook-Datei oder Moodle
   * das wäre also eine Lösung von Hand für den Text
   * "Bäume sind auch in der Informatik ein wichtiges Thema. Viele Daten werden zunächst in Bäumen"+
   * " abgespeichert. Sie werden vor allem zur Suche und Sortierung verwendet."
   */
  public Baum() {
    wurzel = new Knoten(
      /*81*/new Knoten(
        /*47*/new Knoten(new Blatt(' ',24), new Blatt('e',23)),
        /*34*/new Knoten(new Blatt('n',13),new Knoten(new Blatt('i',11),new Blatt('r',10)))),
      /*83*/new Knoten(
        /*47*/new Knoten(
          /*7*/new Knoten(new Blatt('u',8),new Blatt('t',7)),
          /*12*/new Knoten(
        new Knoten(new Blatt('a',6),new Blatt('d',6)),
        new Knoten(new Blatt('h',6),new Blatt('c',5)))),
        /*63*/new Knoten(
          /*20*/new Knoten(
            /*11*/new Knoten(
        new Knoten(new Blatt('w',4), new Blatt('.',3)),
        new Knoten(new Blatt('S',3), new Blatt('g',3))),
            /*9*/new Knoten(
        new Knoten(new Blatt('m',5),new Blatt('s',4)),
        new Knoten(new Blatt('l',3), new Blatt('o',3)))),
          /*20*/new Knoten(
            /*1*/new Knoten(
              /*3*/new Knoten(new Blatt('a',3),new Blatt('B',2)),
              /*4*/new Knoten(new Blatt('v',2),new Blatt('Z',2))),
            /*2*/new Knoten(
              /*5*/new Knoten(
                /*11*/new Knoten(new Blatt('D',1),new Blatt('I',1)),
                /*12*/new Knoten(new Blatt('T',1),new Blatt('V',1))),
              /*6*/new Knoten(
                /*13*/new Knoten(new Blatt('b',1),new Blatt('f',1)),
                /*14*/new Knoten(new Blatt('k',1),new Blatt('p',1))))))));
  }

  /**
   * berechnet Bitlänge des komprimierten Textes, indem die aktuelle Ebene mit der Anzahl der Buchstaben multipliziert
   * wird
   * @return - Bitlänge
   */
  protected Integer berechneBitlänge() { return wurzel.berechneBitlänge(0); }

	/**
   * Produktion eines Bildes mit GraphViz
   * @return - dot-Befehle zur Darstellung des Bildes
   */
  protected String getGraphviz(){
    return "digraph g {\n"
            + " graph [\n"
            + "  rankdir = \"TB\"\n"
            + "  bgcolor = \"white:lightblue\"\n"
            + "  style=\"filled\"\n"
            + "  gradientangle = 270\n"
            + " ];\n"
            + " node [shape=box,style=filled,color=\"lightgray\"];\n"
            + wurzel.getGraphviz(0)
            + "\n}\n";
  }

	/**
	 * ruft GraphViz auf, übergibt dort auf stdIn den Graphen als Text und liest stdOut des Prozesses, welches als Bild
	 * im Weiteren verwendet wird
	 * @return - Bild, dass GraphViz aus dem Text gemacht hat
	 */
	protected BufferedImage getGraphImage(){
		Runtime runtime = Runtime.getRuntime();
		String[] cmd = {"dot","-Tpng"};
		Process process;
		try {
			process = runtime.exec(cmd);
			// stdOutput meint den Output dieses Programms, d.h. die Logig ist auf der Kommandozeile vertauscht
			OutputStream stdIn = process.getOutputStream();
			String s = getGraphviz() + "\n";
			byte[] b = s.getBytes();
			stdIn.write(b);
			stdIn.flush();
			BufferedImage stdInput = ImageIO.read(process.getInputStream());
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			return stdInput;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}