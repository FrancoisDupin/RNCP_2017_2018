package exercice_java_1_B_form;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		System.out.println("taille du triangle ?");
		Scanner reader = new Scanner(System.in);
		
		int taille = Integer.parseInt(reader.nextLine());
		// on dessine ligne par ligne
		for (int ligne = 0; ligne < taille; ligne++) {
			// ici on dessine chaque caractere(colonne) de la ligne courante
			for (int colonne = 0; colonne < taille - ligne; colonne++) {
				// detection du type de caractere suivant que nous somme sur un bord ou pas
				// bord gauche -> colonne == 0, bord superieur -> ligne == 0, etc...
				if (colonne == 0 || ligne == 0 || colonne == taille - ligne - 1)
					System.out.print("*");
				else
					System.out.print("-");
			}
			// on a fini une ligne, on passe a la ligne suivante
			System.out.println();
		}
	}

}
