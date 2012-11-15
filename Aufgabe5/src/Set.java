import java.util.Iterator;
import java.util.NoSuchElementException;


public class Set<P> implements java.lang.Iterable {
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
	public Iterator iterator() {
		class LinkedIterator<P> implements Iterator<P> {
			private Item<P> current;
			private LinkedList list;
			
			public LinkedIterator( LinkedList list ) {
				this.list    = list;
				this.current = this.list.getRoot();
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
				this.current = this.current.getNext();
				
				return value;
			}

			@Override
			public void remove() {
				Item<P> hCurrent = this.list.getRoot();
				Item<P> itemBefore = hCurrent;
				
				while( hCurrent != null ) {
					// aktuelles Element gefunden
					if ( hCurrent == this.current ) {
						if ( hCurrent == this.list.getRoot() ) {
							this.list.setRoot( null );
							this.current = null;
						}
						// akutelles Element wird aus Liste rausgehängt
						itemBefore.setNext( hCurrent.getNext() );
					}
					
					// voriges Element zwischenspeichern
					itemBefore = hCurrent;
					// Zeiger auf nächstes Element verschieben
					hCurrent = hCurrent.getNext();
					
					this.current = itemBefore.getNext();
				}
			}
			
		}
		
		return new LinkedIterator<P>( this.list );
	}
}
