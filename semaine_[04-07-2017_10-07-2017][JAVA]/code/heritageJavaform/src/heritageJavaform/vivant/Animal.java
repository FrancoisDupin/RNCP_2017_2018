package heritageJavaform.vivant;

// si l'on ne precise rien sur l'heritage (on ne specifie pas de quelle classe on herite)
// alors par défaut on herite de la classe Object
// cette classe est a la racine de l'heritage java, autrement dit
// tous les objets en java herite forcement (directment ou indirectment) de la classe Object

public class Animal {
	private int age;
	protected String nom;
	private double poids;
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public double getPoids() {return poids;}
	public void setPoids(double poids) {this.poids = poids;}
	
	
	public Animal(int age, String nom, double poids) {
		setAge(age);
		setNom(nom);
		setPoids(poids);
	}
	
	public void bouger() {
		System.out.println("moi, animal " + getNom() + " me deplace");
	}
	
	@Override
	public String toString() {
		return "Animal [age=" + age + ", nom=" + nom + ", poids=" + poids + "]";
	}
	
	
	

}
