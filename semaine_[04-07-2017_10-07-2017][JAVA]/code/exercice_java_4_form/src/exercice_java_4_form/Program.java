package exercice_java_4_form;

import exercice_java_4_form.metier.*;

public class Program {

	public static void main(String[] args) {
		
		Personne[] peoples = new Personne[5];
		peoples[0] = new Client("eponge", "bob", "bob@bikinibottom.com", "CLI124", 150.0);
		peoples[1] = new Employe("stark", "tony", "tony@starkindustries.com", 1000000.0, "creatif");
		peoples[2] = new ClientGold("Stalonne", "sylvester", "forever@adrienne.com", "CLI876", 5500.0, 1.5);
		peoples[3] = new Client("strafish", "patrick", "patrick@bikinibottom.com", "CLI125", 250.0);
		peoples[4] = new Employe("fury", "nick", "nick@eyepatch.com", 50000.0, "shield director");
		
		for (Personne p : peoples) {
			p.contacter("you have been terminated");
			System.out.println(p.sauver());
		}

	}

}
