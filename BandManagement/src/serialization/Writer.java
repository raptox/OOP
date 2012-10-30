package serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Writer stellt eine Klasse zum Speichern von einem Objekt dar.
 */
public class Writer {
	private String fileName;
	
	/**
	 * Konstruktor
	 * 
	 * Vorb.: fileName != null
	 */
	public Writer( String fileName ) {
		this.fileName = fileName;
	}
	
	/**
	 * Schreibt ein komplettes Objekt in eine Datei
	 * 
	 * Vorb.: fileName muss ein Pfad sein
	 */
	public void write( Object o ) throws IOException {
		File f = new File( this.fileName + ".ser" );
		
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutput s = new ObjectOutputStream(fos);
		s.writeObject( o );

		s.flush();
	}
}
