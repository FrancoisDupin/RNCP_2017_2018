package exercice_java_2_C_form;

public class Program {

	public static void main(String[] args) {
		System.out.println("'kayak' ? " + estPalindrome("kayak"));
		System.out.println("'maison' ? " + estPalindrome("maison"));

	}
	
	public static boolean estPalindrome(String chaine) {
		
		int debut = 0; // position premier caractere
		int fin = chaine.length() - 1; // position dernier caractere
		
		while (debut < fin) {
			if (chaine.charAt(debut++) != chaine.charAt(fin--)) 
				return false;
		}
		return true;
	}

}
