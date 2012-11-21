public class OrderedSet<P extends Shorter<? super P>> extends Set<P> {
	public OrderedSet() {
		this.list = new SortedLinkedList<P>();
	}
}
