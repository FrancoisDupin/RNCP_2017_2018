package manipulationChaineForm;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		String str1 = "hello there";
		String str2 = "hello you too";
		String str3 = /*new String(*/"hello there"/*)*/;
		String str4 = "hello ";
		str4 += "there";
		
		//System.out.println(str4);
		/*
		 * NON!!!
		 *  on ne compare JAMAIS JAMAIS les chaines de caractere avec ==
		 */
		System.out.println("str1 == str2 -> " + (str1 == str2));
		System.out.println("str1 == str3 -> " + (str1 == str3));
		System.out.println("str1 == str4 -> " + (str1 == str4));
		
		/*
		 * OUI!
		 * 
		 */
		System.out.println("str1 equals str2 -> " + (str1.equals(str2)));
		System.out.println("str1 equals str3 -> " + (str1.equals(str3)));
		System.out.println("str1 equals str4 -> " + (str1.equals(str4)));
		
		System.out.println("longueur str1 = " + str1.length());
		System.out.println("caractere no 4 (indexer a 0) = " + str1.charAt(4));
		System.out.println("extraction = " + str1.substring(2, 5));
		System.out.println("position de 'lo' = " + str1.indexOf("lo"));
		System.out.println("position de 'xy' = " + str1.indexOf("xy"));
		
		char c = str1.charAt(4);
		System.out.println("c : " + c + " est un chiffre ? " + Character.isDigit(c));
		System.out.println("c : " + c + " est une majuscule ? " + Character.isUpperCase(c));
		
		// les chaines de caractere son "immutable", non modifiable/mutable
		Scanner reader = new Scanner(System.in);
		System.out.println("appuyez sur entree pour commencer");
		reader.nextLine();
		/*String buffer = "";
		for (int i = 0; i < 500000; i++) {
			buffer += "ho";
		}*/
		// pour les manipulations "lourde" de chaines, ne pas utiliser String
		// desastreux pour les performances
		// Utiliser StringBuilder (ou StringBuffer)
		// specialement optimisé pour ce cas la
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 500000; i++) {
			sb.append("ho");
		}
		String buffer = sb.toString();
		
		
		System.out.println("terminé!");
		
		
		
		
		
	}

}
