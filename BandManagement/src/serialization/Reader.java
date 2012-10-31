package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import management.BandManagement;

/**
 * Reader stellt eine Klasse zum Einlesen von gespeicherten Daten aus einer Datei zur Verfügung
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
	 * SCHLECHT: Es wird direkt ein Bandmanagement Objekt zurückgeliefert -> hohe Klassenkopplung.
	 * 			 Besser wäre es wenn man ein "Object" zurückliefert dass dann später erst gecastet wird.
	 */
	public BandManagement read() throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream( this.fileName + ".ser" );
		ObjectInputStream s = new ObjectInputStream(in);
		
		return (BandManagement)s.readObject();
	}
}
