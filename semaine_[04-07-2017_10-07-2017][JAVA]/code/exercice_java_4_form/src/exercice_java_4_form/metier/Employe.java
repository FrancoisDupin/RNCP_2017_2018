package exercice_java_4_form.metier;

public class Employe extends Personne {
	private double salaire;
	private String poste;
	
	public double getSalaire() {return salaire;}
	public void setSalaire(double salaire) {this.salaire = salaire;}
	public String getPoste() {return poste;}
	public void setPoste(String poste) {this.poste = poste;}

	
	public Employe(String nom, String prenom, String email, double salaire, String poste) {
		super(nom, prenom, email);
		setSalaire(salaire);
		setPoste(poste);
	}
	
	
	
	@Override
	public void contacter(String message) {
		System.out.println("moi employe au poste " + getPoste() 
		+ " ai recu une message : " + getNom() + " votre message " + message);

	}
	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + ", poste=" + poste + ", nom=" + getNom() 
		+ ", prenom=" + getPrenom() + ", email=" + getEmail() + "]";
	}
	
	@Override
	public String getAllFields() {
		return super.getAllFields() + ";" + getSalaire() + ";" + getPoste();
	}
	
	

}
