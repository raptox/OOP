import java.util.ArrayList;

public abstract class AbstractAndroid {
	protected final int seriennummer;
	protected AbstractSoftware software;
	protected AbstractSkin skin;
	protected ArrayList<AbstractSensor> sensoren;
	
	public AbstractAndroid(int seriennummer) {
		this.seriennummer = seriennummer;
		this.software = null;
		this.skin = null;
		this.sensoren = null;
	}

	/* === GETTER === */
	
	// Seriennummer hat nur getter, darf nicht veraendert werden
	public int getSeriennummer() {
		return seriennummer;
	}

	public AbstractSoftware getSoftware() {
		return software;
	}
	
	public AbstractSkin getSkin() {
		return skin;
	}

	public ArrayList<AbstractSensor> getSensoren() {
		return sensoren;
	}

	/* === SETTER === */
	
	//public abstract void setSoftware(AbstractSoftware software, AbstractSecurity sec);

	public abstract void setSkin(AbstractSkin skin);
	
	public abstract void setSensoren(ArrayList<AbstractSensor> sensoren);
	
	/* === other methods === */
	
}
