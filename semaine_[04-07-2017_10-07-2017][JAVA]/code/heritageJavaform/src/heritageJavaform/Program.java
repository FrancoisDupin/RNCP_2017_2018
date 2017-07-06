package heritageJavaform;

import heritageJavaform.vivant.Animal;
import heritageJavaform.vivant.Chat;
import heritageJavaform.vivant.Mammifere;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a1 = new Animal(5, "chouchou", 15.6);
		System.out.println(a1);
		a1.bouger();
		
		
		/*Mammifere m1 = new Mammifere(12, "flipper", 75, 7);
		m1.bouger();
		System.out.println(m1);
		*/
		Chat c1 = new Chat(5, "garfield", 7.5, 2, 0.5);
		System.out.println(c1);
		c1.bouger();
		
		Mammifere m2 = c1;
		Animal a2 = c1;
		
		// le polymorphisme
		// pour choisir la bonne variante de la méthode a appeler
		// il examine le veritable type concret de l'objet
		// il ne se base pas sur le type "fixe" de la variable
		System.out.println(m2.toString());
		a2.bouger();
		
		//c1.faireRien();
		// animal -> chat
		a2 = c1;
		if (a2 instanceof Chat) {
			Chat c2 = (Chat)a2;
			c2.faireRien();
			c2.crier();
		}
		else {
			System.out.println("c'est pas un chat!");
		}
		
		System.out.println("a2 instanceof Chat ? " + (a2 instanceof Chat));
		System.out.println("a2 instanceof Mammifere ? " + (a2 instanceof Mammifere));
		
		System.out.println(a2.getClass().getName());
		
		Mammifere m1 = c1;
		// j'ai une instance de chat dans une variable Mammifere
		//							 dans une variable Chat
		
		c1.description();
		// ici, il appelera le description de Mammifere, car il
		// se base sur le type de la variable pour les methodes statique
		m1.description();
		//Chat.description();
	}

}
