package spyHub;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// creation des espions via le gestionnaire d'espion
		SpyManager manager = new SpyManager("config.txt");
		
		manager.startSpying();
		System.out.println("c'est parti....(entree pour terminer)");
		
		Scanner reader = new Scanner(System.in);
		reader.nextLine();
		
		System.out.println("arret demandé....");
		manager.stopSpying();
		
		manager.saveEvents("events.log");

	}

}
