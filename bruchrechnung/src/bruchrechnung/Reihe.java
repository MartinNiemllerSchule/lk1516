package bruchrechnung;

/**
 * Summiert über 1/i für i bis irgendwo
 */
public class Reihe {
    private Long position;
    private Bruch summe;

    /**
     * Konstruktor
     */
    public Reihe() {
        position = new Long("1");  // Startwert f�r die Folge
        summe = next();
    }

    /**
     * Bildungsvorschrift der Folge - hier momentan 1/i
     *
     * @return i-ter Bruch der Folge
     */
    private Bruch next() {
        Bruch b = new Bruch(new Long("1"), position);
        position++;
        return b;
    }

    public Bruch getSumme(Integer kommastellen) {
        position = new Long("1");
        summe = next();
        double ks = Math.pow(10.0, kommastellen);
        double s;
        do {
            s = summe.getDezimal();
            summe = summe.addiere(next());
            System.out.format("i: %3d summe: %3.6f diff: %f\n",
                    position,
                    summe.getDezimal(),
                    summe.getDezimal() - s
            );
        } while (((int) (ks * summe.getDezimal()) - (int) (ks * s)) != 0);
        return summe;
    }
}
