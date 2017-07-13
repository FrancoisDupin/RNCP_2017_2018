package dateJavaform;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Program {

	public static void main(String[] args) {
		// 3 version de l'api Date en java
		//version 1 historique, avec bcp de problemes
		
		Date d = new Date();
		System.out.println("nous somme le " + d);
		// c'est un timestamp en interne, un point dans le temps depuis le 1er janvier 1970
		// en milliseconde
		
		Date d2 = new Date(2017, 7, 13);
		System.out.println("nous somme le " + d2);
		// annee 1900 + valeur, mois commence a 0 pour janvier
		Date d3 = new Date(117, 6, 13);
		System.out.println("nous somme le " + d3);

		// version 2, tentative de corriger avec Calendar
		Calendar cal = new GregorianCalendar(2017, 6, 13);
		Date d4 = cal.getTime();
		System.out.println("nous somme le " + d4);
		cal.add(Calendar.DAY_OF_MONTH, 4);
		cal.add(Calendar.MONTH, 2);
		d4 = cal.getTime();
		System.out.println("nous somme le " + d4);
		cal.add(Calendar.DAY_OF_MONTH, 20);
		d4 = cal.getTime();
		System.out.println("nous somme le " + d4);
		
		// version 3 avec java 8
		// premierement, il y a un grand nombre de classe pour représenter différent concept
		// une date (sans time), time (sans date), representer une date locale on non
		// on peu représenter un instant dans le temps, un interval de temp (duration)
		// utilise les technique d'API moderne, en particulier l'api builder
		// la représentation d'une date est IMMUTABLE
		
		LocalDate ld1 = LocalDate.of(2017, 7, 14);
		System.out.println("demain, nous somme le " + ld1);
		LocalDate ld2 = LocalDate.now();
		System.out.println("nous somme le " + ld2);
		LocalTime tm1 = LocalTime.now();
		System.out.println("il est " + tm1);
		
		LocalDateTime dt1 = LocalDateTime.now();
		System.out.println("précisement " + dt1);
		LocalDateTime dt2 =  dt1.plusDays(3)
								.plusMonths(1)
								.minusHours(2);
		System.out.println("autre : " + dt2);
		
		//Duration dr1 = Duration.of(1, ChronoUnit.MONTHS);
		// représente une durée deterministe, pas d'unite année ou mois qui peuvent varier
		Duration dr1 = Duration.ZERO;
		dr1 = dr1.plusDays(14);
		
		System.out.println("dt2 is after dt1 = " + dt2.isAfter(dt1));
		System.out.println("dt2 is after dt1 = " + dt1.isAfter(dt2));
		LocalDateTime dt3 = dt2.plus(dr1);
		
		// une duration est elle aussi immutablr
		System.out.println("autre : " + dt3);
		Duration dr2 = Duration.of(1, ChronoUnit.DAYS);
		System.out.println("dr2 = " + dr2);
		dr2 = dr2.multipliedBy(15);
		System.out.println("dr2 = " + dr2);
		
	}

}
