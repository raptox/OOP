import java.util.Iterator;
import java.util.HashMap;


public class AndroidList {
	private HashMap<Integer, AbstractAndroid> androids;
	
	public AndroidList() {
		this.androids = new HashMap<Integer, AbstractAndroid>();
	}
	
	public boolean insert( AbstractAndroid android ) {
		if(android.getSkin() == null || android.getSoftware() == null || android.getKit() == null){
			return false;
		}
		AbstractAndroid foundAndroid = this.androids.get( android.getSeriennummer() );
		
		// Android bereits in Liste -> Aenderung
		if ( foundAndroid != null ) {
			foundAndroid.skin = android.getSkin();
			foundAndroid.software = android.getSoftware();
			foundAndroid.kit = android.getKit();
		}
		// Neuen Android einfügen
		else {
			this.androids.put( android.getSeriennummer(), android );
		}
		return true;
	}
	
	public Iterator<AbstractAndroid> iterator() {
		return this.androids.values().iterator();
	}
	
	public String find( int seriennummer ) {
		AbstractAndroid android = this.androids.get( seriennummer );
		String beschreibung = "";
		
		if ( android != null ) {
			beschreibung += "Seriennummer: " + android.getSeriennummer() + "\n";
			beschreibung += "Skin: " + android.getSkin();
			
			return beschreibung;
		}
		
		return null;
	}
}
