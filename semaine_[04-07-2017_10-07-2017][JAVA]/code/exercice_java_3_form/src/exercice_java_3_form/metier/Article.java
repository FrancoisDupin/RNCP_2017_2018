package exercice_java_3_form.metier;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Article {
	
	public static final String TITRE_DEFAUT;
	public static final String CORPS_DEFAUT;
	public static final String AUTEUR_DEFAUT;
	public static final double RATING_DEFAUT;
	public static final int TITRE_LENGTH_MIN = 5;
	public static final int TITRE_LENGTH_MAX = 100;
	public static final int CORPS_LENGTH_MIN = 5;
	public static final int CORPS_LENGTH_MAX = 400;
	public static final int AUTEUR_LENGTH_MIN = 2;
	public static final int AUTEUR_LENGTH_MAX = 50;
	
	public static final double RATING_MIN = 0.0;
	public static final double RATING_MAX = 5.0;
	
	// le prochain id disponnible pour id automatique
	private static int next_id = 1;
	
	static {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");
			// chargement des properties
			prop.load(input);
			input.close();
			
		} catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {	e.printStackTrace();}
		TITRE_DEFAUT = prop.getProperty("titre_defaut", "absent");
		CORPS_DEFAUT = prop.getProperty("corps_defaut", "absent");
		AUTEUR_DEFAUT = prop.getProperty("auteur_nom_defaut", "absent");
		RATING_DEFAUT = Double.parseDouble(
				prop.getProperty("rating_defaut", "2.5")
				);
	}
	
	
	private int id;
	private String titre;
	private String corps;
	private String nomAuteur;
	private double rating;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getTitre() {return titre;}
	public void setTitre(String titre) {
		if (titre != null 
			&& titre.length() >= TITRE_LENGTH_MIN
			&& titre.length() <= TITRE_LENGTH_MAX)
			this.titre = titre;
		else
			this.titre = TITRE_DEFAUT;
	}
	
	public String getCorps() {return corps;}
	public void setCorps(String corps) {
		if (corps != null 
			&& corps.length() >= CORPS_LENGTH_MIN
			&& corps.length() <= CORPS_LENGTH_MAX)
			this.corps = corps;
		else
			this.corps = CORPS_DEFAUT;
	}
	
	public String getNomAuteur() {return nomAuteur;}
	public void setNomAuteur(String nomAuteur) {
		if (nomAuteur != null 
				&& nomAuteur.length() >= AUTEUR_LENGTH_MIN
				&& nomAuteur.length() <= AUTEUR_LENGTH_MAX)
			this.nomAuteur = nomAuteur;
		else
			this.nomAuteur = AUTEUR_DEFAUT;
	}
	
	public double getRating() {return rating;}
	public void setRating(double rating) {
		if (rating >= RATING_MIN && rating <= RATING_MAX)
			this.rating = rating;
		else
			this.rating = RATING_DEFAUT;
	}
	
	public Article() {
		this(TITRE_DEFAUT, CORPS_DEFAUT, AUTEUR_DEFAUT, RATING_DEFAUT);
	}
	public Article(String titre, String corps, String nomAuteur, double rating) {
		this(next_id++, titre, corps, nomAuteur, rating);
	}

	public Article(int id, String titre, String corps, String nomAuteur, double rating) {
		setId(id);
		setTitre(titre);
		setCorps(corps);
		setNomAuteur(nomAuteur);
		setRating(rating);
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", corps=" + corps + ", nomAuteur=" + nomAuteur + ", rating="
				+ rating + "]";
	}
	
	
	

}
