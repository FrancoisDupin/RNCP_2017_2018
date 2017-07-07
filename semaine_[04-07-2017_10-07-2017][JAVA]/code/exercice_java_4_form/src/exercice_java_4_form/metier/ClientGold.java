package exercice_java_4_form.metier;

public class ClientGold extends Client {
	
	private double reduction;

	public double getReduction() {return reduction;}
	public void setReduction(double reduction) {this.reduction = reduction;}
	
	public ClientGold(String nom, String prenom, String email, String noClient, double soldeCompte, double reduction) {
		super(nom, prenom, email, noClient, soldeCompte);
		setReduction(reduction);
	}
	
	@Override
	public String toString() {
		return "ClientGold [reduction=" + reduction + ", getNoClient()=" + getNoClient() + ", getSoldeCompte()="
				+ getSoldeCompte() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getEmail()="
				+ getEmail() + "]";
	}
	@Override
	public String sauver() {
		return "ClientGold;" + getAllFields(); 
	}
	@Override
	public String getAllFields() {
		return super.getAllFields() + ";" + getReduction();
	}
	
	
	
	
	

}
