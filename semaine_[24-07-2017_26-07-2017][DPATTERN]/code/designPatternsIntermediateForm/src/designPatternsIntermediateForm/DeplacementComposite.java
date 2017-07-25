package designPatternsIntermediateForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeplacementComposite implements Deplacement {

	private List<String> etapes;
	private List<Deplacement> deplacements;
	
	public DeplacementComposite(String ... etapes) {
		this.etapes = Arrays.asList(etapes);
		this.deplacements = new ArrayList<>();
		DeplacementFactory df = new DeplacementFactory();
		
		String previousVille = null;
		for (String ville : this.etapes) {
			if (previousVille != null) {
				this.deplacements.add( 
						df.buildDeplacement(previousVille, ville));
			}
			previousVille = ville;
		}
	}

	@Override
	public String getDepart() {
		return this.etapes.get(0);
	}

	@Override
	public String getArrive() {
		return this.etapes.get(this.etapes.size() - 1);
	}

	// calcul la durée total en accumulant les duree des trajets
	// intermediaire composant cet deplacement
	// pattern composite
	@Override
	public int getDuree() {
		int total = 0;
		for (Deplacement d : deplacements) {
			total += d.getDuree();
		}
		return total;
	}

	@Override
	public String toString() {
		return "DeplacementComposite [etapes=" + etapes + ",\n deplacements=" + deplacements + "]";
	}

	
}
