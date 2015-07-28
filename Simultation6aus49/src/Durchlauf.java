import java.util.concurrent.Callable;

/**
 * Ein Durchlauf ist das Ausführen von Ziehungen, bis ein Erfolg vorliegt.
 * Die call-Methode liefert die Anzahl der Ziehungen bis zum Erfolg zurück.
 * Ein Durchlauf wird nebenläufig ausgeführt, so dass die CPU ausgelastet ist.
 * <p/>
 * Created by frank on 28.07.15.
 */
public class Durchlauf implements Callable<Integer> {
    private final int[] tip;
    private Integer anzahlDurchläufe;

    public Durchlauf(int[] tip) {
        this.tip = tip;
        anzahlDurchläufe = 0;
    }

    @Override
    public Integer call() throws Exception {
        Ziehung z;
        do {
            z = new Ziehung();
            anzahlDurchläufe++;
        } while (z.getTreffer(tip) < 4);
        return anzahlDurchläufe;
    }
}