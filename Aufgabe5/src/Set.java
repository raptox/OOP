import java.util.Iterator;

public class Set<P> implements java.lang.Iterable<P> {
	protected LinkedList<P> list;
	
	public Set() {
		this.list = new LinkedList<P>();
	}
	
	public boolean insert( P element ) {
		return this.list.add( element );
	}
	
	public String toString() {
		Item<P> c = this.list.getRoot();
		String output = "";
		
		while( c != null ) {
			output += c.getValue() + "\n";
			c = c.getNext();
		}
		
		return output;
	}
	
	@Override
	public Iterator<P> iterator() {
		return new SetIterator<P>( this.list );
	}
}
