import java.util.Iterator;
import java.util.NoSuchElementException;


public class Set<P> implements java.lang.Iterable {
	private LinkedList<P> list;
	
	public Set() {
		this.list = new LinkedList<P>();
	}
	
	public boolean insert( P element ) {
		return this.list.add( element );
	}
	
	public String toString() {
		Item<P> c = this.list.root;
		String output = "";
		
		while( c != null ) {
			output += c.value + "\n";
			c = c.next;
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
				this.current = this.list.root;
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
				P value = this.current.value;
				
				if ( this.current == null ) { 
					throw new NoSuchElementException();
				}
				this.current = this.current.next;
				
				return value;
			}

			@Override
			public void remove() {
				Item<P> hCurrent = this.list.root;
				Item<P> itemBefore = hCurrent;
				
				while( hCurrent != null ) {
					// aktuelles Element gefunden
					if ( hCurrent == this.current ) {
						if ( hCurrent == this.list.root ) {
							this.list.root = null;
							this.current = null;
						}
						// akutelles Element wird aus Liste rausgehängt
						itemBefore.next = hCurrent.next;
					}
					
					// voriges Element zwischenspeichern
					itemBefore = hCurrent;
					// Zeiger auf nächstes Element verschieben
					hCurrent = hCurrent.next;
					
					this.current = itemBefore.next;
				}
			}
			
		}
		
		return new LinkedIterator<P>( this.list );
	}
	
	
	
	private class LinkedList<P> {
		private Item<P> root;
		
		public LinkedList() {
			this.root = null;
		}
		
		public boolean add( P element ) {
			Item<P> current = this.root;
			
			if ( this.root == null ) {
				this.root = new Item<P>( element );
			}
			else {
				while ( current.next != null ) {
					if ( current.value == element ) {
						return false;
					}
					current = current.next;
				}
				if ( current.value == element ) {
					return false;
				}
				
				current.next = new Item<P>( element );
			}
			
			return true;
		}
		
		public P get( P value ) {
			Item<P> current = root;
			
			if ( current.value.equals( value ) ) {
				return current.value;
			}
			
			while( ( current = current.next ) != null ) {
				if ( current.value.equals( value ) ) {
					return current.value;
				}
			}
			
			return null;
		}
	}
	
	private class Item<P> {
		private P value;
		private Item next;
		
		public Item( P value ) {
			this.value = value;
			this.next  = null;
		}
		
		public void setValue( P value ) {
			this.value = value;
		}
		
		public P getValue() {
			return this.value;
		}
		
		public void setNext( Item next ) {
			this.next = next;
		}
		
		public Item getNext() {
			return this.next;
		}
	}
	
}
