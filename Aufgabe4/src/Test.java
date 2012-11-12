public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scaled<Pict> fr = new Scaled<Pict>();
		
		Clearbox c = new Clearbox(5, 3);
		Box b = new Box('+', '-', 5, 3);
		Darkbox d = new Darkbox( '#', 5, 5 );
		Freebox f = new Freebox( "asdf" );
		
		
		System.out.println( d );
		d.setCharacter('o');
		System.out.print( d );
		d.scale(1.5);
		System.out.print( d );
	}

}
