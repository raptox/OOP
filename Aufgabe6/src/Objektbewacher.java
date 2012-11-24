import java.util.ArrayList;


public class Objektbewacher extends AbstractBeschuetzer {
	public Objektbewacher(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
