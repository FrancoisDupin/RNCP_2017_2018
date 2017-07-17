package javaSynchronisationForm;

import java.util.concurrent.atomic.AtomicLong;

public class Indicateur {
	private AtomicLong compteur;
	private Object verrou1;
	
	public long getCompteur() {return compteur.get();}
	public void setCompteur(long compteur) {
		this.compteur.set(compteur);
	}
	public Indicateur(long compteur) {
		super();
		this.compteur = new AtomicLong(compteur);
		this.verrou1 = new Object();
	}
	// synchronized n'autorise qu'un seul thread en même temps pour executer
	// cette methode
	public /*synchronized*/ long incrementeCompteur() {
		//synchronized(verrou1) {
			//long c = getCompteur();
			//this.compteur++;
			//setCompteur(c);
			return this.compteur.incrementAndGet();
			//return this.compteur;
			
		//}
	}
	
	public /*synchronized*/ long decrementeCompteur() {
		synchronized(verrou1) {
			long c = getCompteur();
			c--;
			setCompteur(c);
			return c;
			
		}
	}
	
	
	@Override
	public String toString() {
		return "Indicateur [compteur=" + compteur + "]";
	}
}
