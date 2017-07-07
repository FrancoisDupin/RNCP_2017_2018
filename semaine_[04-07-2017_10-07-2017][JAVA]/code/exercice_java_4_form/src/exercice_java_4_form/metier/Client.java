package exercice_java_4_form.metier;

public class Client extends Personne {

	private String noClient;
	private double soldeCompte;
	
	public String getNoClient() {return noClient;}
	public void setNoClient(String noClient) {this.noClient = noClient;}
	public double getSoldeCompte() {return soldeCompte;}
	public void setSoldeCompte(double soldeCompte) {this.soldeCompte = soldeCompte;}

	
	public Client(String nom, String prenom, String email, String noClient, double soldeCompte) {
		super(nom, prenom, email);
		setNoClient(noClient);
		setSoldeCompte(soldeCompte);
	}
	
	@Override
	public void contacter(String message) {
		System.out.println("moi, client " + getNoClient() 
							+ " ai recu un message : " + getNom() + " votre message " + message);
	}
	@Override
	public String toString() {
		return "Client [noClient=" + noClient + ", soldeCompte=" + soldeCompte + ", nom=" + getNom()
				+ ", prenom=" + getPrenom() + ", email=" + getEmail() + "]";
	}
	
	@Override
	public String sauver() {
		return "Client;" + getAllFields();
	}
	@Override
	public String getAllFields() {
		return super.getAllFields() + ";" + getNoClient() + ";" + getSoldeCompte();
	}
	

	
	
}
