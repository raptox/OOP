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
	 *                           Zeilen (Hilfsklasse fuer Repeated)
	 *                           ------
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
		Freebox f = new Freebox("aaaa\nbbbb\ncccc");
		f.scale(1.5);
		System.out.println(f);
		
		
		System.out.println( d );
		d.setCharacter('o');
		System.out.print( d );
		d.scale(1.5);
		System.out.print( f );
		
		
		
		
		Pict [][] dfg = new Pict[2][3];
		dfg[0][0] = new Clearbox(2,2);
		dfg[0][1] = new Freebox("hallo\nblabl\nfffff");
		dfg[0][2] = new Clearbox(3,3);

		dfg[1][0] = new Clearbox(4,4);
		dfg[1][1] = new Darkbox('a', 5, 5);
		dfg[1][2] = new Box('s','t',3,3);
		
		
		System.out.println("Repeated Tests:\n#############\n");
		Repeated<Pict> abc = new Repeated<Pict>(dfg);
		
		System.out.println("Before scaled: \n"+abc.toString());
		abc.scale(1.5);
		System.out.println("After scaled 1.5: \n"+abc.toString());
		
		
		System.out.println("Scaled Tests:\n#############\n");
		Scaled<Pict> jjj = new Scaled<Pict>(dfg);
		System.out.println("Before scaled: \n"+jjj.toString());
		jjj.scale(2);
		System.out.println("After scaled 2: \n"+jjj.toString());
		
		/*Object [][] foo = new Object[2][3];
		foo[0][0] = new String("asdlkfjasd");
		foo[0][1] = new Freebox("hallo\nblabl\nfffff");
		foo[0][2] = new Integer(2);

		foo[1][0] = new Clearbox(4,4);
		foo[1][1] = new Darkbox('a', 5, 5);
		foo[1][2] = new Box('s','t',3,3);
		
		System.out.println("Repeated Tests (diffrent objects):\n#############\n");
		Repeated<Object> bar = new Repeated<Object>(foo);
		
		System.out.println("Before scaled: \n"+bar.toString());
		abc.scale(1.5);
		System.out.println("After scaled 1.5: \n"+bar.toString());*/
		
	}

}
