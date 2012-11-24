import java.util.ArrayList;


public class Hilfskraft extends AbstractBediener {
	public Hilfskraft(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
		this.skin = skin.setHilfskraftSkin(this);
	}
}
