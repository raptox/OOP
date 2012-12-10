// Die Klasse Item<P> stellt einen einzelnen "Knoten" in der LinkedList dar
@Programmierer(autoren="Alexander Tornoreanu")
class Item {
	private String key;
	private CollectionItem value;
	private Item next;
	
	/**
	 * liefert neues Object
	 * @param value 
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item( String key, CollectionItem value ) {
		this.key = key;
		this.value = value;
		this.next  = null;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setKey(String key) {
		this.key = key;
	}
	
	@Programmierer(autoren="Alexander Tornoreanu")
	public String getKey() {
		return key;
	}
	
	/**
	 * setzt Wert
	 * @param value 
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setValue( CollectionItem value ) {
		this.value = value;
	}
	
	/**
	 * liefert neues Object
	 * @param value 
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public CollectionItem getValue() {
		return this.value;
	}
	
	/**
	 * liefert neues Object
	 * @param value 
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public void setNext( Item next ) {
		this.next = next;
	}
	
	/**
	 * liefert neues Object
	 * @param value 
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Item getNext() {
		return this.next;
	}
}