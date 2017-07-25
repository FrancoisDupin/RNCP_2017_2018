package designPatternFinForm;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Program {

	public static void main(String[] args) {
		/*
		 * pattern iterator
		 * 	-> base du foreach et des collections en java
		 * 
		 * parcourir une collection et effectuer un traitement
		 *  sur chacun des elements de celle-ci
		 */

		String [] pays = {"france", "italie", "maroc", "espagne", "allemagne"};
		
		for (String p : pays) {
			System.out.println(p);
		}
		
/*		Double d = 4.5;
		for (Object o : d) {
			
		}
	*/
		List<String> mangas = Arrays.asList("death note",
											"naruto",
											"dragon ball",
											"bleach",
											"one piece",
											"ken le survivant",
											"candy");
		// une List est un Iterable
		// l'ArrayList implemente l'interface Iterable
		Iterable<String> it1 = mangas;
		
		// recuperation du curseur
		Iterator<String> curseur = it1.iterator();
		
		System.out.println("----------------------");
		// parcourir tant que le curseur n'est pas a la fin
		while (curseur.hasNext()) {
			System.out.println(curseur.next());
		}
		
		System.out.println("----------------------");
		Vecteur v1 = new Vecteur(2.5,  -3.8, 15.2);
		
		for (Double d : v1) {
			System.out.println(d);
		}
		System.out.println("----------------------");
		
		PeriodeTemps p1 = new PeriodeTemps(LocalDate.of(2017, 6, 26),
										   LocalDate.now());		
		
		for (LocalDate day : p1)
			System.out.println(day);
		
		System.out.println("----------------------");
		
		JourSupplier js = new JourSupplier(LocalDate.now());
		Stream.generate(js)
			  .filter(j -> j.getDayOfWeek().equals(DayOfWeek.SUNDAY))
			  .limit(20)
			  .forEach(j -> System.out.println(j));
		
		System.out.println("----------------------");
		
		// transformation de l'iterable en stream
		StreamSupport.stream(p1.spliterator(), false)
					.filter(j -> j.getDayOfWeek().equals(DayOfWeek.SUNDAY))
					.forEach(j -> System.out.println(j));
					
		
	}

}
