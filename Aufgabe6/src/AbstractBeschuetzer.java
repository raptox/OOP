import java.util.ArrayList;


public abstract class AbstractBeschuetzer extends AbstractAndroid {
	public AbstractBeschuetzer(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
