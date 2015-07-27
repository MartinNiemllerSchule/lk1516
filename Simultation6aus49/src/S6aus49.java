import java.util.Arrays;

public class S6aus49 {
	public static void main(String[] args) {
		int maxDurchlauf = 1000;
		int[] anzahlTreffer = new int[7];
		int anzahlZiehungen = 0;
		int[] tip = new Ziehung().getZiehung();  // Tip des Benutzers wird mit Zufallswerten belegt
		System.out.println("Tip: " + Arrays.toString(tip));
		for (int durchlauf=0; durchlauf < maxDurchlauf; durchlauf++ ) {
			int treffer = 0;
			while (treffer < 5) {
				treffer = new Ziehung().getTreffer(tip);
				anzahlZiehungen++;
			}
			anzahlTreffer[treffer]++;
			System.out.print(treffer + " ");
			if ((anzahlTreffer[4]+anzahlTreffer[5]+anzahlTreffer[6]) % 60 == 0) System.out.println();
		}
		System.out.println("\nnach " + maxDurchlauf + " Durchläufen wurden\n " + anzahlTreffer[4] + " 4-er\n " +
				anzahlTreffer[5] + " 5-er\n " +  anzahlTreffer[6] + " 6-er erzielt.");
		System.out.println("Dazu waren durchschnittlich " + (anzahlZiehungen / maxDurchlauf) + " Ziehungen nötig.");
	}
}

/*

nach 100000 Durchläufen wurden
 98151 4-er
  1843 5-er
     6 6-er erzielt.
Dazu waren durchschnittlich 1010 Ziehungen nötig.

* Offensichtlich sind etwa 1000 Ziehungen bis zum ersten Gewinn nötig.
* Da ergeben sich neue Fragen, die bei kleinen Änderungen im Programm leicht zu beantworten wären. Beispielsweise
* a) Ändert sich die durchschnittliche Anzahl von Ziehungen, wenn der Tip jedesmal geändert wird?
* b) Wenn bei jeder Ziehung 12 verschiedene Tips abgegeben werden - wie ändert sich dann diese Anzahl?
* c) ...
* d) Wie viele Ziehungen sind bis zum Erreichen eines Fünfers oder Sechsers nötig?
* */