package exercice_java_2_E_form;

public class Program {

	public static void main(String[] args) {
		
		System.out.println(chiffreRomain(879));
	}
	
	public static String chiffreRomain(int number) {
		/*
		 *  1 -> I		10	X		100 C
		 *  2 -> II		20	XX			CC
		 *  3 -> III	30	XXX			CCC
		 *  4 -> IV		40	XL			CD
		 *  5 -> V		50	L			D
		 *  6 -> VI		60	LX			DC
		 *  7 -> VII	70	LXX			DCC
		 *  8 -> VIII	80	LXXX		DCCC
		 *  9 -> IX		90	XC			CM
		 *  10 -> X		100	C			M
		 * 
		 * 112 -> CXII
		 * 194 -> CXCIV
		 * 199 -> CXCIX
		 * 521 -> DXXI
		 * 99 ->  XCIX
		 * 999 -> CMXCIX
		 */
		
		int centaine = (number / 100) % 10 ;   // 521 --> 5
		int dizaine = (number / 10) % 10; // 521 --> 52 % 10 -> 2
		int unite = number  % 10; // 521 % 10 -> 1
		
		return		 sousChiffreRomain(centaine, new char[] {'C', 'D', 'M'})
					 + sousChiffreRomain(dizaine, new char[] {'X', 'L', 'C'})
					 + sousChiffreRomain(unite, new char[] {'I', 'V', 'X'});
		
		
	}
	
	public static String sousChiffreRomain(int number, char[] sigles) {
		switch(number) {
			case 0: return "";
			case 1: return "" + sigles[0];
			case 2: return "" + sigles[0] + sigles[0];
			case 3: return "" + sigles[0] + sigles[0] + sigles[0];
			case 4: return "" + sigles[0] + sigles[1];
			case 5: return "" + sigles[1];
			case 6: return "" + sigles[1] + sigles[0];
			case 7: return "" + sigles[1] + sigles[0] + sigles[0];
			case 8: return "" + sigles[1] + sigles[0] + sigles[0] + sigles[0];
			case 9: return "" + sigles[0] + sigles[2]; 
		}
		return "";
	}

}
