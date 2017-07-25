package designPatternsForm;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		/*
		System.out.println("debut programme");
		
		CustomConfig cf = CustomConfig.getInstance();
		System.out.println("cf = " + cf);
		
		Scanner reader = new Scanner(System.in);
		System.out.println("apputez sur entree pour continuer");
		reader.nextLine();
		
		CustomConfig cf2 = CustomConfig.getInstance();
		System.out.println("cf2 = " + cf2);
		
		// le pattern Singleton est très pratique
		// ne PAS EN ABUSER
		// en particulier, ca devient problématique pour 2 raison
		// 		1) un etat partagé par toute l'application, plein
		//			d'effets de bord potentiels
		// 		2) problématique en cas de programmation multithread

		cf.addValueToConfig("couleur", "red");
		cf.addValueToConfig("databaseName", "boutique");
		cf.addValueToConfig("databaseDriver", "com.mysql.jdbc.Driver");
		
		cf.saveToPropertiesFile("config.properties");
		
		cf.loadFromPropertiesFile("config.properties");
		System.out.println(cf.getValueFromConfig("couleur"));
		*/
		
		Adresse a1 =
		new Adresse("221b baker street", "londre", "12345", "angleterre");
		Client c1 = new Client("Sherlock Holmes", a1);
		Client c2 = new Client("dr john Watson", a1);
		
		System.out.println(c1);
		System.out.println(c2);
		//c2.setAdresse(new Adresse("2 rue toto","francfort", "12345", "allemagne"));
		c2.setAdresse(c2.getAdresse().changeRue("rue de la paix"));
		System.out.println(c1);
		System.out.println(c2);
		
		
		
		
	}

}
