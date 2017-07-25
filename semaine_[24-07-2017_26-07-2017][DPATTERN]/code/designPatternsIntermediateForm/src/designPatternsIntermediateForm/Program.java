package designPatternsIntermediateForm;

public class Program {

	public static void main(String[] args) {

		Computer c1 = new Computer.Builder("intel core 2", 16)
								  .addClavier()
								  .addDisqueDur("ssd 128go")
								  .addCarteReseau("gigabit ethernet")
								  .addDisqueDur("hdd 4to")
								  .build();
		
		System.out.println(c1);
		
		String str = new StringBuilder("hello")
						.append(" world")
						.append('\n')
						.reverse()
						.insert(3, '#')
						.toString();
		
		System.out.println(str);
	}

}
