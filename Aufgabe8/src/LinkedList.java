@Programmierer(autoren="Alexander Tornoreanu")
class LinkedList<AbsCollection> {
	protected Item<AbsCollection> root;
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public LinkedList() {
		this.root = null;
	}
	
	// Fuegt ein neues Element hinzu
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean add( String key, AbsCollection element ) {
		Item<AbsCollection> current = this.root;
		
		// noch keine Element in der Liste, initialisiere root Element
		if ( this.root == null ) {
			this.root = new Item<AbsCollection>( key, element );
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
			current.setNext( new Item<AbsCollection>( key, element ) );
		}
		
		return true;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item<AbsCollection> getRoot() {
		return this.root;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setRoot( Item<AbsCollection> root ) {
		this.root = root;
	}
}