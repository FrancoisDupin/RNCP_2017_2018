package exercice_java_5_form;

import java.util.Scanner;

public class Convertisseur {
	
	private double kelvin;
	public double getKelvin() {return kelvin;}
	public void setKelvin(double kelvin) {
		if (kelvin < 0)
			throw new InvalidTemperatureException("temperature trop basse");
		this.kelvin = kelvin;
	}
	
	public double getCelsius() {
		return getKelvin() - 273.15; // quand je lit en celsius, convertir depuis kelvin
	}
	public void setCelsius(double celsius) {
		setKelvin(celsius + 273.15); // quand j'ecrit des celsius, convertir vers kelvin
	}
	
	public double getFahrenheit() {
		return getKelvin() * 9.0 / 5.0 - 459.67;
	}
	public void setFahrenheit(double fahrenheit) {
		setKelvin((fahrenheit + 459.67) / (9.0 / 5.0));
	}
	
	public void saisieTemperature() {
		Scanner reader = new Scanner(System.in);
		System.out.print("temperature suivie de c,k ou f suivant l'unité: ");
		String saisie = reader.nextLine();
		// je recupere le dernir caractere
		char unite = Character.toUpperCase(saisie.charAt(saisie.length() - 1));
		// et je convertit le reste (la chaine moins le dernier caractere)
		double temp = Double.parseDouble(saisie.substring(0, saisie.length() - 1));
		switch(unite) {
			case 'C': setCelsius(temp); break;
			case 'K': setKelvin(temp); break;
			case 'F': setFahrenheit(temp); break;
			default: throw new InvalidTemperatureUnitException("unite inconnue: " + unite);
		}
	}
	
	
	public static class InvalidTemperatureUnitException extends RuntimeException {
		public InvalidTemperatureUnitException(String message) {super(message);}
	}
	public static class InvalidTemperatureException extends RuntimeException {
		public InvalidTemperatureException(String message) {super(message);}
	}

}
