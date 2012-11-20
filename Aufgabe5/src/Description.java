public class Description implements Shorter<Description> {
	private String text;
	
	public Description( String text ) {
		this.text = text;
	}
	
	@Override
	public boolean shorter(Description arg) {
		if ( this.text.length() < arg.getText().length() ) {
			return true;
		}
		
		return false;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int countLines(){
		return this.text.split("\n").length;
	}
	
	@Override
	public String toString() {
		return this.text;
	}
	
}
