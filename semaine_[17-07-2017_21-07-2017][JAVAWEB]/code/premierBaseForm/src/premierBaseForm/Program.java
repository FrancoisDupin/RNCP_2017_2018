package premierBaseForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		try {
			// charger le driver Mysql
			Class.forName("com.mysql.jdbc.Driver");
			// on peut maintenant demander une connection au driverManager
			// car celui-ci gere maintenant aussi les connection mysql
			Connection connection = DriverManager.getConnection(
									"jdbc:mysql://localhost:3306/firstbase",
									"root",
									"");
			System.out.println("connection réussie!!");
			
			//lister tous les clients
			// Statement est l'objet permettant d'executer une requette
			Statement stat = connection.createStatement();
			
			// execution d'une query (requete de selection)
			ResultSet results = stat.executeQuery("select * from `client`");
			// le resultSet renvoyé permet de parcourir les lignes renvoyées
			// nous somme en mode connecté
			// results est en quelque sorte un curseur sur le resultat de l'execution
			// il va recupérer au fur et a mesure du parcour des resultats
			// les lignes suivante depuis la base
			
			// next passe a la ligne suivante du resultat, et nous renvoie true tant qu'il
			// reste une ligne a lire
			while(results.next()) {
				System.out.println("id = " + results.getInt("id") +
								   " nom = " + results.getString("nom") +
								   " prenom = " + results.getString("prenom") +
								   " email = " + results.getString("email") +
								   " solde = " + results.getDouble("solde"));
			}
			// fermer le resultSet (pour liberer les ressources)
			results.close();
			
			// saisie d'un nouveau client
			Scanner reader = new Scanner(System.in);
			/*System.out.println("nom nouveau client?");
			String nom = reader.nextLine();
			System.out.println("prenom nouveau client?");
			String prenom = reader.nextLine();
			System.out.println("email nouveau client?");
			String email = reader.nextLine();
			System.out.println("solde nouveau client?");
			double solde = Double.parseDouble(reader.nextLine());
			if (solde > 10000) {
				System.out.println("solde trop haut, reduction a 1000");
				solde = 1000.0;
			}
			
			// dans un requette parametre, les valeurs 'variables'
			// celle que l'on fournira sont indiquée par des ?
			// qui seront remplacé ultérieurement par les veritables valeurs
			// a l'execution
			PreparedStatement insertStatement = connection.prepareStatement(
					"INSERT INTO `client` (`nom`, `prenom`, `email`, `solde`) "
					+ " VALUES(?,?,?,?)");
			
			// fourniture des valeur des parametres
			// l'index du parametre est dans l'ordre des ? dans la requette
			// ATTENTION, commence a 1 et PAS a 0
			insertStatement.setString(1, nom);
			insertStatement.setString(2, prenom);
			insertStatement.setString(3, email);
			insertStatement.setDouble(4, solde);
			
			int nbLignes = insertStatement.executeUpdate();
			System.out.println(nbLignes + " insérée(s)");
			*/
			
		/*	Statement insertStatement = connection.createStatement();
			// attention, c'est MAAALLL (pour raison d'injection SQL et de performances)
			// exemple d'injection
			// "v@c.com',100000000) -- " dans email
			String insertSql = "INSERT INTO `client` (`nom`, `prenom`, `email`, `solde`) "
					+ " VALUES('" + nom 
					+ "', '" + prenom 
					+  "', '" + email 
					+ "', "	+ solde + ")";
			System.out.println("requette = " + insertSql);
			
			// executeUpdate pour toute requette alterant le contenu de la base (insert, update, delete)
			int nbLignes = insertStatement.executeUpdate(insertSql);
			System.out.println(nbLignes + " insérée(s)");
			*/
			
			// update
			/*System.out.println("quelle augmentation de solde?");
			double augmentation = Double.parseDouble(reader.nextLine());
			System.out.println("concerne les soldes au dessus de combien ?");
			double seuil = Double.parseDouble(reader.nextLine());
			
			PreparedStatement updateStatement = connection.prepareStatement(
					"UPDATE `client` set `solde`=`solde` + ? WHERE `solde` > ?");
			updateStatement.setDouble(1, augmentation);
			updateStatement.setDouble(2, seuil);
			// execution de la requette
			System.out.println(updateStatement.executeUpdate() + " lignes modifiée(s)");
			*/
			
			/*
			PreparedStatement deleteStatement = connection.prepareStatement(
					"DELETE FROM `client` where `id`=?");
			System.out.println("identifiant du client a effacer ? ");
			int cid = Integer.parseInt(reader.nextLine());
			deleteStatement.setInt(1, cid);
			
			System.out.println(deleteStatement.executeUpdate() + " ligne(s) effacée(s)");
			*/
			// compter les client avec un sole inferieur a une valeur choisie
			PreparedStatement countStatement = connection.prepareStatement(
					"SELECT COUNT(id) from `client` WHERE `solde` < ?");
			System.out.println("solde maximum a compter ? ");
			
			double maximum = Double.parseDouble(reader.nextLine());
			countStatement.setDouble(1, maximum);
			
			// meme si la requete ne renvoie qu'une valeur
			// c'est un resultset, la valeur sera dans le premiere ligne et premiere
			// colonne de ce resultset
			ResultSet rs = countStatement.executeQuery();
			if (rs.next()) {
				// les colonnes aussi sont numérotées a partir de 1 et non 0
				System.out.println("nb clients sous le seuil = " + rs.getInt(1));
			}
			rs.close();
			
			// fermeture de la connection a la base
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
