import java.util.Iterator;
import java.util.NoSuchElementException;

@Programmierer(autoren="Alexander Tornoreanu")
public class HashSet {
	protected LinkedList list;
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public HashSet() {
		this.list = new LinkedList();
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean insert( Object key, CollectionItem element ) {
		return this.list.add( key, element );
	}
	
	// liefert false wenn Element nicht gefunden
	public boolean removeValue( Object key ) {
		Item help = list.getRoot();
		Item before = help;
		
		while (help != null) {
			if (help.getKey().toString().equals(key.toString())) {
				// remove object
				before.setNext(help.getNext());
				return true;
			}
			before = help;
			help = help.getNext();
		}
		
		return false;		
	}
	
	// liefert null wenn Element nicht gefunden
	public CollectionItem getValue( Object key ) {
		Item help = list.getRoot();
		
		while (help != null) {
			if (help.getKey().toString().equals(key.toString())) {
				return help.getValue();
			}
			help = help.getNext();
		}
		
		return null;	
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean hasKey(Object key) {
		Item help = list.getRoot();
		
		while (help != null) {
			if (help.getKey().toString().equals(key.toString())) {
				return true;
			}
			help = help.getNext();
		}
		
		return false;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public String toString() {
		Item c = this.list.getRoot();
		String output = "";
		
		while( c != null ) {
			output += c.getValue() + "\n";
			c = c.getNext();
		}
		
		return output;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public Iterator iterator() {
		return new SetIterator( this.list );
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	private class SetIterator implements Iterator {
		private Item current;
		private Item lastValue;
		private LinkedList list;
		
		@Programmierer(autoren="Alexander Tornoreanu")
		public SetIterator( LinkedList list ) {
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
		public CollectionItem next() {
			CollectionItem value = this.current.getValue();
			
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
			Item help = this.list.getRoot();
			Item before = help;
			
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
