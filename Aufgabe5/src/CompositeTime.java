
public class CompositeTime extends ElapsedTime<CompositeTime>{
	
	private double[] times;
	public CompositeTime(double[] times){
		this.times = times;
		this.count = times.length;
	}

	@Override
	public boolean shorter(CompositeTime arg) {
		return this.summary()<arg.summary();
	}
	
	private double summary(){
		double summary = 0;
		for(int i = 0; i<count;i++){
			summary += this.times[i];
		}
		return summary;
	}

}
