package designPatternsIntermediateForm;

public class TrainDeplacement implements Deplacement {

	private String depart;
	private String arrive;
	private int distance;
	
	public TrainDeplacement(String depart, String arrive, int distance) {
		this.depart = depart;
		this.arrive = arrive;
		this.distance = distance;
	}

	@Override
	public String getDepart() {
		return depart;
	}

	@Override
	public String getArrive() {
		return arrive;
	}

	@Override
	public int getDuree() {
		return (int)Math.round((distance / 100.0) * 60);
	}

	@Override
	public String toString() {
		return "TrainDeplacement [depart=" + depart + ", arrive=" + arrive + ", distance=" + distance + "]";
	}

	
}
