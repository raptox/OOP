public class OrderedSet<P extends Shorter<P>> extends Set<P> {
	public OrderedSet() {
		this.list = new SortedLinkedList<P>();
	}
}
