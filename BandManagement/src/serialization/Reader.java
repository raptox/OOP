package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import management.BandManagement;

public class Reader {
	private String fileName;
	
	public Reader( String fileName ) {
		this.fileName = fileName;
	}
	
	public BandManagement read() throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream( this.fileName + ".ser" );
		ObjectInputStream s = new ObjectInputStream(in);
		
		return (BandManagement)s.readObject();
	}
}
