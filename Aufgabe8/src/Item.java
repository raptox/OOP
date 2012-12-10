// Die Klasse Item stellt einen einzelnen "Knoten" in der LinkedList dar
@Programmierer(autoren="Alexander Tornoreanu")
class Item {
	private Object key;
	private CollectionItem value;
	private Item next;
	
	/*
	 * Konstruktor
	 * 
	 * NB: liefert neues Item Object
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item( Object key, CollectionItem value ) {
		this.key = key;
		this.value = value;
		this.next  = null;
	}
	
	/*
	 * Setter fuer key
	 * 
	 * VB: key != null
	 * NB: setzt den Key des Items
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setKey(Object key) {
		this.key = key;
	}
	
	/*
	 * Getter fuer key
	 * 
	 * NB: liefert key
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Object getKey() {
		return key;
	}
	
	/*
	 * Setter fuer value
	 * 
	 * VB: value != null
	 * NB: setzt den Wert des Items
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setValue( CollectionItem value ) {
		this.value = value;
	}
	
	/*
	 * Getter fuer value
	 * 
	 * NB: liefert value
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public CollectionItem getValue() {
		return this.value;
	}
	
	/*
	 * Setter fuer Zeiger auf naechstem Element
	 * 
	 * VB: next != null
	 * NB: setzt das naechste Element des Items
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setNext( Item next ) {
		this.next = next;
	}
	
	/*
	 * Getter fuer Zeiger auf naechstes Element
	 * 
	 * NB: liefert naechstes Element der Liste
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item getNext() {
		return this.next;
	}
}