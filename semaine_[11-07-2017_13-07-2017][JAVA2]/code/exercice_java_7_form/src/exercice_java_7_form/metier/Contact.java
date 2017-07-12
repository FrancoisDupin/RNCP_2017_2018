package exercice_java_7_form.metier;

import java.util.Comparator;
import java.util.function.Predicate;

public class Contact {
	public static final String TRI_ID = "id";
	public static final String TRI_NOM = "nom";
	public static final String TRI_PRENOM = "prenom";
	public static final String TRI_NOM_PRENOM = "nom et prenom";
	public static final String TRI_EMAIL = "email";
	public static final String TRI_AGE = "age";
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private char genre;
	private int age;
	private boolean clientGold;
	private String referent;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public char getGenre() {return genre;}
	public void setGenre(char genre) {this.genre = genre;}
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}
	public boolean isClientGold() {return clientGold;}
	public void setClientGold(boolean clientGold) {this.clientGold = clientGold;}
	public String getReferent() {return referent;}
	public void setReferent(String referent) {this.referent = referent;}
	
	public Contact() { this(0, "", "", "", 'M', 0, false, ""); }
	public Contact(int id, String nom, String prenom, String email, char genre, int age, boolean clientGold,
			String referent) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.genre = genre;
		this.age = age;
		this.clientGold = clientGold;
		this.referent = referent;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", genre=" + genre
				+ ", age=" + age + ", clientGold=" + clientGold + ", referent=" + referent + "]";
	}

	public static Comparator<Contact> getTri(String champ) {
		switch(champ) {
			case TRI_ID: return (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
			case TRI_NOM: return (c1, c2) -> c1.getNom().compareTo(c2.getNom());
			case TRI_PRENOM: return (c1, c2) -> c1.getPrenom().compareTo(c2.getPrenom());
			case TRI_EMAIL: return (c1, c2) -> c1.getEmail().compareTo(c2.getEmail());
			case TRI_AGE: return (c1, c2) -> Integer.compare(c1.getAge(), c2.getAge());
			case TRI_NOM_PRENOM: return (c1, c2) -> {
				int comp = c1.getNom().compareTo(c2.getNom());
				if (comp != 0) return comp;
				else return c1.getPrenom().compareTo(c2.getPrenom());
			};
			default: return (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
		}
	}
	
	public static Predicate<Contact> getAgeFilter(final int age) {
		return c -> c.getAge() <= age;
	}

	
	public static Predicate<Contact> getGoldFilter(final boolean goldOnly) {
		return c -> c.isClientGold() || !goldOnly;
	}
	
	
	public static Predicate<Contact> getReferentFilter(final String referentName) {
		if (referentName == null || referentName.equals("tous")) return c -> true;
		else return c -> c.getReferent().equals(referentName);
	}
	
}
