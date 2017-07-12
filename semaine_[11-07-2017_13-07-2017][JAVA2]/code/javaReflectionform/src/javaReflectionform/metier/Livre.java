package javaReflectionform.metier;

public class Livre {
	
	private int id;
	private String titre;
	private String auteur;
	private int nbPages;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	public String getAuteur() {return auteur;}
	public void setAuteur(String auteur) {this.auteur = auteur;}
	public int getNbPages() {return nbPages;}
	public void setNbPages(int nbPages) {this.nbPages = nbPages;}
	
	public Livre() {}
	public Livre(int id, String titre, String auteur, int nbPages) {
		setId(id);
		setTitre(titre);
		setAuteur(auteur);
		setNbPages(nbPages);
	}
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", nbPages=" + nbPages + "]";
	}
	
	
	
	

}
