package exercice_java_1_A_form;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		
		double total = 0;
		double min = Double.MAX_VALUE;
		double max = 0;
		int nbNotes = 0;
		
		while(true) {
			System.out.println("saisissez une mote (0 pour finir)");
			String saisie = reader.nextLine();
			double note = Double.parseDouble(saisie);
			if (note == 0)
				break;
			nbNotes++;
			total += note; // total = total + note;
			// si note est plus petite que minimum, ca devient le nouveau minimum
			min = (note < min) ? note : min;
			// si note est plus grande que maximum, ca devient le nouveau maximum
			max = (note > max) ? note : max;
		}
		
		// n'afficher que si au moins une note a été saisie
		if (nbNotes > 0) {
			System.out.println("moyenne = " + (total / nbNotes));
			System.out.println("min = " + min);
			System.out.println("max = " + max);
		}

	}

}
