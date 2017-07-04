package helloJavaForm;

public class Program {

	public static void main(String[] args) {
		// ceci est un commentaire sur une ligne
		/*
		 * ceci est un commentaire multiligne
		 * 
		 */
		// java est un langage type c dans sa syntaxe de base
		// instruction;
		// instruction;
		// ...
		// l'indentation n'a AUCUNE importance pour le compilateur java
		
		// out <- sortie standard
		System.out.println("bonjour java!");
		
		// java est sensible a la casse (majuscule/minuscule)
		
		//System.out.Println("bonjour java!"); <-- erreur
		
		// java est fortement typé, on doit indiquer le type d'une variable
		// a sa déclaration
		
		// chiffres/nombre
		
		// declaration d'un entier signé 32 bits
		int variable_entiere1;
		variable_entiere1 = 42;
		
		// sur une même ligne
		int variable_entiere2 = 15;
		
		System.out.println("variable_entiere_1 = " + variable_entiere1);
		System.out.println("variable_entiere_2 = " + variable_entiere2);
		// int : -2 milliard <---> +2 milliard
		
		long var_e_1 = 4568;
		// entier signé 64 bits
		System.out.println("var_e_1 = " + var_e_1);
	
		//long var_e_2 = 6000000000L;
		long i = 1000000000;
		System.out.println(i);
		i = i * 2;
		System.out.println(i);
		i = i * 2;
		System.out.println(i);
		
		long var_e_2 = 6000000000L;
		System.out.println("var_e_2 = " + var_e_2);
		
		
		// entier 16 bits (-32768 <-> +32767)
		short var_s_1 = 15000;
		
		// entier 8 bits  (-128 <-> + 127), autrement dit un octet
		byte var_b_1 = 112;
		
		// type numerique flottant (virgule flottant)
		// float -> 32 bits
		
		float fl1 = 3.1415F;
		System.out.println("fl1 = " + fl1);
		fl1 = 3.1415161718F;
		System.out.println("fl1 = " + fl1);
		fl1 = 3.14151617181920212223F;
		System.out.println("fl1 = " + fl1);
		
		// double -> 64 bits
		
		double db1 = 3.1415;
		System.out.println("db1 = " + db1);
		db1 = 3.1415161718;
		System.out.println("db1 = " + db1);
		db1 = 3.14151617181920212223;
		System.out.println("db1 = " + db1);
		
		
		// type boolean -> vrai/faux
		boolean bl1 = true;
		boolean bl2 = false;
		System.out.println("bl1 = " + bl1);
		System.out.println("bl1 && bl2 = " + (bl1 && bl2));
		System.out.println("bl1 || bl2 = " + (bl1 || bl2));
		System.out.println("!bl1 = " + !bl1);
		
		// type caractere ---> char
		char c1 = 'a';
		// la simple guillemet denote en java UN caractere
		// la double guillement denote une chaine de caractere
		//char c2 = ''';
		char c2 = 'b';
		// c'est un caractere unicode sur 16 bits
		
		// c'est fini pour les types valeurs natifs/simple
		
		//  type Objet basique chaine de caracter
		String  str1 = "hello";
		System.out.println(str1);
		
		System.out.println("longueur = " + str1.length());
		// la position commence a 0
		System.out.println("caractere pos 2 = " + str1.charAt(2));
		
		
		
	}

}
