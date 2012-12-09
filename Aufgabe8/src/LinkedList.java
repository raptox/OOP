@Programmierer(autoren="Alexander Tornoreanu")
class LinkedList {
	protected Item root;
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public LinkedList() {
		this.root = null;
	}
	
	// Fuegt ein neues Element hinzu
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean add( String key, CollectionItem element ) {
		Item current = this.root;
		
		// noch keine Element in der Liste, initialisiere root Element
		if ( this.root == null ) {
			this.root = new Item( key, element );
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
			current.setNext( new Item( key, element ) );
		}
		
		return true;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item getRoot() {
		return this.root;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setRoot( Item root ) {
		this.root = root;
	}
}