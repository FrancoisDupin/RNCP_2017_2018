package interfacesJavaForm.metier;

// pour declarer une  interface en java
// utiliser le mot clé interface a la pace de class
public interface ICompteBancaire {
	public static final String IBAN_DEFAUT = "343543554135";
	
	
	// dans une interface, pas d'etat ni de code (jusqu'a java 7)
	// quand on declare une methode, elle est automatiquement
	// abstract et publique
	// charge a celui qui implemente l'interface (qui en herite)
	// de fournir le code correspondant
	boolean retirer(double montant);
	void deposer(double montant);
	double getSolde();
	
}
