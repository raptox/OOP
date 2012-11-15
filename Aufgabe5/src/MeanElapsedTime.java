public class MeanElapsedTime extends ElapsedTime {
	private Set<Double> times;
	
	public MeanElapsedTime() {
		this.times = new Set<Double>();
	}
	
	public void addTime( Double time ) {
		this.times.insert( time );
	}
	
	@Override
	public boolean shorter(ElapsedTime arg) {
		return true;
	}

}
