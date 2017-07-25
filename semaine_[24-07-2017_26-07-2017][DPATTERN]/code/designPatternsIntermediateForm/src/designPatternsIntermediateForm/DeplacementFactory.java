package designPatternsIntermediateForm;

import java.util.HashMap;
import java.util.Map;

public class DeplacementFactory {
	
	Map<String, Double> distances;
	
	public DeplacementFactory() {
		distances = new HashMap<>();
		distances.put("paris:londre", 462.2);
		distances.put("paris:berlin", 1054.1);
		distances.put("bordeaux:madrid", 690.1);
		distances.put("paris:madrid", 1275.3);
		distances.put("paris:bordeaux", 584.3);
		distances.put("paris:marrakech", 2542.8);
		distances.put("paris:tokyo", 9711.8);
	}
	
	// la methode fabrique de deplacement
	public Deplacement buildDeplacement(String ... etapes) {
		if (etapes.length < 2)
			throw new IllegalArgumentException("il faut au moins un depart et une arrivé");
		if (etapes.length == 2) {
			String cle1 = etapes[0] + ":" + etapes[1];
			String cle2 = etapes[1] + ":" + etapes[0];
			double d = 0.0;
			if (distances.containsKey(cle1)) {
				d = distances.get(cle1);
			}
			else if (distances.containsKey(cle2)) {
				d = distances.get(cle2);
			}
			else {
				throw new IllegalArgumentException("trajet inconnu");
			}
			if (d > 600.0)
				return new AvionDeplacement(etapes[0], etapes[1], (int)d);
			else
				return new TrainDeplacement(etapes[0], etapes[1], (int)d);
		}
		else {
			return new DeplacementComposite(etapes);
		}
	}

}
