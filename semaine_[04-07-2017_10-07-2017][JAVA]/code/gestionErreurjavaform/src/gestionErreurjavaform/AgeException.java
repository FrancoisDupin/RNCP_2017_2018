package gestionErreurjavaform;

// si on herite de RuntimeException, l'exception sera masquable
// autrement di, java ne nous obligera pas a la gérer
public class AgeException extends Exception
{

	public AgeException(String message) {
		super(message);
	}

}
