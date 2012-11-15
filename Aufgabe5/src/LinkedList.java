class LinkedList<P> {
	protected Item<P> root;
	
	public LinkedList() {
		this.root = null;
	}
	
	// Fuegt ein neues Element hinzu
	public boolean add( P element ) {
		Item<P> current = this.root;
		
		// noch keine Element in der Liste, initialisiere root Element
		if ( this.root == null ) {
			this.root = new Item<P>( element );
		}
		// mehrere Elemente in der Liste vorhanden
		else {
			while ( current.getNext() != null ) {
				// wenn identisches Objekt bereits in Liste vorhanden ist, nichts einfuegen
				if ( current.getValue() == element ) {
					return false;
				}
				current = current.getNext();
			}
			// nochmal ueberpruefen ob ein identisches Objekt bereits in Liste vorhanden ist, dann nichts einfuegen
			if ( current.getValue() == element ) {
				return false;
			}
			
			// Zeiger auf nächstes Element setzen
			current.setNext( new Item<P>( element ) );
		}
		
		return true;
	}
	
	public P get( P value ) {
		Item<P> current = root;
		
		if ( current.getValue().equals( value ) ) {
			return current.getValue();
		}
		
		while( ( current = current.getNext() ) != null ) {
			if ( current.getValue().equals( value ) ) {
				return current.getValue();
			}
		}
		
		return null;
	}
	
	public Item<P> getRoot() {
		return this.root;
	}
	
	public void setRoot( Item<P> root ) {
		this.root = root;
	}
}