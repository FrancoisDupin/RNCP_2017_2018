package interfacesJavaForm;

import java.util.Arrays;
import java.util.Random;

import interfacesJavaForm.metier.CompteSG;
import interfacesJavaForm.metier.ICompteBancaire;

public class Program {

	public static void main(String[] args) {
		ICompteBancaire c1;
		CompteSG csg1 = new CompteSG(250, "8763437687");
		
		// c1 ne m'expose que les fonctionnalité générique
		// définie dans l'interface  (plus Object)
		// csg1 bien, etant une variable de type compteSg, me montre
		// tout ce qui est visible
		c1 = csg1;

		CompteSG csg2 = new CompteSG(350, "2131354354");
		
		tranferer(csg1, csg2, 100);
		System.out.println(csg1);
		System.out.println(csg2);
		
		// generateur de nombre aleatoire
		Random rd = new Random();
		
		ICompteBancaire[] comptes = new ICompteBancaire[5];
		for (int i = 0; i < 5; i++) {
			comptes[i] = new CompteSG(rd.nextDouble() * 1000.0, "5434354" + i);
		}
		System.out.println("-------------------------------");
		for (ICompteBancaire ic : comptes)
			System.out.println(ic);
		System.out.println("--------------------------------");
		Arrays.sort(comptes);
		for (ICompteBancaire ic : comptes)
			System.out.println(ic);
		

	}
	
	
	public static boolean tranferer(ICompteBancaire source,
									ICompteBancaire destination,
									double montant) {
		if (source.retirer(montant)) {
			destination.deposer(montant);
			return true;
		}
		return false;
	}

}
