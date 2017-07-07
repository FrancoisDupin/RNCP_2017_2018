package interfacesJavaForm.metier;

public class Dionaea extends Vegetal implements ICarnivore{
	private String sol;
	
	public String getSol() {return sol;}
	public void setSol(String sol) {this.sol = sol;}


	public Dionaea(int age, String espece, String sol) {
		super(age, espece);
		setSol(sol);
	}
	@Override
	public void pousser() {
		System.out.println(getEspece() + " je pousse (miam miam)");

	}
	@Override
	public String toString() {
		return "Dionaea [sol=" + sol + ", getAge()=" + getAge() + ", getEspece()=" + getEspece() + "]";
	}
	@Override
	public void capturer() {
		System.out.println("......");
	}

	
}
