public class CompositeTime extends ElapsedTime{
	private double[] times;
	
	public CompositeTime(double[] times){
		this.times = times;
		this.count = times.length;
	}
	
	// liefert den kürzesten Messwert
	public double shortest() {
		double shortest = Double.MAX_VALUE;
		
		for ( int i = 0; i < this.times.length; i++ ) {
			if ( this.times[ i ] < shortest ) {
				shortest = this.times[ i ];
			}
		}
		
		return shortest;
	}
	
	private double summary(){
		double summary = 0;
		for(int i = 0; i<count;i++){
			summary += this.times[i];
		}
		return summary;
	}

	@Override
	protected Double comparableValue() {
		return this.summary();
	}

}
