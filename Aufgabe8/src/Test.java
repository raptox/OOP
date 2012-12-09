import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bauernhof bHof = new Bauernhof( "Bauernhof 1" );
		
		DieselTraktor dieselT = new DieselTraktor( 1, 0.0, new Duengerstreuer(500.5), 0 );
		
		if ( dieselT.getRolle().getEinsatzzweck().equals( Einsatzzweck.DRILLMASCHINE ) ) {
			System.out.print( "Drillmaschine - Anzahl Saeschare: " );
		}
		else {
			System.out.print( "Duengerstreuer - Kapazitaet: " );
		}
		
		System.out.println( dieselT.getRolle().getValue() );
		
		dieselT.setRolle( new Drillmaschine( 99 ) );
		
		if ( dieselT.getRolle().getEinsatzzweck().equals( Einsatzzweck.DRILLMASCHINE ) ) {
			System.out.print( "Drillmaschine - Anzahl Saeschare: " );
		}
		else {
			System.out.print( "Duengerstreuer - Kapazitaet: " );
		}
		
		System.out.print( dieselT.getRolle().getValue() );
		
		
		// Collections Test
		System.out.println("\nCollections Test: \n");
		HashSet col = new HashSet();
		
		col.insert("b1", bHof);
		col.insert("t1", dieselT);
		
		System.out.println("Iterator Test:");
		// ITerator Test
		Iterator<AbsCollection> it = col.iterator(); 
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
		
		System.out.println("hasKey Test:");
		System.out.println("hasKey(b1) = "+col.hasKey("b1"));
		System.out.println("hasKey(xxxyyy) = "+col.hasKey("xxxyyy"));
		
		
		/*Annotation[] as = Bauernhof.class.getAnnotations(); // all
		System.out.println( as.length );
		for ( int i = 0; i < as.length; i++ ) {
			System.out.println( as[ i ] );
		}*/
	}
}
