import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface Programmierer {
	String autoren(); // Autor der Klasse/Methode
}


