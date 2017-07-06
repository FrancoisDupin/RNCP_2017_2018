package heritageJavaform.vivant;

public class Chat extends Mammifere {
	private int vie_restante;
	private double resistance_gravite;
	
	public int getVie_restante() {return vie_restante;}
	public void setVie_restante(int vie_restante) {this.vie_restante = vie_restante;}
	
	public double getResistance_gravite() {return resistance_gravite;}
	public void setResistance_gravite(double resistance_gravite) {this.resistance_gravite = resistance_gravite;}
	
	public Chat(int age, String nom, double poids, int dureeGestation, double resistance_gravite) {
		super(age, nom, poids, dureeGestation);
		setVie_restante(9);
		setResistance_gravite(resistance_gravite);
	}
	
	public static void description() {
		System.out.println("description de Chat");
	}
	
	@Override
	public String toString() {
		return "Chat [vie_restante=" + vie_restante + ", resistance_gravite=" + resistance_gravite + ", getAge()="
				+ getAge() + ", getNom()=" + getNom() + "]";
	}
	
	// final permet d'interdire l'override par les descendants
	public final void faireRien() {
		System.out.println("rooonnn, ronnn");
	}
	
	@Override
	public void crier() {
		System.out.println("miaaouuuu");
		
	}
	
	
		
	
}
