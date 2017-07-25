package designPatternsIntermediateForm;

public class Program {

	public static void main(String[] args) {

		// ici le Computer.Builder est un builder renvoyant
		// une instance de Computer
		// cependant, un Buildre n'est pas forcement une classe
		// interne ou directement liée à l'objet construit
		Computer c1 = new Computer.Builder("intel core 2", 16)
								  .addClavier()
								  .addDisqueDur("ssd 128go")
								  .addCarteReseau("gigabit ethernet")
								  .addDisqueDur("hdd 4to")
								  .build();
		
		System.out.println(c1);
		
		String str = new StringBuilder("hello")
						.append(" world")
						.append('\n')
						.reverse()
						.insert(3, '#')
						.toString();
		
		System.out.println(str);
		
		/*Computer c2 = new Computer.Builder("arm 7", 2)
									//.addCarteReseau("10 megabit")
								  .build();
		*/
		System.out.println("------------------------------");
		
		DeplacementFactory f = new DeplacementFactory();
		// j'utilise la factory pour me fournir le deplacement
		Deplacement d1 = f.buildDeplacement("paris", "londre");
		System.out.println(d1);
		System.out.println("duree = " + d1.getDuree());
		
		Deplacement d2 = f.buildDeplacement("paris", "bordeaux", "madrid");
		System.out.println(d2);
		System.out.println("duree = " + d2.getDuree());
		
	}

}
