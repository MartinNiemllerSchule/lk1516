/**
 * Ein Ziehung bedeutet, dass sechs mögliche Zahlen zufällig ausgewählt werden.
 * Created by frank on 26.07.15.
 */
import java.util.Arrays;
public class Ziehung {
    private int[] ziehung;
    private int[] trommel;
    public Ziehung() {
        trommel = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33,
                34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49}; // aus Geschwindigkeitsgründen von Hand eingetragen
        ziehung = new int[6];

        int zufallsPostion, anzahl;
        /*
        Aus der Trommel wird immer eine Zahl entnommen und die letzte Zahl in der Trommel wird an diese Stelle
        geschrieben. Anschließend wird die Trommel verkürzt (anzahl--), das heißt der Array wird nicht mehr mit allen
        Stelle betrachtet, sondern mit jeweils einer Stelle weniger.
         */
        for (int i = 0; i < ziehung.length; i++) {
            anzahl = trommel.length - i;
            zufallsPostion = (int)(Math.random()*anzahl);
            ziehung[i] = trommel[zufallsPostion];
            trommel[zufallsPostion] = trommel[anzahl-1];
        }
        Arrays.sort(ziehung);
    }

    public int[] getZiehung() {
        return ziehung;
    }

    /**
     * Die Ziehung wird mit dem Tip verglichen (dazu ist die Sortierung hilfreich).
     * Übereinstimmende Zahlen ergeben einen Treffer.
     *
     * @param tip - Benutzerwahl der Zahlen
     * @return - Anzahl der richtig getippten Zahlen
     */
    public int getTreffer(int[] tip) {
        int z = 0; // Laufvariable im Array ziehung
        int t = 0; // Laufvariable im Array tip
        int treffer = 0;
        while(z < ziehung.length && t < tip.length) {
            if (ziehung[z] < tip[t]) {
                z++;
            } else if (tip[t] < ziehung[z]) {
                t++;
            } else {
                treffer++;
                z++;
                t++;
            }
        }
        return treffer;
    }
}
