package info.baethge.lk1516;

/**
 * Created by frank on 21.11.15.
 * siehe auch lk1314/Laufzeitverhalten
 */

public class Adresse implements Comparable<Adresse> {

	protected String n;
	protected String v;
	protected String s;
	protected String p;
	protected String o;
	protected int grauWert;

	public Adresse(String nachName, String vorName, String strasse, String postleitzahl, String ort) {
		n = nachName;
		v = vorName;
		s = strasse;
		p = postleitzahl;
		o = ort;
	}
	public Adresse(String[] adresse) {
		this(adresse[0], adresse[1], adresse[2], adresse[3], adresse[4]);
	}

	@Override
	public int compareTo(Adresse a) {
		int nN = n.compareTo(a.n);
		if (nN != 0) {
			return nN;
		} else {
			return v.compareTo(a.v);
		}
	}

	@Override
	public String toString() {
		return n + ", " + v /*+ " | " + s + " | " + p + " | " + o*/;
	}
}
