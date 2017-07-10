package exercice_java_5_form;

import exercice_java_5_form.Convertisseur;

public class Program {

	public static void main(String[] args) {


		Convertisseur conv = new Convertisseur();
		
		while(true) {
			try {
				conv.saisieTemperature();
				
				System.out.println(conv.getKelvin() + "k");
				System.out.println(conv.getCelsius() + "c");
				System.out.println(conv.getFahrenheit() + "f");
				break;
			}
			catch (NumberFormatException ex) {
				System.out.println("veuillez saisir un nombre! " + ex.getLocalizedMessage());
			}
			catch(Convertisseur.InvalidTemperatureUnitException ex) {
				System.out.println("non géré: " + ex.getMessage());
			}
			catch (Convertisseur.InvalidTemperatureException ex) {
				System.out.println("physiquement impossible: " + ex.getMessage());
			}
		}
		
		//conv.setCelsius(-400);

	}

}
