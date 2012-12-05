
import java.awt.Point;

/*
 * Obertyp Strategie, Bewegungsmuster fuer Autos
 */
// Berechnet die naechste Position von einem Auto innerhalb des Spielfelds.
public abstract class AbstractStrategie {
	protected int breite;
	protected int hoehe;
	
	public AbstractStrategie( int breite, int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	/*
	 * Vorb.: auto darf nicht null sein und derzeitigePosition muss einer gueltigen Position innerhalb des Spielfelds darstellen
	 * Nachb.: Liefert die naechste Position auf dem Spielfeld fuer das uebergebene Auto
	 */
	public abstract Point next( SchnellesAuto auto, Point derzeitigePosition );
	
	/*
	 * Vorb.: auto darf nicht null sein und derzeitigePosition muss einer gueltigen Position innerhalb des Spielfelds darstellen
	 * Nachb.: Liefert die naechste Position auf dem Spielfeld fuer das uebergebene Auto
	 */
	public abstract Point next( BeweglichesAuto auto, Point derzeitigePosition );
}
