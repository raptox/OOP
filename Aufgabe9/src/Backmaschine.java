/**
 * Abstrakte Oberklasse fuer alle Backmaschinen zum Backen von Keksen. (Factory Pattern)
 */
public abstract class Backmaschine {
	/**
	 * Backt und liefert den gewuenschten Keks
	 * 
	 * @return Keks Objekt
	 */
	public abstract Keks backe();
}
