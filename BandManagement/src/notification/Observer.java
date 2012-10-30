package notification;

/*
 * Das Interface Observer stellt sicher, dass bei der Verwendung des Observer Pattern auch die 
 * konkret implementierte Klasse alle notwendigen Methoden enth�lt.
 */
public interface Observer {
	/*
	 * Diese Methode wird aufgerufen, wenn eine neue Benachrichtigung an die Subscriber erfolgt
	 */
	public void update( Announcement announcement );
}
