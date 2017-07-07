package interfacesJavaForm;

import java.util.Arrays;
import java.util.Random;

import interfacesJavaForm.metier.*;

public class Program {

	public static void main(String[] args) {
		
		Vegetal[] vegetaux = new Vegetal[2];
		Algue a1 = new Algue(3, "kelp", "verdatre");
		vegetaux[0] = a1;
		Dionaea dio1 = new Dionaea(7, "monstroplante", "sable");
		vegetaux[1] = dio1;
		
		Animal[] animaux = new Animal[2];
		Chat c1 = new Chat(7, "felix", "noir et blanc");
		animaux[0] = c1;
		Dauphin dau1 = new Dauphin(8, "flipper", 1.75);
		animaux[1] = dau1;
		
		animaux[0].bouger();
		animaux[1].crier();
		
		vegetaux[0].pousser();
		vegetaux[1].pousser();
		
		IAquatique ia1 = dau1;
		System.out.println(ia1.getTypeMillieux() + "," + ia1.getProfondeurMax());
		ia1 = a1;
		System.out.println(ia1.getTypeMillieux() + "," + ia1.getProfondeurMax());
		
		//ia1 = c1;
		// je met dans la variable carnivore1
		// l'objet Chat qu'on avait instancié précédement
		/*ICarnivore carnivore1 = c1;
		carnivore1.capturer();
		carnivore1 = dau1;
		*/
		
		nourrirCarnivore(dau1);
		
		
		
		/*ICompteBancaire c1;
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
		*/

	}
	
	public static void nourrirCarnivore(ICarnivore ic) {
		ic.capturer();
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
