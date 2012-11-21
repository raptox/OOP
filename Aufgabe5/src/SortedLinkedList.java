class SortedLinkedList<P extends Shorter<? super P>> extends LinkedList<P> {
	// Fuegt ein neues Element hinzu
	public boolean add( P element ) {
		Item<P> current = this.root;
		Item<P> before = current;
		Item<P> newItem = new Item<P>( element );
		
		// noch keine Element in der Liste, initialisiere root Element
		if ( this.root == null ) {
			this.root = new Item<P>( element );
		}
		// mehrere Elemente in der Liste vorhanden
		else {
			//current.getValue().shorter( element );
			while ( current != null ) {
				// wenn identisches Objekt bereits in Liste vorhanden ist, nichts einfuegen
				if ( current.getValue() == element ) {
					return false;
				}
				
				// wenn aktuelles Element groeßer als das einzufuegende ist, dann fuege es davor ein
				if ( element.shorter( current.getValue() ) ) {
					newItem.setNext( current );
					
					// neues Element wird als neuer Root Knoten gesetzt
					if ( this.root == current ) {
						this.root = newItem;
					}
					// neues Element wird zwischen zwei Elementen eingehaengt
					else {
						before.setNext( newItem );
					}
					return true;
				}
				
				before = current;
				current = current.getNext();
			}
			
			// als letztes einfuegen
			before.setNext( newItem );
		}
		
		return true;
	}
}
