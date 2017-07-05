package exercice_java_2_A_form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		System.out.println("compte double positif = " + comptepositif(1.5, -2.4, -3, 4, 5, 6,-9));
		System.out.println("compte double positif = " + comptepositifStream(
				new Double(1.5),new Double(-2.4), new Double(-3), new Double(4),
				new Double(5), new Double(6),new Double(-9)));
	}
	
	public static long comptepositifStream(Double ... values) {
		return Arrays.stream(values)
			  .filter(d -> d > 0)
			  .collect(Collectors.counting());
	}
	
	
	public static long comptepositif(double ... values) {
		long compteur = 0;
		for (double d : values) {
			if (d > 0)
				compteur++;
		}
		return compteur;
	}

}
