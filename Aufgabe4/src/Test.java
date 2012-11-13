public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Clearbox c = new Clearbox(5, 3);
		Box b = new Box('+', '-', 5, 3);
		Darkbox d = new Darkbox( '#', 5, 5 );
		Freebox f = new Freebox("geil\nhomo\nnega");
		f.scale(1.5);
		System.out.println(f);
		
		
		System.out.println( d );
		d.setCharacter('o');
		System.out.print( d );
		d.scale(1.5);
		System.out.print( d );
	}

}
