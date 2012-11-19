import java.io.IOException;
import java.util.Iterator;




public class test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		
		
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
		me2.addTime(154.5);
		me2.addTime(300.33);
		me2.addTime(50.33);
		me2.addTime(30.43);
		
		// erstellen von CompositeTime Objekten
		CompositeTime ct = new CompositeTime(new double[]{1.0,3.0,4.0,0.01,6.5});
		CompositeTime ct2 = new CompositeTime(new double[]{1.0,0.3,4.0,10.0,6.5});
		CompositeTime ct3 = new CompositeTime(new double[]{1.0,3.0,4.0,10.0,0.00001});
		CompositeTime ct4 = new CompositeTime(new double[]{1.0,3.0,4.0,10.0,6.5});
		
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
		
		
		// erstellen von OrderedSet's von CompositeTime Objekten
		OrderedSet<CompositeTime> orderedCompositeTimes = new OrderedSet<CompositeTime>();
		orderedCompositeTimes.insert( ct );
		orderedCompositeTimes.insert( ct2 );
		
		OrderedSet<CompositeTime> orderedCompositeTimes2 = new OrderedSet<CompositeTime>();
		orderedCompositeTimes2.insert( ct3 );
		orderedCompositeTimes2.insert( ct4 );
		
		// erstellen einer OrderedMap mit MeanElapsedTime Objekten die auf CompositeTime Objekten verweisen
		OrderedMap<MeanElapsedTime, CompositeTime> om = new OrderedMap<MeanElapsedTime, CompositeTime>();
		om.insert( me, orderedCompositeTimes );
		om.insert( me2, orderedCompositeTimes2 );
	
		Iterator<MapNode<MeanElapsedTime, CompositeTime>> itOm = om.iterator();
		MapNode<MeanElapsedTime, CompositeTime> current;
		Iterator<CompositeTime> valuesIterator;
		
		while ( itOm.hasNext() ) {
			current = itOm.next();
			valuesIterator = current.getValues().iterator();
			
			System.out.println( "Laengster Messwert: " + current.getKey().longest() );
			
			while ( valuesIterator.hasNext() ) {
				System.out.println( "Kuerzester Messwert: " + valuesIterator.next().shortest() );
			}
			
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
		}
		
		*
		*
		*
		
		
		
		
	
	
		*/
		
	}

}
