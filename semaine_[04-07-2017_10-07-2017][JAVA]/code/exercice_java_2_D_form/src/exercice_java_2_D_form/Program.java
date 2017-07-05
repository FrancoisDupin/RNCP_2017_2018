package exercice_java_2_D_form;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("saisissez texte a analyser");
		String texte = reader.nextLine();
		texteStat(texte);
		System.out.println("nombre mots = " + compteMots(texte));

	}
	
	public static long compteMots(String chaine) {
		boolean dansMot = false;
		long compteur = 0;
		for (char c : chaine.toCharArray()) {
			// le caractere actuelle est un caractere de mot si c'est une lettre ou un chiffre
			boolean estCaractereDeMot = Character.isAlphabetic(c) || Character.isDigit(c);
			if (!dansMot && estCaractereDeMot) {
				compteur++;
			}
			dansMot = estCaractereDeMot;
		}
		return compteur;
	}
		
	

	public static void texteStat(String chaine) {
		String voyelles = "aeiouy";
		String texte = chaine.toLowerCase();
		
		int nbvoyelles = 0;
		int[] compteursVoyelles = new int[voyelles.length()];
		for (int i = 0; i < texte.length(); i++) {
			char c = texte.charAt(i);
			int pos = voyelles.indexOf(c);
			if (pos != -1) {
				nbvoyelles++; // nombre total de voyelle
				compteursVoyelles[pos]++; // compteur de la voyelle specifique
			}
		}
		
		System.out.println("%a = " + (compteursVoyelles[0] * 100.0 / nbvoyelles));
		System.out.println("%e = " + (compteursVoyelles[1] * 100.0 / nbvoyelles));
		System.out.println("%i = " + (compteursVoyelles[2] * 100.0 / nbvoyelles));
		System.out.println("%o = " + (compteursVoyelles[3] * 100.0 / nbvoyelles));
		System.out.println("%u = " + (compteursVoyelles[4] * 100.0 / nbvoyelles));
		System.out.println("%y = " + (compteursVoyelles[5] * 100.0 / nbvoyelles));
		
		
	}
	
	
}
