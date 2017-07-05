package fonctionsJavaform;

import java.io.File;
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
		
		System.out.println(factorielle(6));
		
		parcourRep(new File("C:\\Users\\Stagiaire\\depotgit"), 0);
		
		System.out.println(moyenne(12.5, 18.6, 8.9, 7.5));
		
	}
	
	public static double moyenne(double ... valeurs) {
		double somme = 0.0;
		for (double d : valeurs) {
			somme += d;
		}
		return somme / valeurs.length;
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
	// fonction recursive
	public static long factorielle(long n) {
		if (n <= 1)
			return 1;
		else 
			return n * factorielle(n - 1);
	}
	
	public static void parcourRep(File rep, int profondeurActuelle) {
		// récupère la liste des fichiers
		File[] files = rep.listFiles();
		for (File f : files) {
			for (int i = 0; i < profondeurActuelle; i++) {
				System.out.print("   ");
			}
			if (f.isDirectory()) {
				System.out.println("REP  : " + f.getName());
				if (profondeurActuelle < 3) {
					parcourRep(f, profondeurActuelle + 1);
				}
			}
			else {
				System.out.println("FILE : " + f.getName());
			}
		}
	}
	
	

}
