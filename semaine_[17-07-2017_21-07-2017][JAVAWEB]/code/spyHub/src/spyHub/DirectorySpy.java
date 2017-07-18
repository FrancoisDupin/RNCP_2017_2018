package spyHub;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DirectorySpy implements Runnable {

	private String directoryPath;
	private boolean mustStop;
	private SpyManager spyManager;
	
	public void setMustStop(boolean mustStop) {
		this.mustStop = mustStop;
	}

	public DirectorySpy(String directoryPath, SpyManager spyManager) {
		this.directoryPath = directoryPath;
		this.spyManager = spyManager;
		setMustStop(false);
	}


	@Override
	public void run() {
		File rep = new File(directoryPath);
		if(!rep.exists() || !rep.isDirectory()) {
			System.out.println("repertoire " + directoryPath + " non surveillable");
			return;
		}
		System.out.println("debut surveillance repertoire " + directoryPath);
		List<String> oldList = Arrays.asList(rep.list());
		while(!mustStop) {
			final List<String> oldListTemp = oldList;
			List<String> newList = Arrays.asList(rep.list());
			newList.stream().filter(fname -> !oldListTemp.contains(fname))
							.forEach(fname -> {
								spyManager.addEvent(directoryPath, "nouveau fichier : "+ fname); 
								System.out.println("nouveau fichier : " + fname);
							});
			oldList.stream().filter(fname -> !newList.contains(fname))
							.forEach(fname -> {
								spyManager.addEvent(directoryPath, "fichier disparu : "+ fname); 
								System.out.println("fichier disparu : " + fname);
							});
			oldList = newList;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("fin surveillance repertoire " + directoryPath);
	}

}
