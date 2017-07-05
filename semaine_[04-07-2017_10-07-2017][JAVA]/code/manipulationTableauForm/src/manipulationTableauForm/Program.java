package manipulationTableauForm;

import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		
		// declaration d'un tableau d'entier
		int[] tableau1;
		// pour allouer un tableau, il faut utiliser le mot clé new
		// et spécifier la taille du tableau
		tableau1 = new int[5];
		
		tableau1[0] = 10;
		tableau1[1] = 15;
		tableau1[2] = 5;
		tableau1[3] = 20;
		tableau1[4] = -10;
		
		// Arrays.toString permet d'afficher correctement le contenu d'un tableau
		System.out.println(Arrays.toString(tableau1));
		Arrays.sort(tableau1); // tri du tableau
		System.out.println(Arrays.toString(tableau1));
		
		double[] tableau2 = {4.5, 2.3, 1.8, -3.5, 9.4};
		System.out.println(tableau2.length);
		System.out.println(Arrays.toString(tableau2));
		
		// acceder en dehors du tableau provoque une erreur
		//tableau2[5] = 2.5;
		
		tableau1 = new int[]{2, 5, 9, 3, 4, 9};
		
		int[] copie = tableau1.clone(); // permet de faire une copie 'legere' d'un tableau
		copie[0] = 4;
		System.out.println(Arrays.toString(tableau1));
		System.out.println(Arrays.toString(copie));
		
		String[] villes = {"paris", "lyon", "marseille"};
		String[] villes2 = villes.clone();
		String[] villes3 = villes;
		
		System.out.println(Arrays.toString(villes));
		System.out.println(Arrays.toString(villes2));
		villes2[0] = "lilles";
		System.out.println(Arrays.toString(villes));
		villes3[0] = "toulouse";
		System.out.println(Arrays.toString(villes));
		
		// ["paris", "lyon", "marseille"]  -->["paris", "lyon", "marseille", null, null] 
		String[] villesExtended = Arrays.copyOf(villes, 5);
		villesExtended[3] = "la rochelle";
		villesExtended[4] = "nice";
		System.out.println(Arrays.toString(villesExtended));
		
		double[][] matrice = {
								{2.5, 1.3, 3.4},
								{5.5, 2.3, 4.4, 7.2, 8.9},
								{-2.5, 8.3, 6.4},
								{1.5, 9.3, 12.4}
							 };
		System.out.println("matrice[1][2] -> " + matrice[1][2]);
		
		// 3 lignes et 4 colonnes
		double[][] matrice2 = new double[3][4];
		
		// 3 lignes, les colonnes ne sont pas allouées, charge a nous de la faire
		double[][] matrice3 = new double[3][];
		matrice3[0] = new double[5]; // 1ere ligne de 5 colonnes
		
		
		
		
		
	}

}
