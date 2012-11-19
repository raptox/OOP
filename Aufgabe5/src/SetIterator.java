import java.util.Iterator;
import java.util.NoSuchElementException;

class SetIterator<P> implements Iterator<P> {
		private Item<P> current;
		private LinkedList<P> list;
		
		public SetIterator( LinkedList<P> list ) {
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