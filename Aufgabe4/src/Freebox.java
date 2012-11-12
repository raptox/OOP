public class Freebox implements Pict {
	private String box;
	
	private double height;
	private double width;
	
	public Freebox( String box ) {
		this.box = box;
		this.height = this.getHeight( box );
		this.width = this.getWidth( box );
	}
	
	private int getHeight( String box ) {
		return 1;
	}
	
	private int getWidth( String box ) {
		return 1;
	}
	

	public void scale(double factor) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Liefert einen Rechteckigen String. 
	 */
	@Override
	public String toString() {
		return "Freebox";
	}

}
