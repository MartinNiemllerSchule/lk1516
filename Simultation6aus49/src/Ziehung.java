/**
 * Created by frank on 26.07.15.
 */
import java.util.Arrays;
public class Ziehung {
    private int[] ziehung = new int[6];
    private int[] trommel = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49};
    public Ziehung() {
        int zufallsPostion, anzahl;
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
    public int getTreffer(int[] tip) {
        int z = 0;
        int t = 0;
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
