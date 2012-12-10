/*
 * Die Klasse LinkedList stellt eine einfach verketette Liste von Item Objekten dar
 */
@Programmierer(autoren="Alexander Tornoreanu")
class LinkedList {
	protected Item root;
	
	/*
	 * Konstruktor
	 * 
	 * NB: liefert neues LinkedList Objekt
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public LinkedList() {
		this.root = null;
	}
	
	/*
	 * Fuegt neues Item in die Liste ein, mit einem beliebigen Key
	 * 
	 * VB: key != null, element != null
	 * NB: true falls erfolgreich, false wenn nicht erfolgreich
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean add( Object key, CollectionItem element ) {
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
	
	/*
	 * Getter fuer die Wurzel der Liste
	 * 
	 * NB: liefert Wurzel der Verketetten Liste
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item getRoot() {
		return this.root;
	}
	
	/*
	 * Setter fuer die Wurzel der Liste
	 * 
	 * VB: root != null
	 * NB: setzt die Wurzel des Items
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setRoot( Item root ) {
		this.root = root;
	}
}