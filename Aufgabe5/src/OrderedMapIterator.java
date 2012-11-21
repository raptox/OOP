import java.util.Iterator;
import java.util.NoSuchElementException;

class OrderedMapIterator<Q extends Shorter<? super Q>, P> implements Iterator<MapNode<Q, P>> {
	private Item<MapNode<Q, P>> current;
	private Item<MapNode<Q, P>> hBefore;
	private Item<MapNode<Q, P>> vorher;
	private LinkedList<MapNode<Q, P>> list;
	
	public OrderedMapIterator( LinkedList<MapNode<Q, P>> list ) {
		this.list    = list;
		this.current = this.list.getRoot();
		this.hBefore = this.current;
		this.vorher = null;
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
		this.vorher = this.current;
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
		Item<MapNode<Q, P>> help = this.list.getRoot();
		Item<MapNode<Q, P>> before = help;
		
		while (help != null) {
			if (help == this.vorher) {
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