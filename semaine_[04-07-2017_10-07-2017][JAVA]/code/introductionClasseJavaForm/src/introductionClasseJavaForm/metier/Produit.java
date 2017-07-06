package introductionClasseJavaForm.metier;
// le mot clé package permet d'indiquer dans quel
// package sera situé la classe

// le mot clé class permet de déclarer une classe
// un nom de classe commence par une Majuscule

public class Produit {
	// attributs
	// public -> tout le monde y a access
	// private -> seule ma classe y a access
	public int id;
	public String nom;
	private double prix; // j'ai protégé prix, j'aimerais quand même pouvoir le lire/ecrire de l'exterieur
	public double poids;
	
	/*
	 * dans certains langage, il existe des constructions syntaxiques spéciales
	 *  exemple: c# properties
	 * en java ce n'est pas le cas, en fait les accesseur/getter/setter
	 * sont des methodes comme les autres (rien de particulier pour java)
	 * 
	 * ceci étant, il est FORTEMENT recommandé de suivre certaines regles a leur ecriture
	 * 
	 * les setter renvoie void et se nomme 'set' + nom de l'attribut en CamelCase
	 * on capitalise la premiere lettre du nom de l'attribut
	 * poids -> setPoids
	 * POIDS -> setPOIDS
	 * 
	 * pour les getters
	 * renvoie la veleur voulue et n'on pas de paramettre
	 * comme les setter sauf que 'get' au lieu de 'set' a une exception pret
	 * 
	 * dans le cas ou l'attribut visé est de type boolean
	 * on a le droit de nommer le getter 'is' au lieur de 'get'
	 * getActive ou isActive
	 * 
	 * ces regles sont importante (même si java lui-même ne s'y interesse pas)
	 * car cela définit une partie du fonctionnement attendu des java beans 
	 * 
	 * toutes les librairie/framework qui manipule vos objets en java (en particulier les beans)
	 * s'attende a rencontrer des getter/setter respectant ces regles de nommage
	 */
	public double getPrix() {
		return this.prix;
	}
	public void setPrix(double prix) {
		// un des pieges classique est de faire un getter/setter recursif
		this.prix = (prix > 0) ? prix : 0.01;
	}
	
	
	// constructeur
	// methode qui a le même nom que la classe
	// et qui n'a PAS de type de retour
	public Produit(int id, String nom, double prix, double poids) {
		// une methode constructeur sera appelée automatiquement
		// par java lors d'un 'new' de cete objet
		// quand on instancie un objet, il y a 2 etapes
		//  1) la jvm alloue la mémoire et initialise l'objet vide
		//  2) la jvm appelle notre constructeur pour initialiser/configurer
		// le contenu de l'objet
		
		// toutes les methode (d'instance) d'un objet on automatiquement
		// une 'variable' this qui pointe vers l'objet sur lequel elle est appelé
		// dans un constructeur, this reference le nouvel objet a initialiser
		
		// si une methode recoit un argument ou declare une variable locale
		// qui a le même nom qu'un attribut, celle ci a priorité
		// sauf si on utilise 'this'
		
		// java fournit un cosntructeur par defaut, sans parametre, qui ne fait rien
		// mais ne le fait plus pour votre classe des qu'au moins un constructeur
		// est ecrit par vous
		this.id = id;
		this.nom = nom;
		setPrix(prix);
		this.poids = poids;
	}
	
	public Produit() {
		// si on ne met rien, numerique -> 0, boolean -> false, char -> 0
		// objet (String par exemple) -> null
		
		// on a le doit de rappeler un constructeur depuis un autre
		// le chainage vers un autre constructeur est forcement la
		// permiere chose que fait un constructeur
		this(0, "noname", 0.01, 0.01);
		
		/*this.id = 0;
		this.nom = "noname";
		this.prix = 0.01;
		this.poids = 0.01;*/
	}
	
	// methodes
	
	public void affiche() {
		// le mot clé this, s'il n'y a pas d'ambiguité, est facultatif
		// quand java rencontre un nom de variable 
		// A) regarde si une variable locale ou argument de ce nom existe
		// B) sinon, il regarde si un attribut de ce nom existe
		// C) sinon erreur
		
		//String nom = "toto";
		System.out.println("produit: " + nom + " ; prix = " + this.prix);
	}
	
}
