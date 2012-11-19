import java.util.Iterator;
import java.util.NoSuchElementException;

class OrderedMapIterator<Q extends Shorter<Q>, P> implements Iterator<MapNode<Q, P>> {
	private Item<MapNode<Q, P>> current;
	private Item<MapNode<Q, P>> hBefore;
	private LinkedList<MapNode<Q, P>> list;
	
	public OrderedMapIterator( LinkedList<MapNode<Q, P>> list ) {
		this.list    = list;
		this.current = this.list.getRoot();
		this.hBefore = this.current;
	}
	
	public boolean hasNext() {
		if ( this.current != null ) {
			return true;
		}
		
		return false;
	}

	public MapNode<Q, P> next() {
		MapNode<Q, P> value = this.current.getValue();
		
		this.hBefore = this.current;
		
		if ( this.current == null ) { 
			throw new NoSuchElementException();
		}
		this.current = this.current.getNext();
		
		return value;
	}
	
	// liefert einen Iterator über den Objekten zurueckgibt, auf welche das aktuelle Element verweist
	public Iterator<P> iterator() {
		if ( this.hBefore != null ) {
			return this.hBefore.getValue().getValues().iterator();
		}
		
		return null;
	}

	public void remove() {
		Item<MapNode<Q, P>> hCurrent = this.list.getRoot();
		Item<MapNode<Q, P>> itemBefore = hCurrent;
		
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