public abstract class AbstractBox implements Pict {
	private double height;
	private double width;
	
	private char borderCharacter;
	private char innerCharacter;
	
	public AbstractBox( char borderCharacter, char innerCharacter, double height, double width ) {
		this.height = height;
		this.width  = width;
		this.borderCharacter = borderCharacter;
		this.innerCharacter = innerCharacter;
	}
	
	protected double getHeight() {
		return this.height;
	}
	
	protected double getWidth() {
		return this.width;
	}
	
	// 0.1 <= factor <= 10.0; resize the picture
	public void scale(double factor) {
		this.height *= factor;
		this.width  *= factor;
	}
	
	/*
	 * Liefert einen Rechteckigen String bestehend aus 2 Zeichen. Ein Zeichen 
	 * steht am Rand, eines steht nur Innen. Der String besteht bei jedem
	 * Aufruf aus den gleichen Zeichen.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		int roundedHeight = (int) Math.ceil( this.height ),
			roundedWidth =  (int) Math.ceil( this.width ),
			charCount = 0;
		
		for ( int y = 0; y < roundedHeight; y++ ) {
			for ( int x = 0; x <  roundedWidth; x++ ) {
				// oberer und unterer Rand
				if ( y == 0 || y == roundedHeight - 1 ) {
					sb.append( this.borderCharacter );
				}
				// seitlicher Rand
				else if ( x == 0 || x == roundedWidth - 1 ) {
					sb.append( this.borderCharacter );
				}
				// Inhalt
				else {
					sb.append( this.innerCharacter );
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
