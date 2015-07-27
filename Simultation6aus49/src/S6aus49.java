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
			while (treffer < 4) {
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