package attenteMultiThreadForm;

import java.util.ArrayList;
import java.util.Vector;

public class Program {

	public static void main(String[] args) {
		
		WorkerAttente w1 = new WorkerAttente("bob");
		
		Thread t1 = new Thread(w1);
		
		t1.start();
		
		int compteur = 0;
		do {
			try {
				System.out.println("j'attend");
				t1.join(4000);
				compteur++;
				if (compteur > 3) {
					System.out.println("ca suffit, mare d'attendre");
					//t1.stop(); // tuer un  thread, c'est mal
					w1.setMustStop(true);
					//break;
				}
				
			} catch (InterruptedException e) {e.printStackTrace();}
		}while(t1.isAlive());
		System.out.println("fini");

		// non thread safe
		StringBuilder sb = new StringBuilder();
		// thread safe
		StringBuffer sb2 = new StringBuffer();
	
		// non thread safe
		ArrayList<String> tab1 = new ArrayList<>();
		
		// thread safe
		Vector<String> tab2 = new Vector<>();
		
	}

}
