public class Test {
	/*
	 *                                               Pict
	 *                                               ----
	 *                                                ^
	 *                                                |
	 *                                   -------------|-------------              
	 *                                  |             |             |
	 *								    |             |             |  
	 *                             AbstractBox	   FreeBox       Repeated<P>
	 *                             -----------	   -------       -----------
	 *                              ^       ^						 ^
	 *                              |       |          				 |
	 *                              |       |                        |
	 *                              |       |                        |
 	 *                             Box   Darkbox				  Scaled<P>
	 *                             ---	 -------				  ---------
	 *                              ^
	 *                              |   
	 *                              |   
	 *                           Clearbox
	 *                           --------
	 *                           
	 * 
	 * Box <-> ClearBox  -  Hier ist ClearBox ein Untertyp, da wie bei Box auch zwei Zeichen für den Rand und Inhalt verwendet werden und sich nicht
	 *				 	    mehr nachträglich ändern
	 *
     * Box <-> DarkBox   -  Hier gibt es keine Untertypbeziehung, da DarkBox nur aus einem Zeichen besteht und dieses nachträglich verändert werden kann
     * Box <-> FreeBox   -  Hier gibt es keien Untertypbeziehung, da die Skalierung von Freebox anders erfolgt und beim Initialisieren FreeBox einen
	 *						rechteckigen Text bekommt anstatt von zwei Zeichen
 	 *
     * ClearBox <-> DarkBox  -  Keine Untertypbeziehung, da Clearbox zwei Zeichen erhält und fix bleiben und Darkbox nur eines dass sich verändert.
	 *
	 * ClearBox <-> FreeBox  -  Hier gibt es keine Untertypbeziehung, da die Skalierung von Freebox anders erfolgt und Freebox einen rechteckigen String erhält
	 *
	 * DarkBox <-> FreeBox  -  Hier gibt es keien Untertypbeziehung, da FreeBox einen rechteckigen Text erhält und fix bleibt und Darkbox nur eines dass sich verändert.
	 * 
	 * Repeated<P> für Untertypen von Pict <-> Scaled<P> für unbekannte erlaubte P  -  Hier ist zweiteres ein Untertyp von ersterem
	 * 
	 * 
	 * 
	 */
		
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
		System.out.print( f );
		
		String[][] s = new String[5][5];
		Repeated<String> r = new Repeated<String>( s );
		
		Box[][] boxes = new Box[2][2];
		
		Scaled<Pict> scal = new Scaled<Pict>( boxes );
		System.out.println( scal.toString() );
	}

}
