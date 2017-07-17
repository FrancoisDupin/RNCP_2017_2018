package javaSynchronisationForm;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Program {

	public static void main(String[] args) {
		Indicateur indic1 = new Indicateur(0);
		
		IncrementeurWorker w1 = new IncrementeurWorker(10000000, indic1);
		IncrementeurWorker w2 = new IncrementeurWorker(10000000, indic1);
		
		//w1.run();
		//w2.run();
		ExecutorService tp1 = Executors.newFixedThreadPool(4);
		Date d1 = new Date();
		tp1.submit(w1);
		tp1.submit(w2);
		
		tp1.shutdown();
		try {
			tp1.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		Date d2 = new Date();
		
		System.out.println("tout fini en  " + (d2.getTime() - d1.getTime()));
		System.out.println(indic1);
	}

}
