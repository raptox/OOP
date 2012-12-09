import java.util.Iterator;
import java.util.NoSuchElementException;

@Programmierer(autoren="Alexander Tornoreanu")
public class HashSet<AbsCollection> implements java.lang.Iterable<AbsCollection> {
	protected LinkedList<AbsCollection> list;
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public HashSet() {
		this.list = new LinkedList<AbsCollection>();
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean insert( String key, AbsCollection element ) {
		return this.list.add( key, element );
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean hasKey(String key) {
		Item<AbsCollection> help = list.getRoot();
		
		while (help != null) {
			if (help.getKey().equals(key)) {
				return true;
			}
			help = help.getNext();
		}
		
		return false;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public String toString() {
		Item<AbsCollection> c = this.list.getRoot();
		String output = "";
		
		while( c != null ) {
			output += c.getValue() + "\n";
			c = c.getNext();
		}
		
		return output;
	}
	
	@Override
	@Programmierer(autoren="Alexander Tornoreanu")
	public Iterator<AbsCollection> iterator() {
		return new SetIterator( this.list );
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	private class SetIterator implements Iterator<AbsCollection> {
		private Item<AbsCollection> current;
		private Item<AbsCollection> lastValue;
		private LinkedList<AbsCollection> list;
		
		@Programmierer(autoren="Alexander Tornoreanu")
		public SetIterator( LinkedList<AbsCollection> list ) {
			this.list    = list;
			this.current = this.list.getRoot();
			this.lastValue = null;
		}
		
		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public boolean hasNext() {
			if ( this.current != null ) {
				return true;
			}
			
			return false;
		}

		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public AbsCollection next() {
			AbsCollection value = this.current.getValue();
			
			if ( this.current == null ) { 
				throw new NoSuchElementException();
			}
			this.lastValue = this.current;
			this.current = this.current.getNext();
			
			return value;
		}

		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public void remove() {
			Item<AbsCollection> help = this.list.getRoot();
			Item<AbsCollection> before = help;
			
			while (help != null) {
				if (help == this.lastValue) {
					if (help == before) {
						// Element am Listenanfang
						this.list.setRoot(help.getNext());
						help = null; // aus Schleife raus
					} else {
						before.setNext(help.getNext());
						help = null; // aus Schleife raus
					}
				}
				
				if (help != null) {
					before = help;
					help = help.getNext();
				}
			}
		}
	}
}
