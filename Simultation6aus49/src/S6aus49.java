import java.util.Arrays;

public class S6aus49 {
	public static void main(String[] args) {
		int[] tip = new Ziehung().getZiehung();  // Tip des Benutzers wird mit Zufallswerten belegt
		System.out.println("Tip: " + Arrays.toString(tip));
		int treffer = 0;
		int anzahlZiehungen = 0;
		while (treffer < 4) {
			treffer = new Ziehung().getTreffer(tip);
			anzahlZiehungen++;
			System.out.print(treffer + " ");
			if (anzahlZiehungen % 60 == 0) System.out.println();
		}
		System.out.println("\nnach " + anzahlZiehungen + " Ziehungen wurde ein " + treffer + "-er erziehlt.");
	}
}