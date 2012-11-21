public class MapNode<P extends Shorter<? super P>, Q> implements Shorter<MapNode<P, Q>>{
	private P key;
	private Set<Q> values;
	
	public MapNode( P key, Set<Q> values ) {
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
