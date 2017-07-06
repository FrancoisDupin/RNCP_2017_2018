package heritageJavaform.vivant;

public class Vegetal {
	
	public void test() {
		Animal a1 = new Animal(2,  "jhg", 42);
		// les classes dans le même package
		// ont aussi access au protected des autres
		// en plus de celles qui sont des descendant
		a1.nom = "hoho";
	}

}
