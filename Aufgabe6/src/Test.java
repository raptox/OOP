
public class Test {
	public static void main(String[] args) {
		AndroidList androids = new AndroidList();
		
	
		//System.out.println( getSkinInstallationMessage( h.getSkin() ) );
	}
	
	public static String getSkinInstallationMessage( AbstractSkin skin ) {
		if ( skin == null ) {
			return "Skin konnte nicht installiert werden!";
		}
		
		return skin.beschreibung;
	}
}
