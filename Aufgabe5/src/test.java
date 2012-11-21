import java.io.IOException;
import java.util.Iterator;




public class test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args){

		// Testfall 1
		System.out.println("Testfall 1:\n###########");

		OrderedSet<Description> od = new OrderedSet<Description>();
		od.insert( new Description( "cc" ) );
		od.insert( new Description( "aa" ) );
		od.insert( new Description( "aab" ) );
		od.insert( new Description( "a" ) );
		od.insert( new Description( "aabaa" ) );

		System.out.println("<<Sortierung>>");

		Iterator<Description> it = od.iterator();
		Description help;
		while ( it.hasNext() ) {
			help = it.next();
			System.out.print( help.getText() );
			System.out.println(" lines:" + help.countLines());
		}

		System.out.println("<<Loeschen + neu einfuegen, Sortierung>>");

		it = od.iterator();
		while ( it.hasNext() ) {
			help = it.next();
			if (help.getText().equals("aabaa") || help.getText().equals("aa")) {
				it.remove();
			}
		}

		od.insert(new Description( "asdf"));
		od.insert(new Description( "eeeeasdf"));
		od.insert(new Description( "foobar"));

		it = od.iterator();
		while ( it.hasNext() ) {
			help = it.next();
			System.out.print( help.getText() );
			System.out.println(" lines:" + help.countLines());
		}

		// Testfall 2
		System.out.println("\nTestfall 2:\n###########");

		MeanElapsedTime me = new MeanElapsedTime();
		me.addTime(10.0);
		me.addTime(1500.5);
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
		CompositeTime ct = new CompositeTime(new double[]{2.0,3.0,4.0,5,6.5});
		CompositeTime ct2 = new CompositeTime(new double[]{1.0,0.3,4.0,10.0,6.5});

		CompositeTime ct3 = new CompositeTime(new double[]{1.0,3.0,4.0,10.0,0.00001});
		CompositeTime ct4 = new CompositeTime(new double[]{1.0,3.0,4.0,10.0,6.5});
		CompositeTime ct5 = new CompositeTime(new double[]{0.01,3.0,4.0,10.0,100.9});
		CompositeTime ct6 = new CompositeTime(new double[]{0.6,3.0,4.0,10.0,6.5});		

		// erstellen von OrderedSet von CompositeTime Objekten
		OrderedSet<CompositeTime> orderedCompositeTimes = new OrderedSet<CompositeTime>();
		orderedCompositeTimes.insert( ct );
		orderedCompositeTimes.insert( ct2 );

		// Set von CompositeTime Objekten (unsortiert)
		Set<CompositeTime> compositeTimes2 = new Set<CompositeTime>();
		compositeTimes2.insert( ct3 );
		compositeTimes2.insert( ct4 );
		compositeTimes2.insert( ct5 );
		compositeTimes2.insert( ct6 );
		
		// erstellen einer OrderedMap mit MeanElapsedTime Objekten die auf CompositeTime Objekten verweisen
		// dabei werden die MeanElapsedTime Objekte soertiert, die CompositeTime Objekte NICHT
		OrderedMap<MeanElapsedTime, CompositeTime> om = new OrderedMap<MeanElapsedTime, CompositeTime>();
		om.insert( me, orderedCompositeTimes );
		om.insert( me2, compositeTimes2 );

		OrderedMapIterator<MeanElapsedTime, CompositeTime> itOm = om.iterator();
		MapNode<MeanElapsedTime, CompositeTime> current;
		Iterator<CompositeTime> valuesIterator;

		while ( itOm.hasNext() ) {
			current = itOm.next();
			valuesIterator = itOm.iterator();

			System.out.println( "Laengster Messwert: " + current.getKey().longest() );

			while ( valuesIterator.hasNext() ) {
				System.out.println( "Kuerzester Messwert: " + valuesIterator.next().shortest() );
			}

		}

		if(ct.shorter(ct2)){
			System.out.println("passt");
		}
		else System.out.println("passt nicht");

		if(me.shorter(me2)){
			System.out.println("passt");
		}
		else System.out.println("passt nicht");		

		
		
		// Testfall 3
		System.out.println("\nTestfall 3:\n###########");
		System.out.println("OrderedMap ist kein Untertyp von OrderedSet. Hier wurde nur Vererbung verwendet um doppelten Code zu vermeiden.");
		
		
		// Testfall 4
		System.out.println("\nTestfall 4:\n###########");

		OrderedSet<ElapsedTime> odset = new OrderedSet<ElapsedTime>();
		odset.insert(me);
		odset.insert(ct);
	}

}
