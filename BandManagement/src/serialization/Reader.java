package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import models.Band;

public class Reader {
	private String fileName;
	
	public Reader( String fileName ) {
		this.fileName = fileName;
	}
	
	public Band read() throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream( this.fileName + ".ser" );
		ObjectInputStream s = new ObjectInputStream(in);
		
		return (Band)s.readObject();
	}
}
