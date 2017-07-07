package interfacesJavaForm.metier;

public class Chat extends Animal  implements ICarnivore{

	private String couleurPelage;
	public String getCouleurPelage() {return couleurPelage;}
	public void setCouleurPelage(String couleurPelage) {this.couleurPelage = couleurPelage;}

	public Chat(int age, String nom, String couleurPelage) {
		super(age, nom);
		setCouleurPelage(couleurPelage);
	}
	
	@Override
	public void bouger() {
		System.out.println("TELEPORTATION!!");

	}

	@Override
	public void crier() {
		System.out.println("miaouuuu");
	}
	@Override
	public String toString() {
		return "Chat [couleurPelage=" + couleurPelage + ", getAge()=" + getAge() + ", getNom()=" + getNom() + "]";
	}
	@Override
	public void capturer() {
		System.out.println("joue joue, miam");
	}

	
	
}
