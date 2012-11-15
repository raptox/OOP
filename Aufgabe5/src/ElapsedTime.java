public class ElapsedTime implements Shorter<ElapsedTime> {
	private long time;
	
	public ElapsedTime( long time ) {
		this.time = time;
	}
	
	@Override
	public boolean shorter(ElapsedTime arg) {
		if ( this.time < arg.time ) {
			return true;
		}
		
		return false;
	}
	
	public long getTime() {
		return this.time;
	}
}
