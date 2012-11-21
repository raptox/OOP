public abstract class ElapsedTime implements Shorter<ElapsedTime> {
	protected int count;
	
	public boolean shorter(ElapsedTime arg) {
		return this.comparableValue() < arg.comparableValue();
	}
	
	abstract protected Double comparableValue();
	
	public int count() {
		return this.count;
	}
}
