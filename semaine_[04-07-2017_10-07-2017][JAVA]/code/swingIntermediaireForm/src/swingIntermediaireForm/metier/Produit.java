package swingIntermediaireForm.metier;

import java.util.function.Predicate;

public class Produit {
	
	public static final Predicate<Produit> ALL_CATEGORIES_FILTER 
										= p -> true;
	public static final Predicate<Produit> VIANDES_CATEGORIES_FILTER 
										= p -> p.getCategorie().equals("viandes");
	public static final Predicate<Produit> FROMAGES_CATEGORIES_FILTER 
										= p -> p.getCategorie().equals("fromages");
	public static final Predicate<Produit> CEREALES_CATEGORIES_FILTER 
										= p -> p.getCategorie().equals("cereales");
	public static final Predicate<Produit> LEGUMES_CATEGORIES_FILTER 
										= p -> p.getCategorie().equals("legumes");
	public static final Predicate<Produit> DIVERS_CATEGORIES_FILTER 
										= p -> p.getCategorie().equals("divers");
	
	
	private int id;
	private String nom;
	private double prix;
	private double poids;
	private String categorie;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	public double getPoids() {return poids;}
	public void setPoids(double poids) {this.poids = poids;}
	public String getCategorie() {return categorie;}
	public void setCategorie(String categorie) {this.categorie = categorie;}
	
	public Produit() { this(0, "", 0.0, 0.0, "divers");}
	public Produit(int id, String nom, double prix, double poids, String categorie) {
		setId(id);
		setNom(nom);
		setPrix(prix);
		setPoids(poids);
		setCategorie(categorie);
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", poids=" + poids + ", categorie=" + categorie
				+ "]";
	}

	
	
	
	

}
