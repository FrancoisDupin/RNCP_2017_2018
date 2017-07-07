package interfacesJavaForm.metier;

public class Dauphin extends Animal implements IAquatique,ICarnivore {
	private double taille;
	
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}
	
	public Dauphin(int age, String nom, double taille) {
		super(age, nom);
		setTaille(taille);
	}
	
	@Override
	public void bouger() {
		System.out.println("nage, nage, boulb bloub");

	}

	@Override
	public void crier() {
		System.out.println("iiiitaktaktakiii");
	}
	
	@Override
	public String toString() {
		return "Dauphin [taille=" + taille + ", getAge()=" + getAge() + ", getNom()=" + getNom() + "]";
	}
	@Override
	public String getTypeMillieux() {
		return "ocean";
	}
	@Override
	public double getProfondeurMax() {
		return 400.0;
	}
	@Override
	public void capturer() {
		System.out.println("miam la sardine, bloub miam");
	}

}
