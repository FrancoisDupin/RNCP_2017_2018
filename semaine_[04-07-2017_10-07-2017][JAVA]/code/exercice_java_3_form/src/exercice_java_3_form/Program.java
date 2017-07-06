package exercice_java_3_form;

import exercice_java_3_form.metier.Article;

public class Program {

	public static void main(String[] args) {
		Article a = new Article();
		
		System.out.println(a.toString());

		Article a2 = new Article("ah ah ah ah","staying alive, staying alive", null, 8.5);
		System.out.println(a2);
	}

}
