package exercice_java_1_C_form;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("taille losange ?");
		int taille = Integer.parseInt(reader.nextLine());
		int hauteur = taille / 2 + 1;
		
		String partie_haute = "";
		String partie_basse = "";
		
		for (int ligne = 0; ligne < hauteur; ligne++) {
			String texte_ligne = "";
			// affichage retrait/marge 
			for (int marge = 0; marge < hauteur - ligne - 1; marge++) {
				texte_ligne += " ";
			}
			// affichage ligne du losange
			for (int colonne = 0; colonne < ligne * 2 + 1; colonne++) {
				if (colonne == 0 || colonne == ligne * 2)
					texte_ligne += "*";
				else
					texte_ligne += "-";
			}
			if (ligne != hauteur - 1) {
				partie_haute += texte_ligne + "\n";
			}
			partie_basse = texte_ligne + "\n" + partie_basse;
		}
		System.out.println(partie_haute + partie_basse);

	}

}
