package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import management.BandManagement;

/**
 * Reader stellt eine Klasse zum Einlesen von gespeicherten Daten aus einer Datei zur Verf�gung
 */
public class Reader {
	private String fileName;
	
	/**
	 * Konstruktor
	 * 
	 * Vorb.: fileName != null
	 */
	public Reader( String fileName ) {
		this.fileName = fileName;
	}
	
	/**
	 * Liest aus der Datei ein BandManagement Objekt
	 * 
	 * Vorb.: fileName muss ein Pfad sein
	 * 
	 * SCHLECHT: Es wird direkt ein Bandmanagement Objekt zur�ckgeliefert -> hohe Klassenkopplung.
	 * 			 Besser w�re es wenn man ein "Object" zur�ckliefert dass dann sp�ter erst gecastet wird.
	 */
	public BandManagement read() throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream( this.fileName + ".ser" );
		ObjectInputStream s = new ObjectInputStream(in);
		
		return (BandManagement)s.readObject();
	}
}
