/*
 * Klasse ClearBox besteht aus zwei Zeichen für den Rand und für den Inhalt. Diese können nicht vom Client festgelegt werden und auch nicht später verändert werden.
 */
public class Clearbox extends Box {
	public Clearbox( double height, double width ) {
		super( '*', ' ', height, width );
	}
	
	// Liefert das Seitenverhältniss der Box (Breite geteilt durch die Höhe)
	public double ratio() {
		return this.getWidth() / this.getHeight();
	}
}
