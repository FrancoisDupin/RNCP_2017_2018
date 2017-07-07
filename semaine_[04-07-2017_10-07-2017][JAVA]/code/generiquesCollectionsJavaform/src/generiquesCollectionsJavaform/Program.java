package generiquesCollectionsJavaform;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generiquesCollectionsJavaform.metier.Tuple;


public class Program {

	public static void main(String[] args) {
		
		// tableau dynamique
		ArrayList tab1 = new ArrayList();
		tab1.add("bonjour");
		tab1.add("hello");
		tab1.add("guten tag");
		tab1.add("salam");
		
		System.out.println(tab1.size());
		System.out.println(tab1.get(2));

		for (Object str : tab1) {
			System.out.println(str);
		}
		
		tab1.add(45.5);
		System.out.println("-------------------");
		for (Object str : tab1) {
			System.out.println(str);
		}
		// ca marche, mais aucun controle de type
		// a eviter si possible
		
		// plutot utiliser les collections generiques
		ArrayList<String> lundis = new ArrayList<String>();
		lundis.add("lundi");
		lundis.add("monday");
		lundis.add("montag");
		lundis.add("lunes");
		//lundis.add(45.5);
		
		for(String str : lundis) {
			System.out.println(str + " " + str.length());
		}
		System.out.println("------------------------");
		String chaine = lundis.get(2);
		System.out.println(chaine);
		
		lundis.remove(2);
		System.out.println("------------------------");
		for(String str : lundis) {
			System.out.println(str + " " + str.length());
		}
		System.out.println("------------------------");
		lundis.add(1, "понедельник");
		for(String str : lundis) {
			System.out.println(str + " " + str.length());
		}
		System.out.println("------------------------");		
		lundis.set(2, "げつようび");
		for(String str : lundis) {
			System.out.println(str + " " + str.length());
		}		
	
		// IMPORTANT!!!
		// List en java est l'interface commune des fonctionnalité type ArrayList
		// ArrayList est une classe concrete implement l'interface liste
		List<String> liste = lundis;
		
		System.out.println("------------------------------------");
		// Map est l'interface des collections de type dictionnaire
		// une des implementations existance est la classe HashMap
		// une des limitations des generiques en java est qu'ils ne marchent
		// qu'avec des classes, donc pas de int, double, etc.. il faut utiliser
		// les versions objet
		Map<String, Double> dictionnaire = new HashMap<>();
		dictionnaire.put("paris", 10000000.0);
		dictionnaire.put("hambourg", 1766000.0);
		dictionnaire.put("madrid", 3100000.0);
		dictionnaire.put("tokyo", 13000000.0);
		
		System.out.println(dictionnaire.get("madrid"));
		System.out.println(dictionnaire.containsKey("tokyo"));
		
		System.out.println("--------------------------");
		// je parcours l'enumeration des cles du dictionnaire
		for ( String ville : dictionnaire.keySet()) {
			// pour chaque cle, je l'affiche ainsi que la valeur correspondante
			System.out.println(ville + " -> " + dictionnaire.get(ville));
		}
		
		
		Tuple<String, Double> couple1 = new Tuple<String, Double>("paris", 32.0);
		if (couple1.getValue2() > 30.0)
			System.out.println("il fait chaud");
		else
			System.out.println("ca va...");
		
		Tuple<String, Boolean> couple2 = new Tuple<String, Boolean>("2<4", true);
		
		System.out.println(couple2);
		
		//couple1 = couple2;
		ArrayList<Tuple<String, Double>> meteoVilles = new ArrayList<>();
		meteoVilles.add(new Tuple<String, Double>("paris", 33.0));
		meteoVilles.add(new Tuple<String, Double>("new york", 21.0));
		meteoVilles.add(new Tuple<String, Double>("djibouti", 38.0));
		meteoVilles.add(new Tuple<String, Double>("oslo", 23.0));
		meteoVilles.add(new Tuple<String, Double>("reykjavik", 13.0));
		
		
		System.out.println("----------------------");
		meteoVilles.stream().forEach(t -> System.out.println(t));
		
		System.out.println("----------------------");
		meteoVilles.stream()
					.filter(t -> t.getValue2() < 30.0)
					.forEach(t -> System.out.println(t));
		
		Collections.sort(meteoVilles);
		System.out.println("----------------------");
		meteoVilles.stream().forEach(t -> System.out.println(t));
		
		//Tuple<String, InputStream> t;
		
	}

}
