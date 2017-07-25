package designPatternsIntermediateForm;

public class AvionDeplacement implements Deplacement {

	private String depart;
	private String arrive;
	private int distance;
	
	@Override
	public String getDepart() {
		return depart;
	}

	@Override
	public String getArrive() {
		return arrive;
	}

	public AvionDeplacement(String depart, String arrive, int distance) {
		this.depart = depart;
		this.arrive = arrive;
		this.distance = distance;
	}

	@Override
	public int getDuree() {
		return (int)Math.round((distance / 800.0) * 60);
	}
	

	@Override
	public String toString() {
		return "AvionDeplacement [depart=" + depart + ", arrive=" + arrive + ", distance=" + distance + "]";
	}

	
}
