import java.util.ArrayList;

public abstract class AbstractAndroid {
	private int seriennummer;
	protected AbstractSoftware software;
	protected AbstractSkin skin;
	protected ArrayList<AbstractSensor> sensoren;
	
	public AbstractAndroid(int seriennummer) {
		this.seriennummer = seriennummer;
		this.software = null;
		this.skin = null;
		this.sensoren = null;
	}

	// Seriennummer hat nur getter, darf nicht veraendert werden
	public int getSeriennummer() {
		return seriennummer;
	}

	public AbstractSoftware getSoftware() {
		return software;
	}

	public void setSoftware(AbstractSoftware software) {
		this.software = software;
	}

	public AbstractSkin getSkin() {
		return skin;
	}

	public ArrayList<AbstractSensor> getSensoren() {
		return sensoren;
	}

	public void setSensoren(ArrayList<AbstractSensor> sensoren) {
		this.sensoren = sensoren;
	}
}
