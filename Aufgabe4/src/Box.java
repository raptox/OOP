public class Box extends AbstractBox {
	private char borderCharacter;
	private char innerCharacter;
	
	public Box( char borderCharacter, char innerCharacter, double height, double width ) {
		super( borderCharacter, innerCharacter, height, width );
		this.borderCharacter = borderCharacter;
		this.innerCharacter = innerCharacter;
	}
}
