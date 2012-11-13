/*
 * Klasse DarkBox besteht aus einem Zeichen dass im Konstruktor gesetzt wird. Dieses kann später wieder verändert werden.
 */
public class Darkbox extends AbstractBox {
	private char character;
	
	public Darkbox( char character, double height, double width ) {
		super( character, character, height, width );
		
		this.character = character;
	}
	
	public void setCharacter( char character ) {
		this.character = character;
	}
	
	/*
	 * Liefert einen Rechteckigen String bestehend aus 1 Zeichen. Die Zeichen können sich jedesmal verändern bei jedem aufruf.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		int roundedHeight = (int) Math.ceil( this.getHeight() ),
			roundedWidth =  (int) Math.ceil( this.getHeight() ),
			charCount = 0;
		
		for ( int y = 0; y < roundedHeight; y++ ) {
			for ( int x = 0; x <  roundedWidth; x++ ) {
				// oberer und unterer Rand
				if ( y == 0 || y == roundedHeight - 1 ) {
					sb.append( this.character );
				}
				// seitlicher Rand
				else if ( x == 0 || x == roundedWidth - 1 ) {
					sb.append( this.character );
				}
				// Inhalt
				else {
					sb.append( this.character );
				}
				
				charCount++;
				
				// Zeilenumbruch einfügen
				if ( charCount == roundedWidth ) {
					sb.append( "\n" );
					charCount = 0;
				}
			}
		}
		
		return sb.toString();
	}
}
