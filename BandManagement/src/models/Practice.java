package models;
import java.util.Date;

/*
 * Klasse Practice stellt eine Probe einer Band dar
 */
//GUT: dynamisches Binden, Costs, es gibt nur eine Methode getCredits und zwar in Credits
public class Practice extends Play{
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
