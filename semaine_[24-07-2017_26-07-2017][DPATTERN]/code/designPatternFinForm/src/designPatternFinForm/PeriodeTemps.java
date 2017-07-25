package designPatternFinForm;

import java.time.LocalDate;
import java.util.Iterator;

public class PeriodeTemps  implements Iterable<LocalDate>
{
	
	private final LocalDate jourDebut;
	private final LocalDate jourFin;
	
	public PeriodeTemps(LocalDate jourDebut, LocalDate jourFin) {
		this.jourDebut = jourDebut;
		this.jourFin = jourFin;
	}

	@Override
	public String toString() {
		return "PeriodeTemps [jourDebut=" + jourDebut + ", jourFin=" + jourFin + "]";
	}

	@Override
	public Iterator<LocalDate> iterator() {
		return new PeriodeIterator();
	}

	public class PeriodeIterator implements Iterator<LocalDate> {

		private LocalDate jourCourant;
		
		public PeriodeIterator() {
			jourCourant = jourDebut.minusDays(1);
		}

		@Override
		public boolean hasNext() {
			return jourCourant.isBefore(jourFin);
		}

		@Override
		public LocalDate next() {
			jourCourant = jourCourant.plusDays(1);
			return jourCourant;
		}
		
	}

}
