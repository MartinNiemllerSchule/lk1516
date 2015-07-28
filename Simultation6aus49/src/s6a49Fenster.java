import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Es wird das vielfache Ziehen der Lottozahlen (6 aus 49) nachgestellt.
 * Dazu gibt der Benutzer einen Tip an und es wird so lange Lotto gespielt bis ein Vierer oder Fünfer oder Sechser
 * erreicht wurde. Die Anzahl bis zum Gewinn wird gezählt.
 *
 * @author Frank Baethge
 * @version 0.1
 *          <p/>
 *          Created by frank on 27.07.15.
 */
public class s6a49Fenster {
    private final int maxDurchlauf;
    private JPanel panel1;
    private JTextField zahl;
    private JTextPane ausgabe;
    private JButton tipAutomatischErstellenButton;
    private JLabel tipLabel;
    private int[] tip; // Tip des Benutzers
    private int anzTip; // wieviele Zahlen schon im Tip eingetragen sind (aktuelle Position im Array 0..5)
    private int[] anzahlTreffer;
    private int anzahlZiehungen;


    /**
     * Konstruktor,
     * in dem im Wesentlichen die Fensterfunktionalitäten für den Button und das Eingabefeld bereitgestellt werden.
     */
    public s6a49Fenster() {
        maxDurchlauf = 10000;

        anzahlZiehungen = 0;
        anzahlTreffer = new int[7];
        tip = new int[6];
        anzTip = 0;

        tipAutomatischErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tip = new Ziehung().getZiehung();
                anzTip = 5;
                zahl.setText("");
                zahl.setEnabled(false);
                tipLabel.setText(Arrays.toString(tip));
                alleDurchläufe();
            }
        });
        zahl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // alle Leerzeichen löschen
                String text = zahl.getText().replaceAll("\\s+", "");
                if (text.contains(",")) {
                    // es werden alle 6 Zahlen auf einmal übergeben
                    try {
                        // entferne eventuell vorhandene Klammern
                        text = text.replaceAll("\\[(.*)\\]", "$1");
                        // zerlege den String an jedem Komma - nimm ersten 6
                        String[] textListe = text.split(",", 6);
                        IllegalArgumentException iae;
                        iae = new IllegalArgumentException("Es müssen genau 6 unterschiedliche Zahlen angegeben werden.");
                        // weniger als 6 Argumente werden nicht akzeptiert
                        if (textListe.length < 6) throw iae;
                        // Umwandlung der Zahlen
                        for (int i = 0; i < tip.length; i++) {
                            Integer t = Integer.valueOf(textListe[i]);
                            if (0 < t && t <= 49) {
                                tip[i] = t;
                            } else {
                                throw new IllegalArgumentException("Es dürfen nur Zahlen von 1 bis 49 eingegeben werden.");
                            }
                        }
                        // sortieren und vergleichen, ob eine Zahl doppelt genannt wurde
                        Arrays.sort(tip);
                        int i = 0;
                        while ((i < tip.length - 1) && (tip[i] != tip[i + 1])) i++;
                        if (i < tip.length - 1) throw iae;
                        // alles ist gut, der Tip ist vollständig
                        anzTip = 5;
                        zahl.setText("");
                        zahl.setEnabled(false);
                        tipLabel.setText(Arrays.toString(tip));
                        alleDurchläufe();
                    } catch (IllegalArgumentException e) {
                        anAusgabeAnhängen(e.getMessage(), Color.RED);
                    } catch (Error e) {
                        anAusgabeAnhängen(e.toString(), Color.RED);
                    }
                } else {
                    // eine weitere Zahl wurde eingegeben
                    try {
                        Integer t = Integer.valueOf(text);
                        if (0 < t && t <= 49) {
                            // suchen, ob diese Zahl schon genannt wurde
                            int i = 0;
                            while (i < anzTip && t != tip[i]) i++;
                            if (i == anzTip) {
                                // Zahl kann eingetragen werden
                                tip[anzTip] = t;
                                if (anzTip == 5) {
                                    // alle Zahlen sind vollständig - es kann weitergehen
                                    Arrays.sort(tip);
                                    zahl.setText("");
                                    zahl.setEnabled(false);
                                    tipLabel.setText(Arrays.toString(tip));
                                    alleDurchläufe();
                                } else {
                                    // es müssen noch weitere Zahlen eingegeben werden
                                    if (anzTip == 0) {
                                        tipLabel.setText("" + tip[anzTip]);
                                    } else {
                                        tipLabel.setText(tipLabel.getText() + "," + tip[anzTip]);
                                    }
                                    anzTip++;
                                    zahl.setText("");
                                }
                            } else {
                                throw new IllegalArgumentException("Diese Zahl wurde schon genannt.");
                            }
                        } else {
                            throw new IllegalArgumentException("Es dürfen nur Zahlen von 1 bis 49 eingegeben werden.");
                        }
                    } catch (IllegalArgumentException e) {
                        anAusgabeAnhängen(e.getMessage(), Color.RED);
                    } catch (Error e) {
                        anAusgabeAnhängen(e.toString(), Color.RED);
                    }
                }
            }
        });
    }

    /**
     * Hauptprogramm - zeigt das Fenster an
     * Nach erfolgreicher Benutzereingabe startet alleDurchläufe automatisch
     *
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lotto 6 aus 49");
        frame.setContentPane(new s6a49Fenster().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Erzeugt die Durchläufe, indem jeder Durchlauf als Thread aufgerufen wird.
     * Das Ergebnis wird direkt im Fenster dargestellt.
     */
    private void alleDurchläufe() {
        Date startZeit = new Date();
        Integer ziehungenInsgesamt = 0;
        ausgabe.setText(maxDurchlauf + " Durchläufe werden gestartet - Zeit in ms: 0.\n"); // Ausgabe löschen

        ExecutorService executor = Executors.newCachedThreadPool();
        Collection<Durchlauf> durchläufe;
        durchläufe = new ArrayList<Durchlauf>(maxDurchlauf);
        for (int i = 0; i < maxDurchlauf; i++) {
            durchläufe.add(new Durchlauf(tip));
        }
        anAusgabeAnhängen("Alle Durchläufe wurden erstellt: " +
                ((new Date()).getTime() - startZeit.getTime()) +
                ".\n", Color.BLACK);
        try {
            java.util.List<Future<Integer>> ergebnisse = executor.invokeAll(durchläufe);
            anAusgabeAnhängen("Alle Durchläufe wurden gestartet -> Ergebnisse einsammeln: " +
                    ((new Date()).getTime() - startZeit.getTime()) +
                    ".\n", Color.BLACK);
            for (Future<Integer> future : ergebnisse) {
                ziehungenInsgesamt += future.get();
            }
            anAusgabeAnhängen("\n\nEs waren durchschnittlich " + (ziehungenInsgesamt / maxDurchlauf) +
                    " Ziehungen bis zum Erfolg nötig: " +
                    ((new Date()).getTime() - startZeit.getTime()) +
                    ".", Color.BLUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    /**
     * Methode zur Ausgabe von farbigem Text.
     *
     * @param s - Text, der in der Ausgabe erscheint
     * @param c - Farbe für den Text
     */
    private void anAusgabeAnhängen(String s, Color c) {
        try {
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setForeground(sas, c);
            Document aus = ausgabe.getDocument();
            aus.insertString(aus.getLength(), "\n" + s, sas);
        } catch (BadLocationException e) {
        }
    }
}