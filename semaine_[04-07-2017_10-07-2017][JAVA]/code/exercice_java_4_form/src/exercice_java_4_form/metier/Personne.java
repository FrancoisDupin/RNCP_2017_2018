package exercice_java_4_form.metier;

public abstract class Personne {

	private String nom;
	private String prenom;
	private String email;
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public Personne(String nom, String prenom, String email) {
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
	}
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
	public abstract void contacter(String message);
	public abstract String sauver();
	
	public String getAllFields() {
		return getNom() + ";" + getPrenom() + ";" + getEmail();
	}
	
	
}
