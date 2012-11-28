import java.util.Iterator;
import java.util.HashMap;


public class AndroidList {
	private HashMap<Integer, AbstractAndroid> androids;
	
	public AndroidList() {
		this.androids = new HashMap<Integer, AbstractAndroid>();
	}
	
	public void insert( AbstractAndroid android ) {
		AbstractAndroid foundAndroid = this.androids.get( android.getSeriennummer() );
		
		// Android bereits in Liste -> Aenderung
		if ( foundAndroid != null ) {
			foundAndroid.skin = android.getSkin();
		}
		// Neuen Android einfügen
		else {
			this.androids.put( android.getSeriennummer(), android );
		}
	}
	
	public Iterator<AbstractAndroid> iterator() {
		return this.androids.values().iterator();
	}
	
	public String find( int seriennummer ) {
		AbstractAndroid android = this.androids.get( seriennummer );
		String beschreibung = "";
		
		if ( android != null ) {
			beschreibung += "Seriennummer: " + android.getSeriennummer() + "\n";
			beschreibung += "Skin: " + android.getSkin() + "\n";
			beschreibung += "Software: " + android.getSoftware() + "\n";
			beschreibung += "Kit: " + android.getKit();
			
			return beschreibung;
		}
		
		return null;
	}
}
