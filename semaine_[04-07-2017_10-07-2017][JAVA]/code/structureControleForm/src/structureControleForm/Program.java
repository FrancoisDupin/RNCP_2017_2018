package structureControleForm;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("quelle heure est il ?");
		// lecture sur l'entree standard
		// dans notre cas, saisie clavier par l'utilisateur
		Scanner reader = new Scanner(System.in);

		String saisie = reader.nextLine();
		// conversion en chiffre
		int heure = Integer.parseInt(saisie);
		
		// la condition/test du if est TOUJOURS entre parenthese
		// l'expression entre les parenthese DOIT evaluer en un boolean
		if (heure < 11) {
			System.out.println("bonjour, un café?");
		}
		else if(heure < 14) {
			System.out.println("bonjour, bon appétit!");
		}
		else {
			System.out.println("bien le bonjour!");
		}
		
		// switch/case, uniquement pour egalité
		
		switch(heure) {
			case 9:
			case 10:
			case 11:
				System.out.println("bonjour un café");
				break;
			case 12:
			case 13:
				System.out.println("bon appétit");
				break;
			case 14:
			case 15:
			case 16:
				System.out.println("bon après-midi");
				break;
			default:
				System.out.println("a demain!");
				break;
		}
		
		System.out.println("---------------------------------------------");
		
		int compteur = 0;
		// boucle repeter tant que la condition est vrais
		while(compteur < 10) {
			System.out.println("compteur = " + compteur);
			compteur++; // compteur = compteur + 1
		}

		System.out.println("---------------------------------------------");
		
		//on peut sortir prématurément d'une boucle
		compteur = 0;
		while(compteur < 10) {
			System.out.println("compteur = " + compteur);
			if (compteur == 5)
				break;
			compteur++; // compteur = compteur + 1
		}

		System.out.println("---------------------------------------------");

		compteur = 15;
		do {
			System.out.println("compteur = "  + compteur);
			compteur++;
		}while(compteur < 10);
		
		// la boucle for, c'est une variante "concise" d'une boucle while
		// for (intialisation; condition; mise a jour) { ... }
		
		// for autorise la declaration d'une variable directement dans son initialisation
		for (int i = 0; i < 10; i++) {
			if (i == 6)
				continue;
			System.out.println("i = " + i);
		}
		
		//System.out.println(i);
		
		
		String[] jours = {"lundi", "mardi", "mercredi", "jeudi", "vendredi"};
		//pour chaque jour de type String dans la collection jours faire:
		// la variable "jour" ici est une variable locale qui n'a d'existence que
		// dans la boucle
		for (String jour : jours) {
			System.out.println(jour);
		}
		
		double prix = 15.99;
		String description = (prix > 20) ? "c'est cher" : " c'est pas cher";
		System.out.println(description);
		
	}
	
}
