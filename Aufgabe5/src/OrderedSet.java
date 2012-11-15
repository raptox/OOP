import java.util.Iterator;


public class OrderedSet<P extends Shorter> extends Set<P> {
	public OrderedSet() {
		this.list = new SortedLinkedList<P>();
	}
}
