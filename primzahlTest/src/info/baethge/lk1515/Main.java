package info.baethge.lk1515;

import java.math.BigInteger;

public class Main {
	private PrimzahlListe primzahlListe;

	public Main() {
		primzahlListe = new PrimzahlListe();
	}

	public static void main(String[] args) {
	  (new Main()).run();
	}

	public void run() {
		try {
			BigInteger zahl0 = new BigInteger("2017");
			BigInteger zahl1 = new BigInteger("383095318228681");
			BigInteger zahl2 = new BigInteger("40610371693540247718059");

			BigInteger faktor = primzahlListe.getFactor(zahl1);
			System.out.println(faktor);

		} finally {
			primzahlListe.write();
		}
	}
}
