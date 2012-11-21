public abstract class ElapsedTime<P extends Shorter<P>> implements Shorter<P> {
	protected int count;
	
	@Override
	public abstract boolean shorter(P arg);
	
	public int count() {
		return this.count;
	}
}
