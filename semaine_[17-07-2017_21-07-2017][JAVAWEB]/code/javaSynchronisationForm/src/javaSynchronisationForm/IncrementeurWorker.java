package javaSynchronisationForm;

public class IncrementeurWorker implements Runnable {

	private int nbIterations;
	private Indicateur indicateur;
	
	public int getNbIterations() {return nbIterations;}
	public void setNbIterations(int nbIterations) {this.nbIterations = nbIterations;}

	public IncrementeurWorker(int nbIterations, Indicateur indicateur) {
		setNbIterations(nbIterations);
		this.indicateur = indicateur;
	}
	
	@Override
	public void run() {
		System.out.println("je demarre...");
		for (int i = 0; i < nbIterations; i++) {
			//long c = indicateur.getCompteur();
			long c = indicateur.incrementeCompteur();
			
			double d = Math.sqrt(c);
			d = d + 1;
			
			//indicateur.setCompteur(c);
		}
		System.out.println("j'ai fini...");
	}

}
