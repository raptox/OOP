// Die Klasse Item<P> stellt einen einzelnen "Knoten" in der LinkedList dar
class Item<P> {
	private P value;
	private Item<P> next;
	
	public Item( P value ) {
		this.value = value;
		this.next  = null;
	}
	
	public void setValue( P value ) {
		this.value = value;
	}
	
	public P getValue() {
		return this.value;
	}
	
	public void setNext( Item<P> next ) {
		this.next = next;
	}
	
	public Item<P> getNext() {
		return this.next;
	}
}