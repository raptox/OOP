package notification;

/*
 * Das Interface Subject stellt die Methoden zur Verf�gung um Benachtichtigungen an Abonnenten zu versenden.
 */
public interface Subject {
	/*
	 * F�gt einen neuen Subscriber/Abonnent hinzu.
	 */
	public void register( Observer o );
	
	/*
	 * L�scht einen bestehenden Subscriber/Abonnent.
	 */
	public void unregister( Observer o );
	
	/*
	 * Benachrichtigt alle Subscriber/Abonnenten.
	 */
	public void announce( Announcement announcement );
}
