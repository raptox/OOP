import java.util.ArrayList;


public class Bauarbeiter extends AbstractSchwerarbeiter {
	public Bauarbeiter(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
