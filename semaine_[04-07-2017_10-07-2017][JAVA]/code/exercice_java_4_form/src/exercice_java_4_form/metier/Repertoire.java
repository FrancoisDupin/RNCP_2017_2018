package exercice_java_4_form.metier;

import java.util.Arrays;

public class Repertoire {
	
	private int nbPersonnes;
	private Personne[] peoples;

	
	public Repertoire() {
		this.nbPersonnes = 0;
		peoples = new Personne[5];
	}
	
	public int ajouter(Personne p) {
		this.nbPersonnes++;
		// augmenter la taille du tableau si necessaire
		if (nbPersonnes > peoples.length) {
			peoples = Arrays.copyOf(peoples, peoples.length + 5);
		}
		// ajouter dans une case vide du tableau
		for (int i = 0; i < peoples.length; i++) {
			if (peoples[i] == null) {
				peoples[i] = p;
				return i;
			}
		}
		return -1;
	}
	public boolean retirer(int index) {
		if (peoples[index] != null) {
			peoples[index] = null;
			nbPersonnes--;
			return true;
		}
		return false;
	}
	
	public Personne lire(int index) {
		if (peoples[index] != null) {
			return peoples[index];
		}
		return null;
	}
	
	public String sauver() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < peoples.length; i++) {
			if (peoples[i] != null) {
				sb.append(peoples[i].sauver());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
}
