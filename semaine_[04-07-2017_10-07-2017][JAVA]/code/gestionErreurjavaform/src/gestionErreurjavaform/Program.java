package gestionErreurjavaform;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		/*
		 * historiquement, si une fonction peut declencher une erreur
		 * elle renvoie un code d'erreur
		 * 
		 * limite 	A) limit� s�mentiquement
		 * 			B) on est oblig� de g�r� l'erreur des le retour du code d'erreur
		 * 		ou de repropager l'erreur aux fonction sup�rieurs
		 * 			C) cela consomme une valeur de retour
		 * 
		 * mise en place d'un systeme plus efficace/facile a g�rer pour le programmeur
		 * 
		 * le mecanisme des exceptions
		 * 			A) Une exception est un objet, qui peut contenir de multiples
		 * informations
		 * 			B) le runtime se charge de repropager l'exception jusqu'a l'endroit
		 * 	ou on a d�cid� de la g�rer, automatiquement et en nettoyant la pile d'appel
		 * 			C) grace a l'heritage, un mecanisme assez fin de s�l�ction des erreurs
		 * � g�rer
		 * 
		 * try  catch   finally
		 * 
		 * try: -> bloc de code sous surveillance
		 * le ou les catch -> gestion d'erreur pour ce bloc de code
		 * finally : le bloc de nettoyage
		 * 
		 */

		Scanner reader = new Scanner(System.in);
		try {
			/*int age = Integer.parseInt(reader.nextLine());
			if (age < 0 || age > 200) {
				// le mot cl� throw permet de d�clencher une erreur
				throw new AgeException("age invalide");
			}*/
			int age = saisie_age();
			
			System.out.println("votre age est : " + age);
			/*if (age > 120)
				return;*/
		}
		catch (NumberFormatException ex) {
			// du plus sp�cialis�
			System.out.println("erreur a la saisie de l'age: " + ex.getMessage());
		}
		catch (AgeException ex) {
			// au plus g�n�ral
			System.out.println("erreur de valeur pour l'age: " + ex.getMessage());
		}
		finally {
			// le bloc de code de nettoyage, ex�cut� quelque soit la maniere
			// dont on sort du bloc try
			System.out.println("netoyage");
		}
		/*catch (Exception ex) {
			System.out.println("on a tout cass�");
		}*/
		System.out.println("fini!!!");
	}
	
	
	public static int saisie_age()  throws AgeException
	{
		// cette boucle se repetera tant qu'on arrivera pas au bout
		// su try (le return age)
		while(true) {
			try {
				System.out.println("saisissez votre age");
				Scanner reader = new Scanner(System.in);
				int age = Integer.parseInt(reader.nextLine());
				if (age < 0 || age > 200)
					throw new AgeException("goaould d�t�ct�");
				// tout est ok, on sort de la fonction (et du try)
				return age;
			}
			catch(NumberFormatException ex) {
				System.out.println("ce n'est pas un nombre!!" + ex.getMessage());
			}
		}
		
	}
	

}
