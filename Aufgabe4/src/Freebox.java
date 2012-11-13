public class Freebox implements Pict {
	private String box;
	private double height;
	private double width;
	
	/*
	 * Es wird ein Text uebergeben (box!=null) der nacher nicht mehr veraenderbar ist.
	 */
	public Freebox( String box ) {
		this.box = box;
		this.width = this.getWidth();
		this.height = this.getHeight();
	}
	
	/*
	 * getHeight liefert die Hoehe der unveraenderbaren Box zurueck
	 */
	private int getHeight(){
		return (int) (getLineBox().length()/getWidth());
	}
	
	/*
	 * getWidth liefert die Breite der unveraenderbaren Box zurueck
	 */
	private int getWidth() {
		int i = 0;
		while(box.charAt(i)!='\n'&&i<box.length()-1){
			i++;
		}
		if(box.length()-1==i){
			i++;
		}
		return i;
	}
	

	/*
	 * scale veraendert nur die gespeicherte Breite und Hoehe 
	 */
	public void scale(double factor) {
		this.width = Math.ceil(width*factor);
		this.height = Math.ceil(height*factor);
	}
	
	/*
	 * Liefert einen Rechteckigen String. Die Zeichen innerhalb der Box werden nicht veraendert!
	 */
	@Override
	public String toString() {
		String ret = "";
		String lineBox = getLineBox();
		int boxWidth = getWidth();
		int boxHeight = getHeight();
		
		for(int j = 0;j<this.height;j++){
			for(int i = 0;i<this.width;i++){
				ret+=lineBox.charAt(((j%boxHeight)*boxWidth)+i%boxWidth);
			}
			ret+='\n';
		}
		return ret;
	}
	
	/*
	 * Liefert einen String der Box ohne \n zurueck
	 */
	private String getLineBox(){
		String lineBox = "";
		for(int i = 0;i<box.length();i++) {
			if(box.charAt(i)!='\n'){
				lineBox += box.charAt(i);
			}
		}
		return lineBox;

	}

}
