package introductionClasseJavaForm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import introductionClasseJavaForm.metier.Client;
import introductionClasseJavaForm.metier.Produit;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("bonjour!");
		Produit p = new Produit(); //1, "lait de chameau equitable", 15.99, 0.5);
		/*
		p.id = 1;
		p.nom = "lait de chameau equitable";
		p.prix = 15.99;
		p.poids = 0.5;
		*/
		System.out.println(p.nom);
		
		Produit p2 = new Produit(2, "tofu tout fou", -29.99, 1.0);
		/*p2.id = 2;
		p2.nom = "tofu tout fou";
		p2.prix = 29.99;
		p2.poids = 1.0;*/
		System.out.println(p2.nom);
		
		// pas de creation de nouvel objet/instance
		// p2 et p3 référence le même objet
		Produit p3 = p2;
		p3.setPrix(-39.99);
		System.out.println(p2.getPrix());
		
		p2.affiche();
		
		System.out.println(Client.getCompteurClient());
		
		Client c1 = new Client(1, "starfish", "patrick", "patrick@sponge.com", 150.0);
		
		System.out.println(c1.toString());
		
		//Date d1 = new Date();
		//Date d1 = new Date(117, 0, 1);
		//System.out.println(d1);
		System.out.println(Client.getCompteurClient());
		
		Client c2 = new Client(2, "Schwarzenegger", "arnold", "gorvernator@california.gov", 1500.0);
		System.out.println(Client.getCompteurClient());
		
		File f = new File("paramNom.txt");
		Scanner reader = new Scanner(f);
		String nom = reader.nextLine();
		reader.close();
		System.out.println("nom defaut = " + nom);
		
	}

}
