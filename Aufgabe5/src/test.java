import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;



public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> s = new Set<String>();
		
		OrderedSet<ElapsedTime> os = new OrderedSet<ElapsedTime>();
		os.insert( new ElapsedTime( 10l ) );
		os.insert( new ElapsedTime( 15l ) );
		os.insert( new ElapsedTime( 20l ) );
		
		Iterator<ElapsedTime> it = os.iterator();
		while ( it.hasNext() ) {
			System.out.println( it.next().getTime() );
		}
		
		/*String h = "seas";
		System.out.println( s.insert( h ) );
		System.out.println( s.insert( "seas" ) );
		System.out.println( s.insert( "Bernd" ) );
		
		//System.out.println( s );
		
		Iterator it = s.iterator();
		
		
		//System.out.println( it.next() );
		
		while ( it.hasNext() ) {
			System.out.println( it.next() );
		}*/
		
	}

}
