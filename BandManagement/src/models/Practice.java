package models;
import java.util.Date;

/*
 * Klasse Practice stellt eine Probe einer Band dar
 */
public class Practice extends Play implements Costs{
	private static final long serialVersionUID = 1L;

	/*
	 * Konstruktor
	 * Vorb.: location != null && timeAndDate != null && duration > 0 && costs > 0
	 */
	public Practice(Location location, Date timeAndDate, int duration, double costs) {
    	super(location, timeAndDate, duration, costs);
    }

	/*
	 * Liefert schoenen String der Infos einer Probe
	 */
    public String toString() {
    	return super.toString()+", Rent: "+this.getCredits();
    }
}
