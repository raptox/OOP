
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
	
	// liefert den längsten Messwert
	public double longest() {
		Iterator<Double> it = this.times.iterator();
		double longest = -1,
			   current;
		
		while( it.hasNext() ) {
			current = it.next();
			
			if ( current > longest ) {
				longest = current;
			}
		}
		
		return longest;
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
