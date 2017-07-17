package attenteMultiThreadForm;

public class WorkerAttente implements Runnable {

	private boolean mustStop;
	
	public void setMustStop(boolean mustStop) {
		this.mustStop = mustStop;
	}
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public WorkerAttente(String name) {
		super();
		setName(name);
		this.mustStop = false;
	}
	
	@Override
	public void run() {
		while (!mustStop) {
			System.out.println("je travaille: " + getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("fini (arret demandé): " + getName());
	}

}
