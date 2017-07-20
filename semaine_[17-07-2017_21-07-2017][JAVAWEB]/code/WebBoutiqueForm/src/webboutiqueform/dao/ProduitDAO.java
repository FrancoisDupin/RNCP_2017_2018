package webboutiqueform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webboutiqueform.metier.Produit;

public class ProduitDAO {
	public static final String SELECT_ALL_SQL = "select * from `produits`";
	
	private Connection connection;
	// mes requettes parametrés
	private PreparedStatement select_all_statement;

	public ProduitDAO(Connection connection) {
		this.connection = connection;
		try {
			select_all_statement = connection.prepareStatement(SELECT_ALL_SQL);
			
		} catch (SQLException e) {e.printStackTrace();	}
	}
	
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<>();
		try {
			// executer la requette 
			ResultSet rs = this.select_all_statement.executeQuery();
			// parcourir les lignes du resultat
			while (rs.next()) {
				// pour chaque ligne de la table,
				// instancier un objet Produit correspondant
				// et l'ajouter a notre liste
				produits.add(new Produit(rs.getInt("id"),
										 rs.getString("nom"),
										 rs.getDouble("prix"),
										 rs.getDouble("poids")));
			}
			rs.close();
		} catch (SQLException e) {e.printStackTrace();	}
		return produits;
	}
}
