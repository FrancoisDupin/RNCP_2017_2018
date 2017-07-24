package antiProcastinator.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import antiProcastinator.metier.Tache;

public class TacheDAO {
	
	public static enum TypeTri {
		AUCUN,
		DESCRIPTION,
		PRIORITE,
	}
	
	public static final String DAO_CONTEXT_KEY = "tacheDAO";
	
	
	public static final String SELECT_ALL_BASE
		= "select * from `taches`";
	public static final String SELECT_ONE_BY_ID_SQL 
		= "select * from `taches` where `id`=?";
	public static final String INSERT_ONE_SQL 
		= "insert into `taches` (`description`,`priorite`,`contexte`,`finished`,`dateCreation`) VALUES(?,?,?,?,?)";
	public static final String UPDATE_ONE_SQL 
		= "update `taches` SET `description`=?, `priorite`=?, `contexte`=?, `finished`=? WHERE `id`=?";
	public static final String DELETE_ONE_BY_ID_SQL 
		= "delete from `taches` where `id`=?";

	private Connection connection;
	
	PreparedStatement find_one_by_id_statement;
	PreparedStatement update_one_statement;
	PreparedStatement insert_one_statement;
	PreparedStatement delete_one_by_id_statement;
	PreparedStatement find_all_statement;
	
	public TacheDAO(Connection connection) {
		super();
		this.connection = connection;
		
		try {
			this.insert_one_statement = connection.prepareStatement(INSERT_ONE_SQL);
			this.update_one_statement = connection.prepareStatement(UPDATE_ONE_SQL);
			this.delete_one_by_id_statement = connection.prepareStatement(DELETE_ONE_BY_ID_SQL);
			this.find_one_by_id_statement = connection.prepareStatement(SELECT_ONE_BY_ID_SQL);
			this.find_all_statement = null;
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	private Tache fetchTacheFromRow(ResultSet rs) {
		try {
			// ici, nous utilisons une LocalDateTime
			// pour la convertir, nous nous basons sur
			// le fuseau horaire systeme
			// conversion java.sql.date -> LocalDateTime
			return new Tache(rs.getInt("id"),
							 rs.getString("description"),
							 rs.getInt("priorite"),
							 rs.getString("contexte"),
							 rs.getBoolean("finished"),
							 LocalDateTime.ofInstant(
								Instant.ofEpochSecond(
									 rs.getTimestamp("dateCreation").getTime() / 1000),
								ZoneId.systemDefault()
								)
							 );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Tache> findAll() {
		return findAll(TypeTri.AUCUN, null);
	}
	public List<Tache> findAll(TypeTri tri, String filtre) {
		List<Tache> taches = new ArrayList<Tache>();
		try {
			String sql = null;
			if (filtre != null)
				sql = SELECT_ALL_BASE + " WHERE contexte=?";
			else
				sql = SELECT_ALL_BASE;
			
			switch(tri) {
				case DESCRIPTION:
					sql += " ORDER BY `description`"; break;
				case PRIORITE:
					sql += " ORDER BY `priorite`"; break;
				case AUCUN:
				default:
					break;
			}
			this.find_all_statement = connection.prepareStatement(sql);
			if (filtre != null)
				this.find_all_statement.setString(1, filtre);
			
			ResultSet rs = find_all_statement.executeQuery();
			while (rs.next()) {
				taches.add(fetchTacheFromRow(rs));
			}
			System.out.println(taches);
			rs.close();
		} catch (SQLException e) {e.printStackTrace();}
		return taches;
	}
	
	public Tache findById(int id) {
		try {
			this.find_one_by_id_statement.clearParameters();
			this.find_one_by_id_statement.setInt(1, id);
			ResultSet rs = this.find_one_by_id_statement.executeQuery();
			Tache t = null;
			if (rs.next()) {
				t = fetchTacheFromRow(rs);
			}
			rs.close();
			return t;
			
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public int saveTache(Tache t) {
		if (t.getId() == 0) {
			// insertion
			try {
				insert_one_statement.clearParameters();
				insert_one_statement.setString(1, t.getDescription());
				insert_one_statement.setInt(2, t.getPriorite());
				insert_one_statement.setString(3, t.getContexte());
				insert_one_statement.setBoolean(4, t.isFinished());
				// conversion de LocalDateTime vers date sql
				insert_one_statement.setDate(5,  new Date(
									new java.util.Date().getTime()));
				return insert_one_statement.executeUpdate();
			} catch (SQLException e) {e.printStackTrace();}
		}
		else {
			// insertion
			try {
				update_one_statement.clearParameters();
				update_one_statement.setString(1, t.getDescription());
				update_one_statement.setInt(2, t.getPriorite());
				update_one_statement.setString(3, t.getContexte());
				update_one_statement.setBoolean(4, t.isFinished());
				update_one_statement.setInt(5, t.getId());
				return update_one_statement.executeUpdate();
				
			} catch (SQLException e) {e.printStackTrace();}
		}
		return 0;
	}
	
	public int deleteTache(int id) {
		try {
			delete_one_by_id_statement.clearParameters();
			delete_one_by_id_statement.setInt(1, id);
			return delete_one_by_id_statement.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
		return 0;
	}
	
	
}
