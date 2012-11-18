import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


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
	
	public int countLines() throws IOException{
		BufferedReader br = new BufferedReader(new StringReader(this.text));
		int counter = 0;
		while(br.readLine()!=null){
			counter++;
		}
		
		return counter;
	}
	
	@Override
	public String toString() {
		return this.text;
	}
	
}
