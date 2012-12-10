// Die Klasse Item stellt einen einzelnen "Knoten" in der LinkedList dar
@Programmierer(autoren="Alexander Tornoreanu")
class Item {
	private Object key;
	private CollectionItem value;
	private Item next;
	
	/*
	 * NB: liefert neues Item Object
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item( Object key, CollectionItem value ) {
		this.key = key;
		this.value = value;
		this.next  = null;
	}
	
	/*
	 * VB: key != null
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setKey(Object key) {
		this.key = key;
	}
	
	/*
	 * NB: liefert key
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Object getKey() {
		return key;
	}
	
	/*
	 * VB: value != null
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setValue( CollectionItem value ) {
		this.value = value;
	}
	
	/*
	 * NB: liefert value
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public CollectionItem getValue() {
		return this.value;
	}
	
	/*
	 * VB: next != null
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setNext( Item next ) {
		this.next = next;
	}
	
	/*
	 * NB: liefert naechstes Element der Liste
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item getNext() {
		return this.next;
	}
}