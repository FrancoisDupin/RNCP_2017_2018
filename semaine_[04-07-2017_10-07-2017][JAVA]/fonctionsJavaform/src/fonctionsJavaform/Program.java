package fonctionsJavaform;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("votre nom?");
		String saisie = reader.nextLine();
		
		salutation(saisie);
		salutation(saisie, "mr");
		
		System.out.println(carre(3));
		
		int i = 15;
		int j = 27;
		System.out.println("i = " + i + " et j = " + j);
		echange(i, j);
		System.out.println("i = " + i + " et j = " + j);
		
		int[] tab = {15, 27 };
		System.out.println("[" + tab[0]  + ", " + tab[1] + "]");
		echange(tab);
		System.out.println("[" + tab[0]  + ", " + tab[1] + "]");
		
		
	}
	// ici, le type de retour de cette methode est void -> vide,
	// pas de valeur retournée
	// le nom de la fonction, avec les même regles de nommage
	// que pour les variables (alphabetique + chiffre + _, mais ne pas commencer par chiffre)
	// entre parenthese, la liste des arguments passés en parametre a la fonction
	// séparé par des ,
	// attention, même si la fonction ne prend aucun parametre, les parenthese sont obligatoires
	public static void salutation(String nom) {
		//saisie = "hohoho";
		System.out.println("bonjour, " + nom);
	}
	
	public static void salutation(String nom, String civilite) {
		System.out.println("bonjour, " + civilite + " " + nom);
	}
	/*
	public static String salutation(String denomination) {
		return "";
	}*/
	
	public static double carre(double x) {
		//if (x > 2)
			return x * x;
		//else
		//	return 0;
	}
	
	public static void echange(int x, int y) {
		System.out.println("x = " + x + " et y = " + y);
		int z = x;
		x = y;
		y = z;
		System.out.println("x = " + x + " et y = " + y);
	}
	
	public static void echange(int[] values) {
		int z = values[0];
		values[0] = values[1];
		values[1] = z;
		//values = new int[5];
	}
	

}
