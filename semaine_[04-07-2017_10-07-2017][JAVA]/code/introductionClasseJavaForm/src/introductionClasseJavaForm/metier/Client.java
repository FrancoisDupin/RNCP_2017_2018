package introductionClasseJavaForm.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {
	// final permet de declarer une 'constante' en java
	// ATTENTION, le mot clé final a d'autres sens q'il est utilisé
	// dans d'autres contextes
	public static final double SOLDE_MIN = 0.0;
	public static final int NOM_LENGTH_MIN = 2;
	public static final int NOM_LENGTH_MAX = 50;
	public static final String NOM_DEFAUT;
	
	// constructeur de classe
	// ce bocl de code sera appelé UNE FOIS au chargement
	// initial de la classe Client
	static {
		String nom = "Doe";
		try {
			File f = new File("paramNom.txt");
			Scanner reader = new Scanner(f);
			nom = reader.nextLine();
			reader.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		NOM_DEFAUT = nom;
	}
	
	
	// compteur de client crée
	private static int compteurClient = 0;
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private double solde;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getNom() {return nom;}
	public void setNom(String nom) {
		if (nom == null) {
			this.nom = NOM_DEFAUT;
		}
		else {
			if (nom.length() < NOM_LENGTH_MIN || nom.length() > NOM_LENGTH_MAX)
				this.nom = NOM_DEFAUT;
			else
				this.nom = nom;			
		}

	}
	
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public double getSolde() {return solde;}
	public void setSolde(double solde) {
		this.solde = (solde >= SOLDE_MIN)? solde : SOLDE_MIN;
	}
	
	public String getNomComplet() {
		return getNom() + ", " + getPrenom();
	}

	public Client() {this(0, NOM_DEFAUT, "", "", SOLDE_MIN);}
	public Client(int id, String nom, String prenom, String email, double solde) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setSolde(solde);
		compteurClient++;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", solde=" + solde
				+ "]";
	}
	
	public static int getCompteurClient() {
		return compteurClient;
	}
	
	

}
