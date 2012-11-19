public class MapNode<P extends Shorter<P>, Q extends Shorter<Q>> implements Shorter<MapNode<P, Q>>{
	private P key;
	private OrderedSet<Q> values;
	
	public MapNode( P key, OrderedSet<Q> values ) {
		this.key = key;
		this.values = values;
	}
	
	public Set<Q> getValues() {
		return this.values;
	}
	
	public P getKey() {
		return this.key;
	}

	@Override
	public boolean shorter(MapNode<P, Q> arg) {
		return this.key.shorter( arg.key );
	}
}
