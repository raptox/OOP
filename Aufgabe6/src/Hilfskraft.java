import java.util.ArrayList;


public class Hilfskraft extends AbstractBediener {
	public Hilfskraft(int seriennummer) {
		super(seriennummer);
		this.skin = skin.setHilfskraftSkin(this);
	}
}
