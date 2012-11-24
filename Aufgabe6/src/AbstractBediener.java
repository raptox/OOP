import java.util.ArrayList;


public abstract class AbstractBediener extends AbstractAndroid {
	public AbstractBediener(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
