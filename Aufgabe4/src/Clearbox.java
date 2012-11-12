public class Clearbox extends Box {
	public Clearbox( double height, double width ) {
		super( '*', ' ', height, width );
	}
	
	// Liefert das Seitenverhältniss der Box (Breite geteilt durch die Höhe)
	public double ratio() {
		return this.getWidth() / this.getHeight();
	}
}
