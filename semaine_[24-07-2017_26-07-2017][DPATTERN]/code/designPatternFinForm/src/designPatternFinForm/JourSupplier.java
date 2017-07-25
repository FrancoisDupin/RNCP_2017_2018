package designPatternFinForm;

import java.time.LocalDate;
import java.util.function.Supplier;

public class JourSupplier implements Supplier<LocalDate>
{
	
	private final LocalDate jourDebut;
	private LocalDate jourCourant;
	
	public JourSupplier(LocalDate jourDebut) {
		this.jourDebut = jourDebut;
		this.jourCourant = jourDebut.minusDays(1);
	}

	@Override
	public LocalDate get() {
		this.jourCourant = this.jourCourant.plusDays(1);
		return this.jourCourant;
	}

	@Override
	public String toString() {
		return "JourSupplier [jourDebut=" + jourDebut + "]";
	}
	

}
