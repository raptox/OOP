import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;



public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> s = new Set<String>();
		
		
		
		OrderedSet<Description> od = new OrderedSet<Description>();
		od.insert( new Description( "aa" ) );
		od.insert( new Description( "aa" ) );
		od.insert( new Description( "aab" ) );
		od.insert( new Description( "a" ) );
		od.insert( new Description( "aabaa" ) );
		
		Iterator<Description> it = od.iterator();
		while ( it.hasNext() ) {
			System.out.println( it.next().getText() );
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
