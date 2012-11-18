public class MeanElapsedTime extends ElapsedTime<MeanElapsedTime> {
	private Set<Double> times;
	
	public MeanElapsedTime() {
		this.times = new Set<Double>();
	}
	
	public void addTime( Double time ) {
		this.times.insert( time );
	}
	
	@Override
	public boolean shorter(MeanElapsedTime arg) {
		return true;
	}
}
