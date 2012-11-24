import java.util.ArrayList;


public abstract class AbstractSchwerarbeiter extends AbstractAndroid {
	public AbstractSchwerarbeiter(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
