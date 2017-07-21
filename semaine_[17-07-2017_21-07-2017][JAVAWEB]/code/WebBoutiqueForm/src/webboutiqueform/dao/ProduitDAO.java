package webboutiqueform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import webboutiqueform.metier.Produit;

public class ProduitDAO {
	public static final String SELECT_ALL_SQL =
			"select * from `produits`";
	public static final String INSERT_ONE_SQL =
			"insert into `produits` (`nom`, `prix`, `poids`) VALUES(?,?,?)";
	public static final String SELECT_ONE_BY_ID_SQL =
			"select * from `produits` where `id`=?";
	public static final String UPDATE_ONE_SQL =
			"update `produits` set `nom`=?, `prix`=?, `poids`=? where `id`=?";
	public static final String DELETE_ONE_BY_ID_SQL =
			"delete from `produits` where `id`=?";
	
	private Connection connection;
	// mes requettes parametrés
	private PreparedStatement select_all_statement;
	private PreparedStatement insert_one_statement;
	private PreparedStatement find_one_by_id_statement;
	private PreparedStatement update_one_statement;
	private PreparedStatement delete_one_by_id_statement;
	
	public ProduitDAO(Connection connection) {
		this.connection = connection;
		try {
			select_all_statement = connection.prepareStatement(SELECT_ALL_SQL);
			insert_one_statement = connection.prepareStatement(INSERT_ONE_SQL);
			find_one_by_id_statement = connection.prepareStatement(SELECT_ONE_BY_ID_SQL);
			update_one_statement = connection.prepareStatement(UPDATE_ONE_SQL);
			delete_one_by_id_statement = connection.prepareStatement(DELETE_ONE_BY_ID_SQL);
			
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
	
	public Produit findOne(int id) {
		try {
			Produit p = new Produit();
			
			find_one_by_id_statement.clearParameters();
			find_one_by_id_statement.setInt(1, id);
			// recupération du produit
			ResultSet rs = find_one_by_id_statement.executeQuery();
			// on va sur la premiere (et unique) ligne
			if (rs.next()) {
				// remplissage du produit depuis la base
				p.setId(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setPoids(rs.getDouble("poids"));
				p.setPrix(rs.getDouble("prix"));
			}
			else {
				// pas de produit trouvé
				p = null; 
			}
			rs.close();
			return p;
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public int saveProduit(Produit p) {
		// si l'ID est à 0, la clé primaire n'est pas encore renseignée
		// ca veut dire que c'est un nouveau produit a inserer dans la base
		if(p.getId() == 0) {
			try {
				// nettoyer les parametre d'une execution précédente s'il y en a
				insert_one_statement.clearParameters();
				// fournir les valeurs du produit a inserer
				insert_one_statement.setString(1, p.getNom());
				insert_one_statement.setDouble(2, p.getPrix());
				insert_one_statement.setDouble(3, p.getPoids());
				// executer la requette et renvoyer le nombre de ligne affectée (normalement une)
				return insert_one_statement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
		else {
			// sinon, c'est un produit correspondant a une ligne
			// deja dans la base, c'est un update
			try {
				update_one_statement.clearParameters();
				update_one_statement.setString(1, p.getNom());
				update_one_statement.setDouble(2, p.getPrix());
				update_one_statement.setDouble(3, p.getPoids());
				update_one_statement.setInt(4, p.getId());
				// execution de la requette et renvoie du nombre de ligne affectée (normalement une)
				return update_one_statement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
		// aucune ligne modifiée
		return 0;
	}
	
	public int deleteProduit(int id) {
		try {
			delete_one_by_id_statement.clearParameters();
			delete_one_by_id_statement.setInt(1, id);
			return delete_one_by_id_statement.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	
}
