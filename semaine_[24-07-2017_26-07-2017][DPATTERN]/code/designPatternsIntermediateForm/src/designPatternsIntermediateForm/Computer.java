package designPatternsIntermediateForm;

import java.util.ArrayList;
import java.util.Arrays;

public class Computer {
	private String cpu;
	private int ramSizeGo;
	private String ecran;
	private boolean clavier;
	private boolean souris;
	private String carteReseau;
	private String[] disqueDurs;
	
	public String getCpu() {return cpu;}
	public void setCpu(String cpu) {this.cpu = cpu;}
	public int getRamSizeGo() {return ramSizeGo;}
	public void setRamSizeGo(int ramSizeGo) {this.ramSizeGo = ramSizeGo;}
	public String getEcran() {return ecran;}
	public void setEcran(String ecran) {this.ecran = ecran;}
	public boolean isClavier() {return clavier;}
	public void setClavier(boolean clavier) {this.clavier = clavier;}
	public boolean isSouris() {return souris;}
	public void setSouris(boolean souris) {this.souris = souris;}
	public String getCarteReseau() {return carteReseau;}
	public void setCarteReseau(String carteReseau) {this.carteReseau = carteReseau;}
	public String[] getDisqueDurs() {return disqueDurs;}
	public void setDisqueDurs(String[] disqueDurs) {this.disqueDurs = disqueDurs;}

	private Computer(String cpu, int ramSizeGo) {
		setCpu(cpu);
		setRamSizeGo(ramSizeGo);
	}
	
	public static class Builder {
		private String buildCpu;
		private int buildRamSizeGo;
		private String buildEcran;
		private boolean buildClavier;
		private boolean buildSouris;
		private String buildCarteReseau;
		private ArrayList<String> buildDisqueDurs;
		
		public Builder(String cpu, int ramSizeGo) {
			this.buildCpu = cpu;
			this.buildRamSizeGo = ramSizeGo;
			this.buildDisqueDurs = new ArrayList<>();
			this.buildEcran = "none";
			this.buildClavier = false;
			this.buildSouris = false;
			this.buildCarteReseau = "none";
		}
		// ajouter un ecran a l'ordinateur qui sera construit
		public Builder addEcran(String ecran) {
			this.buildEcran = ecran;
			return this;
		}
		public Builder addClavier() {
			this.buildClavier = true;
			return this;
		}
		public Builder addSouris() {
			this.buildSouris = true;
			return this;
		}
		public Builder addCarteReseau(String carteReseau) {
			this.buildCarteReseau = carteReseau;
			return this;
		}
		public Builder addDisqueDur(String disqueDur) {
			this.buildDisqueDurs.add(disqueDur);
			return this;
		}
		
		public Computer build() {
			if (this.buildCarteReseau.equals("none") 
					&& !this.buildClavier
					&& !this.buildSouris
					&& this.buildEcran.equals("none")) {
				throw new IllegalStateException("cet ordinateur sert a rien!");
			}
			Computer c = new Computer(buildCpu, buildRamSizeGo);
			c.carteReseau = this.buildCarteReseau;
			c.clavier = this.buildClavier;
			c.ecran = this.buildEcran;
			c.souris = this.buildSouris;
			c.disqueDurs = this.buildDisqueDurs.toArray(new String[0]);
			return c;
		}
	}

	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ",\n ramSizeGo=" + ramSizeGo + ",\n ecran=" + ecran + ", clavier=" + clavier
				+ ",\n souris=" + souris + ",\n carteReseau=" + carteReseau + ",\n disqueDurs=" + Arrays.toString(disqueDurs)
				+ "]";
	}
	
}
