package notification;

/*
 * Das Interface Subject stellt die Methoden zur Verfügung um Benachtichtigungen an Abonnenten zu versenden.
 */
public interface Subject {
	/*
	 * Fügt einen neuen Subscriber/Abonnent hinzu.
	 */
	public void register( Observer o );
	
	/*
	 * Löscht einen bestehenden Subscriber/Abonnent.
	 */
	public void unregister( Observer o );
	
	/*
	 * Benachrichtigt alle Subscriber/Abonnenten.
	 */
	public void announce( Announcement announcement );
}
