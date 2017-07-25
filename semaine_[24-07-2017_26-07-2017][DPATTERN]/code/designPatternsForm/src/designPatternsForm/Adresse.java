package designPatternsForm;

// mes objets de type Adresse son effectivement
// immutable, on ne peut changer leur valeur une fois creer
public class Adresse {
	private final String rue;
	private final String ville;
	private final String codePostal;
	private final String pays;
	
	public String getRue() {return rue;}
	public String getVille() {return ville;}
	public String getCodePostal() {return codePostal;}
	public String getPays() {return pays;}
	
	public Adresse(String rue, String ville, String codePostal, String pays) {
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
	}
	
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + ", pays=" + pays + "]";
	}
	
	public Adresse changeRue(String rue) {
		return new Adresse(rue, this.ville, this.codePostal, this.pays);
	}
	

}
