package interfacesJavaForm.metier;

public class CompteSG extends Object implements ICompteBancaire , Comparable<ICompteBancaire>
{
	private double solde;
	private String noCompte;
	
	public String getNoCompte() {return noCompte;}
	public void setNoCompte(String noCompte) {this.noCompte = noCompte;}

	public CompteSG(double solde, String noCompte) {
		this.solde = solde;
		setNoCompte(noCompte);
	}
	
	@Override
	public boolean retirer(double montant) {
		if (montant < getSolde()) {
			this.solde -= montant;
			return true;
		}
		return false;
	}

	@Override
	public void deposer(double montant) {this.solde += montant;}
	@Override
	public double getSolde() {return this.solde;}
	
	@Override
	public String toString() {
		return "CompteSG [solde=" + solde + ", noCompte=" + noCompte + "]";
	}
	
	// renvoie -1 si inferieur
	// renvoie +1 si superieur
	// renvoir 0 si egal
	@Override
	public int compareTo(ICompteBancaire o) {
		if (getSolde() < o.getSolde())
			return -1;
		else if (getSolde() > o.getSolde())
			return 1;
		return 0;
	}
	
	
}
