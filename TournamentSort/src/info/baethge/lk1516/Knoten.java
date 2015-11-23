package info.baethge.lk1516;

/**
 * Knoten im bBaum
 */
class Knoten  implements Comparable<Knoten> {
	protected Adresse a;
	protected Knoten links;
	protected Knoten rechts;
	public Knoten(Adresse adresse) {
		a = adresse;
	}
	public Knoten(Adresse adresse, Knoten rechts, Knoten links) {
		a = adresse;
		this.rechts = rechts;
		this.links = links;
	}
	protected boolean istBlatt() { return (links == null && rechts == null); }
	protected boolean istLeer() { return a == null; }
	@Override
	public String toString() {
		if (a != null) return a.toString();
		return "leer";
	}
	@Override
	public int compareTo(Knoten knoten) {
		if (knoten != null && knoten.a != null) {
			return this.a.compareTo(knoten.a);
		}
		return -1;
	}
}