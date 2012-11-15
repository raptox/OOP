public abstract class ElapsedTime implements Shorter<ElapsedTime> {
	protected int count;
	
	@Override
	public abstract boolean shorter(ElapsedTime arg);
	
	public int count() {
		return this.count;
	}
}
