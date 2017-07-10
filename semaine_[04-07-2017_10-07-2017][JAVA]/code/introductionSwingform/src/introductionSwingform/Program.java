package introductionSwingform;

import javax.swing.JFrame;

import introductionSwingform.gui.Fenetre1;

public class Program {

	public static void main(String[] args) {
	/*	// creation fenetre avec titre
		JFrame f1 = new JFrame("ma fenetre!!");
		// taille en pixel de la fenetre
		f1.setSize(400, 300);
		// terminer le programme quand on ferme la fenetre
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// centrer la fenetre
		f1.setLocationRelativeTo(null);
		// afficher la fenetre
		f1.setVisible(true);
*/
		
		Fenetre1 f1 = new Fenetre1();
		f1.setVisible(true);
		
		
	}

}
