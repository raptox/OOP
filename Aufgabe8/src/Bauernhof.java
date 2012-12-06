public class Bauernhof {
	private String name;
	
	/**
	 * Konstruktor von Bauernhof setzt den unveraenderlichen Namen des Bauernhofes
	 * 
	 * @param name Name des Bauernhofes, kann nachtraeglich nicht mehr veraendert werden
	 */
	public Bauernhof( String name ) {
		this.name = name;
	}
	
	/**
	 * Liefert den Namen des Bauernhof
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
}
