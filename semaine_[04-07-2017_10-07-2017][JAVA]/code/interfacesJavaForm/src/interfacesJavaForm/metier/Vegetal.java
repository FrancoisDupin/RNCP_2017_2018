package interfacesJavaForm.metier;

public abstract class Vegetal {
	private int age;
	private String espece;
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public String getEspece() {return espece;}
	public void setEspece(String espece) {this.espece = espece;}
	
	
	public Vegetal(int age, String espece) {
		super();
		setAge(age);
		setEspece(espece);
	}
	
	public abstract void pousser();
	
	
	

}
