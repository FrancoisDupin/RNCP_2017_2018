package javaCalculLourdForm;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Program {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("demarrer (appuyez sur entrée)");
		reader.nextLine();
		
		/*for (int i = 0; i < 4; i++) {
			System.out.println("fibonnaci(45) = " +   fibonnaci(45));	
		}
		*/
		//Thread t = new Thread(() -> System.out.println(fibonnaci(45)));
		// l'execution n'as pas démarré
		//t.start();
		
		
		Date d = new Date(); // demarrage
		/*Thread[] workers = new Thread[4];
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Thread(new FibonnaciWorker(45, "travailleur " + i));//() -> System.out.println(fibonnaci(45)));
			workers[i].start();
		}
		
		for (int i = 0; i < workers.length; i++) {
			try {
				do {
					System.out.println("on attend....");
				// attendre que ce thread ai terminé son execution
					workers[i].join(1000);
				}while(workers[i].isAlive());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		Random rd = new Random();
		ExecutorService tpe = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 6; i++) {
			tpe.submit(new FibonnaciWorker(42 + rd.nextInt(5), "travailleur " + i));
		}
		tpe.shutdown();
		try {
			tpe.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {e.printStackTrace();}
		
		
		Date d2 = new Date();
		System.out.println("temps en milliseconde = " + (d2.getTime() - d.getTime()));
		System.out.println("fin main");
		
	}
	
	
	public static long fibonnaci(long n) {
		if (n <= 1)
			return n;
		else
			return fibonnaci(n - 1) + fibonnaci(n - 2);
	}

}
