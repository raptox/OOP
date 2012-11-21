import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set<P> implements java.lang.Iterable<P> {
	protected LinkedList<P> list;
	
	public Set() {
		this.list = new LinkedList<P>();
	}
	
	public boolean insert( P element ) {
		return this.list.add( element );
	}
	
	public String toString() {
		Item<P> c = this.list.getRoot();
		String output = "";
		
		while( c != null ) {
			output += c.getValue() + "\n";
			c = c.getNext();
		}
		
		return output;
	}
	
	@Override
	public Iterator<P> iterator() {
		return new SetIterator( this.list );
	}
	
	private class SetIterator implements Iterator<P> {
		private Item<P> current;
		private Item<P> lastValue;
		private LinkedList<P> list;
		
		public SetIterator( LinkedList<P> list ) {
			this.list    = list;
			this.current = this.list.getRoot();
			this.lastValue = null;
		}
		
		@Override
		public boolean hasNext() {
			if ( this.current != null ) {
				return true;
			}
			
			return false;
		}

		@Override
		public P next() {
			P value = this.current.getValue();
			
			if ( this.current == null ) { 
				throw new NoSuchElementException();
			}
			this.lastValue = this.current;
			this.current = this.current.getNext();
			
			return value;
		}

		@Override
		public void remove() {
			Item<P> help = this.list.getRoot();
			Item<P> before = help;
			
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
