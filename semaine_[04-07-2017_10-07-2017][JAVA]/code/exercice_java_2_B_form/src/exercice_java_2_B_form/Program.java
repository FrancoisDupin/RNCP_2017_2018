package exercice_java_2_B_form;

public class Program {

	public static void main(String[] args) {
		System.out.println("inverse 'bonjour monde' = " + inverse("bonjour monde"));
		System.out.println("inverse 'bonjour monde' = " + inverseLowLevel("bonjour monde"));
	}
	
	public static String inverseLowLevel(String originale) {
		char[] result = new char[originale.length()];
		char[] orig = originale.toCharArray();
		int debut = 0;
		int fin = orig.length - 1;
		while (debut < orig.length) {
			result[fin--]= orig[debut++];
		}
		return new String(result);
	}
	
	
	public static String inverse(String originale) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = originale.length() - 1; i >= 0; i--)
			sb.append(originale.charAt(i));
		
		return sb.toString();
	}

}
