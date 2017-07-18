package spyHub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SpyManager {
	
	public static class SpyEvent {
		private String source;
		private String message;
		private LocalDateTime date;
		
		public String getSource() {	return source;}
		public void setSource(String source) {	this.source = source;}
		public String getMessage() {return message;	}
		public void setMessage(String message) {this.message = message;	}
		public LocalDateTime getDate() {return date;}
		public void setDate(LocalDateTime date) {this.date = date;}
		
		public SpyEvent(String source, String message, LocalDateTime date) {
			this.source = source;
			this.message = message;
			this.date = date;
		}
		
		@Override
		public String toString() {
			return "SpyEvent [source=" + source + ", message=" + message + ", date=" + date + "]";
		}
		
		
	}
	
	
	// mes espions
	private List<DirectorySpy> spies;
	// le threadpool pour faire tourner les espions
	private ExecutorService workers;
	// ma liste d'evenements (ajout, supression, etc....)
	private List<SpyEvent> events;
	
	
	
	public SpyManager(String configFileName) {
		// tous mes espions de repertoires
		spies = new ArrayList<>();
		events = new ArrayList<>();
		
		File config = new File(configFileName);
		try {
			// je lit le fichier de configuration avec la liste des repertoires a surveiller
			Scanner reader = new Scanner(config);
			while (reader.hasNextLine()) {
				// un nom de repertoire a surveiller
				String dirName = reader.nextLine();
				// pour chaque repertoire, je creer un objet DirectorySpy
				// et je le garde en memoire, sans le démarrer pour l'instant
				DirectorySpy ds = new DirectorySpy(dirName, this);
				spies.add(ds);
			}
		} catch (FileNotFoundException e) {	e.printStackTrace();}
		// on dimensionne la threadpool en fonction du nombre d'espion a gérer
		workers = Executors.newFixedThreadPool(spies.size());
	}
	
	// publication d'un evenement en provenance d'un des espions
	// synchronisé pour eviter des confilts a l'ajout dans la liste
	// en effet, tous les directorySpy (tournant en parallel)
	// peuvent appeler a tout moment cette méthode pour signaler un evenement
	public synchronized void addEvent(String source, String message) {
		SpyEvent spe = new SpyEvent(source, message, LocalDateTime.now());
		events.add(spe);
	}
	
	
	public void startSpying() {
		// j'ajoute mes spy comme worker (ce qui les demarre) dans la threadPool
		for(DirectorySpy ds : spies) {
			workers.submit(ds);
		}
	}
	

	public void stopSpying() {
		workers.shutdown();
		for(DirectorySpy ds : spies) {
			ds.setMustStop(true);
		}
		try {
			workers.awaitTermination(10, TimeUnit.SECONDS);
			if (workers.isTerminated()) {
				System.out.println("shutDown complete");
			}
			else {
				System.out.println("problem at shutdown");
			}
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	
	public void saveEvents(String filename) {
		try {
			// ouvrir le fichier en ecriture
			PrintWriter pw = new PrintWriter(filename);
			// ecrire un event par ligne
			events.stream()
				  .forEach(evt -> pw.println(evt.toString()));
			pw.close();
		} catch (FileNotFoundException e) {	e.printStackTrace();}
		
	}
}
