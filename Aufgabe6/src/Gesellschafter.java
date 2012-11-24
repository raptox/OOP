import java.util.ArrayList;


public abstract class Gesellschafter extends AbstractAndroid {
	public Gesellschafter(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
