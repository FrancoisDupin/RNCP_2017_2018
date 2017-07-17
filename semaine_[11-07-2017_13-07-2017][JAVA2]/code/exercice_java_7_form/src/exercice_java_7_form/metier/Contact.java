package exercice_java_7_form.metier;

import java.util.Comparator;
import java.util.function.Predicate;

import beanCreator.annotations.IgnoreSetter;
import beanCreator.annotations.MessageSaisie;
import csvMagician.annotations.BooleanConverter;
import csvMagician.annotations.IgnoreGetter;

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
	
	@IgnoreSetter 
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}

	@MessageSaisie(message="le nom du contact")
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return prenom;}

	@MessageSaisie(message="le prenom du contact")
	public void setPrenom(String prenom) {this.prenom = prenom;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	//@IgnoreGetter
	public char getGenre() {return genre;}
	//@csvMagician.annotations.IgnoreSetter
	public void setGenre(char genre) {this.genre = genre;}
	public int getAge() {return age;}
	
	@MessageSaisie(message="l'age du contact entre 0 et 200 ans")
	public void setAge(int age) {this.age = age;}
	
	@BooleanConverter(trueValue="1", falseValue="0")
	public boolean isClientGold() {return clientGold;}
	@BooleanConverter(trueValue="1", falseValue="0")
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

	/*public String toCSVLine() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName()).append(';')
		  .append(getId()).append(';')
		  .append(getNom()).append(';')
		  .append(getPrenom()).append(';')
		  .append(getEmail()).append(';')
		  .append(getGenre()).append(';')
		  .append(getAge()).append(';')
		  .append(isClientGold()).append(';')
		  .append(getReferent());

		return sb.toString();
	}*/
	/*
	public static class ContactFormatException extends RuntimeException {

		public ContactFormatException(String message) {
			super(message);
		}

		public ContactFormatException(String message, Throwable cause) {
			super(message, cause);
		}
		
	}
	
	public static Contact loadFromCsv(String line) throws ContactFormatException 
	{
		String[] values = line.split(";");
		if (values.length != 9) {
			throw new ContactFormatException("format csv du contact invalide, pas le bon nombre de champs");
		}
		try {
			return new Contact(Integer.parseInt(values[1]),
								values[2],
								values[3],
								values[4],
								values[5].charAt(0),
								Integer.parseInt(values[6]),
								Boolean.parseBoolean(values[7]),
								values[8]);
		} catch (Exception ex) {
			throw new ContactFormatException("format d'un champ du contact invalide", ex);
		}
	}
	*/
	
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
