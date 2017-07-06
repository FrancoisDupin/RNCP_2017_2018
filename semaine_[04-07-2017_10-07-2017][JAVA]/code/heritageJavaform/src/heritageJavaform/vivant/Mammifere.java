package heritageJavaform.vivant;

// quand on herite d'une classe
// on recuper tous les attributs et méthodes du parent
public abstract class Mammifere extends Animal
{
	private int dureeGestation;
	
	public int getDureeGestation() {return dureeGestation;}
	public void setDureeGestation(int dureeGestation) {this.dureeGestation = dureeGestation;}
	
	public static void description() {
		System.out.println("description de Mammifere");
	}
	
	public Mammifere(int age, String nom, double poids, int dureeGestation) {
		super(age, nom, poids);
		setDureeGestation(dureeGestation);
	}
	
	public abstract void crier();
	
	@Override
	public void bouger() {
		System.out.println("moi, mammifere " + getNom() + " me deplace");
	}
	
	@Override
	public String toString() {
		// on a la possibilité de rappeler explicitement une méthode
		// du parent, même si nous l'avons overridé
		return super.toString() + " et je suis aussi un mammifere";
	}
	
	
	

	
	
	
}
