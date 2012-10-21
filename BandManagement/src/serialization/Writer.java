package serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Writer {
	private String fileName;
	
	public Writer( String fileName ) {
		this.fileName = fileName;
	}
	
	public void write( Object o ) throws IOException {
		File f = new File( this.fileName + ".ser" );
		
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutput s = new ObjectOutputStream(fos);
		s.writeObject( o );

		s.flush();
	}
}
