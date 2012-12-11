/*
 * Verwaltet alle Rollen eines Traktors
 */
public interface Rolle {
	/**
	 * Liefert den Einsatzzweck des Traktors
	 * 
	 * @return Einsatzzweck des Traktors
	 */
	public Einsatzzweck getEinsatzzweck();
	public double getValue();
	public String toString();
}
