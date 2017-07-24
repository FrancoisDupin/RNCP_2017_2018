package antiProcastinator.metier;

import java.time.LocalDateTime;

public class Tache {
	private int id;
	private String description;
	private int priorite;
	private String contexte;
	private boolean finished;
	private LocalDateTime dateCreation;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public int getPriorite() {return priorite;}
	public void setPriorite(int priorite) {this.priorite = priorite;}
	public String getContexte() {return contexte;}
	public void setContexte(String contexte) {this.contexte = contexte;}
	public boolean isFinished() {return finished;}
	public void setFinished(boolean finished) {this.finished = finished;}
	public LocalDateTime getDateCreation() {return dateCreation;}
	public void setDateCreation(LocalDateTime dateCreation) {this.dateCreation = dateCreation;}
	
	public Tache() { this(0, "", 0, "", false, null);}
	public Tache(int id, String description, int priorite, String contexte, boolean finished,
			LocalDateTime dateCreation) {
		super();
			setId(id);
			setDescription(description);
			setPriorite(priorite);
			setContexte(contexte);
			setFinished(finished);
			setDateCreation(dateCreation);
		}
	@Override
	public String toString() {
		return "Tache [id=" + id + ", description=" + description + ", priorite=" + priorite + ", contexte=" + contexte
				+ ", finished=" + finished + ", dateCreation=" + dateCreation + "]";
	}
	
	
	
}
