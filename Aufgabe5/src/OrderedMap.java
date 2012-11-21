public class OrderedMap<Q extends Shorter<? super Q>, P> extends OrderedSet<MapNode<Q, P>> {
	public OrderedMap() {
		this.list = new SortedLinkedList<MapNode<Q, P>>();
	}
	
	public void insert( Q key, Set<P> values ) {
		this.list.add( new MapNode<Q, P>( key, values ) );
	}
	
	@Override
	public OrderedMapIterator<Q, P> iterator() {
		return new OrderedMapIterator<Q, P>( this.list );
	}
}
