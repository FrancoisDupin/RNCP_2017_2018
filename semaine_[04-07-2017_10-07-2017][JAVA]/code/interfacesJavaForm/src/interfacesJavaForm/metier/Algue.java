package interfacesJavaForm.metier;

public class Algue extends Vegetal implements IAquatique {
	private String couleur;
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Algue(int age, String espece, String couleur) {
		super(age, espece);
		this.couleur = couleur;
	}
	
	@Override
	public void pousser() {
		System.out.println(getEspece() + " je pousse vers la surface...");
	}
	@Override
	public String toString() {
		return "Algue [couleur=" + couleur + ", getAge()=" + getAge() + ", getEspece()=" + getEspece() + "]";
	}
	@Override
	public String getTypeMillieux() {
		return "ocean";
	}
	@Override
	public double getProfondeurMax() {
		return 20.0;
	}

}
