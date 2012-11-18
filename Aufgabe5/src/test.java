import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;



public class test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Set<String> s = new Set<String>();
		
		
		
		OrderedSet<Description> od = new OrderedSet<Description>();
		od.insert( new Description( "aa" ) );
		od.insert( new Description( "aa" ) );
		od.insert( new Description( "aab" ) );
		od.insert( new Description( "a" ) );
		od.insert( new Description( "aabaa" ) );
		
		MeanElapsedTime me = new MeanElapsedTime();
		me.addTime(10.0);
		me.addTime(150.5);
		me.addTime(30.33);
		me.addTime(50.33);
		me.addTime(10.43);
		
		MeanElapsedTime me2 = new MeanElapsedTime();
		me2.addTime(10.0);
		me2.addTime(150.5);
		me2.addTime(30.33);
		me2.addTime(50.33);
		me2.addTime(30.43);
		
		CompositeTime ct = new CompositeTime(new double[]{1.0,3.0,4.0,5.0,6.5});
		CompositeTime ct2 = new CompositeTime(new double[]{1.0,3.0,4.0,10.0,6.5});
		
		if(ct.shorter(ct2)){
			System.out.println("passt");
		}
		else System.out.println("passt nicht");
		
		if(me.shorter(me2)){
			System.out.println("passt");
		}
		else System.out.println("passt nicht");
		
		Description a = new Description("hallo\nich programmiere\na");
		System.out.println(a.countLines());
		
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
