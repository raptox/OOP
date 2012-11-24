
public class Test {
	public static void main(String[] args) {
		AndroidList androids = new AndroidList();
		
		Hilfskraft h = new Hilfskraft(1, null, new Gepanzert(), null);
		
		androids.insert( h );
		
		System.out.println( androids.find( 1 ) );
		
		androids.insert( new Hilfskraft(1, null, new Beruehrungssensitiv(), null) );
	
		System.out.println( androids.find( 1 ) );
		//System.out.println( getSkinInstallationMessage( h.getSkin() ) );
	}
	
	public static String getSkinInstallationMessage( AbstractSkin skin ) {
		if ( skin == null ) {
			return "Skin konnte nicht installiert werden!";
		}
		
		return skin.beschreibung;
	}
}
