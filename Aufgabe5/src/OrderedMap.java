public class OrderedMap<Q extends Shorter<Q>, P extends Shorter<P>> extends OrderedSet<MapNode<Q, P>> {
	public OrderedMap() {
		this.list = new SortedLinkedList<MapNode<Q, P>>();
	}
	
	public void insert( Q key, OrderedSet<P> values ) {
		this.list.add( new MapNode<Q, P>( key, values ) );
	}
}
