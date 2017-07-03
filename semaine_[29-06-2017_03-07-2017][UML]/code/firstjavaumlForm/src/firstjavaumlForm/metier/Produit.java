package firstjavaumlForm.metier;

/**
 * @startuml
 * 
 * actor Client
 * participant Produit
 * 
 * Client -> Produit : getPrix()
 * activate Produit
 * Produit --> Client : return prix
 * deactivate Produit
 * 
 * Client -> Produit : getPoids()
 * activate Produit
 * deactivate Client
 * 
 * Produit -> Produit : calculPoids
 * 
 * Client <-- Produit : return poids
 * deactivate Produit
 * 
 * create Panier
 * Client -> Panier: <<createRequest>>
 * activate Panier
 * 
 * Panier --> Client: travail effectue
 * destroy Panier
 * 
 * @enduml
 * 
 * @startuml
*/
public class Produit {
	private int id;
	private String nom;
	private double prix;
	private double poids;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}



	public double getPoids() {
		return poids;
	}



	public void setPoids(double poids) {
		this.poids = poids;
	}



	public Produit(int id, String nom, double prix, double poids) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.poids = poids;
	}
	
	

}
