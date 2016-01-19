package info.baethge.lk1515;

import java.math.BigInteger;

/**
 * eine Primzahl
 */
public class Primzahl {
	protected BigInteger zahl, quadrat;
	public Primzahl(BigInteger zahl) {
		this.zahl = zahl;
		quadrat = zahl.multiply(zahl);
	}
	public Primzahl(String zahl) {
		this.zahl = new BigInteger(zahl);
		quadrat = this.zahl.multiply(this.zahl);
	}
	@Override
	public String toString() { return zahl.toString(); }
}
