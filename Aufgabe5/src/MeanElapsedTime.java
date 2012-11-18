import java.util.Iterator;

public class MeanElapsedTime extends ElapsedTime<MeanElapsedTime> {
	private Set<Double> times;
	
	public MeanElapsedTime() {
		this.count = 0;
		this.times = new Set<Double>();
	}
	
	public void addTime( Double time ) {
		this.times.insert( time );
		this.count++;
	}
	
	@Override
	public boolean shorter(MeanElapsedTime arg) {
		return this.average()<arg.average();
	}
	
	private double average(){
		Iterator<Double> i = this.times.iterator();
		double average = 0;
		while(i.hasNext()){
			average += i.next();
		}
		return average/this.count;
	}

}
