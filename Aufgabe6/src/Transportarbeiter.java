import java.util.ArrayList;


public class Transportarbeiter extends AbstractSchwerarbeiter {
	public Transportarbeiter(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
