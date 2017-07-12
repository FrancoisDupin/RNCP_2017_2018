package enumerationJavaform;
import java.util.Scanner;

import enumerationJavaform.mesenum.*;

public class Program {

	public static void main(String[] args) {
		// je peu declarer un attribut ou variable de type de l'enumeration voulue
		// cette variable pourra prendre les valeurs décrite dans l'enumération
		JoursSemaine j1 = JoursSemaine.Lundi;
		
		// on peut facilement faire des tests plus lisibles grace a l'enumeration
		if (j1 == JoursSemaine.Lundi)
			System.out.println("c'est un lundi");
		else
			System.out.println("ce n'est pas un lundi");

		// a l'affichage, le 'label' de l'enumeration est affiché
		System.out.println("j1 = " + j1);
		// mais en fait, j1 est un simple integer 'amelioré'
		System.out.println("ordinal de j1 = " + j1.ordinal());
		
		System.out.println("saisissez le nom d'un jour (commencant par une majuscule)");
		Scanner reader = new Scanner(System.in);
		String saisie = reader.nextLine();
		
		// il sait convertir d'une chaine de caractere vers la valeur dans l'enumeration
		JoursSemaine j2 = JoursSemaine.valueOf(saisie);
		
		System.out.println(j2.ordinal());
		
		switch(j2) {
			case Lundi:
			case Mardi:
				System.out.println("on demarre la semaine"); break;
			case Mercredi:
			case Jeudi:
				System.out.println("on continue..."); break;
			case Vendredi:
				System.out.println("bientôt le week-end"); break;
			default:
				System.out.println("le week-end!!!"); break;
		}
		
		System.out.println("----------------------");
		for (JoursSemaine j : JoursSemaine.values()) {
			System.out.println(j + " -> " + j.ordinal());
		}
		
	}

}
